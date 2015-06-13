/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.comment.response;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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

//    public Map<String, String> generateValueMap() {
//        Map<String, String> valueMap = new HashMap<>();
//        valueMap.put("id", id);
//        valueMap.put("value" , value);
//        if (timestamp != null) {
//            valueMap.put("timestamp", timestamp.toString());
//        }
//        return valueMap;
//    }
//    
    public Map<String, String> generateValueMap() {
        Map<String, String> valueMap = new HashMap<>();
        for(Method m : this.getClass().getMethods()) {
            if(m.getName().startsWith("get")) {
                String fieldName = m.getName().replaceFirst("^get", "");
                fieldName = fieldName.replaceFirst("^.", String.valueOf(Character.toLowerCase(fieldName.charAt(0))));

                try {
                    Object o = m.invoke(this);
                    if (null != o && null != o.toString()) {
                        valueMap.put(fieldName, m.invoke(this).toString());
                    }
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    System.out.println("Cannot find getter");
                    System.out.println(ex);
                }
            }
        }
        return valueMap;
    }
    public Comment valueMap(Map<String, String> valueMap) {
        Map<String, Method> methodMap = new HashMap<>();
        for(Method m : this.getClass().getMethods()) {
            System.out.println("--" + m.getName());
            if(m.getName().startsWith("set")) {
                String fieldName = m.getName().replaceFirst("^set", "");
                fieldName = fieldName.replaceFirst("^.", 
                        String.valueOf(Character.toLowerCase(fieldName.charAt(0))));
                System.out.println("fieldName " + fieldName);
                methodMap.put(fieldName, m);
            }
        }
        for (Map.Entry<String, String> entrySet : valueMap.entrySet()) {
            if (null == entrySet.getValue()) {
                continue;
            }
            String key = entrySet.getKey();
            Method m = methodMap.get(key);
            if (null == m) {
                System.out.println("method null for key=" + key);
                continue;
            }
            System.out.println("method for key=" + key + " method=" + m.getName());
            try {
                Class[] c = m.getParameterTypes();
                try {
                    if (!"java.lang.String".equals(c[0].getCanonicalName()) ) {
                        System.out.println("class" + c[0].getCanonicalName());
                        m.invoke(this, (c[0].getMethod("valueOf").invoke(null, entrySet.getValue())));
                    } else {
                        m.invoke(this, entrySet.getValue());
                    }
                } catch (NoSuchMethodException | SecurityException ex) {
                    Logger.getLogger(Comment.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                System.out.println(ex);
            }
        }
        return this;
    }
    @Override
    public String toString() {
        Map<String, String> valueMap = generateValueMap();
        return valueMap.toString();
    }
    
}
