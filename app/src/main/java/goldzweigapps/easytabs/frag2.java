package goldzweigapps.easytabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gilgoldzweig on 28/04/16.
 */
public class frag2 extends Fragment {
    public static RecyclerView rv;
    VideoAdapter adapter;
    List<VideoItem> items;
    LinearLayoutManager llm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        items = new ArrayList<>();
        adapter = new VideoAdapter(view.getContext(), items);
        llm = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
        for (int i = 0; i <= 150; i++){
            items.add(new VideoItem(String.valueOf(i), String.valueOf(i), String.valueOf(i)));
        }

    }
}
