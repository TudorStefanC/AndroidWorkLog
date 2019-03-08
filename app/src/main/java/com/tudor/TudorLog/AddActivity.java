package com.tudor.TudorLog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class AddActivity extends AppCompatActivity {

    private TextView date, resulttxt;
    private Calendar calendar = Calendar.getInstance();

    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;
    private int selectedHour;
    private int selectedMinute;
    private Button save, clockIn, clockOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("Add shifts ");

        //Implements the "Select a date" text view
        date = findViewById(R.id.selectDate);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        selectedYear = year;
                        selectedMonth = monthOfYear + 1;
                        selectedDay = dayOfMonth;
                        if (selectedDay < 10) {
                            date.setText("0" + selectedDay + "/" + selectedMonth + "/" + selectedYear);
                        }
                        if (selectedMonth < 10) {
                            date.setText(selectedDay + "/" + "0" +selectedMonth + "/" + selectedYear);
                        }
                        if (selectedDay < 10 && selectedMonth < 10) {
                            date.setText("0" + selectedDay + "/" + "0"+ selectedMonth + "/" + selectedYear);
                        }
                    }
                };
                DatePickerDialog datePicker = new DatePickerDialog(AddActivity.this, mDateSetListener, yy, mm, dd);

                datePicker.show();
            }
        });

//Implements clock in button
        clockIn = findViewById(R.id.btn_clock_in);
        clockIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DialogFragment timeFragment = new TimePickerFragment();
                //timeFragment.show(getFragmentManager(), "timePicker");

                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedHour = hourOfDay;
                        selectedMinute = minute;
                        if (selectedHour < 10){
                            clockIn.setText("0" + selectedHour + ":" + selectedMinute);
                        } else clockIn.setText(selectedHour + ":" + selectedMinute);
                        if (selectedMinute < 10){
                            clockIn.setText( selectedHour + ":" + "0" + selectedMinute);
                        }
                        if (selectedHour < 10 && selectedMinute < 10){
                            clockIn.setText("0" + selectedHour + ":" + "0" +selectedMinute);
                        }

                    }
                };
                TimePickerDialog timePickerStart = new TimePickerDialog(AddActivity.this, mTimeSetListener, hour, minute, true);
                timePickerStart.show();
            }
        });

        //Implements clock out button
        clockOut = findViewById(R.id.btn_clock_out);
        clockOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DialogFragment timeFragment = new TimePickerFragment();
                //timeFragment.show(getFragmentManager(), "timePicker");

                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedHour = hourOfDay;
                        selectedMinute = minute;
                        if (selectedHour < 10){
                            clockOut.setText("0" + selectedHour + ":" + selectedMinute);
                        } else clockOut.setText( selectedHour + ":" + selectedMinute);
                        if (selectedMinute < 10){
                            clockOut.setText( selectedHour + ":" + "0" +selectedMinute);
                        }
                        if (selectedHour < 10 && selectedMinute < 10){
                            clockOut.setText("0" + selectedHour + ":" + "0" +selectedMinute);
                        }
                    }
                };
                TimePickerDialog timePickerEnd = new TimePickerDialog(AddActivity.this, mTimeSetListener, hour, minute, true);
                timePickerEnd.show();
            }
        });


        //Implements save button
        save = findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = date.getText().toString(); //you can create the date string from selectedYear etc directly
                String clock_In = clockIn.getText().toString();
                String clock_Out = clockOut.getText().toString();


                resulttxt=findViewById(R.id.totalHours);
                SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                df.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date d1 = null; //date 1
                Date d2 = null; //date 2
                try {
                    d1 = df.parse(clockIn.getText().toString());
                    d2 = df.parse(clockOut.getText().toString());

                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Error");
                }
                Long result = d2.getTime() - d1.getTime();
                if (result < 0)
                {
                    result = (24*3600000) + result;
                }
                int result1= Integer.parseInt(String.valueOf(result/3600000));
                int result2= Integer.parseInt(String.valueOf(result/60000))%60;
                String result3="";
                if (result2 < 10 ) {
                    result3 = "0";

                }resulttxt.setText(result1 + ":" +
                        result3+ result2);


                //clockIn.setText(Integer.toString(selectedHour) + ":" + Integer.toString(selectedMinute));
                //int start=selectedHour;
                //clockOut.setText(Integer.toString(selectedHour) + ":" + Integer.toString(selectedMinute));
                //int end=selectedHour;
                //int total = end - start;

                //int clock_in = Integer.parseInt(clock_In);
                //int clock_out = Integer.parseInt(clock_Out);
                //int shift_hours = clock_out - clock_in;
                //String totalHours = Integer.toString(shift_hours);
               Log.d("AddActivity",clock_In);
                Log.d("AddActivity",clock_Out);
                //Log.d("AddActivity",totalHours);

            }
        });
    }

}
