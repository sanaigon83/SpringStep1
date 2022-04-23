package hello.core

import hello.core.Order.OrderServiceImpl
import hello.core.discount.FixDiscountPolicy
import hello.core.discount.RateDiscountPolicy
import hello.core.domain.OrderService
import hello.core.repository.MemoryMemberRepository
import hello.core.service.MemberService
import hello.core.service.MemberServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
 */

@Configuration
class AppConfig {

    @Bean
    fun getMemberService(): MemberService {
        return MemberServiceImpl(memberRepository())
    }

    @Bean
    fun getOrderService(): OrderService {
        return OrderServiceImpl(memberRepository(), discountPolicy())
    }

    @Bean
    fun discountPolicy() = FixDiscountPolicy()

    @Bean
    fun memberRepository() = MemoryMemberRepository()
}