package com.example.amanda.driverapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class PaymentReminders extends AppCompatActivity {

    TextView crme;
    TextView feeee;
    TextView dd;
    ImageView nb;
    String lnl;


    String ddn;
    String fz;
    String ccn = "";

    public static final String idx = "id";
    private static final String cfURL = "http://softizon.tk/Final/getfineBool.php";
    private static final String telURL = "http://softizon.tk/Final/gettel.php";
    private static final String feeURL = "http://softizon.tk/Final/fee.php";
    private static final String fineURL = "http://softizon.tk/Final/fine.php";
    private static final String idURL = "http://softizon.tk/Final/id.php";
    private static final String paidURL = "http://softizon.tk/Final/paid.php";
    private static final String ddURL = "http://softizon.tk/Final/dd.php";
    public static final String KEY_USERNAME = "licenseNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_reminders);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        crme = (TextView) findViewById(R.id.txtcme12);
        feeee = (TextView) findViewById(R.id.txfz23);
        dd = (TextView) findViewById(R.id.txtdd21);

        checkLick2();


        getzID();
    }

    private void getzID() {

    }

    private void checkLick2() {
        final String licNO = getIntent().getStringExtra("licNo");
        // licenseNumber = getIntent().getStringExtra("a");
        lnl = licNO;
//check for crimes
        StringRequest stringRequest = new StringRequest(Request.Method.POST, cfURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(CheckLic.this, response.toString(), Toast.LENGTH_LONG).show();

                        String res = response.trim().toString();
                        if (res.equals("Yes")) {
                            //ln.setText(licNO.toString());
                            crme.setText("No outstandng tickets");
                            dd.setText("No outstandng tickets");
                            feeee.setText("No outstandng tickets");

                            // nb.setBackgroundResource(R.drawable.notick);


                        } else if (res.equals("No")) {
                            // ln.setText(licNO.toString());
                            // nb.setBackgroundResource(R.drawable.ticketv);
                            View b = findViewById(R.id.imageView7);
                            b.setVisibility(View.VISIBLE);
                            getzcrime();
                            getzamount();
                            getzdd();
                            getzID();


                            // Toast.makeText(payFine.this, "Username or password is wrong please try again", Toast.LENGTH_LONG).show();
                        } else {


                            crme.setText("No outstandng tickets");
                            dd.setText("No outstandng tickets");
                            feeee.setText("No outstandng tickets");
                            //  nb.setBackgroundResource(R.drawable.notick);
                        }

                        //typeee.setText(response.trim().toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Toast.makeText(payFine.this, "Username or password is wrong please try again", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_USERNAME, licNO);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private void getzcrime() {

        final String licNO = getIntent().getStringExtra("licNo");


        StringRequest stringRequest = new StringRequest(Request.Method.POST, fineURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Toast.makeText(Payment2.this, response.toString(), Toast.LENGTH_LONG).show();

                        String res = response.trim().toString();
                        ccn = res;
                        crme.setText(ccn.toString());

                        //typeee.setText(response.trim().toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Toast.makeText(Payment2.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_USERNAME, licNO);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    private void getzamount() {

        final String licNO = getIntent().getStringExtra("licNo");


        StringRequest stringRequest = new StringRequest(Request.Method.POST, feeURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Toast.makeText(Payment2.this, response.toString(), Toast.LENGTH_LONG).show();

                        String res = response.trim().toString();
                        fz = res;
                        feeee.setText(fz.toString());

                        //typeee.setText(response.trim().toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Toast.makeText(Payment2.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_USERNAME, licNO);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    private void getzdd() {

        final String licNO = getIntent().getStringExtra("licNo");


        StringRequest stringRequest = new StringRequest(Request.Method.POST, ddURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  Toast.makeText(Payment2.this, response.toString(), Toast.LENGTH_LONG).show();

                        String res = response.trim().toString();
                        ddn = res;
                        dd.setText(ddn.toString());

                        //typeee.setText(response.trim().toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Toast.makeText(Payment2.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_USERNAME, licNO);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void addreminder(View v) {
        String ccn = "";
        String crime = ccn;
        String feePaid = fz;
        String duedtes = ddn;

        String messege = "You have a traffic ticket for " + crime.toString() + " which is not paid before " + duedtes.toString() + " Please pay the fine in order to avoid legal circumstances ";

        String yearString = duedtes.substring(0, 4);
        String monthString = duedtes.substring(5, 7);
        String dayString = duedtes.substring(8, 10);

        int yr = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthString);
        int day = Integer.parseInt(dayString);

        //Toast.makeText(PaymentReminders.this, yearString.toString(), Toast.LENGTH_LONG).show();
        //Toast.makeText(PaymentReminders.this, monthString.toString(), Toast.LENGTH_LONG).show();
        //Toast.makeText(PaymentReminders.this, dayString.toString(), Toast.LENGTH_LONG).show();

        Calendar beginTime = Calendar.getInstance();
        beginTime.set(yr, month - 1, day, 7, 30);
        Calendar endTime = Calendar.getInstance();
        endTime.set(yr, month - 1, day, 11, 00);
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                .putExtra(CalendarContract.Events.TITLE, "Traffic Ticket Payment Reminder")
                .putExtra(CalendarContract.Events.DESCRIPTION, messege.toString())
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Your nearest police station")
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
        startActivity(intent);


    }


}
