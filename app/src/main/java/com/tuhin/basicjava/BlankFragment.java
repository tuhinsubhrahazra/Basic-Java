package com.tuhin.basicjava;

import static com.tuhin.basicjava.MainActivity.arrayList;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class BlankFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        EditText name = view.findViewById(R.id.name);
        EditText roll = view.findViewById(R.id.roll);
        Button add = view.findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(new custom(name.getText().toString(),roll.getText().toString()));
                Objects.requireNonNull(getDialog()).dismiss();
            }
        });
        return view;
    }
}