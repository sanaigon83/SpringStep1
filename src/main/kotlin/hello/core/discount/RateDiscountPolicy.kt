package hello.core.discount

import hello.core.domain.DiscountPolicy
import hello.core.member.Grade
import hello.core.member.Member

class RateDiscountPolicy : DiscountPolicy {
    val discountPercent = 10
    override fun discount(member: Member, price: Int): Int {
        return if(member.grade == Grade.VIP){
            price * discountPercent / 100
        }else {
            0
        }
    }
}