package com.zj.zlgx;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import java.io.File;

public class MainActivity extends AppCompatActivity {

    private String mPatchPath = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "version1.0_2.0.patch";

    private String mNewApkPath = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "version2.0.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

    }

    private void initData() {


        //校验签名

        try {

            String signature = SignatureUtil.getSignature(getPackageResourcePath());
            startMerge(signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!new File(mPatchPath).exists()) {

            return;
        }


    }

    private void startMerge(String signature) {

        if (AppConfig.signature.equals(signature)) {
            Log.e("========", "校验签名成功！");

            new Thread(new Runnable() {
                @Override
                public void run() {

                    MergeApkUtil.mergeApk(getPackageResourcePath(), mNewApkPath, mPatchPath);
                    // 5.安装最新版本 (网上搜索怎么安装apk)
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(new File(mNewApkPath)),
                            "application/vnd.android.package-archive");
                    startActivity(intent);

                    //安装完成后删除拆分包




                }
            }).start();


        } else {
            Log.e("========", "校验签名失败！");
        }

    }


}
