package com.parsigostar.simple_media_player.helper;

import java.lang.reflect.Field;
import java.util.Hashtable;

import android.content.res.Resources;
import android.view.View;

public class UiCache {

    public UiCache() {

        controls = new Hashtable<String, View>();
        fields = new Hashtable<String, Field>();
    }

    public Class<?> activity;

    public View view;

    public Hashtable<String, Field> fields;

    public Hashtable<String, View> controls;

}
