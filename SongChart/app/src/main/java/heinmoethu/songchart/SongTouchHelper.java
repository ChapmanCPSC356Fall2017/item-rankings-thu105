package heinmoethu.songchart;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import heinmoethu.songchart.adapters.SongListAdapter;

/**
 * Created by Hein Moe Thu on 11/12/2017.
 * Assignemnt: mpg_fragments
 * Class: CPSC 356
 */

public class SongTouchHelper extends ItemTouchHelper.SimpleCallback {
    private SongListAdapter adapter;

    public SongTouchHelper(SongListAdapter adapter){
        super(ItemTouchHelper.UP|ItemTouchHelper.DOWN,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT);
        this.adapter = adapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        adapter.swap(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.remove(viewHolder.getAdapterPosition());
    }
}
