package com.example.lab3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.content.DialogInterface;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {
    Button btn, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_click(View view) {
        Toast myToast= Toast.makeText(getApplicationContext(),"Текст", Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.BOTTOM, 0,100);
        myToast.show();
    }

    public void btn_click2(View view) {
        Toast myToast = Toast.makeText(getApplicationContext(),"Текст", Toast.LENGTH_LONG);
        myToast.setGravity(Gravity.TOP, 0,100);
        myToast.show();
    }

    public void btn_click3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Заголовок")
                .setIcon(R.drawable.test_icon)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        btn = findViewById(R.id.button);
                        btn2 = findViewById(R.id.button2);
                        btn3 = findViewById(R.id.button3);
                        btn4 = findViewById(R.id.button4);
                        btn.setTextColor(Color.RED);
                        btn2.setTextColor(Color.RED);
                        btn3.setTextColor(Color.RED);
                        btn4.setTextColor(Color.RED);
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast myToast = Toast.makeText(getApplicationContext(),"Окно закрыто", Toast.LENGTH_SHORT);
                        myToast.setGravity(Gravity.BOTTOM, 0,100);
                        myToast.show();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void btn_click4(View view) {
        String[] items={"L1", "L2", "L3"};
        boolean[] selectedItems={false, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выбрать сетевое оборудование 3 уровня:")
                .setCancelable(true)
                .setMultiChoiceItems(items, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean a) {
                        selectedItems[i] = a;
                    }
                })
                .setPositiveButton("Ответить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for (int j=0; j<items.length; j++){
                            if(selectedItems[2]){
                                Toast toast = Toast.makeText(getApplicationContext(), "Верно", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER, 0,0);
                                toast.show();
                            }
                            else {
                                btn = findViewById(R.id.button);
                                btn2 = findViewById(R.id.button2);
                                btn3 = findViewById(R.id.button3);
                                btn4 = findViewById(R.id.button4);
                                btn.setVisibility(View.INVISIBLE);
                                btn2.setVisibility(View.INVISIBLE);
                                btn3.setVisibility(View.INVISIBLE);
                                btn4.setVisibility(View.INVISIBLE);
                            }
                        }
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}