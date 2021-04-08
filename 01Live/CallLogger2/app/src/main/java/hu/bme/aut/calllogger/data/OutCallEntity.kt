package hu.bme.aut.calllogger.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "outcall")
data class OutCallEntity(
    @PrimaryKey(autoGenerate = true) var callId: Long?,
    @ColumnInfo(name = "calldate") var callDate: String,
    @ColumnInfo(name = "phonenumber") var phonenumber: String) : Serializable