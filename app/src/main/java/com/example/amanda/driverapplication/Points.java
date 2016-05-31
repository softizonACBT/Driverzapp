package com.example.amanda.driverapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class Points extends AppCompatActivity {
    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        im = (ImageView) findViewById(R.id.charts);
        displaydata();


    }

    private void displaydata() {

        try {
            String poi = getIntent().getStringExtra("points");

            int points = Integer.parseInt(poi);

            if (points > 8) {
                points = 8;
            }

            if (points == 1) {
                im.setBackgroundResource(R.drawable.one);

            } else if (points == 2) {
                im.setBackgroundResource(R.drawable.two);

            } else if (points == 3) {
                im.setBackgroundResource(R.drawable.three);

            } else if (points == 4) {
                im.setBackgroundResource(R.drawable.four);

            } else if (points == 5) {
                im.setBackgroundResource(R.drawable.five);

            } else if (points == 6) {
                im.setBackgroundResource(R.drawable.six);

            } else if (points == 7) {
                im.setBackgroundResource(R.drawable.seven);

            } else if (points == 8) {
                im.setBackgroundResource(R.drawable.eight);
            }

        } catch (NumberFormatException x) {

        }

    }
}
