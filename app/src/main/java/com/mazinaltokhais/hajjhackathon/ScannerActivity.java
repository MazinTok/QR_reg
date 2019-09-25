package com.mazinaltokhais.hajjhackathon;

import com.mazinaltokhais.hajjhackathon.scan.*;

import com.mazinaltokhais.hajjhackathon.scan.CodeScanner;
import com.mazinaltokhais.hajjhackathon.scan.CodeScannerView;
import com.mazinaltokhais.hajjhackathon.scan.DecodeCallback;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v4.app.ActivityCompat;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;

//import com.budiyev.android.codescanner.CodeScanner;
//import com.budiyev.android.codescanner.CodeScannerView;
//import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static com.budiyev.android.codescanner.CodeScanner.CAMERA_FRONT;

public class ScannerActivity extends AppCompatActivity {

    private CodeScanner mCodeScanner;
    CodeScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        scannerView = findViewById(R.id.scanner_view);

//        ActivityCompat.requestPermissions(this,
//                new String[]{android.Manifest.permission.CAMERA},
//                100);


        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) this, android.Manifest.permission.CAMERA)) {

                //Show permission dialog
            } else {

                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions((Activity)this, new String[]{android.Manifest.permission.CAMERA}, 100);
            }
        }
//        scannerView.setRotationX(150);
        mCodeScanner = new CodeScanner(this, scannerView, CAMERA_FRONT );
        mCodeScanner.setCamera(CAMERA_FRONT);


//        scannerView.setRotationX(180);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                ScannerActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                     //   Toast.makeText(ScannerActivity.this, result.getText(), Toast.LENGTH_SHORT).show();
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("result",result.getText());
                        setResult(Activity.RESULT_OK,returnIntent);
                        finish();
                    }
                });
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
//                scannerView.setRotationX(180);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }
}
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_scanner);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    }
//
//}
