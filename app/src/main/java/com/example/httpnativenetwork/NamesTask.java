package com.example.httpnativenetwork;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by admin on 8/4/2016.
 */
public class NamesTask extends AsyncTask<String, Void, String > {
    private static final String TAG ="NamesTaskTAG_" ;

    private TextView mTextView;
    private MainActivity mMainActivity;

    public NamesTask(TextView mTextView) {

        this.mTextView = mTextView;
    }

    public NamesTask(MainActivity mainActivity) {

        mMainActivity = mainActivity;
    }

    @Override
    protected String doInBackground(String... strings) {

        String url = "http://www.mocky.io/v2/57a01bec0f0000c10d0f650f";

        HttpURLConnection httpURLConnection = null;

        try {
            URL urlFormatted = new URL(url);

            httpURLConnection
                    = (HttpURLConnection) urlFormatted.openConnection();

            InputStream inputStream
                    = new BufferedInputStream(httpURLConnection.getInputStream());

            Scanner scanner = new Scanner(inputStream);

            StringBuilder stringBuilder = new StringBuilder();

            while (scanner.hasNext()){
                stringBuilder.append(scanner.next());
            }

            return stringBuilder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(httpURLConnection != null)
                httpURLConnection.disconnect();
        }

        return "";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.d(TAG, "onPostExecute: " + s);

//        mTextView.setText(s);

        mMainActivity.loadData(s);
    }
}
