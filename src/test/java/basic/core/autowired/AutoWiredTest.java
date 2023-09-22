package basic.core.autowired;

import basic.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutWiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
    //호출 안됨, 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출되지 않는다.
    @Autowired(required = false)//true 일 경우 예외가 터진다.
    public void setNoBean1(Member member) {
        System.out.println("setNoBean1 = " + member);
    }

    //null 호출, 자동 주입할 대상이 없으면 null이 입력된다.
    @Autowired
    public void setNoBean2(@Nullable Member member) {
        System.out.println("setNoBean2 = " + member);
        }
        //Optional.empty 호출, 자동 주입할 대상이 없으면 호출된다.
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> member) {
            System.out.println("setNoBean3 = " + member);
        }
    }

}
