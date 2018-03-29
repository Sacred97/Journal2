public class Student {
    private long idStudent;
    private String name;
    private long Group;

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGroup() {
        return Group;
    }

    public void setGroup(long group) {
        Group = group;
    }

    public Student(long idStudent, String name, long group) {

        this.idStudent = idStudent;
        this.name = name;
        Group = group;
    }
}