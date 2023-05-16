package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player=1;
    int [][] winingstate={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gamestate={9,9,9,9,9,9,9,9,9};
    int winer=0;
    int imageclicked=-1;
    int i;
    public void load(View view){
        ImageView v=(ImageView) view;
        int tag =Integer.parseInt(v.getTag().toString());
        imageclicked=gamestate[tag];
        if(winer==0&&imageclicked==9) {
            if (player==1) {
                v.setImageResource(R.drawable.cross);
                Toast.makeText( this,  tag + "" + "cross", Toast.LENGTH_SHORT).show();
                gamestate[tag]=player;
                player=0;
            }
            else {
                v.setImageResource(R.drawable.zero);
                Toast.makeText(this, tag + "" + "zero", Toast.LENGTH_SHORT).show();
                gamestate[tag]=player;
                player = 1;
            }
            for (i = 0; i<winingstate.length; i++) {
                if (gamestate[winingstate[i][0]] == gamestate[winingstate[i][1]] && gamestate[winingstate[i][1]] == gamestate[winingstate[i][2]] && gamestate[winingstate[i][0]]!=9) {
                    Toast.makeText( this, tag + "winner is" + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    winer=1;
                }
            }
        }
    }

    public void reset2(View view){
        GridLayout gridLayout=findViewById(R.id.gridlayout);
        int total_images=gridLayout.getChildCount();
        for(int i=0;i<total_images;i++){
            ImageView v=(ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        winer=0;
        imageclicked=9;
        player=1;
        for(i=0;i<gamestate.length;i++){
            gamestate[i]=9;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}