package creditangelteam.creditangel;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class InventmentGraph extends AppCompatActivity {

    public static int[] COLORS = {
            Color.rgb(255, 0, 255), // FF00FF
            Color.rgb(170, 170, 255), // #A8A8FF
            //Color.rgb(255, 255, 255), // FF00FF
    };

    public static int[] COLORS2 = {
            Color.rgb(255, 0, 255), // FF00FF
            Color.rgb(255, 255, 0), // #FFFF00
            Color.rgb(170, 170, 255), // #A8A8FF
            //Color.rgb(255, 255, 255), // FF00FF
    };

    public static String[] mParties = new String[] {"已達成", "未達成"};
    public static String[] mParties2 = new String[] {"已達成","投資收入", "未達成"};

    public static ArrayList<Entry> yVals1;
    public static ArrayList<Entry> yVals2;

    private PieChart mChart1;
    private PieChart mChart2;

    private SpannableString generateCenterSpannableText(String pa) {

        SpannableString s = new SpannableString(pa);
        s.setSpan(new RelativeSizeSpan(1.5f), 0, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 0, s.length(), 0);

        return s;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventment_graph);

        final Button OKBtn = (Button)findViewById(R.id.currentButton);

        OKBtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                WishListPage.PlaceholderFragment.IsSpecial = true;
                startActivity(new Intent(getApplicationContext(), InvestmentAngel.class));
                finish();
            }
        });

        mChart1 = (PieChart) findViewById(R.id.chart1);

        yVals1 = new ArrayList<Entry>();
        yVals1.add(new Entry((float) (1 * 1) + 100 * (1200/2000.0f), 0));
        yVals1.add(new Entry((float) (1 * 1) + 100 * (800/2000.0f), 1));

        PieChartCreator.CreateChart(mChart1, mParties, COLORS, yVals1, 2, generateCenterSpannableText("59.8%"),true);

        mChart2 = (PieChart) findViewById(R.id.chart2);

        yVals2 = new ArrayList<Entry>();
        yVals2.add(new Entry((float) (1 * 1) + 100 * (1200/2000.0f), 0));
        yVals2.add(new Entry((float) (1 * 1) + 100 * (140/2000.0f), 1));
        yVals2.add(new Entry((float) (1 * 1) + 100 * (660/2000.0f), 2));

        PieChartCreator.CreateChart(mChart2, mParties2, COLORS2, yVals2, 3, generateCenterSpannableText("67%"),true);

    }
}
