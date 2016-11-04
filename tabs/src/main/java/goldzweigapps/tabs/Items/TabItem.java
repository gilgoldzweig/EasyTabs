package goldzweigapps.tabs.Items;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by gilgoldzweig on 13/05/16.
 */
public class TabItem {
   @NonNull private Fragment fragment;
   @Nullable private String title;

    public TabItem(@NonNull Fragment fragment, String title) {

        this.fragment = fragment;
        this.title = title;
    }

    @NonNull
    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(@NonNull Fragment fragment) {
        this.fragment = fragment;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }
}