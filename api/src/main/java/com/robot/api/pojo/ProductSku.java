package com.robot.api.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author robot
 * @date 2019/12/19 15:17
 */
@Data
public class ProductSku implements Serializable {

    /**
     * id
     */
    private int id;

    /**
     * sku
     */
    private String sku;

    /**
     * 名称
     */
    private String name;

    /**
     * title
     */
    private String title;

    /**
     * 主图
     */
    private String img;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private String stock;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
