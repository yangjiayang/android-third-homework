package com.example.thinkpad.datepickerdialog;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.R.attr.y;

public class MainActivity extends AppCompatActivity {
    private TextView showdate;
    private Button setdate;
    private int year;
    private int month;
    private int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showdate = (TextView) this.findViewById(R.id.showtime);
        setdate=(Button)this.findViewById(R.id.setdate);
        //初始化calendar日历对象
        Calendar c= Calendar.getInstance(Locale.CHINA);
        Date mydate=new Date();
        c.setTime(mydate);//为calendar设置时间为当前的日期。

        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        showdate.setText("当前时间："+year+"."+(month+1)+"."+day);
        //添加单机时间--设置日期
        setdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建DatePickerDialog对象
                DatePickerDialog my_datePickerDialog=new DatePickerDialog(MainActivity.this,Datelistener,year,month,day);
                my_datePickerDialog.show();
            }
        });
    }
    private DatePickerDialog.OnDateSetListener Datelistener=new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker v, int y, int m, int d) {
           Calendar c =Calendar.getInstance(Locale.CHINA);
            year=c.get(Calendar.YEAR);
            month=c.get(Calendar.MONTH);
            day=c.get(Calendar.DAY_OF_MONTH);
            //格式化时间戳
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String time =y+"-"+m+"-"+d;
            String current_time=year+"-"+month+"-"+day;
            Date date=null;
            Date current_date=null;
            try{
                date=format.parse(time);
                //simpleDateFormat parse方法可以把string型的字符串转换成特定格式的date类型。
                current_date=format.parse(current_time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(date.getTime()<=current_date.getTime()){
                year=y;
                month=m;
                day=d;
                update();
            }else{
                Toast.makeText(getApplicationContext(),"设置日期无效",Toast.LENGTH_SHORT).show();
                //toast.makeText是消息提醒。
            }
        }

        private void update(){
           showdate.setText("修改后的时间为："+year+"."+(month+1)+"."+day);
        }
    };
}
