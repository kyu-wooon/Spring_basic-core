package basic.core.member;

import basic.core.AppConfig;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();//멤버서비스 생성
        //MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP); // 멤버 객체 생성

        memberService.join(member); //멤버 회원가입 (저장소에 저장)

        Member findMember = memberService.findMember(1L); // 찾은 멤버 객체화
        System.out.println("new member = " + member.getName()); // member 이름 리턴
        System.out.println("find member = " + findMember.getName()); //findmember 이름 리턴
    }

}