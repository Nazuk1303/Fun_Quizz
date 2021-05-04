package answer.fun.funquizes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MenuMath extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_math);

        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
        final int level = save.getInt("level", 1);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //развернуть на весь экран - конец

        TextView textView11111 = (TextView)findViewById(R.id.textView11111);
        textView11111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 1) {
                    Intent intent = new Intent(MenuMath.this, MathTest.class);
                    startActivity(intent);
                    finish();
                } else {

                }
            }
        });

        Button button5 = (Button) findViewById(R.id.button_back5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuMath.this, Menu_btn.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MenuMath.this, Menu_btn.class);
        startActivity(intent);
        finish();
    }
}