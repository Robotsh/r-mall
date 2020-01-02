package com.robot.product.provider;

import com.robot.api.pojo.Carousel;
import com.robot.product.service.CarouselService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品服务的提供者
 *
 * @author robot
 * @date 2019/12/26 15:09
 */
@Service(version = "1.0.0", timeout = 5000)
public class CarouselProvider implements CarouselService {

    @Resource
    private CarouselService carouselService;

    public List<Carousel> findCarouselList(int type) {
        return carouselService.findCarouselList(type);

    }

}
