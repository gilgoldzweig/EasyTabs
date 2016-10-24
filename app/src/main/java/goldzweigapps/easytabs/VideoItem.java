package goldzweigapps.easytabs;

/**
 * Created by gilgoldzweig on 16/10/2016.
 */

public class VideoItem {
    String url, title, thumbnail;

    public VideoItem(String thumbnail, String title, String url) {

        this.thumbnail = thumbnail;
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
