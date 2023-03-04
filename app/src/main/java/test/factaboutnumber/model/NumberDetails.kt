package test.factaboutnumber.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "NumbersFact")
@Parcelize
data class NumberDetails(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "number")
    val number: String? = null,
    @ColumnInfo(name = "fact")
    val interestFact: String? = null
) : Parcelable
