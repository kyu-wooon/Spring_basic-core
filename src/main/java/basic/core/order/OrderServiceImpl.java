package basic.core.order;
import basic.core.discount.DiscountPolicy;
import basic.core.discount.FixDiscountPolicy;

import basic.core.discount.RateDiscountPolicy;
import basic.core.member.Member;
import basic.core.member.MemberRepository;
import basic.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /* 필드 주입 방법은 사용하지 않는 편이 좋다 .
    @Autowired private  MemberRepository memberRepository;
    @Autowired private  DiscountPolicy discountPolicy;
    */
    /*setter 방식
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }*/

    @Autowired//생성자가 하나일 때에는 Autowired생략이 가능하다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    //1. 회원정보와, 상품 이름 가격 받음
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //2. 멤버 아이디로 멤버 조회 후 바탕으로 할인 정책 생성 후 주문 정보 리턴
        Member member = memberRepository.findById(memberId);
        int discountprice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountprice);

    }


    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
