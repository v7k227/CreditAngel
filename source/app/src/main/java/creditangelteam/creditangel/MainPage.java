package creditangelteam.creditangel;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;

import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainPage extends AppCompatActivity {
    public static int[] COLORS = {
            Color.rgb(255, 0, 255), // FF00FF
            Color.rgb(170, 170, 255), // #A8A8FF
    };

    public static String[] mParties = new String[] {"已達成", "未達成"};

    public static ArrayList<Entry> yVals1;

    private PieChart mChart;

    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("出國留學");
        s.setSpan(new RelativeSizeSpan(1.5f), 0, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 0, s.length(), 0);

        return s;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);



        mChart = (PieChart)findViewById(R.id.chart_dream);
        yVals1 = new ArrayList<Entry>();
        yVals1.add(new Entry((float) (1 * 1) + 100 * (1200/2000.0f), 0));
        yVals1.add(new Entry((float) (1 * 1) + 100 * (800/2000.0f), 1));
        PieChartCreator.CreateChart(mChart, mParties, COLORS, yVals1, 2, generateCenterSpannableText(),true);

        final View actionB = findViewById(R.id.action_b);
        final View actionD = findViewById(R.id.action_c);

        actionB.setEnabled(false);
        actionD.setEnabled(false);

        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(getResources().getColor(R.color.white));

        final com.getbase.floatingactionbutton.FloatingActionsMenu menuBtn = (com.getbase.floatingactionbutton.FloatingActionsMenu) findViewById(R.id.multiple_actions);

        menuBtn.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                View RootView = findViewById(R.id.id_mask);
                RootView.setVisibility(View.VISIBLE);
                IsStop = true;
            }

            @Override
            public void onMenuCollapsed() {
                View RootView = findViewById(R.id.id_mask);
                RootView.setVisibility(View.GONE);
                IsStop = true;
            }
        });

        final com.getbase.floatingactionbutton.FloatingActionButton actionA = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),InvestmentListPage.class));
            }
        });
    }

    public void onClickForShow(View v){
        View RootView = findViewById(R.id.id_mask);
        RootView.setVisibility(View.VISIBLE);
    }

    public void OnClickForDis(View v){
        View RootView = findViewById(R.id.id_mask);
        RootView.setVisibility(View.GONE);
    }
    private int m_nTime = 800;
    private Handler mHandlerTime = new Handler();

    TransitionDrawable transition;
    public void OnClickAngelAnimateStart(View v){

        IsStop = false;
        mHandlerTime.postDelayed(timerRun, m_nTime);

        ImageView AngelView = (ImageView)findViewById(R.id.id_angel);
        transition = (TransitionDrawable) AngelView.getBackground();

    }
private Boolean IsStop = true;
    private final Runnable timerRun = new Runnable()
    {
        private int tick = 0;

        public void run()
        {
            if(tick == 0) {
                transition.startTransition(m_nTime);
                tick = 1;
            }
            else if(tick == 1){
                transition.reverseTransition(m_nTime);
                tick = 0;
            }

            if(!IsStop)
                mHandlerTime.postDelayed(this, m_nTime);
            else
                transition.resetTransition();
        }
    };

    public void OnClickForProfile(View v){
        startActivity(new Intent(this, ProfilePage.class));
    }

    public void OnClickForAsset(View v){
        startActivity(new Intent(this, AssetPage.class));
    }

    public void OnClickForSmartShopping(View v){
        startActivity(new Intent(this, SmartShoppingPage.class));
    }

    public void OnClickForMyWish(View v){
        startActivity(new Intent(this, WishListPage.class));
    }

}
