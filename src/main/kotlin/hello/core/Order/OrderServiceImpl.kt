package hello.core.Order

import hello.core.discount.FixDiscountPolicy
import hello.core.discount.RateDiscountPolicy
import hello.core.domain.DiscountPolicy
import hello.core.domain.OrderService
import hello.core.repository.MemoryMemberRepository

class OrderServiceImpl : OrderService {

    val memberRepository = MemoryMemberRepository()
    //val disCountPolicy = FixDiscountPolicy()
    //val disCountPolicy = RateDiscountPolicy()
    lateinit var disCountPolicy: DiscountPolicy

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        val member = memberRepository.findById(memberId)
        val discountPrice = disCountPolicy.discount(member, itemPrice)
        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}