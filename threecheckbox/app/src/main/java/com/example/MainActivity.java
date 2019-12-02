package com.example;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox1 ;
    CheckBox checkBox2 ;
    CheckBox checkBox3 ;
    CheckBox checkBox4 ;
     TextView textView ;
    CheckBox[] checkBoxes ;

    private CheckBox.OnCheckedChangeListener checkedChangeListener = new CheckBox.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int countSelect = 0;
            for (CheckBox checkBox : checkBoxes){
                if (checkBox.isChecked()){
                    countSelect ++;
                }
            }
            switch (countSelect){
                case 0:
                    textView.setText("您还没选择物品");
                    break;
                case 1:
                    textView.setText("您还可以继续购物");
                    break;
                case 2:
                    textView.setText("您的预算已达到峰值");
                    break;
                case 3:
                case 4:
                    textView.setText("已超出您的预算");
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectProduct();
        checkBox1 = findViewById(R.id.checkBox);
         checkBox2 = findViewById(R.id.checkBox2);
         checkBox3 = findViewById(R.id.checkBox3);
         checkBox4 = findViewById(R.id.checkBox4);
         textView = findViewById(R.id.textView);
        checkBoxes = new CheckBox[]{checkBox1,checkBox2,checkBox3,checkBox4};
        checkBox1.setOnCheckedChangeListener(checkedChangeListener);
        checkBox2.setOnCheckedChangeListener(checkedChangeListener);
        checkBox3.setOnCheckedChangeListener(checkedChangeListener);
        checkBox4.setOnCheckedChangeListener(checkedChangeListener);

    }


    private void selectProduct(){
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                int countSelect = 0;
                for (CheckBox checkBox : checkBoxes){
                    if (checkBox.isChecked()){
                        countSelect ++;
                    }
                }
                switch (countSelect){
                    case 0:
                        textView.setText("您还没选择物品");
                        break;
                    case 1:
                        textView.setText("您还可以继续购物");
                        break;
                    case 2:
                        textView.setText("您的预算已达到峰值");
                        break;
                    case 3:
                    case 4:
                        textView.setText("已超出您的预算");
                        break;
                }
            }
        });

    }


}
