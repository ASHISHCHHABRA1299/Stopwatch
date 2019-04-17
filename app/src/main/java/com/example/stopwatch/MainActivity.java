package com.example.stopwatch;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timer;
    Button start, pause, reset;
    private boolean running;
    private int Seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = (TextView) findViewById(R.id.tvTimer);
        start = (Button) findViewById(R.id.btStart);
        pause = (Button) findViewById(R.id.btPause);
        reset = (Button) findViewById(R.id.btReset);
       runtime();

    }

    public void onclickstart(View view) {
        running = true;
        reset.setEnabled(false);
    }

    public void onclickstop(View view) {
        running = false;
        reset.setEnabled(true);


    }

    public void onclickreset(View view) {
        running = false;
        Seconds=0;
    }

    public void runtime() {
        final Handler handler = new Handler() ;

    handler.post(new Runnable() {
    @Override
    public void run() {

        int hours = Seconds / 3600;
        int Minutes = (Seconds % 3600) / 60;
        int Secs = Seconds % 60;

        String time = String.format("%d:%02d:%02d", hours, Minutes, Secs);


        timer.setText(time);
        if(running)
        {
            Seconds++;
        }
        handler.postDelayed(this, 1000);

    }
});

    }
}
