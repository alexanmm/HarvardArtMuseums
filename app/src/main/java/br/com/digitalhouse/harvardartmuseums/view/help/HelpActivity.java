package br.com.digitalhouse.harvardartmuseums.view.help;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.Objects;

import br.com.digitalhouse.harvardartmuseums.R;

public class HelpActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Help");
        setSupportActionBar(toolbar);

        //Adiciona a seta de voltar na toolbar
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
            }
        }catch (Exception e){
            e.printStackTrace();

        }

    }

    //Este método é chamado no momento em que pressionamos a seta de voltar da toolbar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); //Este método é o mesmo chamado no momento que apertamos o back na parte debaixo do celular...
        return true;
    }
}
