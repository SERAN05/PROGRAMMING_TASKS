import java.sql.*;

public class week_8_a {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/spotknack_task";
        String user = "root";
        String password = "12345";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String createDepartmentsTable = "CREATE TABLE IF NOT EXISTS Departments (" +
                    "department_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "department_name VARCHAR(100) UNIQUE NOT NULL)";
            statement.executeUpdate(createDepartmentsTable);

            String createStudentsTable = "CREATE TABLE IF NOT EXISTS Students (" +
                    "student_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100) NOT NULL, " +
                    "email VARCHAR(100) UNIQUE NOT NULL, " +
                    "department_id INT, " +
                    "age INT CHECK (age >= 18), " +
                    "FOREIGN KEY (department_id) REFERENCES Departments(department_id))";
            statement.executeUpdate(createStudentsTable);

            String createCoursesTable = "CREATE TABLE IF NOT EXISTS Courses (" +
                    "course_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "course_name VARCHAR(100) NOT NULL, " +
                    "department_id INT, " +
                    "FOREIGN KEY (department_id) REFERENCES Departments(department_id))";
            statement.executeUpdate(createCoursesTable);

            String createEnrollmentsTable = "CREATE TABLE IF NOT EXISTS Enrollments (" +
                    "enrollment_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "student_id INT, " +
                    "course_id INT, " +
                    "enrollment_date DATE, " +
                    "FOREIGN KEY (student_id) REFERENCES Students(student_id), " +
                    "FOREIGN KEY (course_id) REFERENCES Courses(course_id))";
            statement.executeUpdate(createEnrollmentsTable);

            System.out.println("Tables created successfully.");
        } catch (Exception e) {
            System.out.println("there is some error");
        }
    }
}
