package com.example.verticaltickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class ChooseDay extends AppCompatActivity {

    //For select Day
    private DatePickerDialog datePickerDialog, datePickerDialog2;
    private Button dateButton, dateButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_day);

        initDatePicker();
        initDatePicker2();
        dateButton = findViewById(R.id.ucus);
        dateButton.setText(getTodaysDate());

        dateButton2 = findViewById(R.id.inis);
        dateButton2.setText(getTodaysDate());

    }

    private String getTodaysDate() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month +1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    //For ucus

    private void initDatePicker() {

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day,month,year);
                dateButton.setText(date);

            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this,style, dateSetListener, year, month, day);
    }

    //For inis

    private void initDatePicker2() {

        DatePickerDialog.OnDateSetListener dateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day,month,year);
                dateButton2.setText(date);

            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog2 = new DatePickerDialog(this,style, dateSetListener2, year, month, day);
    }

    private String makeDateString(int day, int month, int year) {
         return getMontFormat(month) + " " + day + " " + year;

    }

    private String getMontFormat(int month) {
        if (month==1)
            return "Jan";

        if (month==2)
            return "Feb";

        if (month==3)
            return "Mar";

        if (month==4)
            return "Apr";

        if (month==5)
            return "May";

        if (month==6)
            return "Jun";

        if (month==7)
            return "Jul";

        if (month==8)
            return "Avq";

        if (month==9)
            return "Sep";

        if (month==10)
            return "Oct";

        if (month==11)
            return "Nov";

        if (month==12)
            return "Dec";

        return "Jan";


    }


    //For back Button
    public void backfind(View view){
        Intent intent = new Intent(this,MainPageActivity.class);
        startActivity(intent);
    }

    //For open Select Day Button
    public void openucus(View view) {

        datePickerDialog.show();
    }

    public void openinis(View view){

        datePickerDialog2.show();
    }
}