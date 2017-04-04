package hu.bme.aut.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
    public void endGame(int winner){
        if(winner == 1)
            Toast.makeText(GameActivity.this,getString(R.string.str_winnerCircle),Toast.LENGTH_LONG).show();
        if(winner == 2)
            Toast.makeText(GameActivity.this,getString(R.string.str_winnerCross),Toast.LENGTH_LONG).show();
        if(winner == 3)
            Toast.makeText(GameActivity.this,getString(R.string.str_draw),Toast.LENGTH_LONG).show();
        finish();
    }

}
