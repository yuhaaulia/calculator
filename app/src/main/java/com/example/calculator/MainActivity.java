package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> resultAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList());
        ListView resultsListView = (ListView) findViewById(R.id.recordListView);
        resultsListView.setAdapter(resultAdapter);

    }

    public void kalkulator(View view) {
        EditText bilangan1 = (EditText) findViewById(R.id.edt1);
        EditText bilangan2 = (EditText) findViewById(R.id.edt2);

        int bil1 = Integer.parseInt(bilangan1.getText().toString());
        int bil2 = Integer.parseInt(bilangan2.getText().toString());

        RadioButton rbtambah =(RadioButton) findViewById(R.id.rb_tambah);
        RadioButton rbkurang =(RadioButton) findViewById(R.id.rb_kurang);
        RadioButton rbbagi =(RadioButton) findViewById(R.id.rb_bagi);
        RadioButton rbkali =(RadioButton) findViewById(R.id.rb_kali);

        int hasil = 0;

        if (rbtambah.isChecked()){
            hasil = bil1 + bil2;
        } else if (rbkurang.isChecked()){
            hasil = bil1 - bil2;
        } else if (rbbagi.isChecked()){
            hasil = bil1 / bil2;
        } else if (rbkali.isChecked()){
            hasil = bil1 * bil2;
        }

        TextView resultTextView = (TextView) findViewById(R.id.txt_hasil);
        resultTextView.setText("Hasil: " + hasil);

        CheckBox recordCheckBox = (CheckBox) findViewById(R.id.checkBox);
        if (recordCheckBox.isChecked()){
            resultAdapter.add("Hasil Record: " + hasil);
        }
    }
}