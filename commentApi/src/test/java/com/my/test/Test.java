/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.test;

import com.google.inject.Guice;
import com.my.comment.redis.RedisSession;
import com.my.comment.response.Comment;
import junit.framework.TestCase;

/**
 *
 * @author yoovrajshinde
 */
public class Test extends TestCase{
    RedisSession session = Guice.createInjector().getInstance(RedisSession.class);;

    public void testJedis() {
        System.out.println("session="  + session);
        String test = "Test";
        System.out.println("org :" + test);
        System.out.println("relace1 :"  + test.replaceFirst("^.", String.valueOf(Character.toLowerCase(test.charAt(0)))));
    }
    
    
    public void testComment() {
        Comment comment = new Comment();
        comment.setId("100");
        comment.setValue("Hundred");
        comment.setTimestamp(System.currentTimeMillis()/1000);
        
        Comment comment1 = new Comment();
        System.out.println(comment.generateValueMap().toString());
        comment1.valueMap(comment.generateValueMap());
        System.out.println(comment1.generateValueMap().toString());
        
    }
}
