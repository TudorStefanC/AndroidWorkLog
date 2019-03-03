package com.tudor.TudorLog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView date;
    private Calendar calendar;

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

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("Add Shifts");

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
                DatePickerDialog datePicker = new DatePickerDialog(AddActivity.this, mDateSetListener, yy, mm,  dd);
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
                        }
                        if (selectedMinute < 10){
                            clockIn.setText( selectedHour + ":" + "0" +selectedMinute);
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


    }

}
