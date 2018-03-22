package com.vst.jnitest;

/**
 * Created by zwy on 2018/3/21.
 * email:16681805@qq.com
 */

public class JniTest {
    static {
        System.loadLibrary("native-lib");
    }

    public static native String sayHello();

}
