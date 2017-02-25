package com.example.nikit.mydoctor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.support.v4.view.PagerAdapter;
import android.widget.TextView;

import com.example.nikit.mydoctor.InfinityViewPager.PageModel;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener {

    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2, fab3;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;



    // we name the left, middle and right page
    private static final int PAGE_LEFT = 0;
    private static final int PAGE_MIDDLE = 1;
    private static final int PAGE_RIGHT = 2;


    private LayoutInflater mInflater;
    private int mSelectedPageIndex = 1;
    // we save each page in a model
    private PageModel[] mPageModel = new PageModel[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab1.setVisibility(View.INVISIBLE);
        fab2.setVisibility(View.INVISIBLE);
        fab3.setVisibility(View.INVISIBLE);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);


        initPageModel();

        mInflater = getLayoutInflater();
        InfinityPagerAdapter adapter = new InfinityPagerAdapter();

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        // we dont want any smoothscroll. This enables us to switch the page
        // without the user notifiying this
        viewPager.setCurrentItem(PAGE_MIDDLE, false);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                mSelectedPageIndex = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {

                    final PageModel leftPage = mPageModel[PAGE_LEFT];
                    final PageModel middlePage = mPageModel[PAGE_MIDDLE];
                    final PageModel rightPage = mPageModel[PAGE_RIGHT];

                    final int oldLeftIndex = leftPage.getIndex();
                    final int oldMiddleIndex = middlePage.getIndex();
                    final int oldRightIndex = rightPage.getIndex();

                    // user swiped to right direction --> left page
                    if (mSelectedPageIndex == PAGE_LEFT) {

                        // moving each page content one page to the right
                        leftPage.setIndex(oldLeftIndex - 1);
                        middlePage.setIndex(oldLeftIndex);
                        rightPage.setIndex(oldMiddleIndex);

                        setContent(PAGE_MIDDLE);
                        viewPager.setCurrentItem(PAGE_MIDDLE,false);
                        setContent(PAGE_RIGHT);
                        setContent(PAGE_LEFT);

                        // user swiped to left direction --> right page
                    } else if (mSelectedPageIndex == PAGE_RIGHT) {

                        leftPage.setIndex(oldMiddleIndex);
                        middlePage.setIndex(oldRightIndex);
                        rightPage.setIndex(oldRightIndex + 1);

                        setContent(PAGE_MIDDLE);
                        viewPager.setCurrentItem(PAGE_MIDDLE,false);
                        setContent(PAGE_LEFT);
                        setContent(PAGE_RIGHT);
                    }
                    viewPager.setCurrentItem(PAGE_MIDDLE, false);
                }
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fab:

                animateFAB();
                break;
            case R.id.fab1:

                Log.d("Raj", "Fab 1");
                break;
            case R.id.fab2:

                Log.d("Raj", "Fab 2");
                break;
            case R.id.fab3:

                Log.d("Raj", "Fab 3");
                break;
        }
    }

    public void animateFAB() {

        if (isFabOpen) {

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isFabOpen = true;
            Log.d("Raj", "open");

        }
    }

    private void setContent(int index) {
        final PageModel model = mPageModel[index];
        model.textView.setText(model.getText());
    }

    private void initPageModel() {
        for (int i = 0; i < mPageModel.length; i++) {
            // initing the pagemodel with indexes of -1, 0 and 1
            mPageModel[i] = new PageModel(i - 1);
        }
    }


    private class InfinityPagerAdapter extends PagerAdapter {

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            // we only need three pages
            return 3;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = (TextView)mInflater.inflate(R.layout.content, null);
            PageModel currentPage = mPageModel[position];
            currentPage.textView = textView;
            textView.setText(currentPage.getText());
            container.addView(textView);
            return textView;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

    }
}
