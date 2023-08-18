package basic.core.discount;
import basic.core.member.Grade;
import basic.core.member.Member;

public class  FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return discountFixAmount; //VIP면 1000원 할인
        }
        return 0;
    }
}