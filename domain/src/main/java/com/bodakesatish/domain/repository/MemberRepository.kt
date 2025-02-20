package com.bodakesatish.domain.repository

import com.bodakesatish.domain.model.Member
import kotlinx.coroutines.flow.Flow

interface MemberRepository {
    fun getMember(): Flow<List<Member>>
    fun addMember(member: Member)
    fun updateMember(member: Member)
    fun deleteMember(member: Member)
}