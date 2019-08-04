package br.com.digitalhouse.harvardartmuseums.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.view.base.BaseActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    public Button buttonSignIn;
    private TextView textViewCreateAccount;
    private ImageView imageViewGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initObjects();

        //Valida dados ao clicar no botão para Login
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Login User
                if (validaDadosLogin()) {

                    // ->>>> Incluir neste ponto a busca dos dados do usuário no banco de dados

                    Toast.makeText(v.getContext(),
                            "Login in progress...",
                            Toast.LENGTH_SHORT).show();

                    //Chamada da BaseActivity (Tela de Galeria)
                    Intent intent = new Intent(LoginActivity.this, BaseActivity.class);
                    startActivity(intent);

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

        //Login pelo Google
        imageViewGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ->>>> Incluir neste ponto a chamada da Tela de login do Google

            }
        });
    }

    private void initObjects() {
        //Inicializa Objetos
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewCreateAccount = findViewById(R.id.textViewCreateAccount);
        imageViewGoogle = findViewById(R.id.imageViewGoogle);
        buttonSignIn = findViewById(R.id.buttonSignIn);
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
