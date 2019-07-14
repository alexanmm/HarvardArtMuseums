package br.com.digitalhouse.harvardartmuseums.fragments.game;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.view.help.HelpActivity;
import br.com.digitalhouse.harvardartmuseums.view.settings.SettingsActivity;

public class GameMainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imageViewPlay;
    private ImageView imageViewControls;
    private ImageView imageViewLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Art memories");
        setSupportActionBar(toolbar);

        //Inicialização da view ref. ao inicio do jogo (play) e Inserção de ação para mudar para a activity do jogo
        imageViewPlay = findViewById(R.id.imageViewPlay);

        imageViewPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameMainActivity.this,GamePlay1Activity.class);
                startActivity(intent);
            }
        });

        //Inicialização da view ref. aos controles do jogo (controls) e Inserção de ação para mudar para a activity dos controles
        imageViewControls = findViewById(R.id.imageViewControls);

        imageViewControls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameMainActivity.this,GameControlsActivity.class);
                startActivity(intent);
            }
        });

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
        if (id == R.id.action_help) {
            Intent intent = new Intent(GameMainActivity.this, HelpActivity.class);
            startActivity(intent);
        }

        if (id == R.id.action_settings) {
            Intent intent = new Intent(GameMainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}