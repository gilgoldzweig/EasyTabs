package goldzweigapps.tabs.View;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import goldzweigapps.tabs.Adapters.ViewPagerAdapter;
import goldzweigapps.tabs.Builder.EasyTabsBuilder;
import goldzweigapps.tabs.Interface.TabsListener;
import goldzweigapps.tabs.Items.AdapterItem;
import goldzweigapps.tabs.Items.TabItem;
import goldzweigapps.tabs.R;

/**
 * Created by gilgoldzweig on 24/10/2016.
 */

public class EasyTabs extends RelativeLayout {
   public TabLayout tabs;
    public ViewPager pager;
    View rootView;
    private AppCompatActivity appCompactActivity;
    public EasyTabs(Context context) {
        this(context, null);
        init(context);
//        pager = new ViewPager(context);
//        tabs = new TabLayout(context);
//        tabs.setBackgroundColor(Color.BLACK);
//        params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        params.addRule(RelativeLayout.BELOW, tabs.getId());


    }

    public EasyTabs(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init(context);
//        pager = new ViewPager(context, attrs);
//        tabs = new TabLayout(context, attrs);
//        tabs.setBackgroundColor(Color.BLACK);
//        params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        params.addRule(RelativeLayout.BELOW, tabs.getId());

    }

    public EasyTabs(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
//        tabs = new TabLayout(context,attrs,defStyleAttr);
//        tabs.setBackgroundColor(Color.BLACK);
//        params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        params.addRule(RelativeLayout.BELOW, tabs.getId());
    }


    private void init(Context context){
        rootView = inflate(context, R.layout.easytabs, this);
        tabs = (TabLayout) rootView.findViewById(R.id.tabs);
        pager = (ViewPager) rootView.findViewById(R.id.pager);
        appCompactActivity = (AppCompatActivity) context;
    }
    public ViewPager getViewPager(){
        return pager;
    }
    public TabLayout getTabLayout(){
        return tabs;
    }
    public AppCompatActivity getAppCompactActivity(){
        return appCompactActivity;
    }
}
