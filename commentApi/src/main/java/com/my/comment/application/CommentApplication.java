/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.comment.application;

import com.my.comment.resource.CommentResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author yoovrajshinde
 */
@ApplicationPath("resources")
public class CommentApplication extends Application{

//    static {
//        Guice.createInjector(new Module() {
//
//            @Override
//            public void configure(Binder binder) {
//                binder.bind(RedisSession.class).to(RedisSessionImpl.class);
//            }
//        }).getInstance(RedisSession.class);
//    }
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(CommentResource.class);
        return s;
    }
    
}
