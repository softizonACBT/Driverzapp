package com.example.amanda.driverapplication;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.junit.Test;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class WelcomeTest extends ActivityInstrumentationTestCase2<Welcome> {


    private ImageView logo;
    private TextView un;
    private ImageButton started;
    private ImageButton off;


    Welcome at = new Welcome();

    public WelcomeTest() {
        super(Welcome.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        at = this.getActivity();

        //setting up edit text fields
        logo = (ImageView) at.findViewById(R.id.imageView2);
        un = (TextView) at.findViewById(R.id.licNumb);
        started = (ImageButton) at.findViewById(R.id.imageButton);
        off = (ImageButton) at.findViewById(R.id.imageButton2);


    }

    @Test
    public void testOtherItems() {

        ViewAsserts.assertOnScreen(logo.getRootView(), logo);


    }

    @Test
    public void testButtons() {
        ViewAsserts.assertOnScreen(started.getRootView(), started);
        ViewAsserts.assertOnScreen(off.getRootView(), off);


    }

    @Test
    public void testEditText() {
        ViewAsserts.assertOnScreen(un.getRootView(), un);


    }

}