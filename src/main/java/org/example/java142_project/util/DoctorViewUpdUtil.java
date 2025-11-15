package org.example.java142_project.util;

import org.example.java142_project.vo.DoctorVO;

import java.util.Map;

public class DoctorViewUpdUtil {

    //    1是线程本地变量查看，2是更新
    static ThreadLocal<Map<Integer, DoctorVO>> local = new ThreadLocal<>();

    public static ThreadLocal<Map<Integer, DoctorVO>> getLocal() {
        return local;
    }

    public static void setLocal(ThreadLocal<Map<Integer, DoctorVO>> local) {
        DoctorViewUpdUtil.local = local;
    }
    public static void setLocal(Map<Integer, DoctorVO> map) {
        local.set(map);
    }


}
