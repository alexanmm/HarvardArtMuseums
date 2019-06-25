package br.com.digitalhouse.harvardartmuseums.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.events.EventsActivity;
import br.com.digitalhouse.harvardartmuseums.favs.FavsActivity;
import br.com.digitalhouse.harvardartmuseums.game.GameMainActivity;
import br.com.digitalhouse.harvardartmuseums.help.HelpActivity;
import br.com.digitalhouse.harvardartmuseums.home.Home;
import br.com.digitalhouse.harvardartmuseums.information.InformationActivity;
import br.com.digitalhouse.harvardartmuseums.login.LoginActivity;

public class SettingActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navigationView;

    private SeekBar seekBar;

    SwitchCompat sound, notify;

    boolean stateSound, stateNotify;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Settings");
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);



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

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(this, "action_settings", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.action_help) {
            Toast.makeText(this, "action_help", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.action_logout) {
            Toast.makeText(this, "action_logout", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home: {
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
                return true;
            }
            case R.id.navigation_information: {
                Intent intent = new Intent(this, InformationActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.navigation_events: {
                Intent intent = new Intent(this, EventsActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.navigation_favorites: {
                Intent intent = new Intent(this, FavsActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.navigation_game: {
                Intent intent = new Intent(this, GameMainActivity.class);
                startActivity(intent);
                return true;
            }
        }
        return true;
    }

}


