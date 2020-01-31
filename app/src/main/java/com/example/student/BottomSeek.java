package com.example.student;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSeek extends BottomSheetDialogFragment {

    private Bottomtext bst;
    Button btnseekfs,btnseeksec;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.openseek, container, false);
        btnseekfs = view.findViewById(R.id.btnseekfs);
        btnseeksec = view.findViewById(R.id.btnseeksec);
        btnseekfs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bst.OnClickeseekbtn("btn fs click");
                dismiss();
            }
        });
        btnseeksec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bst.OnClickeseekbtn("btn sec click");
                dismiss();
            }
        });

        return view;
    }

    public interface Bottomtext {
        void OnClickeseekbtn(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            bst = (Bottomtext) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
