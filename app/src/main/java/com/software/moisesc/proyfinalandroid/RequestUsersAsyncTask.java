package com.software.moisesc.proyfinalandroid;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestUsersAsyncTask extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) {
        // Login
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        Uri buildUri = Uri.parse("http://dip-androiducbv2.herokuapp.com/");
        try {
            URL url = new URL(buildUri.toString());

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.addRequestProperty("Content-Type", "application/json");
            //urlConnection.setConnectTimeout(1000);
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer buffer = new StringBuffer();

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
            }

            String usersJSON = buffer.toString();
            Log.d("Thread", usersJSON);
        } catch (IOException ex) {
            Log.e("MainActivity", ex.getMessage());
        }
        return null;
    }
}
