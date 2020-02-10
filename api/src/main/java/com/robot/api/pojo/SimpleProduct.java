package com.robot.api.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author robot
 * @date 2019/12/11 16:41
 */
@Data
public class SimpleProduct implements Serializable {

    /**
     * sku
     */
    private String sku;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private int stock;
}
