package heinmoethu.songchart.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import heinmoethu.songchart.R;
import heinmoethu.songchart.SongTouchHelper;
import heinmoethu.songchart.adapters.SongListAdapter;

/**
 * Created by Hein Moe Thu on 11/12/2017.
 * Assignemnt: mpg_fragments
 * Class: CPSC 356
 */

public class SongListFragment extends Fragment {
    private SongListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_song_list,container,false);
        RecyclerView rv_songList=v.findViewById(R.id.rv_songs);

        this.adapter=new SongListAdapter();
        rv_songList.setAdapter(adapter);
        rv_songList.setLayoutManager(new LinearLayoutManager(getActivity()));

        ItemTouchHelper.Callback callback = new SongTouchHelper(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rv_songList);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        this.adapter.notifyDataSetChanged();
    }
}
