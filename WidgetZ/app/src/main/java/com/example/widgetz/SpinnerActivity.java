package com.example.widgetz;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SpinnerActivity extends AppCompatActivity {
    private static final String[] mCountries = {"中国","日本","韩国"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        setTitle("SpinnerActivity");
        spinner_data();
    }


    private void spinner_data(){
        Spinner spinner = findViewById(R.id.spinner_1);
        ArrayAdapter<String> aspnCountries = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, mCountries);
        aspnCountries.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(aspnCountries);


    }

}
