package creditangelteam.creditangel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.FillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends AppCompatActivity {


    private class ProfileActivityCallback implements HackathonSandboxCallback{

        private View view;
        public ProfileActivityCallback(View v){
            view = v;
        }
        public ProfileActivityCallback(){

        }

        @Override
        public void callback(HackathonSandboxDef.ActionDef actionDef, JSONObject output) {
            if(actionDef == HackathonSandboxDef.ActionDef.CreditCardLimit){
                try {
                    JSONArray JArray = output.getJSONArray("CreditCardLimit");
                    String CardNO = JArray.getJSONObject(0).getString("CardNO");
                    String CreditCardLimit = JArray.getJSONObject(0).getString("CreditCardLimit");
                    String AvailableCredit = JArray.getJSONObject(0).getString("AvailableCredit");


                    ((TextView)view.findViewById(R.id.credit_item_card_no)).setText("登入卡號: " + CardNO);
                    ((TextView)view.findViewById(R.id.credit_item_card_limit)).setText("信用卡額度: " + CreditCardLimit);
                    ((TextView)view.findViewById(R.id.credit_item_card_available)).setText("可用額度: " + AvailableCredit);
                    view.findViewById(R.id.credit_item).setVisibility(View.VISIBLE);

                }
                catch (Exception exc){

                }
            }

            if(actionDef == HackathonSandboxDef.ActionDef.BonusPointInq){
                try {
                    String BonusPoint = output.getString("BonusPoint");
                    String ExpiryDate = output.getString("ExpiryDate");

                    ((TextView)view.findViewById(R.id.credit_item_card_bonus)).setText("剩餘紅利點數: " + BonusPoint);
                    ((TextView)view.findViewById(R.id.credit_item_card_expiry_day)).setText("紅利點數到期日: " + ExpiryDate);
                    view.findViewById(R.id.credit_item).setVisibility(View.VISIBLE);

                }
                catch (Exception exc){

                }
            }
        }
    }

    public static int[] COLORS = {
            Color.rgb(170, 170, 255), // #A8A8FF
            Color.rgb(255, 255, 0), // #FFFF00
            Color.rgb(255, 0, 255), // FF00FF
            Color.rgb(0, 255, 200), // #00FFC7
            Color.rgb(255, 160, 0), // #FF9E00
            Color.rgb(170, 255, 170), //A8FFA8
    };

    public static String[] mParties = new String[] {"工作", "投資", "其他"
    };

    public static ArrayList<Entry> yVals1;

    private PieChart mChart;
    public static Boolean IsInitial = true;
    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("存款\n100萬");
        s.setSpan(new RelativeSizeSpan(1.5f), 0, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 0, s.length(), 0);

        return s;
    }

    public void OnGoToDreamPage(View v){
        WishListPage.PlaceholderFragment.IsSpecial = false;
        startActivity(new Intent(getApplicationContext(), PersonalWishListSetting.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        //if(IsInitial == true) {
            View v = findViewById(R.id.add_go_dream_btn);
            v.setVisibility(View.VISIBLE);
        //    IsInitial = false;
        //}
        //else{
        //    View v = findViewById(R.id.add_go_dream_btn);
        //    v.setVisibility(View.GONE);
       // }

        try {
            ProfileActivityCallback MAC = new ProfileActivityCallback(this.findViewById(android.R.id.content));
            HackathonSandbox HS = new HackathonSandbox(HackathonSandboxDef.ActionDef.CreditCardLimit, MAC);
            HS.DoAction();
        }
        catch (Exception e) {
            String Msg = e.getMessage();
        }

        try {
            ProfileActivityCallback MAC = new ProfileActivityCallback(this.findViewById(android.R.id.content));
            HackathonSandbox HS = new HackathonSandbox(HackathonSandboxDef.ActionDef.BonusPointInq, MAC);
            HS.DoAction();
        }
        catch (Exception e) {
            String Msg = e.getMessage();
        }

        int imageSize = 360;
        ImageView img1 = (ImageView) findViewById(R.id.profile_img);
        Bitmap bm = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_me_new);
        Bitmap resized = Bitmap.createScaledBitmap(bm, imageSize, imageSize, true);
        Bitmap conv_bm = getRoundedRectBitmap(resized, imageSize);
        img1.setImageBitmap(conv_bm);


        mChart = (PieChart) findViewById(R.id.chart_income);

        yVals1 = new ArrayList<Entry>();

        yVals1.add(new Entry((float) (1 * 1) + 100 * (10/100.0f), 0));
        yVals1.add(new Entry((float) (1 * 1) + 100 * (70/100.0f), 1));
        yVals1.add(new Entry((float) (1 * 1) + 100 * (20/100.0f), 2));
        PieChartCreator.CreateChart(mChart, mParties, COLORS, yVals1, 3, generateCenterSpannableText(), true);

        BarChart chart_bar = (BarChart)findViewById(R.id.chart_bar);
        BarData barData = getBarData();
        barData.setDrawValues(false);
        chart_bar.setData(barData);
        chart_bar.setDescription("");
        configChartAxis(chart_bar);
    }

    public Bitmap getRoundedRectBitmap(Bitmap bitmap, int imageSize) {
        Bitmap result = null;
        try {
            result = Bitmap.createBitmap(imageSize, imageSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(result);

            int color = 0xff424242;
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, imageSize, imageSize);

            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawCircle(imageSize/2, imageSize/2, 150, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);

        } catch (NullPointerException e) {
        } catch (OutOfMemoryError o) {
        }
        return result;
    }















    private int DATA_COUNT = 5;

    public void configChartAxis(BarChart chart_bar){
        XAxis xAxis = chart_bar.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis leftYAxis = chart_bar.getAxisLeft();
        leftYAxis.setDrawGridLines(false);
        leftYAxis.setEnabled(false);
        YAxis RightYAxis = chart_bar.getAxisRight();
        RightYAxis.setEnabled(true);   //不顯示右側
        RightYAxis.setShowOnlyMinMax(true);
    }

    public BarData getBarData(){
        BarDataSet dataSetA = new BarDataSet(getChartData(), "");
        //設定顏色
        dataSetA.setColors(getChartColors());
        //設定顯示字串
        dataSetA.setStackLabels(getStackLabels());

        List<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSetA); // add the datasets

        return new BarData(getLabels(), dataSets);
    }

    private String[] getStackLabels(){
        return new String[]{"預期內",
                "超出預期",
        };
    }

    private int[] getChartColors() {
        int[] colors = new int[]{
                getResourceColor(R.color.colorSuggestion),
                getResourceColor(R.color.colorNow)};
        return colors;
    }

    private List<BarEntry> getChartData(){
        final int DATA_COUNT = 5;

        float[] You = new float[]{0, 0, 4500, 5000, 2500};
        float[] Suggest = new float[]{6000, 10000, 0, 0, 0};

        List<BarEntry> chartData = new ArrayList<>();
        //每一個月都有四筆資料
        for(int i=0;i<DATA_COUNT;i++){

            chartData.add(new BarEntry(new float[]{You[i], Suggest[i]}, i));
        }
        return chartData;
    }

    private List<String> getLabels(){
        List<String> chartLabels = new ArrayList<>();
        chartLabels.add("六月");
        chartLabels.add("七月");
        chartLabels.add("八月");
        chartLabels.add("九月");
        chartLabels.add("十月");
        return chartLabels;
    }

    private int getResourceColor(int resID){
        return getResources().getColor(resID);
    }
}
