package com.robot.api.util;

import redis.clients.jedis.JedisPool;

/**
 * @author robot
 * @date 2019/12/30 10:26
 */
public interface JedisPoolI{

    JedisPool redisPoolFactory()throws Exception ;
}
