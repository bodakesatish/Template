package com.bodakesatish.domain.repository

import com.bodakesatish.domain.model.Member
import kotlinx.coroutines.flow.Flow

interface MemberRepository {
    fun getMember(): Flow<List<Member>>
    suspend fun addMember(member: Member) : Boolean
    suspend fun updateMember(member: Member)
    suspend fun deleteMember(member: Member)
}