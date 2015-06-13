/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.comment.redis.impl;

import com.my.comment.redis.*;
import com.google.inject.Singleton;
import com.my.comment.response.Comment;
import java.util.Map;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 * @author yoovrajshinde
 */
@Singleton
public class RedisSessionImpl implements RedisSession{
    private final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
    
    @Override
    public String getData(String key) {
        String value;
        try (Jedis jedis = pool.getResource()) {
            value = jedis.get(key);
        }
        return value;
    }
    @Override
    public Comment getCommentData(String key) {
        Map<String, String> valueMap;
        try (Jedis jedis = pool.getResource()) {
            valueMap = jedis.hgetAll(key);
        }
        return new Comment().valueMap(valueMap);
    }
    
    @Override
    public void putCommentData (String key, Comment comment) {
        try (Jedis jedis = pool.getResource()) {
            jedis.hmset(key, comment.generateValueMap());
        }
    }
    
    @Override
    public void deleteCommentData(String key) {
        try (Jedis jedis = pool.getResource()) {
            jedis.del(key);
        }
    }
}
