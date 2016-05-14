package goldzweigapps.easytabs;

import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.Bind;
import butterknife.ButterKnife;
import goldzweigapps.tabs.Builder.EasyTabsBuilder;
import goldzweigapps.tabs.Builder.TabItem;
import goldzweigapps.tabs.EasyTabsColors;
import goldzweigapps.tabs.transforms.AccordionTransformer;
import goldzweigapps.tabs.transforms.CubeInTransformer;
import goldzweigapps.tabs.transforms.CubeOutTransformer;

public class MainActivity extends AppCompatActivity {
    EasyTabsBuilder builder;
    EasyTabsColors colors;
    @Bind(R.id.pager)
    ViewPager pager;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface selected;
        selected = Typeface.createFromAsset(getAssets(), "fonts/bubble.ttf");
        colors = new EasyTabsColors();
builder = new EasyTabsBuilder(this, tabs, pager)
        .addTabs(false,
                new TabItem(new frag1(), "number 1"),
                new TabItem(new frag2(), "number 2"),
                new TabItem(new frag3(), "number 3"),
                new TabItem(new frag4(), "number 4"),
                new TabItem(new frag1(), "number 1"),
                new TabItem(new frag2(), "number 2"),
                new TabItem(new frag3(), "number 3"),
                new TabItem(new frag4(), "number 4"),
                new TabItem(new frag1(), "number 5")
       )
        .setBackgroundColor(colors.RoyalBlue)
        .setIndicatorColor(colors.White)

        .setTextColors(colors.White, colors.DarkSlateBlue)
        .addIcons(R.drawable.ic_person_white_36dp,
                R.drawable.ic_photo_camera_white_36dp,
                R.drawable.ic_favorite_white_36dp,
                R.drawable.ic_help_white_36dp,
                R.drawable.ic_person_white_36dp)
        .setTransformation(true, new CubeOutTransformer())
        .setTabLayoutScrolable(false)
        .setTypeface(selected)
        .setToRTL(false)
        .withIconFading(true);

    }
}
