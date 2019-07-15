package br.com.digitalhouse.harvardartmuseums.view.base;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.fragments.art.ArtDetailFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.events.EventFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.favorite.FavoriteFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.game.GameFragment;
import br.com.digitalhouse.harvardartmuseums.fragments.gallery.GalleryFragment;
import br.com.digitalhouse.harvardartmuseums.interfaces.Comunicator;
import br.com.digitalhouse.harvardartmuseums.model.Obra;
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
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new HomeFragment())
                .commit();
    }

    //Troca os fragmentos do container
    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack("FRAGMENTS")
                .commit();
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
                case R.id.navigation_events:
                    replaceFragment(new EventFragment());
                    toolbar.setTitle("Events");
                    return true;
                case R.id.navigation_favorites:
                    replaceFragment(new FavoriteFragment());
                    toolbar.setTitle("Favorites");
                    return true;
                case R.id.navigation_game:
                    replaceFragment(new GameFragment());
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
    public void sendArtToFragments(Obra obra) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("OBRA", obra);

        Fragment artDetailFragment = new ArtDetailFragment();
        artDetailFragment.setArguments(bundle);
        replaceFragment(artDetailFragment);
    }
}