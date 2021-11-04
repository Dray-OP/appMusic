package com.example.ktramusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView_casi;
    ArrayList<list_casi> list_casi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_casi = (ListView) findViewById(R.id.list_casi);

        list_casi = new ArrayList<list_casi>();
        list_casi.add(new list_casi("bài 1",""));
        list_casi.add(new list_casi("bài 2",""));
        list_casi.add(new list_casi("bài 3",""));
        list_casi.add(new list_casi("bài 4",""));
        list_casi.add(new list_casi("bài 5",""));
        list_casi.add(new list_casi("bài 6",""));

        Adapter_casi adapter_casi = new Adapter_casi(MainActivity.this,R.layout.list_music,list_casi);

        listView_casi.setAdapter(adapter_casi);

    }
}