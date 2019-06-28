package br.com.digitalhouse.harvardartmuseums.home.galeria.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.events.EventsActivity;
import br.com.digitalhouse.harvardartmuseums.favs.FavsActivity;
import br.com.digitalhouse.harvardartmuseums.game.GameMainActivity;
import br.com.digitalhouse.harvardartmuseums.help.HelpActivity;
import br.com.digitalhouse.harvardartmuseums.home.Home;
import br.com.digitalhouse.harvardartmuseums.home.galeria.adapter.RecyclerViewGaleriaAdapter;
import br.com.digitalhouse.harvardartmuseums.home.galeria.model.Obra;
import br.com.digitalhouse.harvardartmuseums.information.InformationActivity;
import br.com.digitalhouse.harvardartmuseums.login.LoginActivity;
import br.com.digitalhouse.harvardartmuseums.settings.SettingActivity;

public class GaleriaActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerViewGaleriaAdapter adapter;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        overridePendingTransition(R.anim.activity_filho_entrando, R.anim.activity_pai_saindo);
        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerViewGaleria);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Seleciona dinamicamente as obras conforme o andar
        Intent intent2 = getIntent();
        Bundle bundle2 = intent2.getExtras();
        if (bundle2 != null) {
            String andar2 = bundle2.getString("ANDARS");
            adapter = new RecyclerViewGaleriaAdapter(listaObras(andar2),andar2);
        } else {
            adapter = new RecyclerViewGaleriaAdapter(listaObras("0"),"0");
            toolbar.setTitle("Lower Level");
            setSupportActionBar(toolbar);
        }



        recyclerView.setAdapter(adapter);
    }

    private List<Obra> listaObras(String andar) {
        List<Obra> obras = new ArrayList<>();
        if (andar.equals("0")) {
            toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle("Lower Level");
            setSupportActionBar(toolbar);
            obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture","0"));
            obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture","0"));
            obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture","0"));
            obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture","0"));
            obras.add(new Obra(R.drawable.obra1, "Rebecca Horn", "Flying Books Under Black  Rain Painting Sculpture","0"));
        } else if (andar.equals("1")) {
            toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle("First Level");
            setSupportActionBar(toolbar);

            obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table","1"));
            obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table","1"));
            obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table","1"));
            obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table","1"));
            obras.add(new Obra(R.drawable.obra2, "Rebrega Corn", "Flying Books On The Table","1"));

        }else if (andar.equals("2")) {
            toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle("Second Level");
            setSupportActionBar(toolbar);

            obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall","2"));
            obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall","2"));
            obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall","2"));
            obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall","2"));
            obras.add(new Obra(R.drawable.obra2, "Reboga Chorn", "Flying Cooks On The Wall","2"));
        } else if (andar.equals("3")) {
            toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle("Third Level");
            setSupportActionBar(toolbar);

            obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball","3"));
            obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball","3"));
            obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball","3"));
            obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball","3"));
            obras.add(new Obra(R.drawable.obra1, "Refoga Porn", "Flying Coollers On The Ball","3"));
        } else if (andar.equals("4")) {
            toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle("Fourth Level");
            setSupportActionBar(toolbar);

            obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call","4"));
            obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call","4"));
            obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call","4"));
            obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call","4"));
            obras.add(new Obra(R.drawable.obra2, "Retrata Born", "Changing Roads On The Call","4"));
        } else if (andar.equals("5")) {
            toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle("Fifth Level");
            setSupportActionBar(toolbar);

            obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose","5"));
            obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose","5"));
            obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose","5"));
            obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose","5"));
            obras.add(new Obra(R.drawable.obra2, "Relax Worn", "Relaxing And Goose","5"));
        }

        return obras;
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
