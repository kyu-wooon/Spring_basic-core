package basic.core.order;
import basic.core.discount.DiscountPolicy;
import basic.core.discount.FixDiscountPolicy;
import basic.core.member.Member;
import basic.core.member.MemberRepository;
import basic.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    //1. 회원정보와, 상품 이름 가격 받음
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //2. 멤버 아이디로 멤버 조회 후 바탕으로 할인 정책 생성 후 주문 정보 리턴
        Member member = memberRepository.findById(memberId);
        int discountprice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountprice);

    }
}
