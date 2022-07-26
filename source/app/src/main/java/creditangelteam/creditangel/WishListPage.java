package creditangelteam.creditangel;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class WishListPage extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), AssetPage.class));
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wish_list_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public static int[] COLORS1 = {
                //Color.rgb(0, 0, 0), // #FFFFFF
                Color.rgb(170, 170, 255), // #A8A8FF
        };

        public static int[] COLORS2 = {
                Color.rgb(255, 0, 255), // FF00FF
                Color.rgb(170, 170, 255), // #A8A8FF
                //Color.rgb(255, 255, 0), // #FFFF00
                //Color.rgb(255, 255, 255), // FF00FF
        };

        public static String[] mParties0 = new String[] {"未達成"};
        public static String[] mParties = new String[] {"已達成", "未達成"};

        public static ArrayList<Entry> yVals0;

        public static ArrayList<Entry> yVals1;
        public static ArrayList<Entry> yVals2;
        public static ArrayList<Entry> yVals3;
        public static ArrayList<Entry> yVals4;

        public static ArrayList<Entry> yVals5;

        private PieChart mChart1;
        private PieChart mChart2;
        private PieChart mChart3;
        private PieChart mChart4;

        private PieChart mChart5;
        private PieChart mChart6;
        private PieChart mChart7;
        private PieChart mChart8;

        private PieChart mChart9;

        private TextView williamTxt;
        private TextView williamTxt2;

        private TextView emilyTxt;
        private TextView emilyTxt2;

        private TextView yaoTxt;
        private TextView yaoTxt2;

        private TextView seanTxt;
        private TextView seanTxt2;

        private SpannableString generateCenterSpannableText(String pa) {

            SpannableString s = new SpannableString(pa);
            s.setSpan(new RelativeSizeSpan(1.5f), 0, s.length(), 0);
            s.setSpan(new StyleSpan(Typeface.NORMAL), 0, s.length(), 0);

            return s;
        }

        private int pStatus = 0;
        private Handler handler = new Handler();

        public static Boolean IsSpecial = false;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_wish_list_page, container, false);

            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            mChart1 = (PieChart) rootView.findViewById(R.id.chart1);
            mChart2 = (PieChart) rootView.findViewById(R.id.chart2);
            mChart3 = (PieChart) rootView.findViewById(R.id.chart3);
            mChart4 = (PieChart) rootView.findViewById(R.id.chart4);

            williamTxt = (TextView) rootView.findViewById(R.id.WilliamTxt);
            williamTxt2 = (TextView) rootView.findViewById(R.id.WilliamTxt2);

            emilyTxt = (TextView) rootView.findViewById(R.id.EmilyTxt);
            emilyTxt2 = (TextView) rootView.findViewById(R.id.EmilyTxt2);

            yaoTxt = (TextView) rootView.findViewById(R.id.YaoTxt);
            yaoTxt2 = (TextView) rootView.findViewById(R.id.YaoTxt2);

            seanTxt = (TextView) rootView.findViewById(R.id.SeanTxt);
            seanTxt2 = (TextView) rootView.findViewById(R.id.SeanTxt2);

            yVals0 = new ArrayList<Entry>();
            yVals0.add(new Entry((float) (1 * 1) + 100 * (0/2000.0f), 0));


            // Special
            ArrayList<Entry>  yValsSpecial = new ArrayList<Entry>();
            yValsSpecial.add(new Entry((float) (1 * 1) + 100 * (1340/2000.0f), 0));
            yValsSpecial.add(new Entry((float) (1 * 1) + 100 * (140/2000.0f), 1));
            yValsSpecial.add(new Entry((float) (1 * 1) + 100 * (520/2000.0f), 2));
            String[] mPartiesSpecial = new String[] {"已達成","投資收入", "未達成"};
            int[] COLORSSpecial = {
                    Color.rgb(255, 0, 255), // FF00FF
                    Color.rgb(255, 255, 0), // #FFFF00
                    Color.rgb(170, 170, 255), // #A8A8FF
                    //Color.rgb(255, 255, 255), // FF00FF
            };

            //
            if(getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                mChart1.setVisibility(View.VISIBLE);
                mChart2.setVisibility(View.VISIBLE);
                mChart3.setVisibility(View.VISIBLE);
                mChart4.setVisibility(View.VISIBLE);

                williamTxt.setVisibility(View.VISIBLE);
                emilyTxt.setVisibility(View.VISIBLE);
                yaoTxt.setVisibility(View.VISIBLE);
                seanTxt.setVisibility(View.VISIBLE);

                if(!IsSpecial)
                    PieChartCreator.CreateChart(mChart1, mParties0, COLORS1, yVals0, 1, generateCenterSpannableText("0%"),false);
                else
                {
                    PieChartCreator.CreateChart(mChart1, mPartiesSpecial, COLORSSpecial, yValsSpecial, 3, generateCenterSpannableText("67%"),false);
                }

                PieChartCreator.CreateChart(mChart2, mParties0, COLORS1, yVals0, 1, generateCenterSpannableText("0%"),false);
                PieChartCreator.CreateChart(mChart3, mParties0, COLORS1, yVals0, 1, generateCenterSpannableText("0%"),false);
                PieChartCreator.CreateChart(mChart4, mParties0, COLORS1, yVals0, 1, generateCenterSpannableText("0%"),false);
            }
            else
            {
                mChart1.setVisibility(View.INVISIBLE);
                mChart2.setVisibility(View.INVISIBLE);
                mChart3.setVisibility(View.INVISIBLE);
                mChart4.setVisibility(View.INVISIBLE);

                williamTxt.setVisibility(View.INVISIBLE);
                emilyTxt.setVisibility(View.INVISIBLE);
                yaoTxt.setVisibility(View.INVISIBLE);
                seanTxt.setVisibility(View.INVISIBLE);
            }

            mChart5 = (PieChart) rootView.findViewById(R.id.chart5);
            mChart6 = (PieChart) rootView.findViewById(R.id.chart6);
            mChart7 = (PieChart) rootView.findViewById(R.id.chart7);
            mChart8 = (PieChart) rootView.findViewById(R.id.chart8);

            yVals1 = new ArrayList<Entry>();
            yVals1.add(new Entry((float) (1 * 1) + 100 * (65/100.0f), 0));
            yVals1.add(new Entry((float) (1 * 1) + 100 * (35/100.0f), 1));
            yVals2 = new ArrayList<Entry>();
            yVals2.add(new Entry((float) (1 * 1) + 100 * (55/100.0f), 0));
            yVals2.add(new Entry((float) (1 * 1) + 100 * (45/100.0f), 1));
            yVals3 = new ArrayList<Entry>();
            yVals3.add(new Entry((float) (1 * 1) + 100 * (70/100.0f), 0));
            yVals3.add(new Entry((float) (1 * 1) + 100 * (30/100.0f), 1));
            yVals4 = new ArrayList<Entry>();
            yVals4.add(new Entry((float) (1 * 1) + 100 * (90/100.0f), 0));
            yVals4.add(new Entry((float) (1 * 1) + 100 * (10/100.0f), 1));

            if(getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                mChart5.setVisibility(View.VISIBLE);
                mChart6.setVisibility(View.VISIBLE);
                mChart7.setVisibility(View.VISIBLE);
                mChart8.setVisibility(View.VISIBLE);

                williamTxt2.setVisibility(View.VISIBLE);
                emilyTxt2.setVisibility(View.VISIBLE);
                yaoTxt2.setVisibility(View.VISIBLE);
                seanTxt2.setVisibility(View.VISIBLE);

                PieChartCreator.CreateChart(mChart5, mParties, COLORS2, yVals1, 2, generateCenterSpannableText("65%"),false);
                PieChartCreator.CreateChart(mChart6, mParties, COLORS2, yVals2, 2, generateCenterSpannableText("55%"),false);
                PieChartCreator.CreateChart(mChart7, mParties, COLORS2, yVals3, 2, generateCenterSpannableText("70%"),false);
                PieChartCreator.CreateChart(mChart8, mParties, COLORS2, yVals4, 2, generateCenterSpannableText("90%"),false);
            }
            else
            {
                mChart5.setVisibility(View.INVISIBLE);
                mChart6.setVisibility(View.INVISIBLE);
                mChart7.setVisibility(View.INVISIBLE);
                mChart8.setVisibility(View.INVISIBLE);

                williamTxt2.setVisibility(View.INVISIBLE);
                emilyTxt2.setVisibility(View.INVISIBLE);
                yaoTxt2.setVisibility(View.INVISIBLE);
                seanTxt2.setVisibility(View.INVISIBLE);
            }

            mChart9 = (PieChart) rootView.findViewById(R.id.chart9);

            yVals5 = new ArrayList<Entry>();
            yVals5.add(new Entry((float) (1 * 1) + 100 * (1200/2000.0f), 0));
            yVals5.add(new Entry((float) (1 * 1) + 100 * (800/2000.0f), 1));

            if(getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                mChart9.setVisibility(View.VISIBLE);

                PieChartCreator.CreateChart(mChart9, mParties, COLORS2, yVals5, 2, generateCenterSpannableText("60%"),false);
            }
            else
            {
                mChart9.setVisibility(View.INVISIBLE);
            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private TextView goalTxt;
        private TextView totalMoneyTxt;
        private TextView yearMoneyTxt;
        private TextView yearTxt;
        private TextView yerOrnoTxt3;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);

            ViewPager pagr = (ViewPager) findViewById(R.id.container);
            pagr.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                    goalTxt = (TextView) findViewById(R.id.textView2);
                    totalMoneyTxt = (TextView) findViewById(R.id.textView4);
                    yearMoneyTxt = (TextView) findViewById(R.id.textView6);
                    yearTxt = (TextView) findViewById(R.id.textView8);
                    yerOrnoTxt3 = (TextView) findViewById(R.id.textView10);

                    RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton);
                    RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
                    RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);

                    switch (position) {
                        case 0:
                            rb1.setChecked(true);
                            rb2.setChecked(false);
                            rb3.setChecked(false);

                            goalTxt.setText( "$1,000,000" );
                            totalMoneyTxt.setText( "$200,000" );
                            yearMoneyTxt.setText( "$50,000" );
                            yearTxt.setText( "5年" );
                            yerOrnoTxt3.setText( "否" );
                            break;
                        case 1:
                            rb1.setChecked(false);
                            rb2.setChecked(true);
                            rb3.setChecked(false);

                            goalTxt.setText( "$1,000,000" );
                            totalMoneyTxt.setText( "$700,000" );
                            yearMoneyTxt.setText( "$55,000" );
                            yearTxt.setText( "6個月" );
                            yerOrnoTxt3.setText( "否" );
                            break;
                        case 2:
                            rb1.setChecked(false);
                            rb2.setChecked(false);
                            rb3.setChecked(true);

                            goalTxt.setText( "$500,000" );
                            totalMoneyTxt.setText( "$200,000" );
                            yearMoneyTxt.setText( "$50,000" );
                            yearTxt.setText( "3年" );
                            yerOrnoTxt3.setText( "否" );
                            break;
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });





        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}

