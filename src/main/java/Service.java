import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Service {
    private static final String URL = "jdbc:mysql://localhost:3306/journal";

    public static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "root");
        properties.put("useSSL", "true");
        properties.put("serverTimezone", "Europe/Moscow");
        return properties;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, getProperties());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public static ArrayList<Attendances> selectUsers() {
        String query = "SELECT attendances.idAttendance, students.Student, groups.numberGroup, lessons.Lesson, attendances.Data, attendances.State\n" +
                "FROM attendances, students, groups, lessons\n" +
                "WHERE attendances.student = students.idStudent and attendances.Group = groups.idGroup and attendances.Lesson = lessons.idLesson;";
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        ArrayList<Attendances> resultList = new ArrayList<Attendances>();
        try {
            while (resultSet.next()) {
                long idAttendance = resultSet.getLong("idAttendance");
                String Student = resultSet.getString("Student");
                String numberGroup = resultSet.getString("numberGroup");
                String Lesson = resultSet.getString("Lesson");
                Date Data = resultSet.getDate("Data");
                String State = resultSet.getString("State");
                resultList.add(new Attendances(idAttendance, Student, numberGroup, Lesson, Data, State));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultList;
    }
    public static boolean addStudent(Attendances attendances) {
        String query = "INSERT INTO attendances (Student, attendances.Group, Lesson, Data, State) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, attendances.getStudent());
            preparedStatement.setString(2, attendances.getNumberGroup());
            preparedStatement.setString(3, attendances.getLesson());
            preparedStatement.setDate(4, attendances.getData());
            preparedStatement.setString(5, attendances.getState());
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean updateStudent(Attendances attendances) {
        /*String query = "UPDATE attendances SET Student = ?, numberGroup = ?, Lesson = ?, " +
                "Data = ?, State = ? WHERE idAttendance = ? ";*/
        String query = "UPDATE attendances SET Data = ?, State = ? WHERE idAttendance = ?";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            //preparedStatement.setString(1, attendances.getStudent());
            //preparedStatement.setString(2, attendances.getNumberGroup());
           // preparedStatement.setString(3, attendances.getLesson());
            preparedStatement.setDate(1, attendances.getData());
            preparedStatement.setString(2, attendances.getState());
            preparedStatement.setLong(3, attendances.getIdAttendance());
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static ArrayList<Student> students() {
        String query = "SELECT * FROM students";
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        ArrayList<Student> resultList = new ArrayList<Student>();
        try {
            while (resultSet.next()) {
                long id = resultSet.getLong("idStudent");
                String name = resultSet.getString("Student");
                Date birth = resultSet.getDate("BirthDate");
                String Group1 = resultSet.getString("Group");
                resultList.add(new Student(id, name, birth, Group1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultList;
    }
}
