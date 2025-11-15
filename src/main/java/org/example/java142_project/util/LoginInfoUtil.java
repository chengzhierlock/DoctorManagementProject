package org.example.java142_project.util;

import java.util.Map;

public class LoginInfoUtil {
    static ThreadLocal<Map<Integer,Object>> local = new ThreadLocal<>();
    public static void setLoginInfo(Map<Integer,Object> map) {
        local.set(map);
    }

    public static Map<Integer,Object> getLoginInfo() {
        return local.get();
    }
}
