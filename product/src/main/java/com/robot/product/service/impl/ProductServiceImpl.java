package com.robot.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.robot.api.enums.RedisKeyEnum;
import com.robot.api.pojo.Product;
import com.robot.api.pojo.ProductSku;
import com.robot.api.util.StaticUtil;
import com.robot.product.dao.ProductDao;
import com.robot.product.dao.ProductSkuDao;
import com.robot.product.service.ProductService;

import com.robot.product.util.BaseRedis;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author robot
 * @date 2019/12/10 17:38
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Resource
    private ProductSkuDao productSkuDao;

    @Resource
    private BaseRedis baseRedis;

    @Override
    public List<Product> productList(int page, int limit) {
        PageBounds pageBounds = new PageBounds();
        pageBounds.setLimit(limit);
        pageBounds.setPage(page);
        return productDao.findProductList(pageBounds);
    }

    @Override
    public List<ProductSku> productSkuList(int page, int limit) {
        PageBounds pageBounds = new PageBounds();
        pageBounds.setLimit(limit);
        pageBounds.setPage(page);
        return productSkuDao.findProductSkuList(pageBounds);
    }

    @Override
    public Product productDetail(String sku) {
        return getProductByRedis(sku);
    }

    private Product getProductByRedis(String sku) {
        Product product;
        if (StringUtils.isBlank(sku)) {
            return null;
        }
        String result = baseRedis.get(String.format(RedisKeyEnum.PRODUCT_DETAIL_KEY.getKey(), sku));
        //如果redis存在就直接返回
        if (StringUtils.isNotBlank(result)) {
            product = JSON.parseObject(result, new TypeReference<Product>() {
            });
            return product;
        }
        //如果不存在就查库
        product = productDao.findProductDetail(sku);
        if (product != null) {
            try {
                String valuesign = UUID.randomUUID().toString();
                //加锁，防止多出并发设值
                String lockResult = baseRedis.set(sku, valuesign, "nx", "ex", 30);
                if (StringUtils.isNotBlank(lockResult)) {
                    baseRedis.set(String.format(RedisKeyEnum.PRODUCT_DETAIL_KEY.getKey(), sku), JSON.toJSONString(product), StaticUtil.out_time);
                }
                if (StringUtils.equals(baseRedis.get(sku), valuesign)) {
                    baseRedis.del(sku);
                }
                return product;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
