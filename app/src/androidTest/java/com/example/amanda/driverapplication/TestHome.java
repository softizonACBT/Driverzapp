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
public class TestHome extends ActivityInstrumentationTestCase2<OnlinePayment> {


    private TextView crime;
    private TextView ffee;
    private TextView paiddate;
    private ImageView pay;
    private ImageView back;

    OnlinePayment at = new OnlinePayment();

    public TestHome() {
        super(OnlinePayment.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        at = this.getActivity();

        //setting up edit text fields
        crime = (TextView) at.findViewById(R.id.txtcme12);
        ffee = (TextView) at.findViewById(R.id.txfz23);
        paiddate = (TextView) at.findViewById(R.id.txtdd21);
        pay = (ImageButton) at.findViewById(R.id.imageButton11);
        back = (ImageButton) at.findViewById(R.id.imageButton12);
        // paynow = (ImageButton) at.findViewById(R.id.imageButton17);


    }

    @Test
    public void testOtherItems() {

        ViewAsserts.assertOnScreen(crime.getRootView(), crime);
        ViewAsserts.assertOnScreen(ffee.getRootView(), ffee);
        ViewAsserts.assertOnScreen(paiddate.getRootView(), paiddate);

        //  ViewAsserts.assertOnScreen(notification.getRootView(), notification);
        // ViewAsserts.assertOnScreen(paynow.getRootView(), paynow);


    }

    @Test
    public void testTextViews() {

        ViewAsserts.assertOnScreen(pay.getRootView(), pay);
        ViewAsserts.assertOnScreen(back.getRootView(), back);
    }

}