package br.com.digitalhouse.harvardartmuseums.view.settings;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;

import java.util.Objects;

import br.com.digitalhouse.harvardartmuseums.R;

public class SettingsActivity extends AppCompatActivity{

    private SwitchCompat sound, notify;
    boolean stateSound, stateNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Settings");
        setSupportActionBar(toolbar);

        //Adiciona a seta de voltar na toolbar
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
            }
        }catch (Exception e){
            e.printStackTrace();

        }

        final SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        stateSound = preferences.getBoolean("sound", false);
        stateNotify = preferences.getBoolean("notify", false);

        SeekBar seekBar = findViewById(R.id.seekBar);
        sound = findViewById(R.id.sound);
        notify = findViewById(R.id.notify);

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

    //Este método é chamado no momento em que pressionamos a seta de voltar da toolbar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); //Este método é o mesmo chamado no momento que apertamos o back na parte debaixo do celular...
        return true;
    }
}


