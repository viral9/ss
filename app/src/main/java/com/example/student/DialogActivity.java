package com.example.student;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    Button btntime,btndate,btnalert,btncustom,btnsnakbar;
    AlertDialog.Builder builder;
    int c_day , c_month , c_year ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("DialogActivity");
        setContentView(R.layout.activity_dialog);
        initViews();
    }

    private void initViews() {
        btntime = findViewById(R.id.btnTime);

        btndate = findViewById(R.id.btndate);

        btnalert = findViewById(R.id.btnalert);

        btncustom = findViewById(R.id.btncustome);
        btnsnakbar = findViewById(R.id.btnsnakbar);
        btnsnakbar.setOnClickListener(this);
        btnalert.setOnClickListener(this);
        btndate.setOnClickListener(this);
        btntime.setOnClickListener(this);

        btncustom.setOnClickListener(this);
        builder = new AlertDialog.Builder(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnTime:
                time();
                break;
            case R.id.btndate:
                date();
                break;
            case R.id.btnalert:
                alert();

                break;
            case R.id.btncustome:
                custom();

                break;
            case R.id.btnsnakbar:
                snak();
                break;
        }

    }

    private void snak() {
        //View contextView = findViewById(R.id.);
        //setContentView(R.layout.activity_dialog);
        //Snackbar
        //new SnackBar.Builder(this)



    }

    private void custom() {
        //setContentView(R.layout.activity_dialog);
        //Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

       /* ViewGroup viewGroup = findViewById(R.id.content);
        View dialogView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_custom,viewGroup,false);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();*/

        final Dialog dialog = new Dialog(DialogActivity.this);

        dialog.setContentView(R.layout.activity_custom);
        dialog.setTitle("custbutton");
        dialog.show();
        EditText etcust1 =  dialog.findViewById(R.id.etcust);
        etcust1.setText("hello");
        Button btncust1 = dialog.findViewById(R.id.btncust);
        btncust1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                //dialog.dismiss();
                //finish();
            }
        });



    }

    private void alert() {
        builder.setMessage("choose yes or no")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //finish();
                        Toast.makeText(DialogActivity.this, "you select yes", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(DialogActivity.this, "you select on", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("Alert Box");
        alertDialog.show();
    }

    private void date() {

        final Calendar c = Calendar.getInstance();
        c_day = c.get(Calendar.DAY_OF_MONTH);
        c_month = c.get(Calendar.MONTH);
        c_year = c.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(DialogActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                btndate.setText(dayOfMonth+"/"+month+"/"+year);
            }
        }, c_year, c_month, c_day);
        datePickerDialog.show();
    }

    private void time() {
        final int c_hour,c_min;
        final Calendar c = Calendar.getInstance();
                c_hour = c.get(Calendar.HOUR_OF_DAY);
                c_min = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(DialogActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                btntime.setText(hourOfDay+":"+minute);
            }
        },c_hour,c_min,true);
        timePickerDialog.show();


    }
}
