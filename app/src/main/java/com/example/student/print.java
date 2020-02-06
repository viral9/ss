package com.example.student;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class print extends AppCompatActivity   implements  View.OnClickListener {
    //TextView tvStudentData;
   // EditText etStudent;
    //Button btnAddStudent,btnDialog;
    FloatingActionButton feb;
    RecyclerView recyclerView;
    Button btncontact,btntab,btnside,btnside2,btnweb,btnseek,btnupseek,btnbro,btnviewbt,btndialog,btncal,btnradio;
    //RecyclerView.Adapter recadapter;
    studentAdapter recadapter;
    RecyclerView.LayoutManager layour;
    public String name,roll,dob;
    //ListView lvStudent;
    //ArrayList<String> arrayList;
    //ArrayAdapter<String> adapter;
    Intent intent;
    String filepath;
    TextView tvtest;
    ArrayList<card> datalist = new ArrayList<>();
    String s = null;

    Context cp = print.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Student");
        setContentView(R.layout.activity_print);
        tvtest = findViewById(R.id.tvtest);
        //tvtest.setTag("hiii");
        //tvtest.setText(tvtest.getTag().toString());
        //tvtest.setText("hello\ni am\nviral\nnice \nto \nmeet you");
        //tvtest.setLineSpacing(2,2);

        initViews();







       // lvStudent.setAdapter(adapter);
        //lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          /*  @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //arrayList.get(position);
                etStudent.setEnabled(true);
                etStudent.setText(" ");
                String r = etStudent.getText().toString();
                arrayList.set(position,r);
                adapter.notifyDataSetChanged();
                //lv.getSelectedItem();
            }
        });*/

        //List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        //String[] from = { "flag","txt","cur" };

       // SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_print, from);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1)
        {
            if(resultCode == RESULT_OK) {
                name = data.getStringExtra("name");
                 roll = data.getStringExtra("roll");
                 dob = data.getStringExtra("dob");
                 filepath = data.getStringExtra("filepath");

                    //s = "name:- "+name+"\nroll:- "+roll+"\ndob:- "+dob;
                    //datalist.add(new card("add"+s));
                   c("name:-"+name,"roll:-"+roll,"DOB"+dob,filepath);


                //tvStudentData.append("\n\nname:- "+name+"\nroll:- "+roll+"\ndob:- "+dob);
                /*arrayList.add(name);
                arrayList.add(roll);
                arrayList.add(dob);
                lvStudent.setAdapter(adapter);
                adapter.notifyDataSetChanged();*/
            }
        }
    }
    public void changeItem(int position, String text)
    {
        datalist.get(position).change(text);
    }
    private void c(final String name, final String roll, final String dob,final  String fpath) {

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layour = new LinearLayoutManager(this);
        recadapter = new studentAdapter(datalist);
        recyclerView.setLayoutManager(layour);
        recyclerView.setAdapter(recadapter);
        datalist.add(new card(name,roll,dob,fpath));
        recadapter.notifyDataSetChanged();
        recadapter.setOnItemClickLisner(new studentAdapter.OnItemClickLisne() {
            @Override
            public void onItemClick(int position) {
                Intent ii = new Intent(print.this,MainActivity.class);
                ii.putExtra("name",name);
                ii.putExtra("roll",roll);
                ii.putExtra("dob",dob);
                startActivity(ii);

                   // startActivityForResult(ii,1);


                changeItem(position,ii.getStringExtra("roll"));
                recadapter.notifyDataSetChanged();
            }
        });

    }


    private void initViews()
    {
       // btnAddStudent = findViewById(R.id.btnAddStudent);
        //btnAddStudent.setOnClickListener(this);
        //tvStudentData = findViewById(R.id.tv2);
        //btnDialog = findViewById(R.id.btnDialog);
        //btnDialog.setOnClickListener(this);
        btntab = findViewById(R.id.btntab);
        btntab.setOnClickListener(this);
        btnweb = findViewById(R.id.btnweb);
        btnweb.setOnClickListener(this);
        btnseek = findViewById(R.id.btnseek);
        btnseek.setOnClickListener(this);
        btnupseek = findViewById(R.id.btnseek_up);
        btnupseek.setOnClickListener(this);
        btnbro = findViewById(R.id.btnbro);
        btnbro.setOnClickListener(this);
        feb = findViewById(R.id.floatingActionButton);
        feb.setOnClickListener(this);
        btncontact = findViewById(R.id.btncontact);
        btncontact.setOnClickListener(this);
        btnside = findViewById(R.id.btnside);
        btnside.setOnClickListener(this);
        btnside2 = findViewById(R.id.btnside2);
        btnside2.setOnClickListener(this);
        btnviewbt = findViewById(R.id.btnviewbt);
        btnviewbt.setOnClickListener(this);
        btndialog = findViewById(R.id.btndialog);
        btndialog.setOnClickListener(this);
        btncal = findViewById(R.id.btncal);
        btncal.setOnClickListener(this);
        btnradio = findViewById(R.id.btnradio);
        btnradio.setOnClickListener(this);
        //lvStudent =findViewById(R.id.lvdata);
        //etStudent = findViewById(R.id.etEditStudent);
        //etStudent.setEnabled(false);
        //arrayList = new ArrayList<String>();
        //adapter = new ArrayAdapter<String>(print.this,R.layout.support_simple_spinner_dropdown_item,arrayList);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.btnAddStudent:
                Intent i = new Intent(print.this,MainActivity.class);
                //startActivity(i);
                startActivityForResult(i,1);
                break;*/
            case R.id.btndialog:
                callintentact(DialogActivity.class);

                //startActivityForResult(intent,1);
                break;
            case R.id.floatingActionButton:
                //showmsg();
                intent = new Intent(print.this,MainActivity.class);
                //startActivity(i);

                startActivityForResult(intent,1);
                break;
            case R.id.btncontact:
                callintentact(contactActivity.class);
                break;
            case R.id.btntab:
                callintentact(tabActivity.class);
                break;
            case R.id.btnside:
                callintentact(sidemenu.class);
                break;
            case R.id.btnside2:
                callintentact(sidemenu2.class);
                break;
            case R.id.btnweb:
                callintentact(web.class);
                break;
            case R.id.btnseek:
                callintentact(seekbar.class);
                break;
            case R.id.btnseek_up:
                callintentact(up_seek.class);
                break;
            case R.id.btnbro:
                callintentact(brodcasttest.class);
                break;
            case R.id.btncal:
                //intent = new Intent(print.this,calender.class);
                callintentact(calender.class);
                //startActivity(intent);
                break;
            case R.id.btnradio:
                callintentact(radio.class);
                break;
            case R.id.btnviewbt:

                if(btncontact.getVisibility()== View.GONE)
                {
                    btncontact.setVisibility(View.VISIBLE);
                    btndialog.setVisibility(View.VISIBLE);
                    btntab.setVisibility(View.VISIBLE);
                    btnside.setVisibility(View.VISIBLE);
                    btnside2.setVisibility(View.VISIBLE);
                    btnweb.setVisibility(View.VISIBLE);
                    btnseek.setVisibility(View.VISIBLE);
                    btnupseek.setVisibility(View.VISIBLE);
                    btnbro.setVisibility(View.VISIBLE);
                    btncal.setVisibility(View.VISIBLE);
                    btnradio.setVisibility(View.VISIBLE);

                }
                else
                {
                    btncontact.setVisibility(View.GONE);
                    btndialog.setVisibility(View.GONE);
                    btntab.setVisibility(View.GONE);
                    btnside.setVisibility(View.GONE);
                    btnside2.setVisibility(View.GONE);
                    btnweb.setVisibility(View.GONE);
                    btnseek.setVisibility(View.GONE);
                    btnupseek.setVisibility(View.GONE);
                    btnbro.setVisibility(View.GONE);
                    btncal.setVisibility(View.GONE);
                    btnradio.setVisibility(View.GONE);
                }
                break;
        }
    }


    void callintentact(Class classname) {
        Intent i = new Intent(print.this,classname);
        startActivity(i);
    }


    /*private void showmsg() {
        Toast.makeText(this, "this is floating", Toast.LENGTH_SHORT).show();
    }*/


}