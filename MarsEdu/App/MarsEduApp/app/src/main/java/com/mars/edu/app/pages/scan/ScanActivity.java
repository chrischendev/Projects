package com.mars.edu.app.pages.scan;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;

import com.chris.base.library.base.activity.BaseMvpActivity;
import com.chris.base.library.base.mvp.BasePresenter;
import com.mars.edu.app.R;
import com.mars.edu.app.locallibs.inject.DaggerActivityComponent;
import com.tbruyelle.rxpermissions.RxPermissions;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import rx.functions.Action1;

/**
 * @author Chris Chan
 * on 2019/7/10 17:03
 * use for:
 */
public class ScanActivity extends BaseMvpActivity implements ScanContracts.View, QRCodeView.Delegate {
    @Inject
    ScanPresenter scanPresenter;

    private ViewHolder vh;

    @Override
    protected BasePresenter getPresenter() {
        return scanPresenter;
    }

    @Override
    public void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.act_scan;
    }

    @Override
    public void createViewHolder() {
        vh = new ViewHolder(getContentView());
    }

    @Override
    public void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);

        vh.zxvHomeQrcodeScan.setDelegate(this);

        if (Build.VERSION.SDK_INT >= 23) {
            RxPermissions.getInstance(this)
                    .request(Manifest.permission.CAMERA)
                    .subscribe(new Action1<Boolean>() {
                        @Override
                        public void call(Boolean aBoolean) {
                            if (aBoolean) {
                                vh.zxvHomeQrcodeScan.startCamera();
                                vh.zxvHomeQrcodeScan.startSpotDelay(500);
                                Toast.makeText(ScanActivity.this, "6.0获取权限成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ScanActivity.this, "权限被拒绝", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    });
        } else {
            Toast.makeText(ScanActivity.this, "权限被拒绝", Toast.LENGTH_SHORT).show();
            vh.zxvHomeQrcodeScan.startCamera();
            vh.zxvHomeQrcodeScan.startSpotDelay(500);
        }
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);

        vh.zxvHomeQrcodeScan.startSpot();//可以多次识别
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Toast.makeText(this, "无法识别", Toast.LENGTH_SHORT).show();
    }

    static
    class ViewHolder {
        @BindView(R.id.zxv_home_qrcode_scan)
        ZXingView zxvHomeQrcodeScan;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
