package basic.core.discount;

import basic.core.member.Grade;
import basic.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100; //가격의 10퍼센트를 리턴
        }else{ return 0;}



    }
}
