package com.example.bbtproject;

import android.app.Activity;
import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<BBTEpisodes> {
    List list;
    List listI;
    Context context;
    int xmlResource;
    ListView listView;

    public CustomAdapter(Context context, int resource, List<BBTEpisodes> objects) {
        super(context, resource, objects);
        xmlResource = resource;
        list = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View adapterLayout = layoutInflater.inflate(xmlResource, null);


        TextView name = adapterLayout.findViewById(R.id.textView);
        ImageView image = adapterLayout.findViewById(R.id.imageView);
        Button remove = adapterLayout.findViewById(R.id.button);
        SeekBar bar = adapterLayout.findViewById(R.id.seekBar);
        listView = adapterLayout.findViewById(R.id.list_id);
        remove.setText("remove");
        bar.setProgress(getItem(position).getProgress());

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                getItem(position).setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
        name.setText("Episode " + (position + 1) + ": " + getItem(position).getName());
        image.setImageResource(getItem(position).getimage());

        return adapterLayout;
    }
    public String getDes(int position){
        String s = " ";
        s = getItem(position).getDescript();
        return s;
    }
}
