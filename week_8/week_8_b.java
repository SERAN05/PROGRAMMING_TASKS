import java.sql.*;

public class week_8_b {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/spotknack_task";
        String user = "root";
        String password = "12345";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String insertDepartments = "INSERT INTO Departments (department_name) VALUES " +
                    "('Computer Science'), ('Electrical Engineering'), ('Mechanical Engineering')";
            statement.executeUpdate(insertDepartments);

            String insertStudents = "INSERT INTO Students (name, email, department_id, age) VALUES " +
                    "('ram ', 'john@example.com', 1, 20), " +
                    "('bob ', 'jane@example.com', 2, 22), " +
                    "('shree ', 'robert@example.com', 1, 23), " +
                    "('tarun ', 'emily@example.com', 3, 21), " +
                    "('mathan ', 'james@example.com', 2, 24)";
            statement.executeUpdate(insertStudents);

            String insertCourses = "INSERT INTO Courses (course_name, department_id) VALUES " +
                    "('Data Structures', 1), ('Circuit Analysis', 2), ('Thermodynamics', 3), ('Algorithms', 1)";
            statement.executeUpdate(insertCourses);

            String insertEnrollments = "INSERT INTO Enrollments (student_id, course_id, enrollment_date) VALUES " +
                    "(1, 1, '2025-04-01'), (2, 2, '2025-04-01'), (3, 4, '2025-04-01'), " +
                    "(4, 3, '2025-04-01'), (5, 2, '2025-04-01')";
            statement.executeUpdate(insertEnrollments);

            System.out.println("Data inserted successfully.");
        } catch (Exception e) {
            System.out.println("there is some error");
        }
    }
}
