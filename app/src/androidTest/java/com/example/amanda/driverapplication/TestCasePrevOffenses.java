package com.example.amanda.driverapplication;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.ImageButton;
import android.widget.TextView;

import org.junit.Test;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class TestCasePrevOffenses extends ActivityInstrumentationTestCase2<PreviousOffenses> {


    private TextView crime;
    private TextView ffee;
    private TextView paiddate;
    private TextView refno;
    private TextView paym;
    private ImageButton next;
    private ImageButton prev;

    PreviousOffenses at = new PreviousOffenses();

    public TestCasePrevOffenses() {
        super(PreviousOffenses.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        at = this.getActivity();

        //setting up edit text fields
        crime = (TextView) at.findViewById(R.id.crime);
        ffee = (TextView) at.findViewById(R.id.txtFee);
        paiddate = (TextView) at.findViewById(R.id.txtID);

        next = (ImageButton) at.findViewById(R.id.imageButton9);
        prev = (ImageButton) at.findViewById(R.id.imageButton10);


    }

    @Test
    public void testOtherItems() {

        ViewAsserts.assertOnScreen(next.getRootView(), next);
        ViewAsserts.assertOnScreen(prev.getRootView(), prev);

    }

    @Test
    public void testTextViews() {

        ViewAsserts.assertOnScreen(crime.getRootView(), crime);
        ViewAsserts.assertOnScreen(ffee.getRootView(), ffee);
        ViewAsserts.assertOnScreen(paiddate.getRootView(), paiddate);

    }

}