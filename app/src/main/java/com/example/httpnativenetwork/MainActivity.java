package com.example.httpnativenetwork;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG_";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 /*       StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);*/

        mTextView = (TextView) findViewById(R.id.txt1);
    }

    public void doMagic(View view) {

        //            Log.d(TAG, "doMagic: " + stringBuilder);

//        new NamesTask(mTextView).execute();
            new NamesTask(this).execute();


//        mTextView.setText(stringBuilder);
    }

    public void loadData(String s) {

        mTextView.setText(s);

    }
}
