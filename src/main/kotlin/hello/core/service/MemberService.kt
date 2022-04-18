package hello.core.service

import hello.core.member.Member

interface MemberService {
    fun join(member: Member)
    fun findMember(memberId: Long): Member
}