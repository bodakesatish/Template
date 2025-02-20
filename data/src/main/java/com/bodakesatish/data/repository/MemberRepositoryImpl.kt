package com.bodakesatish.data.repository

import com.bodakesatish.data.mapper.MemberMapper
import com.bodakesatish.data.mapper.MemberMapper.mapFrom
import com.bodakesatish.data.mapper.MemberMapper.mapTo
import com.bodakesatish.data.source.local.dao.MemberDao
import com.bodakesatish.domain.model.Member
import com.bodakesatish.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
    private val memberDao: MemberDao
) : MemberRepository {

    override fun getMember(): Flow<List<Member>> {
        return memberDao.getAllMember()
            .map { members ->
                members.map { member ->
                    member.mapTo()
                }
            }
    }

    override suspend fun addMember(member: Member): Boolean {
        val id = memberDao.insertMember(member.mapFrom())
        return id > 0
    }

    override suspend fun updateMember(member: Member) {
        memberDao.updateMember(member.mapFrom())
    }

    override suspend fun deleteMember(member: Member) {
        memberDao.deleteMember(member.id)
    }

}