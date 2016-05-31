package com.example.amanda.driverapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Home extends AppCompatActivity {
    TextView name;
    TextView lno;
    String namee;
    String lnooo;
    String points;
    public static final String licenseNo = "licenseNo";
    private static final String LOGIN_URL = "http://softizon.tk/Final/getPoints.php";
    //test
    String bb = "hna";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        name = (TextView) findViewById(R.id.txtname);
        lno = (TextView) findViewById(R.id.txtln);
        updateD();
        points();
    }

    private void points() {
        final String licNumb = getIntent().getStringExtra("licNo");


        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        points = response.trim().toString();

                        if (points.equals("")) {
                        } else {

                            //Toast.makeText(seePoints.this, "You have collected " + points + " out of 8 points avaialable", Toast.LENGTH_LONG).show();
                            //nextAct();
                            //Toast.makeText(seePoints.this, "You have collected " + points + " out of 8 points avaialable", Toast.LENGTH_LONG).show();
                            // Toast.makeText(seePoints.this, "You have collected " + points + " out of 8 points avaialable", Toast.LENGTH_LONG).show();


                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Home.this, "error", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(licenseNo, licNumb);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void nextAct(View v) {
        // Toast.makeText(Home.this, "You have collected " + points + " out of 8 points avaialable", Toast.LENGTH_LONG).show();
        //Toast.makeText(Home.this, "You have collected " + points + " out of 8 points avaialable", Toast.LENGTH_LONG).show();
        //Toast.makeText(Home.this, "You have collected " + points + " out of 8 points avaialable", Toast.LENGTH_LONG).show();
        //Toast.makeText(Home.this, "You have collected " + points + " out of 8 points avaialable", Toast.LENGTH_LONG).show();
        // Toast.makeText(Home.this, "You have collected " + points + " out of 8 points avaialable", Toast.LENGTH_SHORT).show(); lnooo = getIntent().getStringExtra("licNo");
        Intent intent = new Intent(this, Points.class);
        intent.putExtra("points", points);
        startActivity(intent);
    }

    private void updateD() {
        namee = getIntent().getStringExtra("name");
        lnooo = getIntent().getStringExtra("licNo");

        name.setText(namee.toString());
        lno.setText(lnooo.toString());
    }

    public void precrime(View v) {
        lnooo = getIntent().getStringExtra("licNo");
        Intent intent = new Intent(this, PreviousOffenses.class);
        intent.putExtra("licNo", lnooo);
        startActivity(intent);

    }

    public void onliniPay(View v) {
        lnooo = getIntent().getStringExtra("licNo");
        Intent intent = new Intent(this, OnlinePayment.class);
        intent.putExtra("licNo", lnooo);
        startActivity(intent);

    }

    public void addrem(View v) {
        lnooo = getIntent().getStringExtra("licNo");
        Intent intent = new Intent(this, PaymentReminders.class);
        intent.putExtra("licNo", lnooo);
        startActivity(intent);

    }

    public void payhistory(View v) {
        lnooo = getIntent().getStringExtra("licNo");
        Intent intent = new Intent(this, PaymentHistory.class);
        intent.putExtra("licNo", lnooo);
        startActivity(intent);

    }

    public void logoutas(View v) {

        Intent intent = new Intent(this, Welcome.class);

        startActivity(intent);

    }
}
