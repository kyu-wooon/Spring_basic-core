package basic.core.member;

public class MemberServiceImpl implements MemberService {
    //메모리 저장소 생성
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);//멤버 저장
    }

    @Override //멤버의 아이디를 받아, findbyId로 조회한 결과 return
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
