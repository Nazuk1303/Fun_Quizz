package answer.fun.funquizes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Menu_btn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_btn);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //развернуть на весь экран - конец

        Button button_back3 = (Button)findViewById(R.id.button_back3);
        button_back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_btn.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        TextView textView111 =(TextView)findViewById(R.id.textView111);
        textView111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_btn.this, GameLevels.class);
                startActivity(intent);
                finish();
            }
        });


        TextView textView66 =(TextView)findViewById(R.id.textView66);
        textView66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_btn.this, MenuMath.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Menu_btn.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}