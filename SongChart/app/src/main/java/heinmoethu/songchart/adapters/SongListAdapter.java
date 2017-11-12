package heinmoethu.songchart.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;

import heinmoethu.songchart.R;
import heinmoethu.songchart.SongCollection;
import heinmoethu.songchart.activities.SongActivity;
import heinmoethu.songchart.models.SongModel;

/**
 * Created by Hein Moe Thu on 11/12/2017.
 * Assignemnt: mpg_fragments
 * Class: CPSC 356
 */

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.SongViewHolder> {

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cell_song,parent,false);

        return new SongViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SongListAdapter.SongViewHolder holder, int position) {
        SongModel song = SongCollection.GetInstance().getSongs().get(position);
        holder.setup(song);
    }

    public int getItemCount(){
        return SongCollection.GetInstance().getSongs().size();
    }
    public void remove(int position){
        SongCollection.GetInstance().getSongs().remove(position);
        notifyItemRemoved(position);
    }
    public void swap(int pos1, int pos2){
        Collections.swap(SongCollection.GetInstance().getSongs(),pos1,pos2);
        notifyItemMoved(pos1,pos2);
    }

    class SongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private SongModel song;
        private TextView tv_title, tv_artist;
        SongViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            this.tv_title=itemView.findViewById(R.id.tv_title);
            this.tv_artist=itemView.findViewById(R.id.tv_artist);
        }
        void setup(SongModel song){
            this.song=song;
            this.tv_title.setText(song.getTitle());
            this.tv_artist.setText(song.getArtist());
        }

        @Override
        public void onClick(View view) {
            Intent songIntent =new Intent(view.getContext(), SongActivity.class);
            songIntent.putExtra(SongActivity.EXTRA_SONG_ID,this.song.getId());
            view.getContext().startActivity(songIntent);
        }


    }

}
