package com.zj.zlgx;

/**
 * Created by Administrator on 2018/1/3.
 */

public class MergeApkUtil {

    static {
        System.loadLibrary("bspatch");
    }


    /**
     * @param oldApkPath 原来的apk  1.0 本地安装的apk
     * @param newApkPath 合并后新的apk路径   需要生成的2.0
     * @param patchPath  差分包路径， 从服务器上下载下来
     */
    public static native void mergeApk(String oldApkPath, String newApkPath, String patchPath);


}
