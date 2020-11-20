package com.example.session1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    final Context context = this;

    private Button button;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Инициализируем элементы:
        button = (Button) findViewById(R.id.Sign);


        //Добавляем слушателя нажатий по кнопке Button:
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //Получаем вид с файла prompt.xml, который применим для диалогового окна:
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompt, null);

                //Создаем AlertDialog
                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

                //Настраиваем prompt.xml для нашего AlertDialog:
                mDialogBuilder.setView(promptsView);

                //Настраиваем отображение поля для ввода текста в открытом диалоге:
                final EditText userInput = (EditText) promptsView.findViewById(R.id.login);

                //Настраиваем сообщение в диалоговом окне:
                mDialogBuilder
                        .setCancelable(false)

                        .setNegativeButton("Войти",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                //Создаем AlertDialog:
                AlertDialog alertDialog = mDialogBuilder.create();

                //и отображаем его:
                alertDialog.show();

            }
        });
        button = (Button) findViewById(R.id.Bankomatie);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });

    }
    public void openActivity2() {
        Intent intent= new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}