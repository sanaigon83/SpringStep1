package hello.core.singleton

import hello.core.AppConfig
import hello.core.service.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class SingletonTest {


    @Test
    @DisplayName("싱글톤 테스트")
    fun pureConainter(){
        val ac = AppConfig()
        println(Singleton.getInstance())
        println(Singleton.getInstance())
        println(Singleton.getInstance())
        Assertions.assertThat(Singleton.getInstance()).isSameAs(Singleton.getInstance())
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    fun springContainer() {
        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        println(ac.getBean("getMemberService", MemberService::class.java))
        Assertions.assertThat(ac.getBean("getMemberService", MemberService::class.java)).isSameAs(ac.getBean("getMemberService", MemberService::class.java))
    }
}