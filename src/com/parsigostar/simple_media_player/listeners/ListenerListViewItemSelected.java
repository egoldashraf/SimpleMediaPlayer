package com.parsigostar.simple_media_player.listeners;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import com.parsigostar.simple_media_player.ActivityMain;
import com.parsigostar.simple_media_player.G;
import com.parsigostar.simple_media_player.data.FakeData;
import com.parsigostar.simple_media_player.helper.MediaManager;

/**
 * Created by Mohammad on 6/19/14.
 */
public class ListenerListViewItemSelected extends Activity implements AdapterView.OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        G.mediaManager.setCurrentPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        G.mediaManager.setCurrentPosition(0);
    }
}
