package com.robot.api.enums;

/**
 * @author robot
 * @date 2019/12/11 15:08
 */
public enum RedisKeyEnum {
    PRODUCT_KEY("商品List", "PRODUCT_KEY:::%s"),
    PRODUCT_DETAIL_KEY("商品详情", "PRODUCT_DETAIL_KEY:::%s"),
    CAROUSEL_KEY("首页轮播图","CAROUSEL_KEY:::%s");
    private String describe;

    private String key;

    RedisKeyEnum(String describe, String key) {
        this.describe = describe;
        this.key = key;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
