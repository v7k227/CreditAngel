package creditangelteam.creditangel;

import android.graphics.Color;
import android.text.SpannableString;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

/**
 * Created by Sean Wu on 2016/10/8.
 */

public class PieChartCreator {

    public static String[] mParties;

    public static int[] COLORS;
    public static ArrayList<Entry> yVals1;
    public static int NumberOfPies;
    public static SpannableString CenterDisplayText;
    public static void CreateChart(PieChart mChart, String[] Parties, int[] Colors, ArrayList<Entry> YVals1, int numberOfPies, SpannableString centerDisplayText, boolean setDrawValue)
    {
        mParties = Parties;
        CenterDisplayText = centerDisplayText;
        NumberOfPies = numberOfPies;
        COLORS = Colors;
        yVals1 = YVals1;
        mChart.setUsePercentValues(true);
        mChart.setDescription("");
        mChart.setExtraOffsets(5, 10, 5, 5);

        mChart.setDragDecelerationFrictionCoef(0.95f);

        //tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");

        // mChart.setCenterTextTypeface(Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf"));
        mChart.setCenterText(CenterDisplayText);

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        // mChart.setUnit(" ??);
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        //mChart.setOnChartValueSelectedListener(this);

        setData(mChart, NumberOfPies - 1, 100,setDrawValue);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);


    }


    private static void setData(PieChart mChart, int count, float range, boolean setDrawValue) {

        float mult = range;

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        //for (int i = 0; i < count + 1; i++) {
        //    yVals1.add(new Entry((float) (Math.random() * mult) + mult / 5, i));
        //}

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < count + 1; i++)
           xVals.add(mParties[i % mParties.length]);

        PieDataSet dataSet = new PieDataSet(yVals1, "" +
                "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : COLORS)
            colors.add(c);

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);
        dataSet.setDrawValues(setDrawValue);
        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);


        //data.setValueTypeface(tf);
        mChart.setData(data);
        //mChart.setDrawSliceText(false);
        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();


    }


}
