/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.comment.redis;

import com.google.inject.ImplementedBy;
import com.my.comment.redis.impl.RedisSessionImpl;
import com.my.comment.response.Comment;

/**
 *
 * @author yoovrajshinde
 */
@ImplementedBy(RedisSessionImpl.class)
public interface RedisSession {
    public String getData(String key);
    public Comment getCommentData(String key);
    public void putCommentData (String key, Comment comment);
    public void deleteCommentData(String key);

}
