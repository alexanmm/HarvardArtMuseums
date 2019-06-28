package br.com.digitalhouse.harvardartmuseums.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.com.digitalhouse.harvardartmuseums.R;
import br.com.digitalhouse.harvardartmuseums.home.galeria.view.GaleriaActivity;

public class SplashActivityLevel extends AppCompatActivity {


    Timer myTimer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_level);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Floor Plan");
        //Seleciona dinamicamente a imagem do splash conforme o andar selecionado na tela da HOME
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String andar = bundle.getString("ANDAR");

        ImageView imageView = findViewById(R.id.imageViewAndar);


        if (andar.equals("0")){
            imageView.setImageResource(R.drawable.splash_lower_level);
        } else if (andar.equals("1")){
            imageView.setImageResource(R.drawable.splash_first_level);
        } else if (andar.equals("2")){
            imageView.setImageResource(R.drawable.splash_second_level);
        } else if (andar.equals("3")){
            imageView.setImageResource(R.drawable.splash_third_level);
        } else if (andar.equals("4")){
            imageView.setImageResource(R.drawable.splash_fourth_level);
        } else if (andar.equals("5")){
            imageView.setImageResource(R.drawable.splash_fifth_level);
        }


        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent2 = new Intent(SplashActivityLevel.this, GaleriaActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("ANDARS", andar);
                intent2.putExtras(bundle2);
                startActivity(intent2);

            }
        };

        myTimer.schedule(myTask, 3000);
    }
}
