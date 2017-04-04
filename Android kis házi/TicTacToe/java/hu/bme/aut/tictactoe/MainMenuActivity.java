package hu.bme.aut.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import hu.bme.aut.tictactoe.model.TicTacToeModel;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button btn_Highscore = (Button) findViewById(R.id.btn_highscore);
        btn_Highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenuActivity.this,getString(R.string.toast_highscore),Toast.LENGTH_LONG).show();
            }
        });
        Button btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TicTacToeModel.getInstance().resetModel(); // modell törlése új játék indításakor
                Intent i = new Intent(MainMenuActivity.this,GameActivity.class);
                startActivity(i);
            }
        });

        Button btnAbout = (Button) findViewById(R.id.btn_about);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainMenuActivity.this,AboutActivity.class);
                startActivity(i);
            }
        });
    }
}
