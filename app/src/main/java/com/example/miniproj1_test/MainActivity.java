package com.example.miniproj1_test;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.session.PlaybackState;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView androidGridView;

   String[] gridViewString = {
           "Trumpet",       //1
           "French Horn",   //2
           "Snare Drum",     //3
           "Trombone",      //4
           "Tuba",          //5
           "Clarinet",      //6
           "Flute",         //7
           "Oboe",          //8
           "Saxophone",     //9
           "Bassoon",       //10
           "Slide Whistle", //11
           "Timpani"        //12
    };

    int[] gridViewImageId = {
            R.drawable.trumpet, //1
            R.drawable.frenchhorn,  //2
            R.drawable.snaredurm,  //3
            R.drawable.trombone,//4
            R.drawable.tuba,//5
            R.drawable.clarinet,   //6
            R.drawable.flute,  //7
            R.drawable.oboe,  //8
            R.drawable.saxophone,//9
            R.drawable.bassoon,  //10
            R.drawable.slidewhistle,  //11
            R.drawable.timpani,  //12

    };

    int[] gridViewAudioId = {
            R.raw.trumpet,
            R.raw.frenchhorn,
            R.raw.snaredrum,
            R.raw.trombone,
            R.raw.tuba1,
            R.raw.clarinet,
            R.raw.flute,
            R.raw.oboe,
            R.raw.saxophone,
            R.raw.bassoon,
            R.raw.slidewhistle,
            R.raw.timpani
    };

    private MediaPlayer mediaPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(MainActivity.this, gridViewString, gridViewImageId, gridViewAudioId);
        androidGridView = (GridView) findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "GridView Item: " + gridViewString[+position], Toast.LENGTH_LONG).show();

                if (mediaPlayer1 != null) {
                    mediaPlayer1.stop();
                    mediaPlayer1.release();
                    mediaPlayer1 = null;
                }

                mediaPlayer1 = MediaPlayer.create(MainActivity.this, gridViewAudioId[position]);
                mediaPlayer1.start();


            }
        });
    }
}
