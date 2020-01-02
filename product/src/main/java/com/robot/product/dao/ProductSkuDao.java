package com.robot.product.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.robot.api.pojo.ProductSku;


import java.util.List;

/**
 * @author robot
 * @date 2019/12/19 15:42
 */
public interface ProductSkuDao {

    /**
     * 查询商品列表
     *
     * @param pageBounds
     * @return
     */
    List<ProductSku> findProductSkuList(PageBounds pageBounds);
}
