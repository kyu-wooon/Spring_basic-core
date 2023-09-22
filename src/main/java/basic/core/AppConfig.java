package basic.core;

import basic.core.discount.FixDiscountPolicy;
import basic.core.discount.DiscountPolicy;
import basic.core.discount.RateDiscountPolicy;
import basic.core.member.MemberService;
import basic.core.member.MemberServiceImpl;
import basic.core.member.MemoryMemberRepository;
import basic.core.member.MemberRepository;
import basic.core.order.OrderService;
import basic.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//구성정보 어노테이션
@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

        @Bean
        public MemberService memberService() {
            System.out.println("call AppConfig.memberService");
            return new MemberServiceImpl(memberRepository());
        }
        @Bean
        public OrderService orderService() {
            System.out.println("call AppConfig.orderService");
/*            return new OrderServiceImpl(
                    memberRepository(),
                    discountPolicy());*/
            return null;
        }
        @Bean
        public MemberRepository memberRepository() {
            System.out.println("call AppConfig.memberRepository");
            return new MemoryMemberRepository();
        }
        @Bean
        public DiscountPolicy discountPolicy() {
           // return new FixDiscountPolicy();
            return new RateDiscountPolicy();
        }
    }