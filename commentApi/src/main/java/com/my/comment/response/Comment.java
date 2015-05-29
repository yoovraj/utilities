/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.comment.response;

import java.util.HashMap;
import java.util.Map;

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

    public Map<String, String> getValueMap() {
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("id", id);
        valueMap.put("value" , value);
        valueMap.put("timestamp", timestamp.toString());
        return valueMap;
    }
    
    public Comment setValueMap(Map<String, String> valueMap) {
        id = valueMap.get("id");
        value = valueMap.get("value");
        timestamp = Long.valueOf(valueMap.get("timestamp"));
        return this;
    }
    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", value=" + value + ", timestamp=" + timestamp + '}';
    }
    
}
