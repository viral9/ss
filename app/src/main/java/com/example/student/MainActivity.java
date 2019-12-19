package com.example.student;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Instrumentation;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etRollNo,eage;
    TextView textView, tvDob;
    ImageView imageviewmain;
    Button btnSubmit,bnprint,btnclr,btncard,btnimage;
    String name,age,roll,dob,filestrpath;
    int gallary = 1,camera = 2;
    int c_month,c_year,c_day;
    OutputStream outputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        etName.setText(getIntent().getStringExtra("name"));
        //Intent i = new Intent(MainActivity.this,print.class);
        //etName.setText("hello");

        //String ss;

        //ss = getIntent().getStringExtra("name");
        //etName.setText("hr");


        //getIntent().getStringArrayExtra("name").toString();

        tvDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                c_day = c.get(Calendar.DAY_OF_MONTH);
                c_month = c.get(Calendar.MONTH);
                c_year = c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDob.setText(dayOfMonth+"-"+(month +1)+"-"+year);
                    }
                }, c_year, c_month, c_day);
                datePickerDialog.show();


            }
        });




    }



    private void initViews() {

        etRollNo = findViewById(R.id.etrollno);
        etName = findViewById(R.id.etname);

        btnSubmit =findViewById(R.id.btnsub);
        tvDob = findViewById(R.id.tvdob);
        btnclr = findViewById(R.id.btnclear);
        btnimage = findViewById(R.id.btnImage);
        imageviewmain = findViewById(R.id.imgviewmain);
        //btncard = findViewById(R.id.btncard);
        //btncard.setOnClickListener(this);
        btnclr.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        btnimage.setOnClickListener(this);

        etName.setText(getIntent().getStringExtra("name"));


    }

    private void checkValidations() {
        name = etName.getText().toString();
        roll = etRollNo.getText().toString();
        dob = tvDob.getText().toString();
        Drawable drawable = this.getResources().getDrawable(R.drawable.s_profile_place_holder);
        if(name == null || name.isEmpty())
        {
            etName.setError("enter name");
            return;
        }
        if(roll == null || roll.isEmpty())
        {
            etRollNo.setError("enter rollno");
            return;
        }
        if(tvDob.getText().toString().equalsIgnoreCase("Add DOB"))
        {
            Toast.makeText(MainActivity.this, "Enter Date of birth", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!roll.matches("[0-9]+"))
        {
            etRollNo.setError("enter correct");
            return;
        }
        else if(!name.matches("[a-zA-Z]+"))
        {
            etName.setError("enter correct");
            return;
        }

        /*else if(imageviewmain.setImageBitmap(null) == drawable)
        {
            Toast.makeText(this, "Add Image", Toast.LENGTH_SHORT).show();
        }*/
        else
        {
            Toast.makeText(MainActivity.this,"submit successful",Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this,print.class);
            i.putExtra("name",name);
            i.putExtra("roll",roll);
            i.putExtra("dob",dob);
            i.putExtra("filepath",filestrpath);
            setResult(RESULT_OK,i);
            //startActivity(i);
            finish();

        }

    }

   private void clearData(){
        etName.setText(" ");
        etRollNo.setText(" ");
        tvDob.setText("Add DOB");
        etName.requestFocus();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnsub:
                checkValidations();
                break;
            case R.id.btnclear:
                clearData();
                break;
            case R.id.btnImage:
                showpictureDialog();

                break;



        }
    }

    private void showpictureDialog() {
        AlertDialog.Builder  pictredialog = new AlertDialog.Builder(this);
        pictredialog.setTitle("Select Action");
        String[] picureitem ={"gallery","camera"};
        pictredialog.setItems(picureitem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which)
                {
                    case 0:
                        getpermition();
                        //showgallary();
                        //Toast.makeText(MainActivity.this, "gallery", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        getcamerapre();
                        //showcamera();
                        //Toast.makeText(MainActivity.this, "camera", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
        pictredialog.show();
    }

    private void getcamerapre() {
        if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.CAMERA},camera);
        }
        else
        {
            showcamera();
        }

    }

    private void getpermition() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE}, gallary);
        }
        else
        {
            showgallary();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case 1:
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    showgallary();
                }
                break;
            case 2:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    showcamera();
                }
                break;
        }

    }

    private void showcamera() {
        Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraintent,camera);
    }

    private void showgallary() {

        Intent galleryintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryintent, gallary);

        /*BitmapDrawable drawable = (BitmapDrawable) imageviewmain.getDrawable();
        Bitmap bitmap1 = drawable.getBitmap();

        //String[] filepath = {MediaStore.Images.Media.DATA};
        File filepath = Environment.getExternalStorageDirectory();
        File dir = new File(filepath.getAbsolutePath()+"/image/");
        dir.mkdir();
        File file = new File(dir,System.currentTimeMillis()+".jpg");
        try {
            outputStream =  new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap1.compress(Bitmap.CompressFormat.JPEG,100,outputStream);*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== gallary)
        {

           // Intent intent = new Intent(Intent.ACTION_GET_CONTENT); intent.setType("img/*");
            //startActivityForResult(intent, ;


            //filepath.toString();
            //Toast.makeText(this, filepath.toString(), Toast.LENGTH_SHORT).show();
            Uri contentUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),contentUri);
                imageviewmain.setImageBitmap(bitmap);
                BitmapDrawable drawable = (BitmapDrawable) imageviewmain.getDrawable();
                Bitmap bitmap1 = drawable.getBitmap();

                //String[] filepath = {MediaStore.Images.Media.DATA};
                File filepath = Environment.getExternalStorageDirectory();
                File dir = new File(filepath.getAbsolutePath()+"/image/");

                dir.mkdir();
                File file = new File(dir,System.currentTimeMillis()+".jpg");
                filestrpath = file.getPath();
                Toast.makeText(this, filestrpath, Toast.LENGTH_SHORT).show();
                try {
                    outputStream =  new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bitmap1.compress(Bitmap.CompressFormat.JPEG,100,outputStream);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(requestCode==camera)
        {
            Bitmap bitmapcamera = (Bitmap) data.getExtras().get("data");
            imageviewmain.setImageBitmap(bitmapcamera);
            BitmapDrawable drawable = (BitmapDrawable) imageviewmain.getDrawable();
            Bitmap bitmap1 = drawable.getBitmap();

            //String[] filepath = {MediaStore.Images.Media.DATA};
            File filepath = Environment.getExternalStorageDirectory();
            File dir = new File(filepath.getAbsolutePath()+"/image/");
            dir.mkdir();
            File file = new File(dir,System.currentTimeMillis()+".jpg");
            try {
                outputStream =  new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            bitmap1.compress(Bitmap.CompressFormat.JPEG,100,outputStream);

        }
    }
}
