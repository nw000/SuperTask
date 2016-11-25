package net.ruoxu.supertask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import net.ruoxu.SuperTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void execute(View view) {

        SuperTask<String> superTask = new SuperTask<>(new SuperTask.CallBack<String>() {
            @Override
            public void before() {
                Toast.makeText(MainActivity.this, "before", Toast.LENGTH_SHORT).show();
            }

            @Override
            public String doInBackgroud() {
                try {
                    Thread.sleep(2000);
                    Log.d("MainActivity", "doInBackgournd");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return "hello";
            }

            @Override
            public void after() {
                Toast.makeText(MainActivity.this, "after", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void cancel() {
                Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
            }
        });

        superTask.execute();
    }
}