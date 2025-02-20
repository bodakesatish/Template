package com.bodakesatish.domain.usecases

import com.bodakesatish.domain.model.Member
import com.bodakesatish.domain.repository.MemberRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteMemberUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    operator fun invoke(member: Member) {
        memberRepository.addMember(member)
    }
}