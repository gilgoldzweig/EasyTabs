EasyTabs
===================


EasyTabs is a library for android that helps create and customize material design tabs easily.
----------


Installing
-------------

**Add this to your gradle.**
> - repositories {
    maven {
        url "https://jitpack.io"
    }
}

> - compile 'com.android.support:design:23.3.0'

> - compile 'com.github.gilgoldzweig:EasyTabs:f434d9f635'


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

    EasyTabsBuilder builder;
    EasyTabsColors colors;
    TabLayout tabs;
    ViewPager pager;

    colors = new EasyTabsColors();
    tabs = (TabLayout)findViewById(R.id.tabs);
    pager = (ViewPager)findViewById(R.id.pager);
    builder = new EasyTabsBuilder(this, tabs, pager);

**To add tabs**
 **Use** 
 `addTabs(Boolean hideTitle, new TabItem(new fragment, "Tab title") );`
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
>    - setTypeface

  

Creator
-------
> Gil Goldzweig


Contact me
=======
If you use or need help using the library il be happy to help
> Gil5841@gmail.com
