package com.example.julianabrarcaesario_trainingmobile.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.julianabrarcaesario_trainingmobile.R;

public class HomeFragment extends Fragment {

    TextView username;
    Button logout;
    AlertDialog dialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        username = v.findViewById(R.id.tv_username);
        logout = v.findViewById(R.id.btn_logout);

        Intent intent = getActivity().getIntent();
        String tempUsername = intent.getStringExtra("account_username");

        username.setText(tempUsername);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());


        builder.setTitle("Confirmation").setMessage("Are you sure you want to logout?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent logoutIntent = new Intent(getContext(),LoginActivity.class);
                startActivity(logoutIntent);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
                Toast.makeText(getActivity(), "Logout Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        dialog = builder.create();


        logout.setOnClickListener(view -> {
            dialog.show();
        });
        return v;
    }
}