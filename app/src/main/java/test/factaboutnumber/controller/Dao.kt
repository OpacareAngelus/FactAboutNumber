package test.factaboutnumber.controller

import androidx.room.*
import androidx.room.Dao
import test.factaboutnumber.model.NumberDetails


@Dao
interface Dao {

    @Insert
    fun insertNumber(number: NumberDetails)

    @Query("SELECT *  FROM NumbersFact")
    fun getAllNumbers(): List<NumberDetails>
}