package heinmoethu.songchart.activities;

import android.support.v4.app.Fragment;

import heinmoethu.songchart.fragments.SongListFragment;

/**
 * Created by Hein Moe Thu on 11/12/2017.
 * Assignemnt: mpg_fragments
 * Class: CPSC 356
 */

public class SongListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new SongListFragment();
    }
}
