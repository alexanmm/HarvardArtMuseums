package br.com.digitalhouse.harvardartmuseums.settings;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.SeekBar;

import br.com.digitalhouse.harvardartmuseums.R;

public class SettingActivity extends AppCompatActivity {

    private SeekBar seekBar;

    SwitchCompat sound, notify;

    boolean stateSound, stateNotify;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        stateSound = preferences.getBoolean("sound", false);
        stateNotify = preferences.getBoolean("notify", false);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        sound = (SwitchCompat) findViewById(R.id.sound);
        notify = (SwitchCompat) findViewById(R.id.notify);

        sound.setChecked(stateSound);
        notify.setChecked(stateNotify);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSound = !stateSound;
                sound.setChecked(stateSound);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("sound", stateSound);
                editor.apply();
            }
        });

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateNotify = !stateNotify;
                notify.setChecked(stateNotify);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("notify", stateNotify);
                editor.apply();
            }
        });

    }
}
