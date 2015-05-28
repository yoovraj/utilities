/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.comment.resource;

import com.my.comment.response.Comment;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author yoovrajshinde
 */
@Path("comment/{commentId}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
    
    @GET
    public Comment getComment(@PathParam("commentId") String commentId) {
        Comment comment = new Comment();
        comment.setId("1000");
        comment.setValue("Hello Comment");
        comment.setTimestamp(System.currentTimeMillis()/1000);
        
        return comment;
    }
    
    @PUT
    public String updateComment(@PathParam("commentId") String commentId, 
            Comment comment) {
        return null;
    }
}
