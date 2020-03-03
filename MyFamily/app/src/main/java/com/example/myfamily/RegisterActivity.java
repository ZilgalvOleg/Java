package com.example.myfamily;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText email = findViewById(R.id.email);
        final EditText name = findViewById(R.id.name);
        final EditText password = findViewById(R.id.password);
        final EditText confirmPassworld = findViewById(R.id.confirmPassworld);

        Button okbtn = findViewById(R.id.okbtn);
        okbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String error = "";
                if(email.getText().toString().equals("")){
                    error += "Укажите Email\n";
                }
                if(name.getText().toString().equals("")){
                    error += "Укажите Имя\n";
                }
                if(password.getText().toString().equals("")){
                    error += "Укажите Пароль\n";
                }
                if(confirmPassworld.getText().toString().equals("")){
                    error += "Подтвердите Пароль\n";
                }
                if(!password.getText().toString().equals("")
                    && !confirmPassworld.getText().toString().equals("")){
                    if (!password.getText().toString().equals((confirmPassworld.getText().toString()))){
                        error += "Пароли должны совподать";
                    }
                }
                if (!error.equals("")){
                    showError(error);
                }

            }
        });
    }
            public void showError (String error){
        //создаем всплывающий диалог c ошибкой
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage(error);//сюда передается ошибка
                alert.setTitle("Ощибка");//заголовок ошибки
                alert.setCancelable(true);//
                alert.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {}
                });
                alert.setIcon(R.drawable.ic_launcher_foreground);
                alert.create().show();
    }
}


