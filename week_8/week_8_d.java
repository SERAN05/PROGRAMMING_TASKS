import java.sql.*;

public class week_8_d {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/spotknack_task";
        String user = "root";
        String password = "12345";

        Connection connection = DriverManager.getConnection(url, user, password);

        String updateEmailQuery = "UPDATE students SET email = 'newemail@example.com' WHERE student_id = 2";
        Statement stmt1 = connection.createStatement();
        int rowsUpdated = stmt1.executeUpdate(updateEmailQuery);
        if (rowsUpdated > 0) {
            System.out.println("Email updated successfully.");
        }

        String deleteEnrollmentsQuery = "DELETE FROM enrollments WHERE student_id = 4";
        Statement stmt2 = connection.createStatement();
        int enrollmentsDeleted = stmt2.executeUpdate(deleteEnrollmentsQuery);
        if (enrollmentsDeleted > 0) {
            System.out.println("Related enrollment records deleted successfully.");
        }

        String deleteStudentQuery = "DELETE FROM students WHERE student_id = 4";
        Statement stmt3 = connection.createStatement();
        int rowsDeleted = stmt3.executeUpdate(deleteStudentQuery);
        if (rowsDeleted > 0) {
            System.out.println("Student record deleted successfully.");
        }

        connection.close();
    }
}
