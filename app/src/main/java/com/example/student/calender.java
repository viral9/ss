package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

public class calender extends AppCompatActivity {
    CalendarView calendarView;
    TextView tvcal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        tvcal = findViewById(R.id.tvcal);
        calendarView= findViewById(R.id.calender);
        calendarView.setSelectedWeekBackgroundColor(getResources().getColor(R.color.colorPrimary));

        //long date;
        //date = calendarView.getDate();
        //tvcal.setText((int) date);
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.DTSTART,"start");
        values.put(CalendarContract.Events.TITLE,"title");
        values.put(CalendarContract.Events.DESCRIPTION,"description");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //int intmonth;
                //intmonth = month+1;
                calendarView.setSelectedWeekBackgroundColor(getResources().getColor(R.color.colorPrimary));

                //tvcal.setText(" year "+year+" month "+intmonth+" day "+dayOfMonth);
            }
        });
    }
}
