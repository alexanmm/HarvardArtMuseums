package br.com.digitalhouse.harvardartmuseums.information;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.events.EventsActivity;
import br.com.digitalhouse.harvardartmuseums.home.Home;
import br.com.digitalhouse.harvardartmuseums.favs.FavsActivity;
import br.com.digitalhouse.harvardartmuseums.game.GameMainActivity;
import br.com.digitalhouse.harvardartmuseums.help.HelpActivity;
import br.com.digitalhouse.harvardartmuseums.login.LoginActivity;
import br.com.digitalhouse.harvardartmuseums.settings.SettingActivity;


public class InformationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Information");
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
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
