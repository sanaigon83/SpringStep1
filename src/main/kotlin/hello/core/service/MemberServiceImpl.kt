package hello.core.service

import hello.core.member.Member
import hello.core.repository.MemoryMemberRepository

class MemberServiceImpl : MemberService {

    val repo = MemoryMemberRepository()

    override fun join(member: Member) {
        return repo.save(member)
    }

    override fun findMember(memberId: Long): Member {
        return repo.findById(memberId)
    }
}