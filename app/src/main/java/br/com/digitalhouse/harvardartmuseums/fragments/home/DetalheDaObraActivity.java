package br.com.digitalhouse.harvardartmuseums.fragments.home;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.fragments.events.EventFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.favorite.FavoriteFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.home.galeria.fragmentos.IdentificationFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.game.GameMainActivity;
import br.com.digitalhouse.harvardartmuseums.fragments.information.InfoFragment;
import br.com.digitalhouse.harvardartmuseums.view.help.HelpActivity;
import br.com.digitalhouse.harvardartmuseums.fragments.home.galeria.adapter.ViewPageAdapter;
import br.com.digitalhouse.harvardartmuseums.fragments.home.galeria.fragmentos.DescriptionsFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.home.galeria.fragmentos.HistoryFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.home.galeria.fragmentos.ObraFragment;
import br.com.digitalhouse.harvardartmuseums.view.login.LoginActivity;
import br.com.digitalhouse.harvardartmuseums.view.settings.SettingsActivity;

public class DetalheDaObraActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager vpConteudo;
    private ViewPageAdapter adapter;
    private ArrayList<Fragment> arrayFragmentos;
    private ArrayList<String> arrayTitulos;
    private BottomNavigationView navigationView;
    private Toolbar toolbar;
    int idObra = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_da_obra);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Level");
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        //Seleciona dinamicamente a obra e seus detalhes conforme o andar
        String andar = null;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            int idObra = bundle.getInt("OBRA");
            andar = bundle.getString("ANDAR");
        } else {
            toolbar.setTitle("Lower Level");
            setSupportActionBar(toolbar);
        }

        if(andar.equals("0")){
            toolbar.setTitle("Lower Level");
            setSupportActionBar(toolbar);
        } else if(andar.equals("1")){
            toolbar.setTitle("First Level");
            setSupportActionBar(toolbar);
        } else if(andar.equals("2")){
            toolbar.setTitle("Second Level");
            setSupportActionBar(toolbar);
        } else if(andar.equals("3")){
            toolbar.setTitle("Third Level");
            setSupportActionBar(toolbar);
        } else if(andar.equals("4")){
            toolbar.setTitle("Fourth Level");
            setSupportActionBar(toolbar);
        }else if(andar.equals("5")){
            toolbar.setTitle("Fifth Level");
            setSupportActionBar(toolbar);
        }

        //Parte superior da Activity
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerObra,new ObraFragment()) ;
        transaction.commit();

        //Parte inferior da Activity
        CarregarFragmentos();
        CarregarTitulos();
        viewPagerComTabLayout();


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
            Intent intent = new Intent(this, SettingsActivity.class);
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
                Intent intent = new Intent(this, InfoFragment.class);
                startActivity(intent);
                return true;
            }
            case R.id.navigation_events: {
                Intent intent = new Intent(this, EventFragment.class);
                startActivity(intent);
                return true;
            }
            case R.id.navigation_favorites: {
                Intent intent = new Intent(this, FavoriteFragment.class);
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


    private void CarregarFragmentos() {
        arrayFragmentos = new ArrayList<>();
        arrayFragmentos.add(new IdentificationFragment());
        arrayFragmentos.add(new DescriptionsFragment());
        arrayFragmentos.add(new HistoryFragment());
    }

    private void CarregarTitulos() {
        arrayTitulos = new ArrayList<>();
        arrayTitulos.add("Identification");
        arrayTitulos.add("Descriptions");
        arrayTitulos.add("History");
    }

    private void viewPagerComTabLayout() {
        TabLayout tabLayout = findViewById(R.id.tlTab);
        ViewPager vpConteudo = findViewById(R.id.vpConteudo);
        adapter = new ViewPageAdapter(getSupportFragmentManager(), arrayFragmentos, arrayTitulos);
        vpConteudo.setAdapter(adapter);
        tabLayout.setupWithViewPager(vpConteudo);
    }

}

