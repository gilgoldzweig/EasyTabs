package goldzweigapps.tabs.Builder;

import android.support.v4.app.Fragment;

/**
 * Created by gilgoldzweig on 13/05/16.
 */
public class TabItem {
    android.support.v4.app.Fragment fragment;
    String title;

    public TabItem(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }
}