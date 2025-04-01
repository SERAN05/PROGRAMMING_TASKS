import java.sql.*;

public class week_8_c {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/spotknack_task";
        String user = "root";
        String password = "12345";

        Connection connection = DriverManager.getConnection(url, user, password);

        // INNER JOIN
        String query1 = "SELECT students.name, departments.department_name " +
                "FROM students " +
                "INNER JOIN departments ON students.department_id = departments.department_id";
        Statement stmt1 = connection.createStatement();
        ResultSet resultSet1 = stmt1.executeQuery(query1);
        while (resultSet1.next()) {
            System.out.println(resultSet1.getString("name") + " - " + resultSet1.getString("department_name"));
        }

        String query2 = "SELECT courses.course_name, departments.department_name " +
                "FROM courses " +
                "INNER JOIN departments ON courses.department_id = departments.department_id";
        Statement stmt2 = connection.createStatement();
        ResultSet resultSet2 = stmt2.executeQuery(query2);
        while (resultSet2.next()) {
            System.out.println(resultSet2.getString("course_name") + " - " + resultSet2.getString("department_name"));
        }

        String query3 = "SELECT students.name, courses.course_name " +
                "FROM students " +
                "JOIN enrollments ON students.student_id = enrollments.student_id " +
                "JOIN courses ON enrollments.course_id = courses.course_id";
        Statement stmt3 = connection.createStatement();
        ResultSet resultSet3 = stmt3.executeQuery(query3);
        while (resultSet3.next()) {
            System.out.println(resultSet3.getString("name") + " - " + resultSet3.getString("course_name"));
        }

        // LEFT JOIN
        String query4 = "SELECT students.name, courses.course_name " +
                "FROM students " +
                "LEFT JOIN enrollments ON students.student_id = enrollments.student_id " +
                "LEFT JOIN courses ON enrollments.course_id = courses.course_id";
        Statement stmt4 = connection.createStatement();
        ResultSet resultSet4 = stmt4.executeQuery(query4);
        while (resultSet4.next()) {
            System.out.println(resultSet4.getString("name") + " - " + resultSet4.getString("course_name"));
        }

        connection.close();
    }
}
