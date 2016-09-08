package goldzweigapps.tabs.Builder;

import android.support.v4.app.Fragment;

/**
 * Created by gilgoldzweig on 13/05/16.
 */
public class TabItem {
    private android.support.v4.app.Fragment fragment;
    private String title;

    public TabItem(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}