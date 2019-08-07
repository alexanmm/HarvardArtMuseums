package br.com.digitalhouse.harvardartmuseums.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.model.userdata.UserData;
import br.com.digitalhouse.harvardartmuseums.view.base.BaseActivity;

public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 14;
    private static final String TAG = "login";
    private FirebaseAuth firebaseAuth;
    private GoogleSignInClient mGoogleSignInClient;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignIn;
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

                    firebaseAuth = FirebaseAuth.getInstance(); //Autenticação

                    Toast.makeText(v.getContext(),
                            "Login in progress...",
                            Toast.LENGTH_SHORT).show();

                    //Login do usuario
                    firebaseAuth.signInWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) { //Retorna true se o usuario for logado
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = firebaseAuth.getCurrentUser();
                                        updateUI(user);

                                        //Chamada da BaseActivity (Tela de Galeria)
                                        Intent intent = new Intent(LoginActivity.this, BaseActivity.class);
                                        startActivity(intent);

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(v.getContext(),
                                                "Authentication failed: " + task.getException(),
                                                Toast.LENGTH_SHORT).show();

                                        updateUI(null);
                                    }
                                }
                            });
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

                signIn();

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void initObjects() {

        //Inicializa Objetos
        firebaseAuth = FirebaseAuth.getInstance(); //Autenticação

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

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

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);

        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            //updateUI(account);

            //Chamada da BaseActivity (Tela de Galeria)
            Intent intent = new Intent(LoginActivity.this, BaseActivity.class);
            startActivity(intent);


        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d(TAG, "Authentication failed: " + e.getStatusCode());

            updateUI(null);
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        //Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithCredential:failure", task.getException());
                            //Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void updateUI(FirebaseUser user) {

        UserData userData = new UserData();
        userData.setUser(user);

        userData.inicializaDados();
    }
}
