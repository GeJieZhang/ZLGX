//
// Created by Administrator on 2018/1/3.
//

#include <jni.h>

#ifndef ZLGX_MERGE_APK_H
#define ZLGX_MERGE_APK_H

#ifdef __cplusplus
extern "C" {
#endif
JNIEXPORT void JNICALL
Java_com_zj_zlgx_MergeApkUtil_mergeApk(JNIEnv *env, jclass type, jstring oldApkPath_,
                                       jstring newApkPath_, jstring patchPath_);

#ifdef __cplusplus
}
#endif
#endif