package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.provider.ContactsContract;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class contactActivity extends AppCompatActivity {
    ListView listViewcontact;
    ArrayList<String> arrayList;
    public static final int REQUEST_READ_CONTACTS = 79;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        setTitle("contactlist");
        listViewcontact = findViewById(R.id.lvcontact);


        arrayList=new ArrayList<>();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},1);

        }
        else
        {
            getContact();
        }
        /*ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("viral");*/

        /*if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED)
        {
            arrayList = getAllContacts();
        }
        else
        {
            Toast.makeText(this, "not call", Toast.LENGTH_SHORT).show();
        }*/

        //getContentResolver() contentresolver = getContentResolver();
        /*Cursor c = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        while (c.moveToNext()) {
            String name = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String num = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            arrayList.add(name);
            arrayList.add(num);
        }*/
        /*ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        Cursor pcur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID,null,null);

        while(cur.moveToNext())
        {
            String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            arrayList.add(name);



        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        arrayAdapter.notifyDataSetChanged();
        listViewcontact.setAdapter(arrayAdapter);*/
        //Corsor corsor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);



    }

    private void getContact() {
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        while (cursor.moveToNext())
        {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String num = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            arrayList.add(name+"\n"+num);

            ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
            listViewcontact.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                getContact();
            }
        }
    }
    /*public void get(View v)
    {
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        startManagingCursor(cursor);
        String[] form = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.CommonDataKinds.Phone._ID};
        int[] to = {R.id.give_us_a_review_landmine_text_1,R.id.give_us_a_review_landmine_text_2};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,R.layout.support_simple_spinner_dropdown_item,cursor,form,to);
        listViewcontact.setAdapter(simpleCursorAdapter);
        listViewcontact.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }*/

    /*private ArrayList<String> getAllContacts() {
        ArrayList<String> namelist = new ArrayList<>();

        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        Cursor pcur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID,null,null);

        while(cur.moveToNext())
        {
            String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String num = pcur.getString(pcur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            namelist.add(name);
            namelist.add(num);

        }
        return namelist;

    }*/
}
