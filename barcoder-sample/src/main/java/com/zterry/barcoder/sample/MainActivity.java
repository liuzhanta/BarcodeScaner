package com.zterry.barcoder.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_SCAN = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        startActivityForResult(new Intent(this, ScanActivity.class), REQ_CODE_SCAN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQ_CODE_SCAN == requestCode) {
            if (resultCode == RESULT_OK) {

                String result = data.getStringExtra(ScanActivity.EXTRA_SCAN_RESULT);
                ((TextView) findViewById(R.id.text)).append(result);
            }
        }
    }
}
