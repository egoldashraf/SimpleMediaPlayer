package com.parsigostar.simple_media_player.data;

import android.content.res.AssetFileDescriptor;

/**
 * Created by Mohammad on 6/19/14.
 */
public class StructSong {
    public String name;
    public String path;

    public StructSong(String _name, String _path) {
        name=_name;
        path=_path;
    }
}
