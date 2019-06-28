package br.com.digitalhouse.harvardartmuseums.home;

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

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.events.EventsActivity;
import br.com.digitalhouse.harvardartmuseums.favs.FavsActivity;
import br.com.digitalhouse.harvardartmuseums.game.GameMainActivity;
import br.com.digitalhouse.harvardartmuseums.help.HelpActivity;
import br.com.digitalhouse.harvardartmuseums.information.InformationActivity;
import br.com.digitalhouse.harvardartmuseums.login.LoginActivity;
import br.com.digitalhouse.harvardartmuseums.settings.SettingActivity;
import br.com.digitalhouse.harvardartmuseums.splash.SplashActivityLevel;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        ImageView subsolo = findViewById(R.id.imageViewAndarSS);
        ImageView andar1 = findViewById(R.id.imageViewAndar1);
        ImageView andar2 = findViewById(R.id.imageViewAndar2);
        ImageView andar3 = findViewById(R.id.imageViewAndar3);
        ImageView andar4 = findViewById(R.id.imageViewAndar4);
        ImageView andar5 = findViewById(R.id.imageViewAndar5);

        subsolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndarOnClick("0");
            }
        });
        andar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndarOnClick("1");
            }
        });

        andar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndarOnClick("2");
            }
        });

        andar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndarOnClick("3");
            }
        });

        andar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndarOnClick("4");
            }
        });

        andar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndarOnClick("5");
            }
        });

    }

    private void AndarOnClick(String andarEscolhido) {
        Intent intent = new Intent(Home.this, SplashActivityLevel.class);
        CriaBunble(intent,andarEscolhido);
        startActivity(intent);
    }

    private void CriaBunble(Intent intent,String numeroAndar) {
        Bundle bundle = new Bundle();
        bundle.putString("ANDAR", numeroAndar);
        intent.putExtras(bundle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_help) {
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.action_logout) {
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
