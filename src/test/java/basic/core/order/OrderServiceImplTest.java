package basic.core.order;

import basic.core.discount.FixDiscountPolicy;
import basic.core.member.Grade;
import basic.core.member.Member;
import basic.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import basic.core.AppConfig;
import basic.core.member.Grade;
import basic.core.member.Member;
import basic.core.member.MemberService;
import basic.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import basic.core.order.Order;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order= orderService.createOrder(1L, "itemA", 10000 );
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}