package com.example.julianabrarcaesario_trainingmobile.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.julianabrarcaesario_trainingmobile.data.local.NbaTeamDao;
import com.example.julianabrarcaesario_trainingmobile.data.local.NbaTeamRoomDatabase;
import com.example.julianabrarcaesario_trainingmobile.data.remote.NbaTeamItem;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NbaTeamRepository {
    private final NbaTeamDao mNbaTeamDao;
    private final ExecutorService mExecutorService;

    public NbaTeamRepository(Application application){

        mExecutorService = Executors.newSingleThreadExecutor();
        //pake function yg dibikin di teamroom database
        NbaTeamRoomDatabase db = NbaTeamRoomDatabase.getDatabase(application);
        mNbaTeamDao = db.mNbaTeamDao();

    }

    //asynchronous
    public LiveData<List<NbaTeamItem>> getNbaItems(){
        return mNbaTeamDao.getNbaTeams();
    }

    //synchronous
    //final biar gabisa diubah
    public void insert(final NbaTeamItem nbaTeamItem){
        mExecutorService.execute(()->mNbaTeamDao.insert(nbaTeamItem));
    }
}
