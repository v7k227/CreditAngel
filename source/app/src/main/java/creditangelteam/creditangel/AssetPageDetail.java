package creditangelteam.creditangel;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class AssetPageDetail extends AppCompatActivity {

    public static int[] COLORS = {
            Color.rgb(170, 170, 255), // #A8A8FF
            Color.rgb(255, 255, 0), // #FFFF00
            Color.rgb(255, 0, 255), // FF00FF
            Color.rgb(0, 255, 200), // #00FFC7
            Color.rgb(255, 160, 0), // #FF9E00
            Color.rgb(170, 255, 170), //A8FFA8
    };

    public static String[] mParties = new String[] {"食", "衣", "住", "行", "樂", "餘"
    };

    public static ArrayList<Entry> yVals1;

    private PieChart mChart;

    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("支出\n1450元");
        s.setSpan(new RelativeSizeSpan(1.5f), 0, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 0, s.length(), 0);

        return s;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_page_detail);

        mChart = (PieChart) findViewById(R.id.chart1);

        yVals1 = new ArrayList<Entry>();
    /*
        eat 200
        wear 100
        lieve 100
        car 50
        fun 800
        GOT 750
        */
        yVals1.add(new Entry((float) (1 * 1) + 100 * (400/2000.0f), 0));
        yVals1.add(new Entry((float) (1 * 1) + 100 * (100/2000.0f), 1));
        yVals1.add(new Entry((float) (1 * 1) + 100 * (100/2000.0f), 2));
        yVals1.add(new Entry((float) (1 * 1) + 100 * (50/2000.0f), 3));
        yVals1.add(new Entry((float) (1 * 1) + 100 * (800/2000.0f), 4));
        yVals1.add(new Entry((float) (1 * 1) + 100 * (550/2000.0f), 5));
        PieChartCreator.CreateChart(mChart, mParties, COLORS, yVals1, 6, generateCenterSpannableText(), true);
    }
}
