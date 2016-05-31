package com.example.amanda.driverapplication;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PaymentHistory extends AppCompatActivity {

    TextView txtcrimex;
    String licNo;
    TextView txtfx;
    TextView txtrefz;
    TextView txtpdte;
    private static final String JSON_ARRAY = "result";
    TextView txtpaymode;
    ImageButton btnPrev;
    ImageButton btnNext;
    private String myJSONString;
    private int TRACK = 0;
    String JSON_URL = "http://www.softizon.tk/Final/payHistory.php?licenseNumber=";
    private JSONArray users = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);


        txtcrimex = (TextView) findViewById(R.id.txtcrimeeee);
        txtfx = (TextView) findViewById(R.id.txtfff);
        txtrefz = (TextView) findViewById(R.id.pd);
        txtpdte = (TextView) findViewById(R.id.tefn);
        txtpaymode = (TextView) findViewById(R.id.payment);

        loadData();


    }

    public void extractJSON() {


        try {
            JSONObject jsonObject = new JSONObject(myJSONString);
            users = jsonObject.getJSONArray(JSON_ARRAY);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Toast.makeText(PreviousOffenses.this, "Username or password is wrong please try again", Toast.LENGTH_LONG).show();

    }

    private void loadData() {
        String url2 = getIntent().getStringExtra("licNo");
        String url = JSON_URL + url2;
        class GetJSON extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(PaymentHistory.this, "Please Wait...", null, true, true);
            }

            @Override
            protected String doInBackground(String... params) {
//json value updater
                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();

                } catch (Exception e) {
                    return null;
                }

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                //txtv.setText(s);
                myJSONString = s;
                //Toast.makeText(PreviousOffenses.this, myJSONString, Toast.LENGTH_LONG).show();
                extractJSON();
                showData();
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute(url);
    }

    public void moveNext2(View v) {
        if (TRACK < users.length()) {
            TRACK++;
        }
        showData();
    }

    private void showData() {
//json array items to textviews
        try {
            JSONObject jsonObject = users.getJSONObject(TRACK);


            txtcrimex.setText(jsonObject.getString("Crime Committed"));
            txtfx.setText(jsonObject.getString("Fee Charged"));
            txtrefz.setText(jsonObject.getString("Reference no"));
            txtpdte.setText(jsonObject.getString("Paid Date"));
            txtpaymode.setText(jsonObject.getString("ptype"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void movePrev2(View v) {
        if (TRACK > 0) {
            TRACK--;
        }
        showData();
    }
    //final review amanda completed, php modified
}
