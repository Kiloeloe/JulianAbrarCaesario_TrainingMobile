package com.example.julianabrarcaesario_trainingmobile.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.julianabrarcaesario_trainingmobile.R;
import com.example.julianabrarcaesario_trainingmobile.data.remote.NbaTeamItem;
import com.example.julianabrarcaesario_trainingmobile.databinding.ActivityContentBinding;
import com.example.julianabrarcaesario_trainingmobile.viewmodel.MainViewModel;
import com.example.julianabrarcaesario_trainingmobile.viewmodel.MainViewModelFactory;


public class ContentActivity extends AppCompatActivity {

    private ActivityContentBinding mBinding;
    private MainViewModel mMainViewModel;
    private NbaTeamAdapter mNbaTeamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityContentBinding.inflate(getLayoutInflater());


        mMainViewModel = new ViewModelProvider(this, new MainViewModelFactory(getApplication())).get(MainViewModel.class);
        mMainViewModel.callApi();

        mBinding.rvNbaTeams.setLayoutManager(new LinearLayoutManager(this));

        mMainViewModel.getNbaTeamItems().observe(this, nbaTeamItems -> {
            mNbaTeamAdapter = new NbaTeamAdapter(nbaTeamItems);
            mNbaTeamAdapter.setOnItemClickCallback(new NbaTeamAdapter.OnItemClickCallback() {
                @Override
                public void onInsertClick(NbaTeamItem nbaTeamItem) {
                    mMainViewModel.insertNbaItem(nbaTeamItem);
                }
            });

            mBinding.rvNbaTeams.setAdapter(mNbaTeamAdapter);
        });

        mBinding.btnOfflineMode.setOnClickListener(view -> {
            startActivity(new Intent(this, OfflineActivity.class));
        });



        setContentView(mBinding.getRoot());
    }
}