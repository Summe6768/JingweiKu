package com.app.summer.summerwarehouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.summer.titlebar.Interface.OnClickListenerImgLeftBack;
import com.app.summer.titlebar.TitleBar;

public class MainActivity extends AppCompatActivity {

    private TitleBar titleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleBar = findViewById(R.id.titleBar);
        titleBar.setOnClickListenerImgLeftBack(new OnClickListenerImgLeftBack() {
            @Override
            public void OnClickImgLeftBack() {
                Toast.makeText(MainActivity.this, "ddddd", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
