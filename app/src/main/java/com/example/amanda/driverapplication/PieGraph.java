package com.example.amanda.driverapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

/**
 * Created by AMANDA on 5/21/2016.
 */
public class PieGraph {

    String points;

    public PieGraph(String points) {
        this.points = points;
    }

    public Intent getIntent(Context context) {

        int int2 = Integer.parseInt(points);

        int[] values = {int2, 8 - int2};
        CategorySeries series = new CategorySeries("Pie Graph");
        int k = 0;

        series.add("Collected points", values[0]);
        series.add("Remaining points before license blacklisting", values[1]);


        int[] colors = new int[]{Color.RED, Color.GREEN};

        DefaultRenderer renderer = new DefaultRenderer();
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        renderer.setChartTitle("Traffic violation points graph");
        renderer.setChartTitleTextSize(7);
        renderer.setZoomButtonsVisible(true);

        Intent intent = ChartFactory.getPieChartIntent(context, series, renderer, "Pie");
        return intent;


    }
}
