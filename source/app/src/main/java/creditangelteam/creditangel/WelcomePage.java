package creditangelteam.creditangel;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class WelcomePage extends AppCompatActivity {

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
        setContentView(R.layout.activity_welcome_page);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome_page, menu);
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

        private View UIUpdater(LayoutInflater inflater, ViewGroup container, int index){
            View v = null;
            switch (index){
                case 1:
                    v = Page1(inflater, container);
                    break;
                case 2:
                    v = Page2(inflater, container);
                    break;
                case 3:
                    v = Page4(inflater, container);
                    break;
                case 4:
                    v = Page3(inflater, container);
                    break;
                case 5:
                    v = Page5(inflater, container);
                    break;
            }

            return v;
        }

        private View Page1(LayoutInflater inflater, ViewGroup container){
            View rootView = inflater.inflate(R.layout.fragment_welcome_page, container, false);

            TextView textView = (TextView) rootView.findViewById(R.id.titelText);
            textView.setText("歡迎使用 Credit Angel");

            textView = (TextView) rootView.findViewById(R.id.descriptionText);
            textView.setText("Assist Your Dream是我們開發作品Credit Angel的理念，其理念是希望透過支持與鼓勵的方式讓社會大眾更能有效的管理自身的財富，加速完成夢想。");

            ImageView IV = (ImageView)rootView.findViewById(R.id.welcome_image);
            IV.setVisibility(View.VISIBLE);
            IV.setImageResource(R.mipmap.angel_body);

            //RadioButton radioButton = (RadioButton) rootView.findViewById(R.id.indexPage1);
            //radioButton.setChecked(true);

            return rootView;
        }

        private View Page2(LayoutInflater inflater, ViewGroup container){
            View rootView = inflater.inflate(R.layout.fragment_welcome_page, container, false);

            TextView textView = (TextView) rootView.findViewById(R.id.titelText);
            textView.setText("夢想清單");

            textView = (TextView) rootView.findViewById(R.id.descriptionText);
            textView.setText("透過讓使用者設定明確的理財目標，智慧小天使會根據使用者所設定的夢想清單內容，以聰明的方式幫助使用者完成夢想。");

            ImageView IV = (ImageView)rootView.findViewById(R.id.welcome_image);
            IV.setVisibility(View.VISIBLE);
            IV.setImageResource(R.drawable.ic_checklist);

            //RadioButton radioButton = (RadioButton) rootView.findViewById(R.id.indexPage2);
            //radioButton.setChecked(true);

            return rootView;
        }

        private View Page3(LayoutInflater inflater, ViewGroup container){
            View rootView = inflater.inflate(R.layout.fragment_welcome_page, container, false);

            TextView textView = (TextView) rootView.findViewById(R.id.titelText);
            textView.setText("聰明購物");

            textView = (TextView) rootView.findViewById(R.id.descriptionText);
            textView.setText("從單純的金錢收支管理，進階到包含了有形/無形的資產管理。智慧小天使會分析使用者資產的狀態，在使用者購物的時候，給予合適的消費建議，以達到「節流」的效果。");

            ImageView IV = (ImageView)rootView.findViewById(R.id.welcome_image);
            IV.setVisibility(View.VISIBLE);
            IV.setImageResource(R.drawable.ic_shopping_bag);
            //RadioButton radioButton = (RadioButton) rootView.findViewById(R.id.indexPage3);
            //radioButton.setChecked(true);

            return rootView;
        }

        private View Page4(LayoutInflater inflater, ViewGroup container){
            View rootView = inflater.inflate(R.layout.fragment_welcome_page, container, false);

            TextView textView = (TextView) rootView.findViewById(R.id.titelText);
            textView.setText("聰明理財");

            textView = (TextView) rootView.findViewById(R.id.descriptionText);
            textView.setText("教導使用者理財的重要性，並根據理財的狀況與夢想清單的資訊，提供使用者合適的投資理財工具，以達到「開源」的效果。");

            ImageView IV = (ImageView)rootView.findViewById(R.id.welcome_image);
            IV.setVisibility(View.VISIBLE);
            IV.setImageResource(R.drawable.ic_pie_chart);

            //RadioButton radioButton = (RadioButton) rootView.findViewById(R.id.indexPage4);
            //radioButton.setChecked(true);

            return rootView;
        }

        private View Page5(LayoutInflater inflater, ViewGroup container){
            View rootView = inflater.inflate(R.layout.fragment_welcome_page, container, false);

            TextView textView = (TextView) rootView.findViewById(R.id.titelText);
            textView.setText("開始使用");

            textView = (TextView) rootView.findViewById(R.id.descriptionText);
            textView.setText("謝謝您，我們將帶給你更好的收支體驗");

            ImageView IV = (ImageView)rootView.findViewById(R.id.welcome_image);
            IV.setVisibility(View.INVISIBLE);

            //RadioButton radioButton = (RadioButton) rootView.findViewById(R.id.indexPage5);
            //radioButton.setChecked(true);

            return rootView;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int Position = getArguments().getInt(ARG_SECTION_NUMBER);

            return UIUpdater(inflater, container, Position);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public void clickStartMain(View v){

        }

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            Button BtnStartUsing = (Button)findViewById(R.id.btnStartUsing);
            BtnStartUsing.setOnClickListener(new Button.OnClickListener(){

                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), ProfilePage.class));
                    finish();
                }
            });

            ViewPager pagr = (ViewPager) findViewById(R.id.container);
            pagr.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    RadioButton radioButton = null;
                    View LoginAreaView = findViewById(R.id.login_area);

                    switch (position) {
                        case 0:
                            LoginAreaView.setVisibility(View.GONE);

                            radioButton = (RadioButton) findViewById(R.id.indexPage1);
                            radioButton.setChecked(true);
                            break;
                        case 1:
                            LoginAreaView.setVisibility(View.GONE);

                            radioButton = (RadioButton) findViewById(R.id.indexPage2);
                            radioButton.setChecked(true);
                            break;
                        case 2:
                            LoginAreaView.setVisibility(View.GONE);

                            radioButton = (RadioButton) findViewById(R.id.indexPage3);
                            radioButton.setChecked(true);
                            break;
                        case 3:
                            LoginAreaView.setVisibility(View.GONE);

                            radioButton = (RadioButton) findViewById(R.id.indexPage4);
                            radioButton.setChecked(true);
                            break;
                        case 4:
                            LoginAreaView.setVisibility(View.VISIBLE);

                            radioButton = (RadioButton) findViewById(R.id.indexPage5);
                            radioButton.setChecked(true);
                            break;
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });


        }



        private void OnGoMainPage(){

        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {

            return 5;
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
                case 3:
                    return "SECTION 4";
                case 4:
                    return "SECTION 5";
            }
            return null;
        }
    }
}
