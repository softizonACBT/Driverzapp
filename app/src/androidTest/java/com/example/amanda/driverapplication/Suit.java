package com.example.amanda.driverapplication;

import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by AMANDA on 5/29/2016.
 */
public class Suit extends TestSuite {
    public static Test suite() {
        return new TestSuiteBuilder(Suit.class).includeAllPackagesUnderHere().build();
    }

}
