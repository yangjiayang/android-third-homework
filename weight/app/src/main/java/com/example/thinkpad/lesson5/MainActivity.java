package com.example.thinkpad.lesson5;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;




public class MainActivity extends Activity {
    //获得单选按钮
    RadioButton r1=null;
    RadioButton r2=null;
    RadioButton r3=null;
    RadioButton r4=null;
    RadioButton currentRadioButton = null;
    RadioGroup radioGroup=null;
    //获得单选按钮组(如果要获取按钮就需要用findViewById)


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        r1=(RadioButton)findViewById(R.id.a);
        r2=(RadioButton)findViewById(R.id.b);
        r3=(RadioButton)findViewById(R.id.c);
        r4=(RadioButton)findViewById(R.id.d);
        r1.setClickable(true);

    //监听的按钮事件
        radioGroup.setOnCheckedChangeListener(mChangeRadio);
        Button btn1_sure=(Button)findViewById(R.id.sure);
        Button btn2_cancel=(Button)findViewById(R.id.cancel);
        btn1_sure.setOnClickListener(new btn1_sure());
        btn2_cancel.setOnClickListener(new btn2_cancel());
    }
    class btn1_sure implements OnClickListener{
        @Override
        public void onClick(View v) {
            if (currentRadioButton.getText().equals("50")){
                setTitle("你说对了");
            }else {
                setTitle("你说错了");
            }
        }
    }
    class btn2_cancel implements OnClickListener{
        @Override
        public void onClick(View v) {
            radioGroup.clearCheck();
            setTitle("nothing");
        }
    }
    private RadioGroup.OnCheckedChangeListener mChangeRadio= new RadioGroup.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId==r1.getId()){
                currentRadioButton=r1;
            }else if(checkedId==r2.getId()){
                currentRadioButton=r2;
            }else if(checkedId==r3.getId()){
                currentRadioButton=r3;
            }else if(checkedId==r4.getId()){
                currentRadioButton=r4;
            }
        }
    };
}
