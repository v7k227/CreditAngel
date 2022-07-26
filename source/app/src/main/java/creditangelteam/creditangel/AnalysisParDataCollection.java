package creditangelteam.creditangel;

import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean Wu on 2016/10/8.
 */

public class AnalysisParDataCollection {
    private static int DATA_COUNT = 5;

    public static void configChartAxis(BarChart chart_bar){
        XAxis xAxis = chart_bar.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis leftYAxis = chart_bar.getAxisLeft();
        leftYAxis.setDrawGridLines(false);
        leftYAxis.setEnabled(false);
        YAxis RightYAxis = chart_bar.getAxisRight();
        RightYAxis.setEnabled(false);   //不顯示右側
        RightYAxis.setShowOnlyMinMax(true);
    }

    public static BarData getBarData(View v){
        BarDataSet dataSetA = new BarDataSet(getChartData(), "");
        //設定顏色
        dataSetA.setColors(getChartColors(v));
        //設定顯示字串
        dataSetA.setStackLabels(getStackLabels());

        List<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSetA); // add the datasets

        return new BarData(getLabels(), dataSets);
    }

    private static String[] getStackLabels(){
        return new String[]{"消費建議",
                "目前消費",
        };
    }

    private static int[] getChartColors(View v) {
        int[] colors = new int[]{
                getResourceColor(R.color.colorSuggestion, v),
                getResourceColor(R.color.colorNow, v)};
        return colors;
    }

    private static List<BarEntry> getChartData(){
        final int DATA_COUNT = 5;

        float[] You = new float[]{35, 10, 20, 10, 25};
        float[] Suggest = new float[]{20, 5, 0, 0, 15};

        List<BarEntry> chartData = new ArrayList<>();
        //每一個月都有四筆資料
        for(int i=0;i<DATA_COUNT;i++){

            chartData.add(new BarEntry(new float[]{You[i], Suggest[i]}, i));
        }
        return chartData;
    }

    private static List<String> getLabels(){
        List<String> chartLabels = new ArrayList<>();
        chartLabels.add("食");
        chartLabels.add("衣");
        chartLabels.add("住");
        chartLabels.add("行");
        chartLabels.add("樂");
        return chartLabels;
    }

    private static int getResourceColor(int resID, View v){
        return v.getResources().getColor(resID);
    }
}
