package com.app.summer.summerwarehouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.app.summer.titlebar.Interface.OnClickListenerImgLeft;
import com.app.summer.titlebar.Interface.OnClickListenerRight;
import com.app.summer.titlebar.TitleBar;

public class MainActivity extends AppCompatActivity {

    private TitleBar title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title =findViewById(R.id.title111);

        title.setOnClickListenerRight(new OnClickListenerRight() {
            @Override
            public void OnClickRight() {
                Toast.makeText(MainActivity.this, "右边", Toast.LENGTH_SHORT).show();
            }
        });
        title.setonClickListenerImgLeft(new OnClickListenerImgLeft() {
            @Override
            public void OnClickImgLeftBack() {
                Toast.makeText(MainActivity.this, "左边", Toast.LENGTH_SHORT).show();

            }
        });
//        title.setBackgroundColor(getResources().getColor(R.color.colorAccent));

    }


}
