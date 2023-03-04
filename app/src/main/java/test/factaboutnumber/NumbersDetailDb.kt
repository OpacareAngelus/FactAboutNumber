package test.factaboutnumber

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import test.factaboutnumber.controller.Dao
import test.factaboutnumber.model.NumberDetails

@Database(entities = [NumberDetails::class], version = 1)
abstract class NumbersDetailDb : RoomDatabase() {

    abstract fun getDao(): Dao

    companion object {
        val nameDB = "NumbersDetailListDB"

        fun getDb(context: Context): NumbersDetailDb {
            return Room.databaseBuilder(
                context.applicationContext, NumbersDetailDb::class.java,
                nameDB
            ).build()
        }
    }
}