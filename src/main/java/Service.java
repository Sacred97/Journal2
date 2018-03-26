import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Service {
    private static final String URL = "jdbc:mysql://localhost:3306/db_Test";

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
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public static ArrayList<User> selectUsers() {
        String query = "SELECT * FROM users";
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        ArrayList<User> resultList = new ArrayList<User>();
        try {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                boolean gender = resultSet.getBoolean("gender");
                Date birthDate = resultSet.getDate("birth_date");
                resultList.add(new User(id, name, login, password, gender, birthDate));
            }
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return resultList;
    }

}
