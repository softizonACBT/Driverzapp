package com.example.amanda.driverapplication;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.ImageView;

import org.junit.Test;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class PointTest extends ActivityInstrumentationTestCase2<Points> {


    private ImageView pointsss;


    Points at = new Points();

    public PointTest() {
        super(Points.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        at = this.getActivity();

        //setting up edit text fields
        pointsss = (ImageView) at.findViewById(R.id.charts);


    }

    @Test
    public void testOtherItems() {

        ViewAsserts.assertOnScreen(pointsss.getRootView(), pointsss);


    }

    @Test
    public void testTextViews() {


    }

}