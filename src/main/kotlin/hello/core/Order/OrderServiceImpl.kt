package hello.core.Order

import hello.core.domain.DiscountPolicy
import hello.core.domain.OrderService
import hello.core.repository.MemberRepository

class OrderServiceImpl(
    val memberRepository: MemberRepository,
    val discountPolicy: DiscountPolicy
) : OrderService {
    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)
        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}