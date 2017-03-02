package com.example.andrew.ark9studios;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends Activity {


    ImageView deck,card1,card2,card3,card4,card5,card6;

    ArrayList<Integer> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        setContentView(R.layout.main_menu);


        deck = (ImageView) findViewById(R.id.deck);
        card1 = (ImageView) findViewById(R.id.card1);
        card2 = (ImageView) findViewById(R.id.card2);
        card3 = (ImageView) findViewById(R.id.card3);
        card4 = (ImageView) findViewById(R.id.card4);
        card5 = (ImageView) findViewById(R.id.card5);
        card6 = (ImageView) findViewById(R.id.card6);

        card1.setVisibility(View.INVISIBLE);
        card2.setVisibility(View.INVISIBLE);
        card3.setVisibility(View.INVISIBLE);
        card4.setVisibility(View.INVISIBLE);
        card5.setVisibility(View.INVISIBLE);
        card6.setVisibility(View.INVISIBLE);

        cards = new ArrayList<>();

        cards.add(1); //demo_card
        cards.add(2); //
        cards.add(3); //
        cards.add(4); //
        cards.add(5); //
        cards.add(6);
        cards.add(7);

        deck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //shuffle the cards
                Collections.shuffle(cards);

                //deal the first 6 cards
                assignImages(cards.get(0),card1);
                assignImages(cards.get(0),card2);
                assignImages(cards.get(0),card3);
                assignImages(cards.get(0),card4);
                assignImages(cards.get(0),card5);
                assignImages(cards.get(0),card6);

                card1.setVisibility(View.VISIBLE);
                card2.setVisibility(View.VISIBLE);
                card3.setVisibility(View.VISIBLE);
                card4.setVisibility(View.VISIBLE);
                card5.setVisibility(View.VISIBLE);
                card6.setVisibility(View.VISIBLE);

                Toast.makeText(MainActivity.this, "Cards dealt!", Toast.LENGTH_SHORT).show();





            }
        });

    }

        public void assignImages(int card, ImageView image) {
            switch(card) {
                case 1:
                    image.setImageResource(R.drawable.Card1);
                    break;

                case 2:
                    image.setImageResource(R.drawable.Card2);
                    break;

                case 3:
                    image.setImageResource(R.drawable.Card3);
                    break;

                case 4:
                    image.setImageResource(R.drawable.Card4);
                    break;

                case 5:
                    image.setImageResource(R.drawable.Card6);
                    break;

                case 6:
                    image.setImageResource(R.drawable.Card6);
                    break;

                case 7:
                    image.setImageResource(R.drawable.Card7);
                    break;


            }

            }
    }


