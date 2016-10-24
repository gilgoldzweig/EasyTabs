package goldzweigapps.easytabs;

import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import goldzweigapps.tabs.Builder.EasyTabsBuilder;
import goldzweigapps.tabs.Colors.EasyTabsColors;
import goldzweigapps.tabs.Interface.TabsListener;
import goldzweigapps.tabs.Items.TabItem;
import goldzweigapps.tabs.View.EasyTabs;
import goldzweigapps.tabs.transforms.EasyAccordionTransformer;
import goldzweigapps.tabs.transforms.EasyBackgroundToForegroundTransformer;
import goldzweigapps.tabs.transforms.EasyCubeInTransformer;
import goldzweigapps.tabs.transforms.EasyCubeOutTransformer;
import goldzweigapps.tabs.transforms.EasyDefaultTransformer;
import goldzweigapps.tabs.transforms.EasyDepthPageTransformer;
import goldzweigapps.tabs.transforms.EasyFlipHorizontalTransformer;
import goldzweigapps.tabs.transforms.EasyFlipVerticalTransformer;
import goldzweigapps.tabs.transforms.EasyForegroundToBackgroundTransformer;
import goldzweigapps.tabs.transforms.EasyRotateDownTransformer;
import goldzweigapps.tabs.transforms.EasyRotateUpTransformer;
import goldzweigapps.tabs.transforms.EasyScaleInOutTransformer;
import goldzweigapps.tabs.transforms.EasyStackTransformer;
import goldzweigapps.tabs.transforms.EasyTabletTransformer;
import goldzweigapps.tabs.transforms.EasyZoomInTransformer;
import goldzweigapps.tabs.transforms.EasyZoomOutSlideTransformer;
import goldzweigapps.tabs.transforms.EasyZoomOutTranformer;

public class MainActivity extends AppCompatActivity {
    Spinner spinner, spinner2;
    ArrayAdapter adapter, adapter2;
    EasyTabs tab;
    EasyTabsBuilder builder;
    boolean hide = false;
    ViewPager.PageTransformer[] transformers = { new EasyDefaultTransformer(), new EasyAccordionTransformer(), new EasyBackgroundToForegroundTransformer(),new EasyCubeInTransformer(),new EasyCubeOutTransformer(),new EasyDepthPageTransformer(),new EasyFlipHorizontalTransformer(),new EasyFlipVerticalTransformer(),new EasyForegroundToBackgroundTransformer(),new EasyRotateDownTransformer(),new EasyRotateUpTransformer(),new EasyScaleInOutTransformer(),new EasyStackTransformer(),new EasyTabletTransformer(),new EasyZoomInTransformer(),new EasyZoomOutSlideTransformer(),new EasyZoomOutTranformer()};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab = (EasyTabs) findViewById(R.id.EasyTabs);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        for (String s : new String[]{"Show title", "Hide title"}){
            adapter2.add(s);
        }
        for (String s : new String[]{"Default","AccordionTransformer", "BackgroundToForegroundTransformer ","CubeInTransformer ","CubeOutTransformer ","DepthPageTransformer ","FlipHorizontalTransformer ","FlipVerticalTransformer ","ForegroundToBackgroundTransformer ","RotateDownTransformer ","RotateUpTransformer ","ScaleInOutTransformer "," StackTransformer ","TabletTransformer ","ZoomInTransformer","ZoomOutSlideTransformer","ZoomOutTranformer"}){
            adapter.add(s);
        }
       spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                EasyTabsBuilder.init(tab).addTabs( //this = AppCompactActivity, tabs = TabsLayout, pager = ViewPager
                        new TabItem(new frag1(), "Profile"), // Add four Tab items with fragment and title
                        new TabItem(new frag2(), "Camera"),
                        new TabItem(new frag3(), "Favorite"),
                        new TabItem(new frag4(), "Help"))
                        .setBackgroundColor(EasyTabsColors.White)
                        .setIndicatorColor(EasyTabsColors.Black)
                        .setTextColors(EasyTabsColors.Black, EasyTabsColors.RoyalBlue) //Setting two colors selected one and unselected one
                        .addIcons(
                                R.drawable.ic_person_white_36dp,
                                R.drawable.ic_photo_camera_white_36dp,
                                R.drawable.ic_favorite_white_36dp,
                                R.drawable.ic_help_white_36dp) //Adding four icons
                        .setTabLayoutScrollable(false)
                        .setCustomTypeface(Typeface.createFromAsset(getAssets(), "fonts/bubble.ttf"))
                        .withListener(new TabsListener() {

                            @Override
                            public void onScreenPosition(int position) {
                                Log.d("tag", String.valueOf(position));
                            }
                        })
                        .setIconFading(true)
                        .HideTitle(true)
                        .setTransformation(false, transformers[position])
                        .Build();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        hide = false;
                        break;
                    case 1:
                        hide = true;
                        break;

                }
                EasyTabsBuilder.init(tab).addTabs( //this = AppCompactActivity, tabs = TabsLayout, pager = ViewPager
                        new TabItem(new frag1(), "Profile"), // Add four Tab items with fragment and title
                        new TabItem(new frag2(), "Camera"),
                        new TabItem(new frag3(), "Favorite"),
                        new TabItem(new frag4(), "Help"))
                        .setBackgroundColor(EasyTabsColors.White)
                        .setIndicatorColor(EasyTabsColors.Black)
                        .setTextColors(EasyTabsColors.Black, EasyTabsColors.RoyalBlue) //Setting two colors selected one and unselected one
                        .addIcons(
                                R.drawable.ic_person_white_36dp,
                                R.drawable.ic_photo_camera_white_36dp,
                                R.drawable.ic_favorite_white_36dp,
                                R.drawable.ic_help_white_36dp) //Adding four icons
                        .setTabLayoutScrollable(false)
                        .setCustomTypeface(Typeface.createFromAsset(getAssets(), "fonts/bubble.ttf"))
                        .withListener(new TabsListener() {

                            @Override
                            public void onScreenPosition(int position) {
                                Log.d("tag", String.valueOf(position));
                            }
                        })
                        .setIconFading(true)
                        .HideTitle(hide)
                        .Build();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
