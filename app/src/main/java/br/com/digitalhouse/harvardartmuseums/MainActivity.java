package br.com.digitalhouse.harvardartmuseums;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.com.digitalhouse.harvardartmuseums.view.login.CadastroLoginActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCreateaccount = (Button) findViewById(R.id.buttonCreateAccount);
            buttonCreateaccount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, CadastroLoginActivity.class));
                }
            });

            Button buttonSignIn =(Button) findViewById(R.id.buttonSignIn);
            buttonSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }



            });
    }

    }



