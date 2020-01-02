package com.robot.home.controller;

import com.robot.api.pojo.Carousel;
import com.robot.api.pojo.RequestData;
import com.robot.product.provider.CarouselProvider;
import com.robot.product.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页
 *
 * @author robot
 * @date 2019/12/25 11:31
 */
@Controller
@RequestMapping("/home")
@CrossOrigin
@Api(value = "页面管理")
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Reference(version = "1.0.0", timeout = 5000)
    private CarouselService carouselService;

    @RequestMapping("/productList")
    @ResponseBody
    @ApiOperation(value = "获取首页轮播图", notes = "查询所有的已启用的轮播图片")
    public Map<String, Object> productList(Integer type) {
        Map<String, Object> map = new HashMap<>();
        logger.info("productList type:{}", type);
        List<Carousel> carousels = new ArrayList<>();
        try {
            carousels = carouselService.findCarouselList(type);
        } catch (Exception e) {
            logger.error("productList error e", e);
            return null;
        }
        map.put("carousels", carousels);
        map.put("type", type);
        return map;
    }

}
