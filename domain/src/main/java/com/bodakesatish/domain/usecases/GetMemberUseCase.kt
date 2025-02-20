package com.bodakesatish.domain.usecases

import com.bodakesatish.domain.model.Member
import com.bodakesatish.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetMemberUseCase @Inject constructor(
    private val memberRepository: MemberRepository
) {
    operator fun invoke(): Flow<List<Member>> {
        return memberRepository.getMember()
    }
}