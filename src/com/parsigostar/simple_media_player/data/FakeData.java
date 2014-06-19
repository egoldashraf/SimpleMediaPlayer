package com.parsigostar.simple_media_player.data;

import android.content.res.AssetManager;

import java.util.ArrayList;

/**
 * Created by Mohammad on 6/19/14.
 */
public class FakeData {

    public static ArrayList<StructSong> songs = new ArrayList<StructSong>();

    public static int currentPosition = 0;

    public static AdapterSongs adapter;

    public static void init() {

        for (int i = 1; i < 10; i++) {

            songs.add(new StructSong("Song #" + i, "0" + i + ".MP3"));
        }

        adapter = new AdapterSongs(songs);

        adapter.notifyDataSetChanged();
    }
}
