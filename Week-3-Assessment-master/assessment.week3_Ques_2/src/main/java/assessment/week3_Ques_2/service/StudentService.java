package assessment.week3_Ques_2.service;

import assessment.week3_Ques_2.util.DBConnection;

import java.sql.*;

public class StudentService {

    public void addStudent(String name, String course, int semester) {

        if (course == null || course.isEmpty()) {
            System.out.println("Course cannot be empty");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "INSERT INTO student(name,course,semester) VALUES(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setInt(3, semester);

            ps.executeUpdate();

            System.out.println("Student added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchStudent(int id) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM student WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Semester: " + rs.getInt("semester"));

            } else {
                System.out.println("Student not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(int id, String newCourse) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "UPDATE student SET course=? WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, newCourse);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Course updated successfully");
            else
                System.out.println("Student not found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "DELETE FROM student WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student deleted successfully");
            else
                System.out.println("Student not found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}