package com.example.student;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.student.ui.first.FirstFragment;
import com.example.student.ui.secound.SecoundFragment;

public class pageAdapter extends FragmentStatePagerAdapter  {

    int tabcount;

    public pageAdapter(FragmentManager fm,int tabcount) {

        super(fm);
        this.tabcount = tabcount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                FirstFragment firstFragment = new FirstFragment();
                return firstFragment;

            case 1:
                SecoundFragment secoundFragment = new SecoundFragment();
                return secoundFragment;
            case 2:
                print print = new print();
                //return print;
                //MainActivity mainActivity = new MainActivity();
                //return mainActivity;

            default:
                return null;


        }

    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
