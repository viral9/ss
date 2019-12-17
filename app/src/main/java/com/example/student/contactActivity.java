package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.provider.ContactsContract;
import java.util.ArrayList;

public class contactActivity extends AppCompatActivity {
    ListView listViewcontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        listViewcontact = findViewById(R.id.lvcontact);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("viral");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        listViewcontact.setAdapter(arrayAdapter);
        Uri contact_uri = ContactsContract.Contacts.CONTENT_URI;

    }
}
