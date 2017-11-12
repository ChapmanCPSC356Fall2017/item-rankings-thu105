package heinmoethu.songchart.models;

import org.joda.time.DateTime;

import java.util.UUID;

/**
 * Created by Hein Moe Thu on 11/12/2017.
 * Assignemnt: mpg_fragments
 * Class: CPSC 356
 */

public class SongModel {
    private String id,title,artist;
    private DateTime date;

    public SongModel(){
        this.id = UUID.randomUUID().toString();
        this.date=DateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

    public DateTime getDate() {
        return date;
    }
}
