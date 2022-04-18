package hello.core.discount

import hello.core.domain.DiscountPolicy
import hello.core.member.Grade
import hello.core.member.Member

class FixDiscountPolicy : DiscountPolicy {
    val DiscountPrice = 1000

    override fun discount(member: Member, price: Int): Int {
        return if(member.grade == Grade.VIP) DiscountPrice else 0
    }
}