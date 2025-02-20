package com.bodakesatish.domain.usecases

import com.bodakesatish.domain.model.Member
import com.bodakesatish.domain.repository.MemberRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddMemberUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(member: Member): Boolean {
        return memberRepository.addMember(member)
    }
}