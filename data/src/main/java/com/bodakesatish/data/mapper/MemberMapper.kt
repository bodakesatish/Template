package com.bodakesatish.data.mapper

import com.bodakesatish.data.mapper.base.Mapper
import com.bodakesatish.data.source.local.entity.MemberEntity
import com.bodakesatish.domain.model.Member

object MemberMapper : Mapper<MemberEntity, Member> {

    override fun MemberEntity.mapTo(): Member {
        return Member(id = id, firstName = firstName, lastName = lastName, mobile = mobile)
    }

    override fun Member.mapFrom(): MemberEntity {
        return MemberEntity(id = id, firstName = firstName, lastName = lastName, mobile = mobile)
    }

}