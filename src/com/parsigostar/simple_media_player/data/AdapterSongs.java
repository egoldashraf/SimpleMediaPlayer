package com.parsigostar.simple_media_player.data;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.parsigostar.simple_media_player.G;
import com.parsigostar.simple_media_player.R;
import com.parsigostar.simple_media_player.helper.UiParser;

import java.util.List;

/**
 * Created by Mohammad on 6/19/14.
 */
public class AdapterSongs extends ArrayAdapter<StructSong> {
    public AdapterSongs(List<StructSong> objects) {
        super(G.context, R.layout.adapter_songs, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        StructSong item = getItem(position);

        if (convertView == null) {
            convertView = G.inflater.inflate(R.layout.adapter_songs, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.fill(item, position);

        return convertView;
    }

    private static class ViewHolder {
        public ViewGroup viewGroup;

        public TextView textView;

        public ViewHolder(View view) {
            textView=(TextView)view.findViewById(R.id.textView);
            viewGroup=(ViewGroup)view.findViewById(R.id.viewGroup);
        }

        public void fill(final StructSong item, final int position) {

            textView.setText(item.name);

            viewGroup.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    G.mediaManager.setCurrentPosition(position);
                }
            });
        }
    }
}
