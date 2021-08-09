package com.example.picker_for_time;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void showTimePicker(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processDatePickerResult(int hourOfDay, int minutes) {
        String minutes_string = Integer.toString(minutes);
        String timeSet="";
        if (hourOfDay > 12) {
            hourOfDay -= 12;
            timeSet = "PM";
        } else if (hourOfDay == 0) {
            hourOfDay += 12;
            timeSet = "AM";
        } else if (hourOfDay == 12){
            timeSet = "PM";
        }else{
            timeSet = "AM";
        }
        String hourOfDay_string = Integer.toString(hourOfDay);

        String timeMessage = (hourOfDay_string +" : " + minutes_string + " "+ timeSet);
        Toast.makeText(this, "Time: " + timeMessage, Toast.LENGTH_SHORT).show();
    }
}