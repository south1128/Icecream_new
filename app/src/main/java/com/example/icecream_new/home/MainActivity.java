package com.example.icecream_new.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.renderscript.ScriptGroup;
import android.widget.GridView;
import androidx.databinding.DataBindingUtil;

import com.example.icecream_new.R;
import com.example.icecream_new.databinding.ActivityMainBinding;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private HomeGridViewAdapter adapter;
    ActivityMainBinding b;


    int count = 0;
    String path = "/data/data/com.example.icecream_new/files/";
    File file = new File(path);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this,R.layout.activity_main);
//        setContentView(R.layout.activity_main);

        adapter = new HomeGridViewAdapter();


    }
}