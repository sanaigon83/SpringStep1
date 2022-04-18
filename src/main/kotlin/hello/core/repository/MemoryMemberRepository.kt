package hello.core.repository

import hello.core.member.Member
import java.util.concurrent.ConcurrentHashMap

class MemoryMemberRepository : MemberRepository {

    val store = ConcurrentHashMap<Long, Member>();

    override fun save(member: Member) {
        store.putIfAbsent(member.id, member)
    }

    override fun findById(memberId: Long): Member {
        return store.get(memberId)!!
    }
}