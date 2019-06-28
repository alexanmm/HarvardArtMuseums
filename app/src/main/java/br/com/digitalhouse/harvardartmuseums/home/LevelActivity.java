package br.com.digitalhouse.harvardartmuseums.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.events.EventsActivity;
import br.com.digitalhouse.harvardartmuseums.favs.FavsActivity;
import br.com.digitalhouse.harvardartmuseums.game.GameMainActivity;
import br.com.digitalhouse.harvardartmuseums.information.InformationActivity;


public class LevelActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;

    int i = 0;
    ImageView estrela_alterada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_level);
        overridePendingTransition(R.anim.activity_filho_entrando, R.anim.activity_pai_saindo);
        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        final ImageView estrela = findViewById(R.id.estrela1);
        final ImageView estrela2 = findViewById(R.id.estrela2);
        final ImageView estrela3 = findViewById(R.id.estrela3);
        final ImageView estrela4 = findViewById(R.id.estrela4);
        final ImageView estrela5 = findViewById(R.id.estrela5);


        estrela.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MudaEstrela(estrela);
            }
        });

        estrela2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MudaEstrela(estrela2);

            }
        });
        estrela3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MudaEstrela(estrela3);

            }
        });
        estrela4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MudaEstrela(estrela4);

            }
        });
        estrela5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MudaEstrela(estrela5);

            }
        });


    }

    private void MudaEstrela(ImageView estrela_atual) {

        int[] imagensIds = {
                R.drawable.star,
                R.drawable.star2
        };


        if (i == 0) {
            i = 1;
        } else {
            i = 0;
        }

        estrela_atual.setImageResource(imagensIds[i]);
        estrela_alterada = estrela_atual;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings){
            Toast.makeText(this,"action_settings", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.action_help){
            Toast.makeText(this,"action_help", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.action_logout){
            Toast.makeText(this,"action_logout", Toast.LENGTH_SHORT).show();
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
