package com.bodakesatish.domain.usecases

import com.bodakesatish.domain.model.Member
import com.bodakesatish.domain.repository.MemberRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UpdateMemberUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(member: Member) {
        memberRepository.updateMember(member)
    }
}