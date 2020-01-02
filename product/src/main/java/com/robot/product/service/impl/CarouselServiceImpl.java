package com.robot.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.robot.api.enums.RedisKeyEnum;
import com.robot.api.pojo.Carousel;
import com.robot.api.util.StaticUtil;
import com.robot.product.dao.CarouselDao;
import com.robot.product.service.CarouselService;
import com.robot.product.util.BaseRedis;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author robot
 * @date 2019/12/26 14:26
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Resource
    private CarouselDao carouselDao;

    @Resource
    private BaseRedis baseRedis;

    @Override
    public List<Carousel> findCarouselList(int type) {
        return carouselDao.findCarouselList(type);
        //        return getProductByRedis(type);
    }

    private List<Carousel> getProductByRedis(int type) {
        List<Carousel> carousels;
        String result = null;
        try {
            baseRedis.del(String.format(RedisKeyEnum.CAROUSEL_KEY.getKey(), type));

            result = baseRedis.get(String.format(RedisKeyEnum.CAROUSEL_KEY.getKey(), type));

        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果redis存在就直接返回
        if (StringUtils.isNotBlank(result)) {
            carousels = JSON.parseObject(result, new TypeReference<List<Carousel>>() {
            });
            return carousels;
        }
        //如果不存在就查库
        carousels = carouselDao.findCarouselList(type);
        if (!CollectionUtils.isEmpty(carousels)) {
            baseRedis.set(String.format(RedisKeyEnum.CAROUSEL_KEY.getKey(), type), JSON.toJSONString(carousels), StaticUtil.out_time);
            return carousels;

        }
        return null;
    }
}
