package com.example.myfamily;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myfamily.api.APIbuilder;
import com.example.myfamily.model.JoinRequest;
import com.example.myfamily.model.JoinResponse;
import com.example.myfamily.utils.Dialog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinActivity extends AppCompatActivity {
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        email = findViewById(R.id.email);
        Button joinBtn = findViewById(R.id.joinBtn);
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("")){
                    Dialog.showErrorDialog(JoinActivity.this,"Укажите email");
                    return;
                }
                String regex = "^(.+)@(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email.getText().toString());
                if (!matcher.matches()){
                    Dialog.showErrorDialog(JoinActivity.this,"Не верно указан email");
                    return;
                }
                join(email.getText().toString());
            }
        });
    }
    public void join (String email){
        JoinRequest r = new JoinRequest();
        r.email = email;
        APIbuilder<JoinRequest, JoinResponse> builder = new APIbuilder<>();
        builder.execute("join", r, JoinResponse.class, new APIbuilder.OnCallback<JoinResponse>() {
            @Override
            public void onResponse(JoinResponse resp){
                Dialog.showErrorDialog(JoinActivity.this,"Пользователь добавлен!");
                JoinActivity.this.email.setText("");
            }

            @Override
            public void onError(Exception e) {
                Dialog.showErrorDialog(JoinActivity.this, e.getMessage());

            }
        });

    }

}
