package com.example.amanda.driverapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
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

public class Welcome extends AppCompatActivity {

    private EditText un;

    String licNo;
    String name;

    public static final String KEY_USERNAME = "regID";
    private static final String LOGIN_URL = "http://softizon.tk/Final/clogin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        un = (EditText) findViewById(R.id.licNumb);

    }

    public void cont(View v) {

        String usn = un.getText().toString();


        if (usn.toString().trim().length() <= 0) {
            Toast.makeText(Welcome.this, "Please enter your driving license number", Toast.LENGTH_LONG).show();
        } else {

            login();

        }


    }

    private void login() {

        licNo = un.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(Welcome.this, response.toString(), Toast.LENGTH_LONG).show();

                        String res = response.trim().toString();

                        if (res.equals("")) {
                            Toast.makeText(Welcome.this, "Please enter a valid license number", Toast.LENGTH_LONG).show();
                        } else {
                            navi(licNo, res);
                        }


                        //typeee.setText(response.trim().toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Welcome.this, "Username or password is wrong please try again", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_USERNAME, licNo);
                return map;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void navi(String licNo, String res) {
        Intent intent = new Intent(this, Home.class);
        intent.putExtra("licNo", licNo);
        intent.putExtra("name", res);
        startActivity(intent);
    }

    public void ends(View v) {

        this.finishAffinity();
        System.exit(0);
    }
}
