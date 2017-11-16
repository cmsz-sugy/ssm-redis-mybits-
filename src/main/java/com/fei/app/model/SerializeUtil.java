package com.fei.app.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import net.sf.json.JSONObject;


public class SerializeUtil {  
    public static byte[] serialize(Object object) {  
        ObjectOutputStream oos = null;  
        ByteArrayOutputStream baos = null;  
        try {  
        //序列化  
        baos = new ByteArrayOutputStream();  
        oos = new ObjectOutputStream(baos);  
        oos.writeObject(object);  
        byte[] bytes = baos.toByteArray();  
        return bytes;  
        } catch (Exception e) {  
         e.printStackTrace();  
        }  
        return null;  
        }  
           
        public static Object deserialize(byte[] bytes) {  
        ByteArrayInputStream bais = null;  
        try {  
        //反序列化  
        bais = new ByteArrayInputStream(bytes);  
        ObjectInputStream ois = new ObjectInputStream(bais);  
        return ois.readObject();  
        } catch (Exception e) {  
           
        }  
        return null;  
        }  
}       