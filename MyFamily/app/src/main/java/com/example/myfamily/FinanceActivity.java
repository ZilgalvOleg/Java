package com.example.myfamily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.myfamily.adapter.FinanceAdapter;
import com.example.myfamily.api.APIbuilder;
import com.example.myfamily.model.Finance;
import com.example.myfamily.model.FinanceResponse;
import com.example.myfamily.utils.Dialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class FinanceActivity extends AppCompatActivity {
    /////TODO:remove
    private Finance [] fakeFinance = {
            new Finance(12.5f, "Oleg", "car", "24/03/2012 18:44:45"),
            new Finance(30.f, "Nat", "sport", "25/02/2012 18:40:45"),
            new Finance(10, "Vlad", "shopping", "10/02/2012 02:44:45"),
            new Finance(12.5f, "Vasilisa", "shopping", "17/03/2012 03:44:45")

    };
    /////

    private ListView financeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        ImageButton calendarBtn = findViewById(R.id.calendarBtn);
        calendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog.showCalendarDialog(FinanceActivity.this, new Dialog.onDateChangeListener() {
                    @Override
                    public void onDateChange(int year, int month, int day) {
                        fetchFinance(year, month, day);
                    }
                });
                //TODO: uncomment
                Calendar calendar = Calendar.getInstance();
                /*fetchFinance(
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));*/

            }
        });
        financeList = findViewById(R.id.finanseList);
        FinanceAdapter adapter = new FinanceAdapter(this,fakeFinance);
        financeList.setAdapter(adapter);
        FloatingActionButton addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinanceActivity.this, AddCreditActivity.class);
                startActivity(i);
            }
        });
    }
    public void fetchFinance (int year, int month, int day){
        APIbuilder<String, FinanceResponse> builder = new APIbuilder<>();
        builder.execute("getFinance", String.format("%d/%d/%d", day, month, year),
                FinanceResponse.class, new APIbuilder.OnCallback<FinanceResponse>() {
            @Override
            public void onResponse(FinanceResponse r) {
                if (!r.result){
                    Dialog.showErrorDialog(FinanceActivity.this, r.error);
                    return;
                }
                showList (r.finances);
            }

            @Override
            public void onError(Exception e) {
                Dialog.showErrorDialog(FinanceActivity.this, "Ничего не найдено за указанную дату");

            }
        });
    }
    public void showList (Finance [] finances){
        FinanceAdapter adapter = new FinanceAdapter(FinanceActivity.this, finances);
        this.financeList.setAdapter(adapter);
        //notifyAll - насильно перерисует область с нашим ListView на экране
        this.financeList.notifyAll();
    }
}
