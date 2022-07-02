package com.example.julianabrarcaesario_trainingmobile.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.julianabrarcaesario_trainingmobile.R;
import com.example.julianabrarcaesario_trainingmobile.databinding.ActivityContentBinding;
import com.example.julianabrarcaesario_trainingmobile.viewmodel.MainViewModel;


public class ContentActivity extends AppCompatActivity {

    private ActivityContentBinding mBinding;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityContentBinding.inflate(getLayoutInflater());


        mMainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mMainViewModel.callApi();

        mBinding.rvNbaTeams.setLayoutManager(new LinearLayoutManager(this));

        mMainViewModel.getNbaTeamItems().observe(this, nbaTeamItems -> {
            mBinding.rvNbaTeams.setAdapter(new NbaTeamAdapter(nbaTeamItems));
        });

        setContentView(mBinding.getRoot());
    }
}