package br.com.digitalhouse.harvardartmuseums.view.login;

import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.model.userdata.UserData;
import br.com.digitalhouse.harvardartmuseums.view.base.BaseActivity;

public class CadastroLoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

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
                if (validaDadosCadastroLogin()) {


                    //Cadastro do usuario
                    firebaseAuth.createUserWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString())
                            .addOnCompleteListener(CadastroLoginActivity.this, new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) { //Retorna true se o usuario for criado

                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = firebaseAuth.getCurrentUser();
                                        updateUI(user);

                                        Toast.makeText(v.getContext(),
                                                "Registered user successfully, login in progress...",
                                                Toast.LENGTH_LONG).show();

                                        Intent intent = new Intent(CadastroLoginActivity.this, BaseActivity.class);
                                        startActivity(intent);

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(v.getContext(),
                                                "Authentication failed: " + task.getException(),
                                                Toast.LENGTH_LONG).show();

                                        updateUI(null);
                                    }
                                }
                            });
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
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    private void initObjects() {

        //Inicializa Objetos
        firebaseAuth = FirebaseAuth.getInstance(); //Autenticação

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
        if (textName.isEmpty()) {
            editTextName.setError("Name is mandatory");
            return false;
        }

        //Validate Last Name field
        if (textLastName.isEmpty()) {
            editTextLastName.setError("Last Name is mandatory");
            return false;
        }

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

        if (textPassword.length() < minimalPassLen) {
            editTextPassword.setError("Enter password with 6 or more characters");
            return false;
        }

        //Validate Repeat Password field
        if (textRepeatPassword.isEmpty()) {
            editTextRepeatPassword.setError("Repeat Password is mandatory");
            return false;
        }

        //Password and Repeat Password fields can not be different
        if (!textPassword.equals(textRepeatPassword)) {
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

    private void updateUI(FirebaseUser user) {

        UserData userData = new UserData();
        userData.setUser(user);

        userData.inicializaDados();
    }
}
