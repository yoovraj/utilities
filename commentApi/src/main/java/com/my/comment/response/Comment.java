/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.comment.response;

/**
 *
 * @author yoovrajshinde
 */
public class Comment {
    private String id;
    private String value;
    private Long timestamp;

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", value=" + value + ", timestamp=" + timestamp + '}';
    }
    
}
