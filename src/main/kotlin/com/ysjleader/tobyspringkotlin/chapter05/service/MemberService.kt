package com.ysjleader.tobyspringkotlin.chapter05.service

import com.ysjleader.tobyspringkotlin.chapter05.domain.Member
import com.ysjleader.tobyspringkotlin.chapter05.dto.request.MemberDTO
import com.ysjleader.tobyspringkotlin.chapter05.repository.MemberRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {

    private val log = LoggerFactory.getLogger(MemberService::class.java)

    fun singUp(memberDTO: MemberDTO): MemberDTO {
        val member: Member = Member(
            memberId = memberDTO.memberId,
            password = memberDTO.password,
            nickName = memberDTO.nickName
        )
        val saveMember = memberRepository.save(member)

        return MemberDTO(
            memberId = saveMember.memberId,
            nickName = saveMember.nickName
        )
    }

    fun login(id: String, password: String): MemberDTO {
        val findMember = memberRepository.findByMemberIdAndPassword(id = id, password = password)
        findMember.plusLoginCount()
        val saveMember = memberRepository.save(findMember)
        return MemberDTO(
            memberId = saveMember.memberId,
            nickName = saveMember.nickName
        )
    }

    fun updateMemberLevels(): String {
        val memberList = memberRepository.findAll()
        memberList.forEach {
            it.checkAndUpdateLevel()
        }
        return "OK"
    }
}