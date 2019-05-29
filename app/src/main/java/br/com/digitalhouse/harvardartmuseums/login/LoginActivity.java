package br.com.digitalhouse.harvardartmuseums.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.splash.SplashActivity;

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignIn;
    private TextView textViewCreateAccount;
    private ImageView imageViewFacebook;
    private ImageView imageViewGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initObjects();
        initToolbar();

        //Valida dados ao clicar no botão para Login
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Login User
                if (validaDadosLogin()) {

                    // ->>>> Incluir neste ponto a busca dos dados do usuário nno banco de dados

                    Toast.makeText(v.getContext(),
                            "Login in progress...",
                            Toast.LENGTH_LONG).show();

                    // ->>>> Incluir neste ponto a chamada da MainActivity (Tela de Galeria)

                }
            }
        });


        //Chama a tela de cadastro do usuário
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, CadastroLoginActivity.class);
                startActivity(intent);
            }
        });

        //Login pelo Facebook
        imageViewFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ->>>> Incluir neste ponto a chamada da Tela de login do Facebook

            }
        });

        //Login pelo Google
        imageViewGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ->>>> Incluir neste ponto a chamada da Tela de login do Google

            }
        });
    }

    private void initToolbar() {

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Login");
        setSupportActionBar(toolbar);

    }

    private void initObjects() {

        //Inicializa Objetos
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewCreateAccount = findViewById(R.id.textViewCreateAccount);
        imageViewFacebook = findViewById(R.id.imageViewFaceBook);
        imageViewGoogle = findViewById(R.id.imageViewGoogle);
        buttonSignIn = findViewById(R.id.buttonSignIn);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean validaDadosLogin() {

        String textEmail = editTextEmail.getText().toString();
        String textPassword = editTextPassword.getText().toString();

        //Validate Email field
        if (textEmail.isEmpty()) {
            editTextEmail.setError("Email is mandatory");
            return false;
        }

        //Validate Password field
        if (textPassword.isEmpty()) {
            editTextPassword.setError("Password is mandatory");
            return false;
        }

        return true;
    }
}
