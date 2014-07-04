package com.parsigostar.simple_media_player.helper;

import android.content.res.*;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.SeekBar;
import com.parsigostar.simple_media_player.G;
import com.parsigostar.simple_media_player.data.*;

import java.io.IOException;

/**
 * Created by Mohammad on 6/19/14.
 */
public class MediaManager {

    private MediaPlayer mediaPlayer;

    private AssetManager assets;

    private SeekBar seekBar;

    private Runnable UpdateSongTime = new Runnable() {

        public void run() {

            int startTime = mediaPlayer.getCurrentPosition();

            if (seekBar != null)

                seekBar.setProgress(startTime);

            G.handler.postDelayed(this, 100);
        }
    };

    public MediaManager(AssetManager _assets, SeekBar _seekBar) {

        assets = _assets;

        seekBar = _seekBar;

        mediaPlayer = new MediaPlayer();

    }

    public void setCurrentPosition(int position) {

        reset();

        if (position < 0)

            position = 0;

        if (position >= FakeData.songs.size())

            position = FakeData.songs.size() - 1;

        FakeData.currentPosition = position;

        Log.i("PG", "" + position);

        StructSong song = FakeData.songs.get(position);

        try {

            AssetFileDescriptor afd = assets.openFd(song.path);

            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());

            afd.close();

            mediaPlayer.prepare();

            start();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveCurrentPosition(int count) {

        setCurrentPosition(FakeData.currentPosition + count);

    }

    public void pause() {

        mediaPlayer.pause();

    }

    public void start() {

        mediaPlayer.start();

        if (seekBar != null) {

            seekBar.setMax(mediaPlayer.getDuration());

            G.handler.postDelayed(UpdateSongTime, 100);
        }
    }

    public void reset() {

        mediaPlayer.reset();

    }

    public void stop() {

        mediaPlayer.pause();

        mediaPlayer.seekTo(0);

    }
}
