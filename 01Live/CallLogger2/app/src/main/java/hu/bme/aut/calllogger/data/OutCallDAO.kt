package hu.bme.aut.calllogger.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface OutCallDAO {

    @Query("SELECT * FROM outcall")
    fun getAllCalls() : LiveData<List<OutCallEntity>>

    @Insert
    fun addCall(outCallEntity: OutCallEntity) : Long

}