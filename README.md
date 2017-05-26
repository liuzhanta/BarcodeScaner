# BarcodeScaner

仿微信二维码扫描,基于journeyapps/ [zxing-android-embedded](https://github.com/journeyapps/zxing-android-embedded)开发


Screenshot
----------
![](https://github.com/liuzhanta/BarcodeScaner/blob/master/image.jpg) ![](https://github.com/liuzhanta/BarcodeScaner/blob/master/screen_shot.gif)

Usage Xml
---------
    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
    
        <com.journeyapps.barcodescanner.CompoundBarcodeView
            android:id="@+id/zxing_barcode_scanner"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
    
    </RelativeLayout>

Usage Code
----------
Put the following code in your Activity.onCreate() method

    private void initCaptureManager(Bundle savedInstanceState) {
            barcodeScannerView = (CompoundBarcodeView) findViewById(R.id.zxing_barcode_scanner);
            capture = new CaptureManager(this, barcodeScannerView);
            capture.initializeFromIntent(getIntent(), savedInstanceState);
            capture.setOnBarcodeCallBack(this);
            capture.decode();
    }

You can receive and handle your result after scan through implement the interface _CaptureManager.OnBarcodeCallBack_

     @Override
        public void onBarcodeResult(String content) {
            Intent data = new Intent();
            data.putExtra(EXTRA_SCAN_RESULT, content);
            setResult(RESULT_OK, data);
            finish();
        }
        
And Handling the Scanner's lifecycle in your Activity

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

You could also handling the OnKeyDownEvent by call the CompoundBarcodeView.onKeyDown(keyCode, event).

    @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            return barcodeScannerView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
        }


Adding aar dependency
---------------------
 1. download the sample
 2. Android Studio : **File** - **New** - **Import Module**, and choose source directory
 3. Add the following to your build.gradle file:
 
 
        dependencies {
             compile project(':zxing-barcoder-embed')
        }

Notice: For more information you can visit the repository [zxing-android-embedded](https://github.com/journeyapps/zxing-android-embedded).
And Thanks for the help _**journeyapps**_ again.

Developed by
------------
Name: ZTerry Liu  
E-mail: tata1989y@gmail.com  
Subject: BarcodeScaner 

License
---------

    Copyright 2016 刘战塔
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.      



