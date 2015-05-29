/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.comment.redis;

import com.google.inject.ImplementedBy;
import com.my.comment.redis.impl.RedisSessionImpl;

/**
 *
 * @author yoovrajshinde
 */
@ImplementedBy(RedisSessionImpl.class)
public interface RedisSession {
    public String getData(String key);

}
