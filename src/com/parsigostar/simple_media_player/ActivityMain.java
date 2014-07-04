package com.parsigostar.simple_media_player;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import com.parsigostar.simple_media_player.data.FakeData;
import com.parsigostar.simple_media_player.helper.MediaManager;
import com.parsigostar.simple_media_player.helper.UiParser;
import com.parsigostar.simple_media_player.listeners.*;

public class ActivityMain extends Activity {

    public SeekBar seekBar;

    public Button buttonPrevious;

    public Button buttonNext;

    public Button buttonPlay;

    public Button buttonPause;

    public Button buttonStop;

    public ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        UiParser.parse(this);

        G.mediaManager = new MediaManager(getAssets(), seekBar);

        FakeData.init();

        listView.setAdapter(FakeData.adapter);

        listView.setOnItemSelectedListener(new ListenerListViewItemSelected());

        buttonPrevious.setOnClickListener(new ListenerPreviousButton());

        buttonNext.setOnClickListener(new ListenerNextButton());

        buttonPlay.setOnClickListener(new ListenerPlayButton());

        buttonPause.setOnClickListener(new ListenerPauseButton());

        buttonStop.setOnClickListener(new ListenerStopButton());

        G.mediaManager.setCurrentPosition(0);
    }
}
