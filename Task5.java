import java.sql.*;
import java.util.*;
class DTO{
    public List<ViewCoursesDTO> ViewProducts() throws Exception {
        List<ViewCoursesDTO> list = new ArrayList<>();
            try (Connection conn = Connectivity.getConnection()) {
                PreparedStatement ps = conn.prepareStatement("select * from courses where course_capacity>=1");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    ViewCoursesDTO view = new ViewCoursesDTO();
                    view.setC_code(rs.getString("course_code"));
                    view.setC_title(rs.getString("course_title"));
                    view.setC_description(rs.getString("course_description"));
                    view.setC_capacity(rs.getInt("course_capacity"));
                    view.setC_day(rs.getString("course_day"));
                    view.setTime(rs.getString("time"));
                    list.add(view);
                }
                if (list.size() == 0) {
                    throw new Exception("No data in Courses");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new Exception(e.getMessage());
            }
            return list;
        }
    public void viewCourses() {
        try {
            List<ViewCoursesDTO> list = ViewProducts();

            System.out.println("-----------------------------------------------------------|Table of all the Courses |---------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%10s %25s %35s %45s %20s  %20s", "CourseCode", "CourseTitle", "Description", "Capacity", "Day","courseTIme");
            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------");

            list.forEach(course -> {
                System.out.format("%10s %25s %65s %10s %25s %20s",
                        course.getC_code(), course.getC_title(), course.getC_description(), course.getC_capacity(), course.getC_day(),course.getTime());
                System.out.println();
            });

            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void registerCourse(String name, String code) {
        try (Connection conn = Connectivity.getConnection()) {
            PreparedStatement checkCapacityStmt = conn.prepareStatement("SELECT course_capacity FROM courses WHERE course_code = ?");
            checkCapacityStmt.setString(1, code);
            ResultSet rs = checkCapacityStmt.executeQuery();
            if (rs.next()) {
                int capacity = rs.getInt("course_capacity");
                if (capacity >0) {
                    capacity--;
                    PreparedStatement updateCapacityStmt = conn.prepareStatement("UPDATE courses SET course_capacity = ? WHERE course_code = ?");
                    updateCapacityStmt.setInt(1, capacity);
                    updateCapacityStmt.setString(2, code);
                    updateCapacityStmt.executeUpdate();
                    PreparedStatement insertStudentStmt = conn.prepareStatement("INSERT INTO students (student_name, course_code) VALUES (?, ?)");
                    insertStudentStmt.setString(1, name);
                    insertStudentStmt.setString(2, code);
                    insertStudentStmt.executeUpdate();
                    System.out.println("Successfully registered " + name + " for course " + code);
                } else {
                    System.out.println("Sorry, the course " + code + " is full and cannot accept any more registrations.");
                }
            } else {
                System.out.println("Course with code " + code + " does not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewStudents() {
        try {
            List<StudentDTO> studentList = getStudentsForCourse();

            System.out.println("--------------------| Students enrolled in Course  |-----------------------------");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.printf("%10s %25s %35s", "StudentID", "StudentName", "CourseCode");
            System.out.println("\n---------------------------------------------------------------------------------");

            studentList.forEach(student -> {
                System.out.format("%10s %25s %35s",
                        student.getStudentId(), student.getStudentName(), student.getCourseCode());
                System.out.println();
            });

            System.out.println("---------------------------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<StudentDTO> getStudentsForCourse() throws Exception {
        List<StudentDTO> studentList = new ArrayList<>();
        try (Connection conn = Connectivity.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                StudentDTO student = new StudentDTO();
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setCourseCode(rs.getString("course_code"));
                studentList.add(student);
            }
            if (studentList.size() == 0) {
                throw new Exception("No Students has been registered");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return studentList;
    }
    public void dropCourse(int id) {
        try (Connection con = Connectivity.getConnection()) {
            PreparedStatement p = con.prepareStatement("DELETE FROM students WHERE student_id = ?");
            p.setInt(1, id);
            int rowsAffected = p.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully deleted StudentId: " + id + " from Registered courses.");
            } else {
                System.out.println("No student found with ID: " + id + ".");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
public class Task5 {
    public static void main(String[] args) {
        DTO d=new DTO();
        Scanner sc=new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("|                     Student Course Registration System                |");
        System.out.println("------------------------------------------------------------------------");
        int op=5;
        String name,code;
        int id=0;
        do{
            System.out.println("------------------------------------");
            System.out.println("|     1.To View Available Courses  |");
            System.out.println("|     2.To Register Courses        |");
            System.out.println("|     3.To View Student registers  |");
            System.out.println("|     4.To Drop the Courses        |");
            System.out.println("|     5.Exit                       |");
            System.out.println("------------------------------------");
            System.out.print("  Enter Option : ");
            op=sc.nextInt();
            switch (op){
                case 1:
                    d.viewCourses();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("  Enter Name : ");
                    name=sc.nextLine();
                    System.out.print("  Enter Course Code : ");
                    code=sc.nextLine();
                    d.registerCourse(name,code);
                    break;
                case 3:
                    d.viewStudents();
                    break;
                case 4:
                    System.out.print("  Enter Student id : ");
                    id=sc.nextInt();
                    d.dropCourse(id);
                    break;
                case 5:
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("--| Thanks for Using  Student Course Registration System |---");
                    System.out.println("-------------------------------------------------------------");
                    break;
                default:
                    System.out.println("Enter Valid Option");
            }
        }while(op!=5);

    }
}
