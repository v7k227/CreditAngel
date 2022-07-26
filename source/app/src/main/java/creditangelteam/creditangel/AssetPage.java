package creditangelteam.creditangel;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class AssetPage extends AppCompatActivity {

    public void OnClickForEatSuggestion(View v){
        startActivity(new Intent(this, SuggestEat.class));
    }

    public void OnClickForAccountingPage(View v){
        startActivity(new Intent(this, AccountingPage.class));
    }
    private TabLayout mTabs;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_page);

        mTabs = (android.support.design.widget.TabLayout) findViewById(R.id.pager_tabs);
        mTabs.addTab(mTabs.newTab().setText("資產管理"));
        mTabs.addTab(mTabs.newTab().setText("消費分析"));


        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter());
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

    }

    public void OnClickForViewAsset(View v){
        startActivity(new Intent(this, AssetPageDetail.class));
    }

    class MyPagerAdapter extends PagerAdapter {
        private int pageCount = 2;
        private int DATA_COUNT = 5;
        @Override
        public int getCount() {
            return pageCount;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return obj == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "MyPage " + (position + 1);
        }

        private List<View> ViewCollection = new ArrayList<>();
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getLayoutInflater().inflate(R.layout.activity_asset_page_tabs, container, false);
            ViewCollection.add(position, view);
            container.addView(view);
            View PageAnalysis = (View) view.findViewById(R.id.page_analysis);
            View PageAsset = (View) view.findViewById(R.id.page_asset);
            View AddBtn = (View) view.findViewById(R.id.add_btn);

            PageAnalysis.setVisibility(View.INVISIBLE);
            PageAsset.setVisibility(View.INVISIBLE);
            AddBtn.setVisibility(View.INVISIBLE);
            switch (position)
            {
                case 0:
                    AddBtn.setVisibility(View.VISIBLE);
                    PageAnalysis.setVisibility(View.VISIBLE);
                    break;
                case 1:

                    BarChart chart_bar = (BarChart)view.findViewById(R.id.chart_bar);
                    BarData barData = AnalysisParDataCollection.getBarData(view);
                    barData.setDrawValues(false);
                    chart_bar.setData(barData);
                    chart_bar.setDescription("");

                    chart_bar.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                        @Override
                        public void onValueSelected(Entry entry, int i, Highlight highlight) {
                            View v = ViewCollection.get(1);

                            int index = entry.getXIndex();

                            View ViewPageEat = v.findViewById(R.id.pageEat);
                            View ViewPageWear = v.findViewById(R.id.pageWear);

                            ViewPageEat.setVisibility(View.GONE);
                            ViewPageWear.setVisibility(View.GONE);

                            if(index == 0){
                                ViewPageEat.setVisibility(View.VISIBLE);
                            }
                            else if(index == 1){
                                ViewPageWear.setVisibility(View.VISIBLE);
                            }

                        }

                        @Override
                        public void onNothingSelected() {

                        }
                    });

                    AnalysisParDataCollection.configChartAxis(chart_bar);
                    PageAsset.setVisibility(View.VISIBLE);
                    break;
            }

            return view;
        }





        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
