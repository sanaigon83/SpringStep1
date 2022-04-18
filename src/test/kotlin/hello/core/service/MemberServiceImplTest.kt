package hello.core.service

import hello.core.AppConfig
import hello.core.member.Grade
import hello.core.member.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class MemberServiceImplTest {

    lateinit var memberService: MemberService

    @BeforeEach
    fun beforeEach() {
        memberService = AppConfig().getMemberService()
    }

    @Test
    fun join() {
        val member = Member(1, "memberA", Grade.VIP)
        memberService.join(member)
        val findMember = memberService.findMember(member.id)
        assertThat(member).isEqualTo(findMember)
    }
}