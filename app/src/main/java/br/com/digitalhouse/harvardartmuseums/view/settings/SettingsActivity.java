package br.com.digitalhouse.harvardartmuseums.view.settings;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.model.userdata.UserData;

public class SettingsActivity extends AppCompatActivity {

    UserData userData = new UserData();

    private Spinner spinnerSettingsLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Settings");
        setSupportActionBar(toolbar);

        //Adiciona a seta de voltar na toolbar
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        //Inicializa Views
        initViews();

        //Inicializa com o idioma padrão do usuário
        if (userData.getLanguage() != null) {
            spinnerSettingsLanguage.setSelection(userData.getLanguage().getIdIdioma());
        }

        //Ao mudar o idioma, atualiza dados do usuário
        spinnerSettingsLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String[] listaIdiomas = getResources().getStringArray(R.array.arrayLanguages);

                userData.gravaIdiomaUsuario(position, listaIdiomas[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    //Este método é chamado no momento em que pressionamos a seta de voltar da toolbar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); //Este método é o mesmo chamado no momento que apertamos o back na parte debaixo do celular...
        return true;
    }

    //Inicializa Views
    public void initViews() {

        spinnerSettingsLanguage = findViewById(R.id.spinnerSettingsLanguage);

    }
}


