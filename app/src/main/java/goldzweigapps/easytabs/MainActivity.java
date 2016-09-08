package goldzweigapps.easytabs;

import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.Bind;
import butterknife.ButterKnife;
import goldzweigapps.tabs.Builder.EasyTabsBuilder;
import goldzweigapps.tabs.Builder.TabItem;
import goldzweigapps.tabs.EasyTabsColors;
import goldzweigapps.tabs.Interface.TabsListener;
import goldzweigapps.tabs.transforms.EasyTabletTransformer;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        EasyTabsBuilder.init(this,tabs,pager).addTabs( //this = AppCompactActivity, tabs = TabsLayout, pager = ViewPager
                new TabItem(new frag1(), "number 1"), // Add four Tab items with fragment and title
                new TabItem(new frag2(), "number 2"),
                new TabItem(new frag3(), "number 3"),
                new TabItem(new frag4(), "number 4"))
                .HideTitle(false)
                .setBackgroundColor(EasyTabsColors.White)
                .setIndicatorColor(EasyTabsColors.Black)
                .setTextColors(EasyTabsColors.Black, EasyTabsColors.RoyalBlue) //Setting two colors selected one and unselected one
                .addIcons(
                    R.drawable.ic_person_white_36dp,
                    R.drawable.ic_photo_camera_white_36dp,
                    R.drawable.ic_favorite_white_36dp,
                    R.drawable.ic_help_white_36dp) //Adding four icons
                .setTransformation(true, new EasyTabletTransformer())
                .setTabLayoutScrollable(false)
                .setCustomTypeface(Typeface.createFromAsset(getAssets(), "fonts/bubble.ttf"))
                .setRTLPosition(true)
                .withListener(new TabsListener() {

                    @Override
                    public void onScreenPosition(int position) {
                        Log.d("tag", String.valueOf(position));
                    }
                })
                .setIconFading(true)
                .Build();
    }

}
