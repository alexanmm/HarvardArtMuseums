package br.com.digitalhouse.harvardartmuseums.home.galeria.view;

import android.content.Intent;
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
import br.com.digitalhouse.harvardartmuseums.game.GameControlsActivity;
import br.com.digitalhouse.harvardartmuseums.help.HelpActivity;
import br.com.digitalhouse.harvardartmuseums.home.galeria.adapter.RecyclerViewGaleriaAdapter;
import br.com.digitalhouse.harvardartmuseums.home.galeria.model.Obra;
import br.com.digitalhouse.harvardartmuseums.settings.SettingActivity;

public class GaleriaActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerViewGaleriaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Lower Level");
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerViewGaleria);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewGaleriaAdapter(listaObrasLowerLevel());
        recyclerView.setAdapter(adapter);
    }

    private List<Obra> listaObrasLowerLevel(){
        List<Obra> obras = new ArrayList<>();
        obras.add(new Obra(R.drawable.obra1,"Rebecca Horn","Flying Books Under Black  Rain Painting Sculpture"));
        obras.add(new Obra(R.drawable.obra1,"Rebecca Horn","Flying Books Under Black  Rain Painting Sculpture"));
        obras.add(new Obra(R.drawable.obra1,"Rebecca Horn","Flying Books Under Black  Rain Painting Sculpture"));
        obras.add(new Obra(R.drawable.obra1,"Rebecca Horn","Flying Books Under Black  Rain Painting Sculpture"));
        obras.add(new Obra(R.drawable.obra1,"Rebecca Horn","Flying Books Under Black  Rain Painting Sculpture"));

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
        if (id == R.id.action_help) {
            Intent intent = new Intent(GaleriaActivity.this, HelpActivity.class);
            startActivity(intent);
        }

        if (id == R.id.action_settings) {
            Intent intent = new Intent(GaleriaActivity.this, SettingActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
