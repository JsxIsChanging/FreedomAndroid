package com.example.a91256.freedomandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.a91256.freedomandroid.R;

public class FreedomActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioButton bookcase;
    private RadioButton library;
    private RadioButton featured;
    private RadioButton find;
    private RadioGroup bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freedom);
        init();
    }
    private void init(){
        bookcase = (RadioButton)findViewById(R.id.bookcase_text);
        library = (RadioButton)findViewById(R.id.library_text);
        featured = (RadioButton)findViewById(R.id.featured_text);
        find = (RadioButton)findViewById(R.id.find_text);
        bottomBar = (RadioGroup)findViewById(R.id.bottom_bar);
        bottomBar.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}
