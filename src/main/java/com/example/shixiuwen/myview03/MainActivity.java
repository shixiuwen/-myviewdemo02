package com.example.shixiuwen.myview03;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyTop mytop = (MyTop) findViewById(R.id.mytop);

        mytop.setMyOnclickListener(new MyTop.MyOnclickListenerFace() {
            @Override
            public void myLeftOnclickListener() {
                Toast.makeText(MainActivity.this,"返回",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void myRightOnclickListener() {
                Toast.makeText(MainActivity.this,"确认",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
