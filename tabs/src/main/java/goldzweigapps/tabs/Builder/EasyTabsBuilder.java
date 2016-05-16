package goldzweigapps.tabs.Builder;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.LayoutDirection;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gilgoldzweig on 13/05/16.
 */
public class EasyTabsBuilder {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mFragmentTitleListemety = new ArrayList<>();
    private List<String> mFragmentTitleList = new ArrayList<>();
    int selectedColors,textColor,BackgroundColor,IndicatorColor;
    boolean withoutTitle,withIconFading;
    String title;
    private boolean mIsRtlOriented;
    android.support.v4.app.Fragment fragment;
    TabLayout tabs;

    ViewPagerAdapter adapter;
    AppCompatActivity activity;
    boolean hide;
    LayoutDirection direction;
    ViewPager pager;
    int icons = -1;


    public EasyTabsBuilder(AppCompatActivity activity, TabLayout tabs, final ViewPager pager){
        adapter = new ViewPagerAdapter(activity.getSupportFragmentManager());
        this.tabs = tabs;
        this.pager = pager;
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);



      tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
          @Override
          public void onTabSelected(TabLayout.Tab tab) {
              log("positon", tab.getPosition());
              pager.setCurrentItem(tab.getPosition(), true);
          }

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {

          }

          @Override
          public void onTabReselected(TabLayout.Tab tab) {
              log("positon", tab.getPosition());
              pager.setCurrentItem(tab.getPosition(), true);
          }
});
    }
    public EasyTabsBuilder setTypeface(final Typeface selected){

        ViewGroup vg = (ViewGroup) tabs.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);

                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(selected);
                }
            }
        }
        return this;
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public EasyTabsBuilder setToRTL(Boolean answer){

        if (answer){
            tabs.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                pager.setCurrentItem(adapter.getCount() - 1);
            }else{
               pager.setCurrentItem(0);
        }
        return this;
    }
    public EasyTabsBuilder setTextColors(int normalColor, int selectedColor){
        if (textColor == 0 || selectedColor == 0){
            tabs.setTabTextColors(normalColor, selectedColor);
        }else{

            tabs.setTabTextColors(textColor, selectedColors);
        }
        return this;
    }
    public EasyTabsBuilder setBackgroundColor(int Color){
        if (BackgroundColor == 0){
            tabs.setBackgroundColor(Color);
        }else {
            tabs.setBackgroundColor(BackgroundColor);
        }
        return this;
    }
    public EasyTabsBuilder setIndicatorColor(int Color){
        if (BackgroundColor == 0) {
            tabs.setSelectedTabIndicatorColor(Color);
        }else {
            tabs.setSelectedTabIndicatorColor(IndicatorColor);
        }
        return this;
    }
    public EasyTabsBuilder withIconFading(boolean answer){
        if (icons ==adapter.getCount()){


        this.withIconFading = answer;
        if (answer) {
            pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @SuppressWarnings("ConstantConditions")
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    int alphaCurrent = (int) (255 - (128 * Math.abs(positionOffset)));
                    int alphaNext = (int) (128 + (128 * Math.abs(positionOffset)));

                    if (positionOffset != 0) {

                        switch (icons) {
                            case 0:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                }
                                break;
                            case 1:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                }
                                break;
                            case 2:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);

                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;

                                }
                                break;
                            case 3:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                }
                                break;
                            case 4:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 5:
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaNext);
                                        break;
                                }
                                break;
                            case 5:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 5:
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 6:
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaNext);
                                        break;

                                }
                                break;
                            case 6:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 5:
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 6:
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 7:
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaNext);

                                }
                                break;
                            case 7:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 5:
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 6:
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 7:
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 8:
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaNext);
                                        break;

                                }
                                break;
                            case 8:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 5:
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 6:
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 7:
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 8:
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 9:
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaNext);
                                        break;

                                }
                                break;
                            case 9:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 5:
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 6:
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 7:
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 8:
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 9:
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 10:
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(11).getIcon().setAlpha(alphaNext);
                                        break;

                                }
                                break;

                            case 10:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 5:
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 6:
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 7:
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 8:
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 9:
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 10:
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(11).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 11:
                                        tabs.getTabAt(11).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(12).getIcon().setAlpha(alphaNext);
                                        break;

                                }
                                break;
                            case 11:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 5:
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 6:
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 7:
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 8:
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 9:
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 10:
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(11).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 11:
                                        tabs.getTabAt(11).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(12).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 12:
                                        tabs.getTabAt(12).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(13).getIcon().setAlpha(alphaNext);
                                        break;


                                }
                                break;
                            case 12:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 5:
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 6:
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 7:
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 8:
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 9:
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 10:
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(11).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 11:
                                        tabs.getTabAt(11).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(12).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 12:
                                        tabs.getTabAt(12).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(13).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 13:
                                        tabs.getTabAt(13).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(14).getIcon().setAlpha(alphaNext);
                                        break;


                                }
                                break;
                            case 13:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 5:
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 6:
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 7:
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 8:
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 9:
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 10:
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(11).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 11:
                                        tabs.getTabAt(11).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(12).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 12:
                                        tabs.getTabAt(12).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(13).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 13:
                                        tabs.getTabAt(13).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(14).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 14:
                                        tabs.getTabAt(14).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(15).getIcon().setAlpha(alphaNext);
                                        break;
                                }
                                break;
                            case 14:
                                switch (position) {
                                    case 0:
                                        tabs.getTabAt(0).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 1:
                                        tabs.getTabAt(1).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 2:
                                        tabs.getTabAt(2).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 3:
                                        tabs.getTabAt(3).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 4:
                                        tabs.getTabAt(4).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 5:
                                        tabs.getTabAt(5).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 6:
                                        tabs.getTabAt(6).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 7:
                                        tabs.getTabAt(7).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 8:
                                        tabs.getTabAt(8).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 9:
                                        tabs.getTabAt(9).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 10:
                                        tabs.getTabAt(10).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(11).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 11:
                                        tabs.getTabAt(11).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(12).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 12:
                                        tabs.getTabAt(12).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(13).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 13:
                                        tabs.getTabAt(13).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(14).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 14:
                                        tabs.getTabAt(14).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(15).getIcon().setAlpha(alphaNext);
                                        break;
                                    case 15:
                                        tabs.getTabAt(15).getIcon().setAlpha(alphaCurrent);
                                        tabs.getTabAt(16).getIcon().setAlpha(alphaNext);
                                        break;

                                }
                                break;

                        }
                    }
                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }

            });
        }
        }else {
            Throwable throwable = new Throwable("Amount of icons must be equal to the number of tabs. ");
            try {
                throw throwable;
            } catch (Throwable throwable1) {
                throwable1.printStackTrace();
            }


        }
        return this;
    }
    public EasyTabsBuilder setTabLayoutScrolable(Boolean answer){
        if (answer){
            tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        }else{
            tabs.setTabMode(TabLayout.MODE_FIXED);
        }
        if (adapter.getCount() > 6){
            tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
        return this;
    }
    public EasyTabsBuilder addTabs(boolean hideTitle,TabItem... tabItems){
        for (TabItem item : tabItems){
            adapter.addFrag(item.fragment, item.title, hideTitle);
        }
        return this;
    }
    public EasyTabsBuilder addIcons(int... resId){
        for (int icon: resId){
            icons++;
//            int lessone = resId.length - 1;
//            int currect = resId.length - lessone;
            Log.d("dodo", String.valueOf(icons));


            try {
                if ( icon != 0 || tabs != null)  {
                    tabs.getTabAt(icons).setIcon(icon);
                }

            } catch (NullPointerException e) {
                e.printStackTrace();
            }


        }
        return this;
    }
    public EasyTabsBuilder addIcons(Drawable... icon){
        for (Drawable iconn: icon){
            icons++;
//            int lessone = resId.length - 1;
//            int currect = resId.length - lessone;
            Log.d("dodo", String.valueOf(icons));


            try {
                if ( iconn != null || tabs != null)  {

                    tabs.getTabAt(icons).setIcon(iconn);
                }

            } catch (NullPointerException e) {
                e.printStackTrace();
            }




        }return this;}
    public EasyTabsBuilder setTransformation(boolean reverseDrawingOrder, ViewPager.PageTransformer transform){
        pager.setPageTransformer(reverseDrawingOrder, transform);
        return this;
    }

   class ViewPagerAdapter extends FragmentPagerAdapter {

boolean t;
       public ViewPagerAdapter(android.support.v4.app.FragmentManager fragmentManager) {
           super(fragmentManager);
       }


       @Override
       public android.support.v4.app.Fragment getItem(int position) {
           return mFragmentList.get(position);
       }

       @Override
       public int getCount() {
           return mFragmentList.size();
       }

       public void addFrag(android.support.v4.app.Fragment fragment, String title, boolean hidee) {
           mFragmentList.add(fragment);
           mFragmentTitleList.add(title);

           t = hide;
           notifyDataSetChanged();



       }

       @Override
       public CharSequence getPageTitle(int position) {
           log("show", t);
           if (t){
               return null;
           }else{
           return mFragmentTitleList.get(position);
       }
       }
       /**
        * @return the {@link #getCount()} result of the wrapped adapter
        */
   }
    private void log(String value, String values){
        Log.i(value, values);
    }
    private void log(String value, int values){
        Log.i(value, String.valueOf(values));
    }
    private void log(String value, boolean values){
        Log.i(value, String.valueOf(values));
    }
    private void log(String value, List values){
        Log.i(value, String.valueOf(values));
    }
    private void log(String value, float values){
        Log.i(value, String.valueOf(values));
    }
    private void log(String value, Double values){
        Log.i(value, String.valueOf(values));
    }
    private void log(String value, Integer values){
        Log.i(value, String.valueOf(values));
    }




}
