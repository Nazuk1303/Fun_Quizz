package answer.fun.funquizes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Test1 extends AppCompatActivity {
    Dialog dialog;
    Dialog dialogEnd;
    TextView qwest;
    TextView anwer;
    TextView w1;
    TextView w2;
    TextView w3;
    ArrayList <Test> list = new ArrayList<>();
    ArrayList<TextView> arrayListText = new ArrayList<>();
    public int count = 0;
    Integer number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        TextView textdescription = (TextView)dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.test1);

        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test1.this, MenuTest.class);
                startActivity(intent);
                finish();
                dialog.dismiss();

            }
        });
        ImageView imgpreview = (ImageView)dialog.findViewById(R.id.previewimg);
        imgpreview.setImageResource(R.drawable.prdialtest);

        LinearLayout dialogfon = (LinearLayout)dialog.findViewById(R.id.dialogfon);
        dialogfon.setBackgroundResource(R.drawable.prbackt);

        dialogEnd = new Dialog(this);//создаём новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend);//путь
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);//нельзе закрыть кнопкой "Назад"




        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test1.this, MenuTest.class);
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
                Intent intent = new Intent(Test1.this, Demo.class);
                startActivity(intent);
                finish();
                dialogEnd.dismiss();
            }
        });

        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

        Button btn_back6 = (Button)findViewById(R.id.button_back6);
        btn_back6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Test1.this, MenuTest.class);
                startActivity(intent);
                finish();
            }
        });



        number=0;

        Test test1=new Test("Как звали лошадь Дон Кихота?", "Росинант",  "Юлий", "Шептало",  "Фердинант","Конь");
        Test test2=new Test("Знаменитый писатель-фантаст Айзек Азимов написал:", "Слова в науке",  "Биография Галилео Галилея",  "Мы",  "Четверо друзей", "Братья");
        Test test3 = new Test("Назовите имя замечательного русского поэта Майкова", "Аполлон", "Артур",  "Марк", "Владислав", "Андрей");
        Test test4 = new Test("Где родился главный герой романа А.С. Пушкина «Евгений Онегин»?", "Петербург", "Москва", "Владивосток",  "Кавказ", "Саратов");
        Test test5 = new Test ("Название какого из этих духовных произведений переводится на русский язык как «книга»?", "Библия", "Евангелие",  "Катехизис",  "Талмуд", "Аллах");
        Test test6 = new Test ( "Кто из писателей-фантастов придумал три закона робототехники?",  "Айзек Азимов", "Энтони Райан",  "Андрей Круз", "Дуглас Адамс","Евген Замятин");
        Test test7 = new Test ("Как называется одна из знаменитых сказок Г.Х. Андерсена?", "Новое платье короля",  "Старое платье короля", "Голый король", "Долой короля!", "Грустный король");
        Test test8 = new Test ("Повествование в романе А.С. Пушкина \"Капитанская дочка\" ведется от лица ...",  "Петра Гринёва",  "Пугачёва", "Маши Мироновой",  "Автора", "Призрака");
        Test test9 = new Test (  "Отгадайте первоначальную крылатую фразу: «Положительные эмоции," +
                " испытываемые в процессе пассивного перемещения, являются желательной предпосылкой эмоционального комфорта," +
                " сопровождающего реализацию активной двигательной функции.\"", "Любишь кататься - люби и санки возить", "Одним выстрелом - двух заяцев", "Волков бояться - в лес не ходить",  "Готовь сани летом, а телегу зимой", "На обиженных воду возят");
        Test test10 = new Test ("Это \"животное\" стало символом коварства и обмана. Образ его в литературе появился в древности, а сейчас похожее выражение  мы часто слышим от  пользователей ПК.",  "Троянский конь", "Тамбовский волк", "Ивановская лиса",  "Персидский кот", "Ангельский медведь");
        Test test11 = new Test ("Чем брал взятки герой комедии Н.В. Гоголя \"Ревизор\" судья Ляпкин-Тяпкин?", "Борзыми щенками",  "Деньгами",  "Едой",  "Лошадями", "Людьми");
        Test test12 = new Test ("Кто написал повесть «Чапаев»",  "Дмитрий Фурманов", "Евген Замятин",  "Виктор Пелевин",  "Михаил Шолохов", "Петр Зубенко");
        Test test13 = new Test ("Какая пословица является эпиграфом к роману А.С.Пушкина \"Капитанская дочка\"?",  "Береги честь смолоду",  "Береги платье снову, а честь смолоду", "Мир освещается солнцем, а человек знанием", "В добрый час молвить, в дурной промолчать", "Отче наш");
        Test test14 = new Test ("Какая черта характера объединяет Григория Ивановича Муромского (героя повести «Барышня-крестьянка») и императора Александра Павловича (героя сказа Н.С.Лескова «Левша»)?", "Англомания",  "Одиночество", "Щедрость", "Остроумие", "Веселье");
        Test test15 = new Test ( "В стихотворении к близкому другу, милому и чудоковатому (в будущем декабристу), с которым у Пушкина было много и забавных столкновений, он обращается:\n" +
                "\n" +
                " Лицейской жизни милый брат,\n" +
                " Делю с тобой последние мгновенья!\n" +
                "Кого из своих друзей называет Пушкин в этом стихотворении называет братом?", "Пущину",  "Лермонтову", "Толстому", "Дельвигу", "Пугачёву");
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        list.add(test5);
        list.add(test6);
        list.add(test7);
        list.add(test8);
        list.add(test9);
        list.add(test10);
        list.add(test11);
        list.add(test12);
        list.add(test13);
        list.add(test14);
        list.add(test15);



        qwest=findViewById(R.id.textQuestion1);
        anwer=findViewById(R.id.textView22);
        w1=findViewById(R.id.textView23);
        w2=findViewById(R.id.textView24);
        w3=findViewById(R.id.textView25);
        arrayListText.add(anwer);
        arrayListText.add(w1);
        arrayListText.add(w2);
        arrayListText.add(w3);
        qwest.setText(test1.qest);
        anwer.setText(test1.rAnser);
        w1.setText(test1.wAnser1);
        w2.setText(test1.wAnser2);
        w3.setText(test1.wAnser3);






    }
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




    void show(){
        qwest.setText(list.get(number).qest);
        int num=(int)(Math.random()*4);

        for (int i=0;i<4;i++){

            if(i==num){
                arrayListText.get(i).setText(list.get(number).rAnser);}
            else {
                switch (i){
                    case 0:
                        arrayListText.get(i).setText(list.get(number).wAnser1);
                        break;
                    case 1:
                        arrayListText.get(i).setText(list.get(number).wAnser2);
                        break;
                    case 2:
                        arrayListText.get(i).setText(list.get(number).wAnser3);
                        break;
                    case 3:
                        arrayListText.get(i).setText(list.get(number).wAnser1);
                        break;


                }

            }
        }
    }











    public void nexp(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.textView22:
                if (anwer.getText().toString().equals(list.get(number).rAnser)) {

                    count++;

                    for (int y = 0; y < count; y++) {
                        TextView tv = findViewById(progress[y]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }


                } else {
                    count = count + 0;


                }
                break;
            case R.id.textView23:
                if (w1.getText().toString().equals(list.get(number).rAnser)) {

                    count++;


                    for (int y = 0; y < count; y++) {
                        TextView tv = findViewById(progress[y]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }


                } else {
                    count = count + 0;


                }
                break;
            case R.id.textView24:
                if (w2.getText().toString().equals(list.get(number).rAnser)) {

                    count++;

                    for (int y = 0; y < count; y++) {
                        TextView tv = findViewById(progress[y]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }


                } else {
                    count = count + 0;


                }
                break;

            case R.id.textView25:
                if (w3.getText().toString().equals(list.get(number).rAnser)) {

                    count++;

                    for (int y = 0; y < count; y++) {
                        TextView tv = findViewById(progress[y]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    }


                } else {
                    count = count + 0;


                }
                break;


        }

        number++;
        if (number < 15) {
            show();
        }
        if(number==15){
            dend();
        }



    }
    public void dend(){
        TextView textdescription1 = (TextView)dialogEnd.findViewById(R.id.textdescriptionEnd);
        if(count<16){

                textdescription1.setText(R.string.test1end1);}


        if(count<10){

                textdescription1.setText(R.string.test1end2);}


        if(count<6){

                textdescription1.setText(R.string.test1end3);}

        dialogEnd.show();
    }



    }








