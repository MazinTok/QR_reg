package com.mazinaltokhais.hajjhackathon;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.design.widget.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.Result;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    private CodeScanner mCodeScanner;
    CodeScannerView scannerView;
    TextView BottleCountText ;//= (TextView) findViewById(R.id.BottleCount);
    TextView WalletText ;//= (TextView) findViewById(R.id.BottleCount);
    private ImageButton ScannerBtn;
    private ImageButton MapBtn;

    private static final String TAG ="testFB" ;
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    DatabaseReference myRef ;//= database.getReference();
//    DatabaseReference myRef1 ;//= database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        InitioalViewas();
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //--------------------------------------------------------

        //        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//            }
//        });
//        ReadFromFB_Bottles();
//        ReadFromFB_Wallet();
        //readFromFB_Recycle_bins("0");

        ScannerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.CAMERA}, 100);
                    }
                    else {
                        // Already grant Camera permission. Now call your QR scan Activity
                        Intent myIntent = new Intent(MainActivity.this, ScannerActivity.class);
                        //  myIntent.putExtra("key", value); //Optional parameters
                      //  MainActivity.this.startActivity(myIntent);
                        startActivityForResult(myIntent, 1);
                        //Scanner();
                    }
                }else {
//                    // call your QR scan Activity
//                    Intent myIntent = new Intent(MainActivity.this, ScannerActivity.class);
//                    //  myIntent.putExtra("key", value); //Optional parameters
//                    MainActivity.this.startActivity(myIntent);
//                    Scanner();
                    Intent myIntent = new Intent(MainActivity.this, ScannerActivity.class);
                  //  MainActivity.this.startActivity(myIntent);
                    startActivityForResult(myIntent, 1);
                }

            }
        });

        MapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.CAMERA}, 100);
                    }
                    else {
                        // Already grant Camera permission. Now call your QR scan Activity
                        Intent myIntent = new Intent(MainActivity.this, MapsActivity.class);
                        //  myIntent.putExtra("key", value); //Optional parameters
                        //  MainActivity.this.startActivity(myIntent);
                        startActivityForResult(myIntent, 1);
                        //Scanner();
                    }
                }else {
//                    // call your QR scan Activity
//                    Intent myIntent = new Intent(MainActivity.this, ScannerActivity.class);
//                    //  myIntent.putExtra("key", value); //Optional parameters
//                    MainActivity.this.startActivity(myIntent);
//                    Scanner();
                    Intent myIntent = new Intent(MainActivity.this, MapsActivity.class);
                    //  MainActivity.this.startActivity(myIntent);
                    startActivityForResult(myIntent, 1);
                }

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");

                if (!result.startsWith("http://") && !result.startsWith("https://"))
                    result = "http://" + result;

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(result));
                startActivity(browserIntent);
//                That works fine for me.
//
//                        As for the missing "http://" I'd just do something like this:


///------------
//                String[] tokens = result.split("/");
//                int val , id ;
//                id = Integer.parseInt(tokens[1]);
//                val = Integer.parseInt(tokens[0]);
//
//               // WriteTOFBBottlesTest(val);// WriteTOFBRecycleBin( id,  val);
//                // String NumberOfBottles =
//                readFromFB_Recycle_bins(tokens[1],Integer.valueOf(tokens[0]));
//               // android.os.SystemClock.sleep(5000);
//                val += Integer.parseInt("3");//NumberOfBottles);
//
//                for (String t : tokens)
//                    System.out.println(t);

                //----------

//                String Bottles = BottleCountText.getText().toString();
//                int temp = Integer.parseInt(Bottles)+Integer.parseInt(tokens[0]);
//
//                BottleCountText.setText(valueOf(temp));
//                WriteTOFBBottles(temp);
//                double tempWallet = temp * 0.05;
//                tempWallet = Math.floor(tempWallet * 100) / 100;
//                WalletText.setText(String.valueOf(tempWallet));
//                WriteTOFBWallet(tempWallet);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult
    public void InitioalViewas()
    {
//         myRef = database.getReference();
//         myRef1 = database.getReference();

        BottleCountText = (TextView) findViewById(R.id.BottleCount);
        BottleCountText.setText("0");

        WalletText = (TextView) findViewById(R.id.WalletText);
        WalletText.setText("0");

        ScannerBtn = (ImageButton)findViewById(R.id.ScannerBtn);
        MapBtn = (ImageButton)findViewById(R.id.mapBtn);

         scannerView = (CodeScannerView)findViewById(R.id.scanner_view_main);

        TextView BottleCountText ;//= (TextView) findViewById(R.id.BottleCount);
    }
//    public void ReadFromFB_Bottles()
//    {
//
//        // Read from the database
//        Query myTopPostsQuery = myRef.child("Users").child(Build.SERIAL).child("Bottles");
//        myTopPostsQuery.addListenerForSingleValueEvent(new ValueEventListener() {
//        //myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                if (dataSnapshot.exists()) {
//                    String value = dataSnapshot.getValue().toString();
//                    Log.d(TAG, "Value is: " + value);
//                    BottleCountText.setText(value);
//                }
//                else {
//                    WriteTOFB();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                Log.w(TAG, "Failed to read value.", databaseError.toException());
//            }
//
//        });
//    }
//    public void readFromFB_Recycle_bins(String RecycleBin, final int NumberOfBottoles) {
//
//
//    final String[] value = new String[1];
//
//        // Read from the database
//        final int BId = Integer.valueOf(RecycleBin);
//        Query myTopPostsQuery1 = myRef1.child("RecyclePins").child(RecycleBin);
//        myTopPostsQuery1.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
//        //myTopPostsQuery1.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//              //  Log.d(TAG, "Failed to read value.", "A");
//                Log.d(TAG, "Valuessssssssssss is: " + "ss");
//                if (dataSnapshot.exists()) {
//                     value[0] = dataSnapshot.child("bottles").getValue().toString();
//                    Log.d(TAG, "Value is: " + value[0]);
//                    WriteTOFBRecycleBin( BId,  Integer.parseInt(value[0])+NumberOfBottoles);
//                }
//
//            }
//            @Override
//            public void onCancelled( DatabaseError databaseError) {
//                //throw databaseError.toException();
//                Log.d(TAG, "Failed to read value.");
//            }
//        });
//
//}
//    public void WriteTOFBRecycleBin(int id, int val)
//    {
////Integer.toString(id
//        myRef.child("RecyclePins").child(String.valueOf(id)).child("bottles").setValue(val);
//
//    }
//    public void ReadFromFB_Wallet()
//    {
//
//        // Read from the database
//    Query myTopPostsQuery = myRef.child("Users").child(Build.SERIAL).child("Wallet");
//        myTopPostsQuery.addListenerForSingleValueEvent(new ValueEventListener() {
//            //myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                if (dataSnapshot.exists()) {
//                    String value = dataSnapshot.getValue().toString();
//                    Log.d(TAG, "Value is: " + value);
//                    WalletText.setText(value);
//                }
//                else {
//                    WriteTOFB();
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                Log.w(TAG, "Failed to read value.", databaseError.toException());
//            }
//
////            @Override
////            public void onCancelled(DatabaseError error) {
////                // Failed to read value
////
////            }
//        });
//    }
//
//    public void WriteTOFBBottles(int val)
//    {
//
//        myRef.child("Users").child(Build.SERIAL).child("Bottles").setValue(val);
//
//    }
//    public void WriteTOFBBottlesTest(int val)
//    {
//
//        myRef.child("RecyclePins").child("3").child("bottles").setValue(val);
//
//    }
//    public void WriteTOFBWallet(double val)
//    {
//
//        myRef.child("Users").child(Build.SERIAL).child("Wallet").setValue(val);
//
//    }
//    public void WriteTOFB()
//    {
//        //myRef.child("Users").setValue(Build.SERIAL);
//        myRef.child("Users").child(Build.SERIAL).child("Bottles").setValue(0);
//        myRef.child("Users").child(Build.SERIAL).child("Wallet").setValue(0.0);
//        myRef.child("Users").child(Build.SERIAL).child("Name").setValue("Mazin");
//
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
    public void Scanner()
    {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) this, android.Manifest.permission.CAMERA)) {

                //Show permission dialog
            } else {

                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions((Activity)this, new String[]{android.Manifest.permission.CAMERA}, 100);
            }
        }
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, result.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });

    }
}
