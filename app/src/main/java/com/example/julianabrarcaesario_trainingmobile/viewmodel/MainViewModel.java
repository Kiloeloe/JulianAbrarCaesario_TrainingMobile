package com.example.julianabrarcaesario_trainingmobile.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.julianabrarcaesario_trainingmobile.data.remote.ApiConfig;
import com.example.julianabrarcaesario_trainingmobile.data.remote.ApiService;
import com.example.julianabrarcaesario_trainingmobile.data.remote.NbaTeamItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<NbaTeamItem>> _nbaTeams = new MutableLiveData<>();
    public LiveData<List<NbaTeamItem>> getNbaTeamItems() {
        return _nbaTeams;
    }

    private final ApiService mApiService = ApiConfig.getApiService();

    public void callApi() {
        mApiService.getNbaTeams().enqueue(new Callback<List<NbaTeamItem>>() {
            @Override
            public void onResponse(Call<List<NbaTeamItem>> call, Response<List<NbaTeamItem>> response) {
                if (response.isSuccessful()) {
                    _nbaTeams.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<NbaTeamItem>> call, Throwable t) {

            }
        });
    }
}
