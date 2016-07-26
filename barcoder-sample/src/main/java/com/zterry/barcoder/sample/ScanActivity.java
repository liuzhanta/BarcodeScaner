package com.zterry.barcoder.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.CompoundBarcodeView;


/**
 * Desc:扫码界面
 * Author: Terry
 * Date:2016-05-03
 */
public class ScanActivity extends AppCompatActivity implements CaptureManager.OnBarcodeCallBack {

    public static final String EXTRA_SCAN_RESULT = "EXTRA_SCAN_RESULT";

    private CaptureManager capture;
    private CompoundBarcodeView barcodeScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        initCaptureManager(savedInstanceState);
    }

    private void initCaptureManager(Bundle savedInstanceState) {
        barcodeScannerView = (CompoundBarcodeView) findViewById(R.id.zxing_barcode_scanner);
        capture = new CaptureManager(this, barcodeScannerView);
        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.setOnBarcodeCallBack(this);
        capture.decode();
    }


    @Override
    protected void onResume() {
        super.onResume();
        capture.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        capture.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        capture.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        capture.onSaveInstanceState(outState);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return barcodeScannerView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBarcodeResult(String content) {
        Intent data = new Intent();
        data.putExtra(EXTRA_SCAN_RESULT, content);
        setResult(RESULT_OK, data);
        finish();
    }

}
