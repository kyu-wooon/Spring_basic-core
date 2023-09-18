package basic.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
//import java.util.*;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //멤버아이디, 멤버 저장소

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //멤버아이디, 멤버 저장

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //멤버아이디 key 값을 통해 멤버 객체 get
    }
}