package basic.core.member;

public interface MemberRepository {

    void save(Member member); //멤버 저장

    Member findById(Long memberId); // ID를 통한 멤버 찾기
}