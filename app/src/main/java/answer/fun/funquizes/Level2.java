package answer.fun.funquizes;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;
    public int numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //переменная text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.leveltwo);

        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);
        //код, который скругляет углы левой картинки - конец

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);
        //код, который скругляет углы правой картинки - конец

        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_right = findViewById(R.id.text_right);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //развернуть игру на весь экран - конец

        dialog = new Dialog(this);//создаём новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog.setContentView(R.layout.previewdialog);//путь
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
        dialog.setCancelable(false);//нельзе закрыть кнопкой "Назад"

        TextView textdescription = (TextView)dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.level2);

        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2.this, GameLevels.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
                //обрабатываем нажатие кнопки - конец
            }
        });
        //кнопка, которая закрывает диалоговое окно - конец
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //кнопка "Продолжить" - конец




        dialog.show();//показывать диалоговое окно

        //___________________________________
        dialogEnd = new Dialog(this);//создаём новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend);//путь
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);//нельзе закрыть кнопкой "Назад"


        TextView textdescriptionEnd = (TextView)dialogEnd.findViewById(R.id.textdescriptionEnd);
        textdescriptionEnd.setText(R.string.LevelTwoEnd);

        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2.this, GameLevels.class);
                startActivity(intent);
                finish();
                dialogEnd.dismiss();
                //обрабатываем нажатие кнопки - конец
            }
        });
        //кнопка, которая закрывает диалоговое окно - конец
        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2.this, Level2.class);
                startActivity(intent);
                finish();
                dialogEnd.dismiss();
            }
        });
        //кнопка "Продолжить" - конец

        //___________________________________



        Button btn_back = (Button)findViewById(R.id.button_back1);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Level2.this, GameLevels.class);
                startActivity(intent);
                finish();
            }
        });
        //кнопка "назад" - конец

         final int[] progress ={
                 R.id.point1,
                 R.id.point2,
                 R.id.point3,
                 R.id.point4,
                 R.id.point5,
                 R.id.point6,
                 R.id.point7,
                 R.id.point8,
                 R.id.point9,
                 R.id.point10,
                 R.id.point11,
                 R.id.point12,
                 R.id.point13,
                 R.id.point14,
                 R.id.point15,

         };

        final Animation a= AnimationUtils.loadAnimation(Level2.this, R.anim.alpha);
        //подключаем анимацию - конец

        numLeft = random.nextInt(10);
        img_left.setImageResource(array.images2[numLeft]);
        text_left.setText(array.texts2[numLeft]);

        numRight = random.nextInt(10);

        while (numLeft==numRight){
            numRight = random.nextInt(10);
        }

        img_right.setImageResource(array.images2[numRight]);
        text_right.setText(array.texts2[numRight]);

        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN){
                  img_right.setEnabled(false);
                  if(numLeft>numRight){
                      img_left.setImageResource(R.drawable.img_true);
                  }else{
                      img_left.setImageResource(R.drawable.img_false);
                  }
                  //если коснулся картинки - конец
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                   if(numLeft>numRight){
                       if (count<15){
                       count = count+1;
                       }
                       for (int i=0; i<15; i++){
                           TextView tv = findViewById(progress[i]);
                           tv.setBackgroundResource(R.drawable.style_points);
                       }
                       //Закрашиваем прогресс серым цветом - конец

                       for (int i=0; i<count; i++){
                           TextView tv = findViewById(progress[i]);
                           tv.setBackgroundResource(R.drawable.style_points_green);
                       }
                       //Закрашиваем правильные ответы зелёным цветом - конец

                   }else {
                       if (count>0){
                           count=count-1;
                           }
                       for (int i=0; i<14; i++){
                           TextView tv = findViewById(progress[i]);
                           tv.setBackgroundResource(R.drawable.style_points);
                       }

                       for (int i=0; i<count; i++){
                           TextView tv = findViewById(progress[i]);
                           tv.setBackgroundResource(R.drawable.style_points_green);
                       }



                   }
                    //если отпустил палец - конец
                    if (count==15){
                        //Выход из уровня
                       dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(10);
                        img_left.setImageResource(array.images2[numLeft]);
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[numLeft]);

                        numRight = random.nextInt(10);

                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }

                        img_right.setImageResource(array.images2[numRight]);
                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[numRight]);
                        img_right.setEnabled(true);
                    }
                }
                return true;
            }
        });
    // обрабатываем нажатие на левую картинку - конец

        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    img_left.setEnabled(false);
                    if(numRight>numLeft){
                        img_right.setImageResource(R.drawable.img_true);
                    }else{
                        img_right.setImageResource(R.drawable.img_false);
                    }
                    //если коснулся картинки - конец
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    if(numRight>numLeft){
                        if (count<15){
                            count = count+1;
                        }
                        for (int i=0; i<15; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //Закрашиваем прогресс серым цветом - конец

                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //Закрашиваем правильные ответы зелёным цветом - конец

                    }else {
                        if (count>0){
                            count=count-1;
                        }
                        for (int i=0; i<14; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }

                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }



                    }
                    //если отпустил палец - конец
                    if (count==15){
                        //Выход из уровня
                        dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(10);
                        img_left.setImageResource(array.images2[numLeft]);
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[numLeft]);

                        numRight = random.nextInt(10);

                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }

                        img_right.setImageResource(array.images2[numRight]);
                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[numRight]);
                        img_left.setEnabled(true);
                    }
                }
                return true;
            }
        });
        // обрабатываем нажатие на правую картинку - конец




    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent (Level2.this, GameLevels.class);
        startActivity(intent);
        finish();
    }
    //системная кнопка "Назад" - конец
}