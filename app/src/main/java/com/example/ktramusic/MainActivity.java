package com.example.ktramusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    ListView listView_casi;
    ArrayList<Song> arraySong;
    TextView txtTitle,TxtTime;
    Button btnPlay,btnPause,btnChonBai;
    int position = 0;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//     activity_main   listView_casi = (ListView) findViewById(R.id.list_casi);

//        list_casi = new ArrayList<list_casi>();
//        list_casi.add(new list_casi("bài 1",""));
//        list_casi.add(new list_casi("bài 2",""));
//        list_casi.add(new list_casi("bài 3",""));
//        list_casi.add(new list_casi("bài 4",""));
//        list_casi.add(new list_casi("bài 5",""));
//        list_casi.add(new list_casi("bài 6",""));

//        Adapter_casi adapter_casi = new Adapter_casi(MainActivity.this,R.layout.list_music,list_casi);

//        listView_casi.setAdapter(adapter_casi);

        AnhXa();
        AddSong();
        mediaPlayer = MediaPlayer.create(MainActivity.this, arraySong.get(position).getFile());
//        mediaPlayer.start();
        txtTitle.setText(arraySong.get(position).getTitle());
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        btnChonBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                startActivityForResult(new Intent(this, Activity_bai_hat.class), position);
            }
        });
    }

    private void AddSong() {
        arraySong = new ArrayList<>();
        arraySong.add(new Song("Bài 1",R.raw.bai-1));
        arraySong.add(new Song("Bài 2",R.raw.bai-2));
        arraySong.add(new Song("Bài 3",R.raw.bai-3));
        arraySong.add(new Song("Bài 4",R.raw.bai-4));
        arraySong.add(new Song("Bài 5",R.raw.bai-5));
        arraySong.add(new Song("Bài 6",R.raw.bai-6));
    }

    private void AnhXa() {
        txtTitle = (TextView) findViewById(R.id.textviewTitle);
        TxtTime = (TextView) findViewById(R.id.textviewTime);
        btnPlay = (Button) findViewById(R.id.Play);
        btnPause = (Button) findViewById(R.id.Pause);
        btnChonBai = (Button) findViewById(R.id.chonbai);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == position && resultCode == RESULT_OK){

//            txtTitle.setText("Bài " + data.getData(mResIdSelected));

            int resID = data.getIntExtra(Activity_bai_hat.EXTRA_RES_ID_MUSIC, 0);
            mediaPlayer.reset();
            mediaPlayer = MediaPlayer.create(this, resID);

            Time time = new Time();
            time.set(mediaPlayer.getDuration());
//            TxtTime.setText(data.getAction());

            Resources resources = getResources();
            Uri uri = new Uri.Builder()
                    .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                    .authority(resources.getResourcePackageName(resID))
                    .appendPath(resources.getResourceTypeName(resID))
                    .appendPath(resources.getResourceEntryName(resID))
                    .build();
            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            retriever.setDataSource(this, uri);
            txtTitle.setText(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
        }
    }
}