package com.example.student.ui.first;

import androidx.annotation.ContentView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.student.DialogActivity;
import com.example.student.MainActivity;
import com.example.student.R;

public class FirstFragment extends Fragment {

    private FirstViewModel mViewModel;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main,container,false);

        //Context context = getContext();
       /* FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,MainActivity.class);
        fragmentTransaction.commit();
        //final Dialog dialog = new Dialog(FirstFragment.class);
        //getContext();*/
        //Context context = getContext(R.layout.activity_main);
        //dialog.setContentView(R.layout.activity_main);


        return view ;
        //return inflater.inflate(R.layout.activity_main, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FirstViewModel.class);

        // TODO: Use the ViewModel
    }

}
