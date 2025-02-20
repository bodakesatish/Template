package com.bodakesatish.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bodakesatish.data.source.local.entity.MemberEntity

@Database(entities = [MemberEntity::class], version = 1)
abstract class MemberDatabase : RoomDatabase() {
    abstract fun memberDao(): MemberEntity
}