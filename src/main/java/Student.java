import java.sql.Date;

public class Student {
    private long id;
    private String name;
    private Date birth;
    private String Group1;

    public Student(long id, String name, Date birth, String group1) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        Group1 = group1;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getGroup1() {
        return Group1;
    }

    public void setGroup1(String group1) {
        Group1 = group1;
    }
}