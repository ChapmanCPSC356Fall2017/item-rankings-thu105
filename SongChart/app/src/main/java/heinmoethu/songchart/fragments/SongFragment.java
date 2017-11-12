package heinmoethu.songchart.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.joda.time.format.DateTimeFormat;

import heinmoethu.songchart.R;
import heinmoethu.songchart.SongCollection;
import heinmoethu.songchart.activities.SongActivity;
import heinmoethu.songchart.models.SongModel;

/**
 * Created by Hein Moe Thu on 11/12/2017.
 * Assignemnt: mpg_fragments
 * Class: CPSC 356
 */

public class SongFragment extends Fragment {
    private SongModel song;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        String songId=getArguments().getString(SongActivity.EXTRA_SONG_ID);
        this.song= SongCollection.GetInstance().getSong(songId);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_song, container,false);
        EditText et_title = v.findViewById(R.id.et_title);
        EditText et_artist = v.findViewById(R.id.et_artist);

        et_title.setText(song.getTitle());
        et_artist.setText(song.getArtist());

        et_title.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                song.setTitle(editable.toString());
            }
        });
        et_artist.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                song.setTitle(editable.toString());
            }
        });


        Button dateButton = v.findViewById(R.id.btn_released_date);
        dateButton.setText(this.song.getDate().toString(DateTimeFormat.longDateTime()));

        return v;
    }
}
