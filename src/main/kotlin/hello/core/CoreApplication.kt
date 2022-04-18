package hello.core

import hello.core.member.Grade
import hello.core.member.Member
import hello.core.service.MemberService
import hello.core.service.MemberServiceImpl
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoreApplication

fun main(args: Array<String>) {
    //runApplication<CoreApplication>(*args)
    val memberService = MemberServiceImpl()
    val member = Member(1, "jkpark", Grade.VIP)
    memberService.join(member)

    val obj = memberService.findMember(1)
    println("new Member = $member")
    println("find Member = $obj")

}
