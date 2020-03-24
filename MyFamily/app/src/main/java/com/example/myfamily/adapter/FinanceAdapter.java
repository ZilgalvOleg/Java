package com.example.myfamily.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myfamily.R;
import com.example.myfamily.model.Finance;

import java.util.zip.Inflater;

public class FinanceAdapter extends BaseAdapter {
    private Finance[] finances;
    private Context context;//хранит информацию о запущенном процессе в системе

    public FinanceAdapter (Context context, Finance[] finances){
        this.finances = finances;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.finances.length;
    }

    @Override
    public Object getItem(int position) {
        return this.finances[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Finance f = this.finances[position];
        View view = convertView; // Если элемент списка отображается в первые, то convertView == 0
        // и нам необходимо загрузить макет элемента списка самостоятельно
        if (view == null) {// отображается впервые
            view = LayoutInflater.from(this.context).inflate(R.layout.finance_item, parent, false);
        }
        TextView sum = view.findViewById(R.id.sum);
        TextView name = view.findViewById(R.id.name);
        TextView creditLabel = view.findViewById(R.id.creditLabel);
        TextView date = view.findViewById(R.id.date);
        sum.setText(String.valueOf(f.sum));
        date.setText(f.date);
        name.setText(f.name);
        creditLabel.setText(f.creditLabel);
        return view;
    }
}
