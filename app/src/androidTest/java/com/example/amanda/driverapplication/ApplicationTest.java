package com.example.amanda.driverapplication;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.ImageButton;
import android.widget.TextView;

import org.junit.Test;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<PaymentHistory> {


    private TextView crime;
    private TextView ffee;
    private TextView paiddate;
    private TextView refno;
    private TextView paym;
    private ImageButton next;
    private ImageButton prev;

    PaymentHistory at = new PaymentHistory();

    public ApplicationTest() {
        super(PaymentHistory.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        at = this.getActivity();

        //setting up edit text fields
        crime = (TextView) at.findViewById(R.id.txtcrimeeee);
        ffee = (TextView) at.findViewById(R.id.txtfff);
        paiddate = (TextView) at.findViewById(R.id.tefn);
        refno = (TextView) at.findViewById(R.id.pd);
        paym = (TextView) at.findViewById(R.id.payment);
        next = (ImageButton) at.findViewById(R.id.imageButton14);
        prev = (ImageButton) at.findViewById(R.id.imageButton14);


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
        ViewAsserts.assertOnScreen(refno.getRootView(), refno);
        ViewAsserts.assertOnScreen(paiddate.getRootView(), paiddate);
        ViewAsserts.assertOnScreen(paym.getRootView(), paym);
    }

}