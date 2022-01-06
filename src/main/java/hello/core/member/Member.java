package hello.core.member;

public class Member {

    private long id;
    private String name;
    private Gradle grade;

    public Member(long id, String name, Gradle grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gradle getGrade() {
        return grade;
    }

    public void setGrade(Gradle grade) {
        this.grade = grade;
    }
}
