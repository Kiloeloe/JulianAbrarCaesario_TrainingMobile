package com.example.julianabrarcaesario_trainingmobile.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.julianabrarcaesario_trainingmobile.data.remote.NbaTeamItem;

import java.util.List;

@Dao
public interface NbaTeamDao {
    @Insert
    void insert(NbaTeamItem nbaTeamItem);

    //parameter select * from nama database, ditentuin dari entity
    @Query("SELECT * from NbaTeamItem")
    LiveData<List<NbaTeamItem>> getNbaTeams();
}
