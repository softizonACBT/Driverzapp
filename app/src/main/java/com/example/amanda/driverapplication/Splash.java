package com.example.amanda.driverapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        final ImageView iv = (ImageView) findViewById(R.id.imageView12);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_out);
        assert iv != null;
        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);
                finish();
                navi();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }


        });


    }

    private void navi() {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void nextNav(View v) {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);

        // Intent intent = new Intent(Intent.ACTION_INSERT);
        // intent.setType("vnd.android.cursor.item/event");
        // intent.putExtra(CalendarContract.Events.TITLE, "Learn Android");
        // intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Home suit home");
        //intent.putExtra(CalendarContract.Events.DESCRIPTION, "Download Examples");

// Setting dates
        // GregorianCalendar calDate = new GregorianCalendar(2016, 05, 20);
        // intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
        //     calDate.getTimeInMillis());
        // intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
        //     calDate.getTimeInMillis());

// make it a full day event
        //intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

// make it a recurring Event
        // intent.putExtra(CalendarContract.Events.RRULE, "FREQ=WEEKLY;COUNT=11;WKST=SU;BYDAY=TU,TH");

// Making it private and shown as busy
        //  intent.putExtra(CalendarContract.Events.ACCESS_LEVEL, CalendarContract.Events.ACCESS_PRIVATE);
        // intent.putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);

        //startActivity(intent);

        // check this https://www.simplifiedcoding.net/android-json-tutorial-to-get-data-from-mysql-database/
    }
}
