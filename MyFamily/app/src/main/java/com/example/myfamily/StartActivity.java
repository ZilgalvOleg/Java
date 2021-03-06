package com.example.myfamily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button creatBtn = findViewById(R.id.createBtn);
        Button joinBtn = findViewById(R.id.joinBtn);
        creatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterActivity();
            }
        });
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showJoinActivity();
            }
        });
    }

    public void showRegisterActivity (){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
    public void showJoinActivity (){
        Intent i = new Intent(this, JoinActivity.class);
        startActivity(i);
    }

}
