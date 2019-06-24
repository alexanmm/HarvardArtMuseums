package br.com.digitalhouse.harvardartmuseums.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.home.LowerLevelActivity;

public class SplashActivityLowerLevel extends AppCompatActivity {


    Timer myTimer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_lower_level);

        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivityLowerLevel.this, LowerLevelActivity.class);
                startActivity(intent);
            }
        };

        myTimer.schedule(myTask, 3000);
    }
}
