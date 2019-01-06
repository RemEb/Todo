package com.todo.util;

/**
 * @author Lcy
 * @date 2018/12/26 19:08
 */


import java.util.UUID;

public class IDUtil {

    /**
     * 获取主键
     * @return
     */
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
