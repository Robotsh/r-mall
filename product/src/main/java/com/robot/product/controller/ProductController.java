package com.robot.product.controller;

import com.robot.api.pojo.Product;
import com.robot.api.pojo.ProductSku;
import com.robot.api.pojo.RequestData;
import com.robot.product.service.ProductService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author robot
 * @date 2019/12/9 16:57
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Resource
    private ProductService productService;

    /**
     * 默认第一页
     */
    private static final int DEFAULT_PAGE = 1;

    /**
     * 默认一页大小是10
     */
    private static final int DEFAULT_LIMIT = 10;

    @RequestMapping("/productList")
    @ResponseBody
    public List<ProductSku> productList(@NotNull RequestData requestData) {
        String uid = requestData.getUid();
        logger.info("productList uid:{}", uid);
        return productService.productSkuList(DEFAULT_PAGE, DEFAULT_LIMIT);
    }


    @RequestMapping("/productDetail")
    @ResponseBody
    public Product productDetail(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("uid");
        String sku = request.getParameter("sku");
        logger.info("productDetail uid:{},sku:{}", uid, sku);
        return productService.productDetail(sku);
    }

}
