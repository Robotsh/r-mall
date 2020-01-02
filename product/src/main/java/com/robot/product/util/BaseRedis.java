package com.robot.product.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * @author robot
 * @date 2019/12/9 17:29
 */
@Service
public class BaseRedis {

    @Autowired
    private JedisPool jedisPool;

    private static Logger logger = LoggerFactory.getLogger(BaseRedis.class);

    public void set(String key, String str) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, str);
        } catch (Exception e) {
            logger.error("redis set error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void set(String key, String str, int time) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, str);
            jedis.expire(key, time);
        } catch (Exception e) {
            logger.error("redis set error", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            logger.error("redis set error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.del(key);
        } catch (Exception e) {
            logger.error("redis del error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String set(String key, String value, String nxxx, String expx, long time) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.set(key, value, nxxx, expx, time);
        } catch (Exception e) {
            logger.error("redis setnx error", e);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

}
