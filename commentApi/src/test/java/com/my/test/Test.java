/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.test;

import com.my.comment.redis.RedisSession;
import com.my.comment.redis.impl.RedisSessionImpl;
import junit.framework.TestCase;

/**
 *
 * @author yoovrajshinde
 */
public class Test extends TestCase{
    RedisSession session = new RedisSessionImpl();
    
    public void testJedis() {
        System.out.println("session="  + session);
    }
}
