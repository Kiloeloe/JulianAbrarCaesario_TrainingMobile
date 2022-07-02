package com.example.julianabrarcaesario_trainingmobile.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.julianabrarcaesario_trainingmobile.data.remote.NbaTeamItem;

//@database parameter nya minta entities = array entity
//version itu versi dari database
@Database(entities = {NbaTeamItem.class}, version = 1)
public abstract class NbaTeamRoomDatabase extends RoomDatabase {
    public abstract NbaTeamDao mNbaTeamDao();

    public NbaTeamRoomDatabase(){
    }

    //singleton -> object database yang dibuat cuman 1 jadi reusable
    private static NbaTeamRoomDatabase INSTANCE;

    public static NbaTeamRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            //sinkronisasi apakah roomdatabase nya udah ada apa blm
            synchronized (NbaTeamRoomDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), NbaTeamRoomDatabase.class, "nba_database").build();
            }
        }
        return INSTANCE;
    }
}
