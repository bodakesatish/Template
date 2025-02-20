package com.bodakesatish.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = MemberEntity.TABLE_NAME)
data class MemberEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(Columns.ID)
    val id: Int = 0,
    @ColumnInfo(Columns.FIRST_NAME)
    val firstName: String,
    @ColumnInfo(Columns.LAST_NAME)
    val lastName: String,
    @ColumnInfo(Columns.MOBILE)
    val mobile: String
) {

    companion object {
        const val TABLE_NAME = "scheme"
    }

    internal object Columns {
        internal const val ID = "id"
        internal const val FIRST_NAME = "firstName"
        internal const val LAST_NAME = "lastName"
        internal const val MOBILE = "mobile"
    }

}