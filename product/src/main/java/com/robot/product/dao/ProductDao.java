package com.robot.product.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.robot.api.pojo.Product;

import java.util.List;

/**
 * @author robot
 * @date 2019/12/10 17:42
 */

public interface ProductDao {

    /**
     * 分页查询商品
     *
     * @param pageBounds
     * @return
     */
    List<Product> findProductList(PageBounds pageBounds);

    /**
     * 查询商品详情
     * @param sku
     * @return
     */
    Product findProductDetail(String sku);
}
