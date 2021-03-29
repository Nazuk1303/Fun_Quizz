package answer.fun.funquizes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //развернуть на весь экран - конец

        Button button_back = (Button) findViewById(R.id.button_back4);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(GameLevels.this, Menu_btn.class);
                    startActivity(intent);
                    finish();
            }
        });//переход из одноц активности к другой - конец

        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameLevels.this, Level1.class);
                startActivity(intent);
                finish();
            }
        });//кнопка для перехода на 1 уровень - конец

        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameLevels.this, Level2.class);
                startActivity(intent);
                finish();
            }
        });//кнопка для перехода на 2 уровень - конец

        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameLevels.this, Level3.class);
                startActivity(intent);
                finish();
            }
        });//кнопка для перехода на 3 уровень - конец
    }
@Override
    public void onBackPressed(){
    Intent intent = new Intent(GameLevels.this, Menu_btn.class);
    startActivity(intent);
    finish();
} //системная кнопка "Назад" - конец

}


