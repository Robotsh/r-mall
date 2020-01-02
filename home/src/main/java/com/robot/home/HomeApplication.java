package com.robot.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author robot
 * @date 2019/12/26
 */
@SpringBootApplication
public class HomeApplication {

    private static Logger logger = LoggerFactory.getLogger(HomeApplication.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SpringApplication.run(HomeApplication.class, args);
        long endTime = System.currentTimeMillis();
        logger.info("----- ProductApplication start  use time :{}", endTime - startTime);
    }

}
