class ViewCoursesDTO {
    private String c_code;
    private String c_title;
    private String c_description;
    private int c_capacity;
    private String c_day;
    private String time;

    public ViewCoursesDTO() {
    }

    public ViewCoursesDTO(String c_code, String c_title, String c_description, int c_capacity, String c_day, String time) {
        this.c_code = c_code;
        this.c_title = c_title;
        this.c_description = c_description;
        this.c_capacity = c_capacity;
        this.c_day = c_day;
        this.time = time;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_title(String c_title) {
        this.c_title = c_title;
    }

    public String getC_title() {
        return c_title;
    }

    public void setC_description(String c_description) {
        this.c_description = c_description;
    }

    public String getC_description() {
        return c_description;
    }

    public void setC_capacity(int c_capacity) {
        this.c_capacity = c_capacity;
    }

    public int getC_capacity() {
        return c_capacity;
    }

    public void setC_day(String c_day) {
        this.c_day = c_day;
    }

    public String getC_day() {
        return c_day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "ViewCoursesDTO{" +
                "c_code='" + c_code + '\'' +
                ", c_title='" + c_title + '\'' +
                ", c_description='" + c_description + '\'' +
                ", c_capacity=" + c_capacity +
                ", c_day='" + c_day + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
