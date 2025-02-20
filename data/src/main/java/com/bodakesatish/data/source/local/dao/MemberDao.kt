package com.bodakesatish.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bodakesatish.data.source.local.entity.MemberEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MemberDao {

    @Insert
    suspend fun insertMember(customerEntity: MemberEntity): Long

    @Update
    suspend fun updateMember(customerEntity: MemberEntity): Int

    @Query("DELETE FROM ${MemberEntity.TABLE_NAME} WHERE ${MemberEntity.Columns.ID} = :id")
    suspend fun deleteMember(id: Int)

    @Query("SELECT * FROM ${MemberEntity.TABLE_NAME}")
    fun getAllMember(): Flow<List<MemberEntity>>

}