package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class radio extends AppCompatActivity {
    RadioButton rdbmale,rdbfemale;
    RadioGroup rbg;
    Button btnsub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        rdbmale = findViewById(R.id.rdmale);
        rdbfemale = findViewById(R.id.rdfemale);
        rbg = findViewById(R.id.rbg);
        btnsub = findViewById(R.id.btnsub);

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rbclick = rbg.findViewById(rbg.getCheckedRadioButtonId());
                Toast.makeText(radio.this, rbclick.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        rbg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                
                if(null != rb && checkedId > -1)
                {
                    Toast.makeText(radio.this, rb.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
