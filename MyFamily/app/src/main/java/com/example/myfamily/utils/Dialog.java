package com.example.myfamily.utils;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.example.myfamily.R;

public class Dialog {
    public static void showErrorDialog (Context ctx, String error){
        //создаем всплывающий диалог c ошибкой
        AlertDialog.Builder alert = new AlertDialog.Builder(ctx);
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
    public static void showDialog (Context ctx, String message){
        //создаем всплывающий диалог
        AlertDialog.Builder alert = new AlertDialog.Builder(ctx);
        alert.setMessage(message);//сюда передается Сообщение
        alert.setCancelable(true);//
        alert.create().show();
    }
}
