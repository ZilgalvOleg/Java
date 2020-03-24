package com.example.myfamily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.myfamily.adapter.FinanceAdapter;
import com.example.myfamily.model.Finance;
import com.example.myfamily.utils.Dialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
                Dialog.showCalendarDialog(FinanceActivity.this);

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
}
