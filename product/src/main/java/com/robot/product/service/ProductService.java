package com.robot.product.service;

import com.robot.api.pojo.Product;
import com.robot.api.pojo.ProductSku;

import java.util.List;

/**
 * @author robot
 * @date 2019/12/10 17:36
 */
public interface ProductService {

    /**
     * 查询商品列表
     * @param page
     * @param limit
     * @return
     */
     List<Product> productList(int page, int limit);

    /**
     * 查询商品列表
     * @param page
     * @param limit
     * @return
     */
    List<ProductSku> productSkuList(int page, int limit);

    /**
     * 查询商品详情
     * @param sku
     * @return
     */
    Product productDetail(String sku);


}
