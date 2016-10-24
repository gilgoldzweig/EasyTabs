package goldzweigapps.easytabs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by gilgoldzweig on 16/10/2016.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {
    LayoutInflater inflator;
    List<VideoItem> items;
    public VideoAdapter(Context context, List<VideoItem> list){
        items = list;
        inflator = LayoutInflater.from(context);

    }
    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VideoHolder(inflator.inflate(R.layout.videoitem, parent, false));
    }

    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        ImageView thumbnail = holder.thumbnail;
        TextView title = holder.title;
        VideoItem video = items.get(position);
        title.setText(video.getTitle());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VideoHolder extends RecyclerView.ViewHolder{
        ImageView thumbnail;
        TextView title;
        VideoHolder(View v){
            super(v);
            thumbnail = (ImageView) v.findViewById(R.id.profile);
            title = (TextView) v.findViewById(R.id.title);
        }
    }

}
