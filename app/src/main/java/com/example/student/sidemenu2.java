package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class sidemenu2 extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{
    public DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidemenu2);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbarside2);
        //Toolbar toolbar = findViewById(R.id.sidetoll2);
        //Toolbar toolbar = findViewById(R.id.sidetoll2);
        //Toolbar toolbar = findViewById(R.id.toolbarside2);
        //setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.side_layout2);
       // NavigationView navigationView = findViewById(R.id.side_layout2);
       // navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.bar_open,R.string.bar_Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        /*if(savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.side_layout2, new Add_student_fragment()).commit();
            navigationView.setCheckedItem(R.id.main);
        }*/

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.main:
                getSupportFragmentManager().beginTransaction().replace(R.id.side_layout2, new Add_student_fragment()).commit();

                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
