package com.example.julianabrarcaesario_trainingmobile.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.julianabrarcaesario_trainingmobile.R;


public class SecondFragment extends Fragment {
    Button team;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_second, container, false);
        team = v.findViewById(R.id.btn_team);


        team.setOnClickListener(view ->{
            Intent teamIntent = new Intent(getActivity(),ContentActivity.class);
            startActivity(teamIntent);
        });
        return v;
    }
}