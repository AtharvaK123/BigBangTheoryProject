package com.example.bbtproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ImageView imageView;
    ArrayList<String> names;
    ArrayList<String> description;
    ArrayList<Integer> images;
    ArrayList<BBTEpisodes> episodes;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("LIFECYCLETAG", "SAVE");
        outState.putParcelableArrayList("Key", episodes);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = new ArrayList<>();

        episodes = new ArrayList<>();

        if (savedInstanceState != null) {
            episodes = savedInstanceState.getParcelableArrayList("Key");
        } else {
            episodes.add(new BBTEpisodes("Pilot\n\n\n", 1, "A pair of socially awkward theoretical physicists meet their new neighbor Penny, who is their polar opposite.\n\n\n", R.drawable.bbt1));
            episodes.add(new BBTEpisodes("The Big Bran Hypothesis\n\n", 2, "Penny is furious with Leonard and Sheldon when they sneak into her apartment and clean it while she is sleeping.\n\n", R.drawable.bbt2));
            episodes.add(new BBTEpisodes("The Fuzzy Boots Corollary\n", 3, "Leonard gets upset when he discovers that Penny is seeing a new guy, so he tries to trick her into going on a date with him.\n", R.drawable.bbt3));
            episodes.add(new BBTEpisodes("The Luminous Fish Effect\n", 4, "Sheldon's mother is called to intervene when he delves into numerous obsessions after being fired for being disrespectful to his new boss.\n", R.drawable.bbt4));
            episodes.add(new BBTEpisodes("The Hamburger Postulate\n", 5, "Leslie seduces Leonard, but afterwards tells him that she is only interested in a one-night stand.\n", R.drawable.bbt5));
            episodes.add(new BBTEpisodes("The Middle Earth Paradigm\n", 6, "The guys are invited to Penny's Halloween party, where Leonard has yet another run-in with Pennys ex-boyfriend Kurt.\n", R.drawable.bbt6));
            episodes.add(new BBTEpisodes("The Grasshopper Experiment\n", 7, "When Howard hooks up with Penny's old friend, his absence in the gang causes problems for the rest of the guys.\n", R.drawable.bbt7));
            episodes.add(new BBTEpisodes("The Cooper-Hofstadter Polarization\n", 8, "When Raj's parents set him up on a blind date, he finds he can talk to women with the aid of alcohol.\n", R.drawable.bbt8));
            episodes.add(new BBTEpisodes("The Loobenfeld Decay\n", 9, "Leonard and Sheldon's friendship is put to the test when Leonard wants to present a paper they co-authored at a physics convention, but Sheldon doesn't.\n", R.drawable.bbt9));
            episodes.add(new BBTEpisodes("The Pancake Batter Anomaly\n", 10, "Leonard lies to Penny so he and Sheldon can get out of watching her perform, but Sheldon believes that the lie has too many loose ends, so he comes up with a new, unnecessarily complex one to replace it.\n", R.drawable.bbt10));
            episodes.add(new BBTEpisodes("The Jerusalem Duality\n", 11, "When Sheldon gets sick, Leonard, Howard and Raj go AWOL, leaving a reluctant Penny to deal with him.\n", R.drawable.bbt11));
            episodes.add(new BBTEpisodes("The Dumpling Paradox\n", 12, "Sheldon decides to give up his work and focus on other tasks when a 15-year-old prodigy joins the university, so the other guys come up with a plan to get rid of him.\n", R.drawable.bbt12));
        }

        listView = findViewById(R.id.list_id);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.adapter_layout, episodes);
        listView.setAdapter(adapter);

        TextView descriptions = findViewById(R.id.textView3);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    descriptions.setText(adapter.getDes(i));
                    Toast.makeText(MainActivity.this, i + " ", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}