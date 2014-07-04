package com.parsigostar.simple_media_player.helper;

import android.app.Activity;
import android.content.*;
import android.view.View;
import com.parsigostar.simple_media_player.G;

import java.lang.reflect.Field;

public class UiParser {

    public static void parse(Activity activity) {

        parse(activity, activity, activity.getWindow().getDecorView());

    }

    public static void parse(Context context, Object instance, View view) {

        for (Field field : instance.getClass().getDeclaredFields()) {

            int id = context.getResources().getIdentifier(field.getName(), "id", G.packageName);

            if (id == 0)

                continue;

            try {

                field.set(instance, view.findViewById(id));

            } catch (IllegalAccessException e) {

                e.printStackTrace();

            }
        }
    }
}
