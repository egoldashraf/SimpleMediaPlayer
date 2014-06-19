package com.parsigostar.simple_media_player;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import com.parsigostar.simple_media_player.helper.MediaManager;

import java.io.File;

/**
 * Created by Mohammad on 6/19/14.
 */
public class G extends Application {
    public static final int DOWNLOAD_BUFFER_SIZE = 8 * 1024;
    public static Context context;
    public static LayoutInflater inflater;
    public static Handler handler;

    public static MediaManager mediaManager;
    public static Resources resources;

    public static String DIR_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();

    public static String DIR_APP = DIR_SDCARD + "/simple_media_player";

    @Override
    public void onCreate() {

        super.onCreate();

        context = getApplicationContext();

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        handler = new Handler();

        resources = context.getResources();

        new File(DIR_APP).mkdirs();
    }

}
