package com.chris.life.pages.main;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.chris.life.R;
import com.tbruyelle.rxpermissions.RxPermissions;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import rx.functions.Action1;

public class QrCodeActivity extends AppCompatActivity implements QRCodeView.Delegate {
    private ZXingView mZXingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_qr_code);

        initView();
    }

    private void initView() {
        mZXingView = findViewById(R.id.zxv_home_qrcode_scan);
        mZXingView.setDelegate(this);

        if (Build.VERSION.SDK_INT >= 23) {
            RxPermissions.getInstance(this)
                    .request(Manifest.permission.CAMERA)
                    .subscribe(new Action1<Boolean>() {
                        @Override
                        public void call(Boolean aBoolean) {
                            if (aBoolean) {
                                mZXingView.startCamera();
                                mZXingView.startSpotDelay(500);
                                Toast.makeText(QrCodeActivity.this, "6.0获取权限成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(QrCodeActivity.this, "权限被拒绝", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    });
        } else {
            Toast.makeText(QrCodeActivity.this, "权限被拒绝", Toast.LENGTH_SHORT).show();
            mZXingView.startCamera();
            mZXingView.startSpotDelay(500);
        }
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);

        mZXingView.startSpot();//可以多次识别
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Toast.makeText(this, "无法识别", Toast.LENGTH_SHORT).show();
    }
}
