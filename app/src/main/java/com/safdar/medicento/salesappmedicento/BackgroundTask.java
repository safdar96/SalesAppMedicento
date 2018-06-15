package com.safdar.medicento.salesappmedicento;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String, Void, String> {
    Context ctx;

    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String reg_url = "http://192.168.0.9/areaData.php";
        String method = strings[0];
        if(method.equals("area")){
            String area = strings[1];
            String city = strings[2];
            String state =  strings[3];
            String pincode = strings[4];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("area_name", "UTF-8") + "=" + URLEncoder.encode(area,"UTF-8") + "&" +
                        URLEncoder.encode("area_city","UTF-8") + "=" + URLEncoder.encode(city,"UTF-8") + "&" +
                        URLEncoder.encode("area_state","UTF-8") + "=" + URLEncoder.encode(state,"UTF-8")+ "&" +
                        URLEncoder.encode("area_pincode","UTF-8") + "=" + URLEncoder.encode(pincode,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Data Saved ... ";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String aVoid) {
        Toast.makeText(ctx, aVoid,Toast.LENGTH_LONG).show();
    }
}


