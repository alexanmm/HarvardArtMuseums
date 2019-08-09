package br.com.digitalhouse.harvardartmuseums.view.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import br.com.digitalhouse.harvardartmuseums.MainActivity;
import br.com.digitalhouse.harvardartmuseums.R;


public class LoginActivity extends AppCompatActivity {


    public static final String GOOGLE_ACCOUNT = "google_account";
    private EditText profileName;
    private EditText profileEmail;
    private ImageView profileImage;
    private Button signOut;
    private GoogleSignInClient googleSignInClient;

    public LoginActivity(EditText profileEmail) {
            }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        profileName = findViewById(R.id.editTextName);
        profileEmail = findViewById(R.id.editTextEmail);
        profileImage = findViewById(R.id.profile_image);
        signOut = findViewById (R.id.action_logout);



        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()//request email id
                .build();

        googleSignInClient= GoogleSignIn.getClient(this, gso);
        setDataOnView();


        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
            }
        });

    }

    private void setDataOnView() {
        GoogleSignInAccount googleSignInAccount = getIntent().getParcelableExtra(GOOGLE_ACCOUNT);
        Picasso.get().load(googleSignInAccount.getPhotoUrl()).centerInside().fit().into(profileImage);
        profileName.setText(googleSignInAccount.getDisplayName());
        profileEmail.setText(googleSignInAccount.getEmail());
    }
}
