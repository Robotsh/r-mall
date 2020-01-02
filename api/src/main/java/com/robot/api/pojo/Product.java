package com.robot.api.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 *
 * @author robot
 * @date 2019/12/11 11:45
 */
@Data
public class Product implements Serializable {

    /**
     * id
     */
    private String id;


    /**
     * name
     */
    private String name;

    /**
     * sku
     */
    private String sku;

    /**
     * 商品分类编号
     */
    private int categoryId;

    /**
     * 商家编号
     */
    private int merId;

    /**
     * 仓库Id
     */
    private int freightId;

    /**
     * 类型编号
     */
    private int typeId;

    /**
     * 简述
     */
    private String sketch;

    /**
     * 商品描述
     */
    private String intro;

    /**
     * 商品关键字
     */
    private String keywords;

    /**
     * 标签
     */
    private String tags;

    /**
     * 商品型号
     */
    private String marque;


    /**
     * 仓库条码
     */
    private String barcode;

    /**
     * 品牌编号
     */
    private int brandId;

    /**
     * 虚拟购买量
     */
    private int virtual;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 市场价格
     */
    private BigDecimal marketPrice;

    /**
     * 可以使用积分抵消
     */
    private int integral;

    /**
     * 库存
     */
    private int stock;

    /**
     * 库存警告
     */
    private int warnStock;

    /**
     * 封面图
     */
    private String pictureUrl;

    private String posters;

    /**
     * 状态 -1=>下架,1=>上架,2=>预售,0=>未上架
     */
    private int status;

    /**
     * 审核状态 -1 审核失败 0 未审核 1 审核成功
     */
    private int state;

    /**
     * 排序
     */
    private int sort;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
