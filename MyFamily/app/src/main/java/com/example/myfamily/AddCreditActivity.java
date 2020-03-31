package com.example.myfamily;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.myfamily.api.APIbuilder;
import com.example.myfamily.model.AddFinanceRequest;
import com.example.myfamily.model.AddFinanceResponse;
import com.example.myfamily.model.CreditLabels;
import com.example.myfamily.utils.Dialog;

import java.util.Calendar;
import java.util.Locale;

public class AddCreditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_credit);
        Spinner credits = findViewById(R.id.credits);
        final EditText creditLabel = findViewById(R.id.creditsLadel);
        final EditText sum = findViewById(R.id.sum);
        final EditText date = findViewById(R.id.date);
        final EditText time = findViewById(R.id.time);
        Button okBtn = findViewById(R.id.okBtn);

        String []data = new String[CreditLabels.values().length];
        int i = 0;
        for (CreditLabels label : CreditLabels.values()){
            data[i++] = label.get_Label();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, R.layout.support_simple_spinner_dropdown_item, data);
        credits.setAdapter(adapter);
        credits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CreditLabels label = CreditLabels.values()[position];
                if(label == CreditLabels.OTHER){
                    creditLabel.setText("");
                    creditLabel.setEnabled(true);
                    creditLabel.requestFocus();
                } else {
                    creditLabel.setEnabled(false);
                    creditLabel.setText(label.get_Label());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Calendar calendar = Calendar.getInstance();
        String dataStr = String.format(Locale.getDefault(), "%d/%d/%d", calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.YEAR));
        date.setText(dataStr);
        String timeStr = String.format("%d/%d/%d", calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND));
        time.setText(timeStr);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(creditLabel.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this, "Укажите статью затрат");
                    return;
                }
                if(sum.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this, "Укажите сумму затрат");
                    return;
                }
                if(date.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this, "Укажите дату");
                    return;
                }
                if(time.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this, "Укажите время");
                    return;
                }
                AddFinanceRequest request = new AddFinanceRequest();
                request.creditLabel = creditLabel.getText().toString();
                request.date = date.getText().toString() + "" + time.getText().toString();
                try {
                    request.sum = Float.valueOf(sum.getText().toString());
                } catch (Exception e){
                    Dialog.showErrorDialog(AddCreditActivity.this, e.getMessage());
                    return;
                }
                addCredit (request);
            }
        });
    }
    public void addCredit (AddFinanceRequest req){
        APIbuilder<AddFinanceRequest, AddFinanceResponse> builder = new APIbuilder<>();
        builder.execute("addFinance", req, AddFinanceResponse.class,
                new APIbuilder.OnCallback<AddFinanceResponse>() {
            @Override
            public void onResponse(AddFinanceResponse r) {
                if (!r.result){
                    Dialog.showErrorDialog(AddCreditActivity.this, r.error);
                    return;
                }
                //onBackPressed - программно "нажимает" кнопку "назад"
                onBackPressed();
            }

            @Override
            public void onError(Exception e) {
                Dialog.showErrorDialog(AddCreditActivity.this, e.getMessage());

            }
        });
    }
}
