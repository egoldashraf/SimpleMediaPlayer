package com.parsigostar.simple_media_player.helper;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.parsigostar.simple_media_player.G;

import java.lang.reflect.Field;
import java.util.Hashtable;

public class UiParser {

    private static Hashtable<Class<?>, UiCache> _cacheViews = new Hashtable<Class<?>, UiCache>();

    public static void parse(Activity activity) {

        parse(activity, activity.getWindow().getDecorView());

    }

    public static void parse(Object instance, View view) {

        if (_cacheViews.containsKey(instance.getClass())) {

            loadFields(_cacheViews.get(instance.getClass()), instance);

            return;
        }

        UiCache cachedActivity = new UiCache();

        cachedActivity.activity = instance.getClass();

        cachedActivity.view = view;

        Field[] fields = instance.getClass().getDeclaredFields();

        for (Field field : fields)

            cachedActivity.fields.put(field.getName(), field);

        getAllViews(cachedActivity, cachedActivity.view);

        _cacheViews.put(instance.getClass(), cachedActivity);

        loadFields(cachedActivity, instance);
    }

    private static void loadFields(UiCache cachedActivity,
                                   Object activity) {

        try {

            for (String key : cachedActivity.fields.keySet()) {

                Field field = cachedActivity.fields.get(key);

                View control = cachedActivity.controls.containsKey(key) ? cachedActivity.controls
                        .get(key) : null;

                if (control==null)

                    continue;

                field.set(activity, cachedActivity.controls.get(key));
            }

        } catch (IllegalArgumentException e) {

            e.printStackTrace();

        } catch (IllegalAccessException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    private static void getAllViews(UiCache activity, View root) {

        String id = getId(activity, root);

        if (!id.equals(""))

            activity.controls.put(getId(activity, root), root);

        if (root instanceof ViewGroup) {

            ViewGroup viewGroup = (ViewGroup) root;

            for (int i = 0; i < viewGroup.getChildCount(); i++)

                getAllViews(activity, viewGroup.getChildAt(i));
        }
    }

    private static String getId(UiCache activity, View view) {

        String entryName = "";

        int id = view.getId();

        if (id == 0xffffffff)

            return entryName;

        if (G.resources != null)

            entryName = G.resources.getResourceEntryName(id);

        return entryName;
    }

}
