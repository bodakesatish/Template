package com.bodakesatish.data.di

import com.bodakesatish.data.repository.MemberRepositoryImpl
import com.bodakesatish.domain.repository.MemberRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface  DataModule {

    @Binds
    @Singleton
    fun bindMemberRepository(memberRepositoryImpl: MemberRepositoryImpl): MemberRepository

}