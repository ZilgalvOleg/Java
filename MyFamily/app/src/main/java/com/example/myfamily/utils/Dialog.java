package com.example.myfamily.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.myfamily.R;
import com.example.myfamily.model.CalendarDate;

import java.util.Calendar;

public class Dialog {
    public interface onDateChangeListener{
        void onDateChange (int year, int month, int day);

    }
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
    public static void showCalendarDialog (Context ctx, final onDateChangeListener listener){
        //создаем всплывающий диалог
        AlertDialog.Builder alert = new AlertDialog.Builder(ctx);
        alert.setView(R.layout.calendar_layout);
        alert.setCancelable(true);
        final CalendarDate date = new CalendarDate();
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!date.isEmpty()) {
                    listener.onDateChange(date.year, date.month, date.day);
                }
            }
        });
        AlertDialog dialog = alert.create();

        dialog.show();
        CalendarView calendar = dialog.findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int y, int m, int d) {
                date.year = y;
                date.month = m;
                date.day = d;
            }
        });
    }
}
