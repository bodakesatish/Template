package com.bodakesatish.data

import com.bodakesatish.data.repository.MemberRepositoryImpl
import com.bodakesatish.data.source.local.dao.MemberDao
import com.bodakesatish.domain.model.Member
import com.bodakesatish.domain.repository.MemberRepository
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MemberRepositoryTest {

    private lateinit var repository: MemberRepository
    private val mockDao = mockk<MemberDao>(relaxed = true)

    @Before
    fun setUp() {
        repository = MemberRepositoryImpl(mockDao)
    }

    @Test
    fun addMember() = runBlocking {
        val user = Member(1, "John", "john@example.com", "1234567890")

        val response = repository.addMember(user)

        assertTrue(response)
        coVerify { mockDao.insertMember(any()) }
    }
}