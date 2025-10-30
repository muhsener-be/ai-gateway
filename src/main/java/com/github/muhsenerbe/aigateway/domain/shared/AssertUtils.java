package com.github.muhsenerbe.aigateway.domain.shared;

public class AssertUtils {


    public static <T> T notNull(T obj, String message){
        if(obj == null)
            throw new IllegalObjectException(message);

        return obj;
    }
}
