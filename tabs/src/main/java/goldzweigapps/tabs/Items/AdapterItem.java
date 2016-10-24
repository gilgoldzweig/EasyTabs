package goldzweigapps.tabs.Items;

import android.support.v4.app.Fragment;

import java.util.List;


public class AdapterItem {
    private List<Fragment> FragmentList;
    private List<String> TitleList;
    private boolean Title;


    public AdapterItem(List<Fragment> fragmentList, List<String> titleList, boolean title) {
        FragmentList = fragmentList;
        TitleList = titleList;
        Title = title;
    }

    public List<Fragment> getFragmentList() {
        return FragmentList;
    }

    public void setFragmentList(List<Fragment> fragmentList) {
        FragmentList = fragmentList;
    }

    public List<String> getTitleList() {
        return TitleList;
    }

    public void setTitleList(List<String> titleList) {
        TitleList = titleList;
    }

    public boolean isTitle() {
        return Title;
    }

    public void setTitle(boolean title) {
        Title = title;
    }
}
