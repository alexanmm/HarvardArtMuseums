package br.com.digitalhouse.harvardartmuseums.fragments.game;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.os.Handler;
import android.text.style.IconMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.digitalhouse.harvardartmuseums.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GamePlayFragment extends Fragment {

    private TextView textViewTopMessageChoose;
    private ImageView imageViewTopMessage;
    private ImageView imageViewGamePlayCard1;
    private ImageView imageViewGamePlayCard2;
    private ImageView imageViewGamePlayCard3;
    private ImageView imageViewGamePlayCard4;
    private ImageView imageViewGamePlayCard5;
    private ImageView imageViewGamePlayCard6;
    private ImageView imageViewGamePlayCard7;
    private ImageView imageViewGamePlayCard8;
    private ImageView imageViewGamePlayCard9;
    private ImageView imageViewGamePlayCard10;
    private ImageView imageViewGamePlayCard11;
    private ImageView imageViewGamePlayCard12;
    private TextView textViewTopMessagePointsLabel;
    private TextView textViewTopMessageTimeLabel;
    private LinearLayout containerGame;
    private Button buttonGamePlayAgain;

    private List<String> listaCartas = new ArrayList<>();
    private List<String> statusCartas = new ArrayList<>();

    private final String CARTA_FRENTE = "F";
    private final String CARTA_VERSO = "V";
    private final String CARTA_INATIVA = "I";

    private int numeroCartaAnterior;
    private int contadorAcertos;
    private int contadorPontos;
    private int tempoRestante;
    private int tempoLimite = 30; //Inicia com 30 segundos
    private int gameLevel = 1;

    private CountDownTimer countDownTimer;

    private final String IMAGE_CARTA_VERSO = ":drawable/image_game_verso";

    public GamePlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game_play, container, false);

        //Inicializa Views
        initViews(view);

        textViewTopMessageChoose.setText("Let's go!!! \nChoose a picture to start...");
        imageViewTopMessage.setImageDrawable(getResources().getDrawable(R.drawable.personagem06));

        buttonGamePlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Contador de tempo
                tempoRestante = tempoLimite; //30 Segundos

                //Inicializa o Game
                playGame();

                countDownTimer = new CountDownTimer(tempoLimite * 1000, 1000) {
                    public void onTick(long millisUntilFinished) {

                        textViewTopMessageTimeLabel.setText("Time to last: " + tempoRestante + "s");

                        if (tempoRestante <= tempoLimite / 4) {
                            textViewTopMessageChoose.setText("Oh, no!!!");
                        }

                        tempoRestante--;
                    }

                    public void onFinish() {
                        textViewTopMessageChoose.setText("Ops, Time out! \nLet's play again?");

                        textViewTopMessagePointsLabel.setText("Points: " + contadorPontos + " stars (Level " + gameLevel + ")" );

                        //Zera o nível e pontos do usuário
                        gameLevel = 1;
                        contadorPontos = 0;
                        contadorAcertos = 0;
                        tempoRestante = 0;

                        //Inicializa o tempo padrão para o nível 1
                        tempoLimite = 30;
                    }
                }.start();

            }
        });

        imageViewGamePlayCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard1, 1);
            }
        });

        imageViewGamePlayCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard2, 2);
            }
        });

        imageViewGamePlayCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard3, 3);
            }
        });

        imageViewGamePlayCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard4, 4);
            }
        });

        imageViewGamePlayCard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard5, 5);
            }
        });

        imageViewGamePlayCard6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard6, 6);
            }
        });

        imageViewGamePlayCard7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard7, 7);
            }
        });

        imageViewGamePlayCard8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard8, 8);
            }
        });

        imageViewGamePlayCard9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard9, 9);
            }
        });

        imageViewGamePlayCard10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard10, 10);
            }
        });

        imageViewGamePlayCard11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard11, 11);
            }
        });

        imageViewGamePlayCard12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viraCarta(imageViewGamePlayCard12, 12);
            }
        });

        return view;
    }

    public void initViews(View view) {

        textViewTopMessageChoose = view.findViewById(R.id.textViewTopMessageChoose);
        imageViewTopMessage = view.findViewById(R.id.imageViewTopMessage);

        imageViewGamePlayCard1 = view.findViewById(R.id.imageViewGamePlayCard1);
        imageViewGamePlayCard2 = view.findViewById(R.id.imageViewGamePlayCard2);
        imageViewGamePlayCard3 = view.findViewById(R.id.imageViewGamePlayCard3);
        imageViewGamePlayCard4 = view.findViewById(R.id.imageViewGamePlayCard4);
        imageViewGamePlayCard5 = view.findViewById(R.id.imageViewGamePlayCard5);
        imageViewGamePlayCard6 = view.findViewById(R.id.imageViewGamePlayCard6);
        imageViewGamePlayCard7 = view.findViewById(R.id.imageViewGamePlayCard7);
        imageViewGamePlayCard8 = view.findViewById(R.id.imageViewGamePlayCard8);
        imageViewGamePlayCard9 = view.findViewById(R.id.imageViewGamePlayCard9);
        imageViewGamePlayCard10 = view.findViewById(R.id.imageViewGamePlayCard10);
        imageViewGamePlayCard11 = view.findViewById(R.id.imageViewGamePlayCard11);
        imageViewGamePlayCard12 = view.findViewById(R.id.imageViewGamePlayCard12);

        //Habilita opções adicionais da tela
        textViewTopMessagePointsLabel = view.findViewById(R.id.textViewTopMessagePointsLabel);
        textViewTopMessageTimeLabel = view.findViewById(R.id.textViewTopMessageTimeLabel);
        containerGame = view.findViewById(R.id.containerGame);

        buttonGamePlayAgain = view.findViewById(R.id.buttonGamePlayAgain);

        containerGame.setVisibility(View.VISIBLE);
    }

    public void playGame() {

        //Preencher as imagens dinamicamente
        Random randomico = new Random();
        List<String> imageList = new ArrayList<>();

        //Prepara a lista de imagens de 1 a 6 e o par até completar 12 cartas
        for (int cont = 1; cont <= 6; cont++) {
            imageList.add(":drawable/card_image_0" + cont);
            imageList.add(":drawable/card_image_0" + cont);
        }

        //Limpa a lista de cartas
        listaCartas.clear();
        statusCartas.clear();

        while (imageList.size() > 0) {
            int numeroAleatorio = 0;

            //Randomico de 0 a 11 inteiros, total de 12 cartas
            //A ultima imagem é a que sobrou na lista, posição 0
            if (imageList.size() != 1) {
                numeroAleatorio = randomico.nextInt(imageList.size() - 1);
            }

            String imageFound = imageList.get(numeroAleatorio).toString();

            if (!imageFound.equals("")) {
                //Remove o item escolhido da lista
                imageList.remove(numeroAleatorio);

                listaCartas.add(imageFound);
                statusCartas.add(CARTA_VERSO);
            }
        }

        //Vira todas as cartas novamente
        atualizaCartas();
    }

    public void trataCarta(ImageView imageView, String imageFound) {

        imageView.setImageResource(this.getResources().getIdentifier(
                getActivity().getPackageName() + imageFound, null, null));

        if (imageFound.equals(IMAGE_CARTA_VERSO)) { //Verso da carta
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else { //Frente da carta
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }

    }

    public void viraCarta(ImageView imageView, int numeroCarta) {

        //Somente permite virar as cartas se o jogo estiver em andamento
        if (listaCartas.size() != 12){
            textViewTopMessageChoose.setText("Please, click in 'Play' to start the game");

            return;
        }

        //Não permite virar as cartas após o término do tempo
        if (tempoRestante <= 0){
            textViewTopMessageChoose.setText("The game is over. \nPlease, click in 'Play' to start the game");

            return;
        }

        if (statusCartas.get(numeroCarta - 1).equals(CARTA_VERSO)) { //Vira Frente
            statusCartas.set(numeroCarta - 1, CARTA_FRENTE);
            trataCarta(imageView, listaCartas.get(numeroCarta - 1));

            if (numeroCartaAnterior > 0 && statusCartas.get(numeroCartaAnterior - 1).equals(CARTA_FRENTE)) { //Frente
                //Veririca se as cartas são iguais
                if (listaCartas.get(numeroCartaAnterior - 1).equals(listaCartas.get(numeroCarta - 1))) {
                    textViewTopMessageChoose.setText("Excellent!");

                    statusCartas.set(numeroCartaAnterior - 1, CARTA_INATIVA);
                    statusCartas.set(numeroCarta - 1, CARTA_INATIVA);

                    //Atualiza pontuação
                    contadorAcertos++;
                    contadorPontos = contadorPontos + contadorAcertos * tempoRestante * gameLevel;
                    textViewTopMessagePointsLabel.setText("Points: " + contadorPontos + " stars (Level " + gameLevel + ")" );

                    //Fim de jogo
                    if (contadorAcertos == 6) {
                        countDownTimer.cancel(); //Encerra o tempo

                        textViewTopMessageChoose.setText("Yes... you won! \nLet's play again?");

                        //Aumenta o nível de dificuldade
                        gameLevel++;
                        contadorAcertos = 0;

                        if (tempoLimite > 0){
                            tempoLimite--;
                        }
                    }

                    //Cartas diferentes
                } else {
                    statusCartas.set(numeroCartaAnterior - 1, CARTA_VERSO);
                    statusCartas.set(numeroCarta - 1, CARTA_VERSO);

                    textViewTopMessageChoose.setText("You missed. \nTry another card.");

                    //Atualiza pontuação
                    contadorPontos = contadorPontos - 5;
                    textViewTopMessagePointsLabel.setText("Points: " + contadorPontos + " stars (Level " + gameLevel + ")" );

                    numeroCarta = 0;

                    //Aguarda 1 segundo para virar as cartas incorretas
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            atualizaCartas();
                        }
                    }, 500); //Intervalo de 1 segundo
                }
            }

            numeroCartaAnterior = numeroCarta;
        }
    }

    public void atualizaCartas() {

        for (int cont = 0; cont < 12; cont++) {

            //Vira todas as cartas
            if (statusCartas.get(cont).equals(CARTA_VERSO)) {
                switch (cont + 1) {
                    case 1:
                        trataCarta(imageViewGamePlayCard1, IMAGE_CARTA_VERSO);
                        break; // Encerrar a condicao, pois já foi satisfatoria

                    case 2:
                        trataCarta(imageViewGamePlayCard2, IMAGE_CARTA_VERSO);
                        break;

                    case 3:
                        trataCarta(imageViewGamePlayCard3, IMAGE_CARTA_VERSO);
                        break;

                    case 4:
                        trataCarta(imageViewGamePlayCard4, IMAGE_CARTA_VERSO);
                        break;

                    case 5:
                        trataCarta(imageViewGamePlayCard5, IMAGE_CARTA_VERSO);
                        break;

                    case 6:
                        trataCarta(imageViewGamePlayCard6, IMAGE_CARTA_VERSO);
                        break;

                    case 7:
                        trataCarta(imageViewGamePlayCard7, IMAGE_CARTA_VERSO);
                        break;

                    case 8:
                        trataCarta(imageViewGamePlayCard8, IMAGE_CARTA_VERSO);
                        break;

                    case 9:
                        trataCarta(imageViewGamePlayCard9, IMAGE_CARTA_VERSO);
                        break;

                    case 10:
                        trataCarta(imageViewGamePlayCard10, IMAGE_CARTA_VERSO);
                        break;

                    case 11:
                        trataCarta(imageViewGamePlayCard11, IMAGE_CARTA_VERSO);
                        break;

                    case 12:
                        trataCarta(imageViewGamePlayCard12, IMAGE_CARTA_VERSO);
                        break;

                    //Outros
                    default:
                        //Trata outros resultados
                }

            }
        }
    }
}
