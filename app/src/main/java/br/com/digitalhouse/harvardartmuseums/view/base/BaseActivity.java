package br.com.digitalhouse.harvardartmuseums.view.base;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuItem;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.fragments.art.ArtDetailFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.exhibition.ExhibitionFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.favorites.FavoritesFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.gallery.GalleryFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.game.GamePlayFragment;
import br.com.digitalhouse.harvardartmuseums.interfaces.Comunicator;
import br.com.digitalhouse.harvardartmuseums.model.object.Object;
import br.com.digitalhouse.harvardartmuseums.view.help.HelpActivity;
import br.com.digitalhouse.harvardartmuseums.fragments.home.HomeFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.information.InfoFragment;
import br.com.digitalhouse.harvardartmuseums.view.settings.SettingsActivity;
import br.com.digitalhouse.harvardartmuseums.view.login.LoginActivity;

public class BaseActivity extends AppCompatActivity implements Comunicator {

    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //Inicia a toolbar
        initToolbar();

        //Inicia o container com event fragment
        initFirstFragment();
    }

    private void initToolbar() {
        //Configura a ToolBar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Configura a BottomNavigationBar e seta o listener dos botões
        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    //Define o primeiro fragmento que será inflado no cointainer da BaseActivity
    private void initFirstFragment() {
        toolbar.setTitle("Home");

        replaceFragment(new HomeFragment());

/*
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new HomeFragment())
                .commit();
*/
    }

    //Troca os fragmentos do container
    public void replaceFragment(Fragment fragment) {

        try {

            String TAG = fragment.getClass().toString();
            String backStackName = fragment.getClass().getName();

            FragmentManager manager = getSupportFragmentManager();

            boolean fragmentPopped = manager.popBackStackImmediate(backStackName, 0);

            if (!fragmentPopped && getSupportFragmentManager().findFragmentByTag(TAG) == null) {
                final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, fragment, TAG);
                ft.addToBackStack(backStackName);
                ft.commit();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


/*

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack("FRAGMENTS")
                .commit();
*/
    }

    //Define as ações de cada botão do NavigationBar
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    toolbar.setTitle("Home");
                    return true;
                case R.id.navigation_information:
                    replaceFragment(new InfoFragment());
                    toolbar.setTitle("Informations");
                    return true;
                case R.id.navigation_exhibition:
                    replaceFragment(new ExhibitionFragment());
                    toolbar.setTitle("Exhibition");
                    return true;
                case R.id.navigation_favorites:
                    replaceFragment(new FavoritesFragment());
                    toolbar.setTitle("Favorites");
                    return true;
                case R.id.navigation_game:
                    replaceFragment(new GamePlayFragment());
                    toolbar.setTitle("Game");
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.action_settings:
                intent = new Intent(BaseActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_help:
                intent = new Intent(BaseActivity.this, HelpActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_logout:
                intent = new Intent(BaseActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void sendMessageToFragments(String message) {
        Bundle bundle = new Bundle();
        bundle.putString("MESSAGE", message);

        //Troca o título da Base Activity de acordo com o andar escolhido
        switch (message) {
            case "0":
                toolbar.setTitle("Lower Level");
                break;
            case "1":
                toolbar.setTitle("First Level");
                break;
            case "2":
                toolbar.setTitle("Second Level");
                break;
            case "3":
                toolbar.setTitle("Third Level");
                break;
            case "4":
                toolbar.setTitle("Fourth Level");
                break;
            case "5":
                toolbar.setTitle("Fifth Level");
                break;
        }

        Fragment galleryFragment = new GalleryFragment();
        galleryFragment.setArguments(bundle);
        replaceFragment(galleryFragment);

    }

    @Override
    public void sendArtToFragments(Object object) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("OBRA", object);

        Fragment artDetailFragment = new ArtDetailFragment();
        artDetailFragment.setArguments(bundle);

        //Adiciona o fragment detalhe para não sobregravar a lista de obras do fragment Home
        replaceFragment(artDetailFragment);

    }

    @Override
    public void sendGameToPlayFragments() {

        /*
        Fragment gamePlayFragment = new GamePlayFragment();

        replaceFragment(gamePlayFragment);
        */
    }
}