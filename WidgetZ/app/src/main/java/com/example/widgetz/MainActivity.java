package com.example.widgetz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_button_click();
        check_button_click();
        radio_button_click();
        clear_button_click();
        spinner_button_click();
    }


    private void spinner_button_click(){
        Spinner mediaSpinner = findViewById(R.id.media_spinner);
        mediaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view1, int position, long id) {
                TextView tv = (TextView) view1;
                tv.setTextColor(getResources().getColor(R.color.colorAccent));
                tv.setTextSize(12.0f);
                tv.setGravity(Gravity.CENTER_HORIZONTAL);//设置居中
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * 清除单选框
     */
    private void clear_button_click(){
        final Button press = findViewById(R.id.clearRadio);
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        press.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                radioGroup.clearCheck();
            }
        });
    }

    /**
     * 得到单选框选择的值
     */
    private void radio_button_click(){
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.getCheckedRadioButtonId();

        Button press = findViewById(R.id.selectRadio);
        press.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                setTitle(radioButton.getText());
            }
        });
    }

    /**
     * 显示选中的文本信息
     */
    private void check_button_click(){
        CheckBox checkBox1 = findViewById(R.id.cb1);
        CheckBox checkBox2 = findViewById(R.id.cb2);
        CheckBox checkBox3 = findViewById(R.id.cb3);
        CheckBox checkBox4 = findViewById(R.id.cb4);
        final CheckBox[] checkBoxes = new CheckBox[]{checkBox1,checkBox2,checkBox3,checkBox4};
        setTitle("study demo");
        Button press = findViewById(R.id.select);
        press.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                for (CheckBox checkBox : checkBoxes){
                    if (checkBox.isChecked()){
                        setTitle(checkBox.getText());
                    }
                }
            }
        });
    }

    /**
     * 将编辑框的值通过点击事件显示在文本框上
     */
    private void edit_button_click(){
        final TextView textView =  findViewById(R.id.text);
        Button press = findViewById(R.id.click_button);
        final EditText editText = findViewById(R.id.edit_query);
        press.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                textView.setText(s);
            }
        });
    }


}
