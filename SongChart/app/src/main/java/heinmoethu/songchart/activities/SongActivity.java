package heinmoethu.songchart.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import heinmoethu.songchart.fragments.SongFragment;

/**
 * Created by Hein Moe Thu on 11/12/2017.
 * Assignemnt: mpg_fragments
 * Class: CPSC 356
 */

public class SongActivity extends SingleFragmentActivity {
    public static final String EXTRA_SONG_ID = "song_id";

    @Override
    protected Fragment getFragment() {
        Bundle extras = getIntent().getExtras();
        SongFragment sf= new SongFragment();
        sf.setArguments(extras);
        return sf;
    }
}
