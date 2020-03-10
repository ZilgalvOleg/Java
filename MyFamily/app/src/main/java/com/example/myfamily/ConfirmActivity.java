package com.example.myfamily;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myfamily.api.APIServise;
import com.example.myfamily.model.ConfirmRequest;
import com.example.myfamily.model.ConfirmResponse;
import com.example.myfamily.model.RegistrationRequest;
import com.example.myfamily.model.RegistrationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        final EditText code = findViewById(R.id.code);
        Button confirmBtn = findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (code.getText().toString().equals("")){
                    showError("Введите код");
                    return;
                }
                confirmCode(code.getText().toString());

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
    public void confirmCode (String code){
        ConfirmRequest r = new ConfirmRequest();
        r.code = code;
        APIServise.getInstance()
                .getAPI()
                .confirm(r)
                .enqueue(new Callback<ConfirmResponse>() {
                    @Override
                    public void onResponse(Call<ConfirmResponse> call, Response<ConfirmResponse> response) {
                        ConfirmResponse resp = response.body();
                        if(!resp.result){
                            showError(resp.error);
                        } else {
                            showMenuActivity();
                        }

                    }
                    @Override
                    public void onFailure(Call<ConfirmResponse> call, Throwable t) {
                        showError(t.getMessage());
                    }
                });
    }
    public void showMenuActivity(){
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}


