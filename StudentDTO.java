public class StudentDTO {
    private int studentId;
    private String studentName;
    private String courseCode;

    public StudentDTO() {
    }

    public StudentDTO(int studentId, String studentName, String courseCode) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseCode = courseCode;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
