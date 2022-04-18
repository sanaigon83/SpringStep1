package hello.core.discount

import hello.core.member.Grade
import hello.core.member.Member
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RateDiscountPolicyTest {

    val discountPolicy = RateDiscountPolicy()

    @Test
    @DisplayName("VIP회원은 10%가 할인되어야 한다. ")
    fun vip_o() {
        val member = Member(1, "jkpark", Grade.VIP)

        val discount = discountPolicy.discount(member, 10000)

        Assertions.assertThat(discount).isEqualTo(1000)
    }

    @Test
    @DisplayName("Basic회원은 할인이되면 안된다.")
    fun basic_o() {
        val member = Member(1, "jkpark", Grade.BASIC)
        val discount = discountPolicy.discount(member, 10000)
        Assertions.assertThat(discount).isEqualTo(0)
    }
}