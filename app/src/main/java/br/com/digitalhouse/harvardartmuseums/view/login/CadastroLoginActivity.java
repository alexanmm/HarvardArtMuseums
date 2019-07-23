package br.com.digitalhouse.harvardartmuseums.view.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.view.base.BaseActivity;

public class CadastroLoginActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextRepeatPassword;
    private Button buttonCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_login);

        initObjects();
        initToolbar();

        //Valida dados ao clicar no botão para cadastrar usuário e efetuar login
        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Login User
                if (validaDadosCadastroLogin()){

                    // ->>>> Incluir neste ponto a gravação do usuario no banco de dados

                    Toast.makeText( v.getContext(),
                            "Registered user successfully, login in progress...",
                            Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(CadastroLoginActivity.this, BaseActivity.class);
                    startActivity(intent);
                    // ->>>> Incluir neste ponto a chamada da BaseActivity (Tela de Galeria)

                }

            }
        });

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("New account");
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

    private void initObjects() {

        //Inicializa Objetos
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextRepeatPassword = findViewById(R.id.editTextRepeatPassword);
        buttonCreateAccount = findViewById(R.id.buttonCreateAccount);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean validaDadosCadastroLogin() {

        String textName = editTextName.getText().toString();
        String textLastName = editTextLastName.getText().toString();
        String textEmail = editTextEmail.getText().toString();
        String textPassword = editTextPassword.getText().toString();
        String textRepeatPassword = editTextRepeatPassword.getText().toString();
        int minimalPassLen = 6;

        //Validate Name field
        if (textName.isEmpty()){
            editTextName.setError("Name is mandatory");
            return false;
        }

        //Validate Last Name field
        if (textLastName.isEmpty()){
            editTextLastName.setError("Last Name is mandatory");
            return false;
        }

        //Validate Email field
        if (textEmail.isEmpty()){
            editTextEmail.setError("Email is mandatory");
            return false;
        }

        //Validate Password field
        if (textPassword.isEmpty()){
            editTextPassword.setError("Password is mandatory");
            return false;
        }

        if (textPassword.length() < minimalPassLen){
            editTextPassword.setError("Enter password with 6 or more characters");
            return false;
        }

        //Validate Repeat Password field
        if (textRepeatPassword.isEmpty()){
            editTextRepeatPassword.setError("Repeat Password is mandatory");
            return false;
        }

        //Password and Repeat Password fields can not be different
        if (! textPassword.equals(textRepeatPassword)){
            editTextRepeatPassword.setError("The Password can not be different");
            return false;
        }

        return true;

    }

    //Este método é chamado no momento em que pressionamos a seta de voltar da toolbar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); //Este método é o mesmo chamado no momento que apertamos o back na parte debaixo do celular...
        return true;
    }

}
