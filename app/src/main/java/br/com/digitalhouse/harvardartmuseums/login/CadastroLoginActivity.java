package br.com.digitalhouse.harvardartmuseums.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.digitalhouse.harvardartmuseums.R;

public class CadastroLoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
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

                    // ->>>> Incluir neste ponto a chamada da MainActivity (Tela de Galeria)

                }

            }
        });

    }

    private void initToolbar() {

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("New account");
        setSupportActionBar(toolbar);

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

}
