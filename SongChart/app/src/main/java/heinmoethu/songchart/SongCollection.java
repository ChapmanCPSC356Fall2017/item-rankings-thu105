package heinmoethu.songchart;

import java.util.ArrayList;
import java.util.List;

import heinmoethu.songchart.models.SongModel;

/**
 * Created by Hein Moe Thu on 11/12/2017.
 * Assignemnt: mpg_fragments
 * Class: CPSC 356
 */

public class SongCollection {
    private static SongCollection collection;

    public static SongCollection GetInstance(){
        if(collection==null)
            collection = new SongCollection();
        return collection;
    }
    private List<SongModel> songs;
    private SongCollection(){
        this.songs= new ArrayList<>();
        for(int x=0; x<50; ++x){

            SongModel song=new SongModel();
            song.setTitle("Song #" + (x+1));
            song.setArtist("Artist #" + (x+1));

            this.songs.add(song);
        }
    }
    public List<SongModel> getSongs(){
        return this.songs;
    }
    public void addSong(SongModel song){
        this.songs.add(song);
    }
    public SongModel getSong(String id){
        for(SongModel song:this.songs){
            if(song.getId().equals(id))
                return song;
        }
        return null;
    }
}
