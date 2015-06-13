/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.comment.resource;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.my.comment.redis.RedisSession;
import com.my.comment.response.Comment;
import com.my.comment.response.Response;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.arnx.jsonic.JSON;

/**
 *
 * @author yoovrajshinde
 */
@Path("comment/{commentId}")
public class CommentResource {
    @Inject
    RedisSession redisSession = Guice.createInjector().getInstance(RedisSession.class);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getComment(@PathParam("commentId") String commentId) {
        Comment comment = redisSession.getCommentData(commentId);
        return comment;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Comment updateComment(@PathParam("commentId") String commentId, 
           String commentString) {
        System.out.println("updateComment");
        Comment comment = JSON.decode(commentString, Comment.class);
        redisSession.putCommentData(commentId, comment);
        return comment;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteComment(@PathParam("commentId") String commentId) {
        System.out.println("Deleting comment");
        redisSession.deleteCommentData(commentId);
        return new Response("SUCCESS");
    }
}
