package com.ysjleader.tobyspringkotlin.chapter05.repository

import com.ysjleader.tobyspringkotlin.chapter05.domain.Member

interface MemberRepository {

    fun findByMemberIdAndPassword(id: String, password: String): Member

    fun findAll(): List<Member>

    fun saveAll(memberList: List<Member>)

    fun save(member: Member): Member
}