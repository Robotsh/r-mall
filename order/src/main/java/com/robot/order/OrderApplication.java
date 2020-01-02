package com.robot.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author robot
 * @date 2019/12/09
 */
@SpringBootApplication
public class OrderApplication {

    private static Logger logger = LoggerFactory.getLogger(OrderApplication.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SpringApplication.run(OrderApplication.class, args);
        long endTime = System.currentTimeMillis();
        logger.info("----- MemberApplication start  use time :{}", endTime - startTime);
    }

}
