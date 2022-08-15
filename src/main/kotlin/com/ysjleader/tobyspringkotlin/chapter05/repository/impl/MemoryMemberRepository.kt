package com.ysjleader.tobyspringkotlin.chapter05.repository.impl

import com.ysjleader.tobyspringkotlin.chapter05.domain.Member
import com.ysjleader.tobyspringkotlin.chapter05.repository.MemberRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class MemoryMemberRepository: MemberRepository {

    private val map: MutableMap<String, Member> = mutableMapOf()
    private val log = LoggerFactory.getLogger(MemoryMemberRepository::class.java)

    override fun findByMemberIdAndPassword(id: String, password: String): Member {
        val findMember = map[id] ?: Member()
        if(password == findMember.password) return findMember
        return Member()
    }

    override fun findAll(): List<Member> {
        return map.values.toList()
    }

    override fun saveAll(memberList: List<Member>) {
        memberList.forEach {
            map[it.memberId] = it
        }
    }

    override fun save(member: Member): Member {
        map[member.memberId] = member
        log.info("Member Save : ${member}")
        return map[member.memberId]!!
    }
}