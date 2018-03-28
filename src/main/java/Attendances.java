import java.sql.Date;

public class Attendances {
    private long idAttendance;
    private String Student;
    private long numberGroup;
    private String Lesson;
    private Date Data;
    private String State;

    public Attendances(long idAttendance, String student, long numberGroup, String lesson, Date data, String state) {
        this.idAttendance = idAttendance;
        Student = student;
        this.numberGroup = numberGroup;
        Lesson = lesson;
        Data = data;
        State = state;
    }

    public long getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(long idAttendance) {
        this.idAttendance = idAttendance;
    }

    public String getStudent() {
        return Student;
    }

    public void setStudent(String student) {
        Student = student;
    }

    public long getNumberGroup() {
        return numberGroup;
    }

    public void setNumberGroup(long numberGroup) {
        this.numberGroup = numberGroup;
    }

    public String getLesson() {
        return Lesson;
    }

    public void setLesson(String lesson) {
        Lesson = lesson;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}

