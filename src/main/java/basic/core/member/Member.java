package basic.core.member;

public class Member {

    private Long id; //멤버의 아이디
    private String name; //멤버의 이름
    private Grade grade; // 멤버의 등급

    public Member(Long id, String name, Grade grade) {
        //멤버 생성자
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //각 객체 getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}