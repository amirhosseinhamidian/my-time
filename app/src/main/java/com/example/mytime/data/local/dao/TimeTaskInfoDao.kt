package com.example.mytime.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import com.example.mytime.data.local.entities.TimeTaskInfoEntity

@Dao
interface TimeTaskInfoDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(timeTaskInfoEntity: TimeTaskInfoEntity)


}