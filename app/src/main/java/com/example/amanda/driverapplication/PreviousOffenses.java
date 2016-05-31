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

public class PreviousOffenses extends AppCompatActivity {
    TextView txtv;
    String licNo;
    TextView dd;
    private static final String JSON_ARRAY = "result";
    TextView fee;
    ImageButton btnPrev;
    ImageButton btnNext;
    private String myJSONString;
    private int TRACK = 0;
    String JSON_URL = "http://www.softizon.tk/Final/precrimes.php?licenseNumber=";
    private JSONArray users = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_offenses);
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        txtv = (TextView) findViewById(R.id.crime);
        dd = (TextView) findViewById(R.id.txtID);
        fee = (TextView) findViewById(R.id.txtFee);
        loadData();


    }

    public void extractJSON() {
//generating json array

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
                loading = ProgressDialog.show(PreviousOffenses.this, "Please Wait...", null, true, true);
            }

            @Override
            protected String doInBackground(String... params) {

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

    public void moveNext(View v) {
        if (TRACK < users.length()) {
            TRACK++;
        }
        showData();
    }

    private void showData() {
//json array elements to textviews
        try {
            JSONObject jsonObject = users.getJSONObject(TRACK);

            txtv.setText(jsonObject.getString("Crime Committed"));
            fee.setText(jsonObject.getString("Fee Charged"));
            dd.setText(jsonObject.getString("Issued Date"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void movePrev(View v) {
        if (TRACK > 0) {
            TRACK--;
        }
        showData();
    }
// review yasitha, amanda
}
