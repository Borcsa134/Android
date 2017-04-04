package hu.bme.aut.tictactoe.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import hu.bme.aut.tictactoe.GameActivity;
import hu.bme.aut.tictactoe.model.TicTacToeModel;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class TicTacToeView extends View {

  Paint paintBg;
  Paint paintLine;

  public TicTacToeView(Context context, AttributeSet attrs) {
    super(context, attrs);

    paintBg = new Paint();
    paintBg.setColor(Color.BLACK);
    paintBg.setStyle(Paint.Style.FILL);

    paintLine = new Paint();
    paintLine.setColor(Color.WHITE);
    paintLine.setStyle(Paint.Style.STROKE);
    paintLine.setStrokeWidth(5);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    canvas.drawRect(0, 0, getWidth(), getHeight(), paintBg);

    drawGameArea(canvas);

    drawPlayers(canvas);
    checkGameStatus();
  }

  private void drawGameArea(Canvas canvas) {
    // border
    canvas.drawRect(0, 0, getWidth(), getHeight(), paintLine);
    // two horizontal lines
    canvas.drawLine(0, getHeight() / 3, getWidth(), getHeight() / 3,
            paintLine);
    canvas.drawLine(0, 2 * getHeight() / 3, getWidth(),
            2 * getHeight() / 3, paintLine);

    // two vertical lines
    canvas.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight(),
            paintLine);
    canvas.drawLine(2 * getWidth() / 3, 0, 2 * getWidth() / 3, getHeight(),
            paintLine);
  }

  private void drawPlayers(Canvas canvas) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (TicTacToeModel.getInstance().getFieldContent(i,j) == TicTacToeModel.CIRCLE) {

          // draw a circle at the center of the field

          // X coordinate: left side of the square + half width of the square
          float centerX = i * getWidth() / 3 + getWidth() / 6;
          float centerY = j * getHeight() / 3 + getHeight() / 6;
          int radius = getHeight() / 6 - 2;

          canvas.drawCircle(centerX, centerY, radius, paintLine);

        } else if (TicTacToeModel.getInstance().getFieldContent(i,j) == TicTacToeModel.CROSS) {
          canvas.drawLine(i * getWidth() / 3, j * getHeight() / 3,
                  (i + 1) * getWidth() / 3,
                  (j + 1) * getHeight() / 3, paintLine);

          canvas.drawLine((i + 1) * getWidth() / 3, j * getHeight() / 3,
                  i * getWidth() / 3, (j + 1) * getHeight() / 3, paintLine);
        }
      }
    }
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int w = MeasureSpec.getSize(widthMeasureSpec);
    int h = MeasureSpec.getSize(heightMeasureSpec);
    int d = w == 0 ? h : h == 0 ? w : w < h ? w : h;
    setMeasuredDimension(d, d);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {

    if (event.getAction() == MotionEvent.ACTION_DOWN) {
      int tX = ((int) event.getX()) / (getWidth() / 3);
      int tY = ((int) event.getY()) / (getHeight() / 3);
      if (tX < 3 && tY < 3 && TicTacToeModel.getInstance().getFieldContent(tX, tY) == TicTacToeModel.EMPTY) {
        TicTacToeModel.getInstance().setFieldContent(tX, tY, TicTacToeModel.getInstance().getNextPlayer());
        invalidate();
      }
    }
    return super.onTouchEvent(event);
  }
  private void checkGameStatus(){
      boolean empty = FALSE;
      boolean finished = FALSE;
      GameActivity gameActivity = (GameActivity)getContext();
      for(int i=0; i<3; i++)
          for(int j=0; j<3; j++)
              if(TicTacToeModel.getInstance().getFieldContent(i,j) == TicTacToeModel.EMPTY)
                  empty = TRUE;


      for(int i=0; i<3; i++) {

          //Az oszlopok vizsgálata
          if (TicTacToeModel.getInstance().getFieldContent(i, 0) == TicTacToeModel.CIRCLE &&
                  TicTacToeModel.getInstance().getFieldContent(i, 1) == TicTacToeModel.CIRCLE &&
                  TicTacToeModel.getInstance().getFieldContent(i, 2) == TicTacToeModel.CIRCLE) {
              gameActivity.endGame(1);
              finished = TRUE;
          } else if (TicTacToeModel.getInstance().getFieldContent(i, 0) == TicTacToeModel.CROSS &&
                  TicTacToeModel.getInstance().getFieldContent(i, 1) == TicTacToeModel.CROSS &&
                  TicTacToeModel.getInstance().getFieldContent(i, 2) == TicTacToeModel.CROSS) {
              gameActivity.endGame(2);
              finished = TRUE;
          }
          //A sorok vizsgálata
          else if (TicTacToeModel.getInstance().getFieldContent(0, i) == TicTacToeModel.CIRCLE &&
                  TicTacToeModel.getInstance().getFieldContent(1, i) == TicTacToeModel.CIRCLE &&
                  TicTacToeModel.getInstance().getFieldContent(2, i) == TicTacToeModel.CIRCLE) {
              gameActivity.endGame(1);
              finished = TRUE;
          } else if (TicTacToeModel.getInstance().getFieldContent(0, i) == TicTacToeModel.CROSS &&
                  TicTacToeModel.getInstance().getFieldContent(1, i) == TicTacToeModel.CROSS &&
                  TicTacToeModel.getInstance().getFieldContent(2, i) == TicTacToeModel.CROSS) {
              gameActivity.endGame(2);
              finished = TRUE;
          }
      }
      //Az átlók vizsgálata
      if((TicTacToeModel.getInstance().getFieldContent(0,0) == TicTacToeModel.CIRCLE &&
              TicTacToeModel.getInstance().getFieldContent(1,1) == TicTacToeModel.CIRCLE &&
              TicTacToeModel.getInstance().getFieldContent(2,2) == TicTacToeModel.CIRCLE)){
          gameActivity.endGame(1);
          finished = TRUE;
      }

      else if((TicTacToeModel.getInstance().getFieldContent(0,0) == TicTacToeModel.CROSS &&
              TicTacToeModel.getInstance().getFieldContent(1,1) == TicTacToeModel.CROSS &&
              TicTacToeModel.getInstance().getFieldContent(2,2) == TicTacToeModel.CROSS)){
          gameActivity.endGame(2);
          finished = TRUE;
      }

      else if((TicTacToeModel.getInstance().getFieldContent(0,2) == TicTacToeModel.CIRCLE &&
              TicTacToeModel.getInstance().getFieldContent(1,1) == TicTacToeModel.CIRCLE &&
              TicTacToeModel.getInstance().getFieldContent(2,0) == TicTacToeModel.CIRCLE)){
          gameActivity.endGame(1);
          finished = TRUE;
      }

      else if((TicTacToeModel.getInstance().getFieldContent(0,2) == TicTacToeModel.CROSS &&
              TicTacToeModel.getInstance().getFieldContent(1,1) == TicTacToeModel.CROSS &&
              TicTacToeModel.getInstance().getFieldContent(2,0) == TicTacToeModel.CROSS)){
          gameActivity.endGame(2);
          finished = TRUE;
      }

      else if(empty == FALSE && finished == FALSE)                //Ha nincs üres mező, döntetlen
          gameActivity.endGame(3);
  }
}
