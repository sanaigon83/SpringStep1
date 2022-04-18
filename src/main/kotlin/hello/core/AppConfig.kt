package hello.core

import hello.core.Order.OrderServiceImpl
import hello.core.discount.RateDiscountPolicy
import hello.core.domain.OrderService
import hello.core.repository.MemoryMemberRepository
import hello.core.service.MemberService
import hello.core.service.MemberServiceImpl

/**
 * AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
 */
class AppConfig {
    fun getMemberService(): MemberService {
        return MemberServiceImpl(MemoryMemberRepository())
    }

    fun getOrderService(): OrderService {
        return OrderServiceImpl(MemoryMemberRepository(), RateDiscountPolicy())
    }
}