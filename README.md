EasyTabs
===================


EasyTabs is a library for android that helps create and customize material design tabs easily.
----------
Demo
-------------
     ![image](https://github.com/gilgoldzweig/EasyTabs/blob/master/animation.gif)
       ![image](https://github.com/gilgoldzweig/EasyTabs/blob/master/sliding%20tablayoutfull.gif)
                                                                 
                                                                 
Installing
-------------

**Add this to your gradle.**
> - repositories {
    maven {
        url "https://jitpack.io"
    }
}
> - dependencies {
> - compile 'com.android.support:design:23.3.0'
>
> - compile 'com.github.gilgoldzweig:EasyTabs:f434d9f635'
> - }
**Add this in your xml file**

    <android.support.design.widget.TabLayout
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:id="@+id/tabs"
      android:background="@color/colorPrimary"/>


     <android.support.v4.view.ViewPager
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:id="@+id/pager"
       android:layout_below="@+id/tabs"/>

**In your java file**

    TabLayout tabs;
    ViewPager pager;

    colors = new EasyTabsColors();
    tabs = (TabLayout)findViewById(R.id.tabs);
    pager = (ViewPager)findViewById(R.id.pager);
    
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
    
    

**To add tabs**
 **Use** 
 `addTabs( new TabItem(new fragment, "Tab title") );`
> **Tip** 
> You can add as many Tabitems as you want by separate them with **,** between each item.

----------


Available Transformation
-------------------


>    - AccordionTransformer
   - BackgroundToForegroundTransformer
   - CubeInTransformer
   - CubeOutTransformer
   -  DepthPageTransformer
   - FlipHorizontalTransformer
   - 	FlipVerticalTransformer
   - ForegroundToBackgroundTransformer
   - RotateDownTransformer
   - RotateUpTransformer
   - ScaleInOutTransformer
   -  StackTransformer
   - TabletTransformer
   - ZoomInTransformer
   - ZoomOutSlideTransformer
   -  ZoomOutTranformer


Available features
-------------------
>    - seticons
>    - setTransformation
> 
>    - withIconFading (Just like in facebook's app)
> 
>    - setIndicatorColor
> 
>    - setBackgroundColor
>    
>    - setTextColors(Selected, unselected)
> 
>    - setToRTL
>
>    - supportRecyclerview(int position, Recyclerview rv)
>
>    -withListener(InfoListener)
>
>    - setTypeface

  

Creator
-------
> Gil Goldzweig


Contact me
=======
If you use or need help using the library il be happy to help
> Gil5841@gmail.com
