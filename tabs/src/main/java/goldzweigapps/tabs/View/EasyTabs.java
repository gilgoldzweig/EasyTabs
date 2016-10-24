package goldzweigapps.tabs.View;


import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import goldzweigapps.tabs.R;

/**
 * Created by gilgoldzweig on 24/10/2016.
 * Enjoy
 */

public class EasyTabs extends RelativeLayout {
    private TabLayout tabs;
    private ViewPager pager;
    private AppCompatActivity appCompactActivity;
    public EasyTabs(Context context) {
        super(context);
        init(context);


    }

    public EasyTabs(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public EasyTabs(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context){
        View rootView = inflate(context, R.layout.easytabs, this);
        tabs = (TabLayout) rootView.findViewById(R.id.tabs);
        pager = (ViewPager) rootView.findViewById(R.id.pager);
    }

    public ViewPager getViewPager(){
        return pager;
    }
    public TabLayout getTabLayout(){
        return tabs;
    }
}
