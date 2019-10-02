package com.chris.base.scanloginapp;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tbruyelle.rxpermissions.RxPermissions;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import rx.functions.Action1;

public class ScanActivity extends AppCompatActivity implements QRCodeView.Delegate {
    private ZXingView zXingView;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        getUserInfo();
        initView();
    }

    private void getUserInfo() {
        //SharedPreferences sp = getSharedPreferences("loginUser",MODE_PRIVATE);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        username = sp.getString("username", "unkown");
        password = sp.getString("password", "unkown");
        Toast.makeText(ScanActivity.this, username + " : " + password, Toast.LENGTH_LONG).show();
        setTitle(username + " : " + password);
    }

    private void initView() {
        zXingView = findViewById(R.id.zxv_qrcode_scan);
        zXingView.setDelegate(this);

        if (Build.VERSION.SDK_INT >= 23) {
            RxPermissions.getInstance(this)
                    .request(Manifest.permission.CAMERA)
                    .subscribe(new Action1<Boolean>() {
                        @Override
                        public void call(Boolean aBoolean) {
                            if (aBoolean) {
                                zXingView.startCamera();
                                zXingView.startSpotDelay(500);
                                Toast.makeText(ScanActivity.this, "6.0获取权限成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ScanActivity.this, "权限被拒绝", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    });
        } else {
            Toast.makeText(ScanActivity.this, "权限被拒绝", Toast.LENGTH_SHORT).show();
            zXingView.startCamera();
            zXingView.startSpotDelay(500);
        }
    }

    @Override
    public void onScanQRCodeSuccess(final String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        //振动器
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);

        //发出请求
        HttpUtils.login(username, password, result, new LoginCallback<String>() {
            @Override
            public void success(String data) {
                Toast.makeText(ScanActivity.this, username + " : " + password + " : " + result, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void failed(String message, Throwable t) {
                Toast.makeText(ScanActivity.this, "发送失败", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //zXingView.startSpot();//可以多次识别
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Toast.makeText(this, "无法识别", Toast.LENGTH_SHORT).show();
    }


}
