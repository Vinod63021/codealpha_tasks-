class Student {
    private int id;
    private String name;
    private String course;
    private double grade;

    public Student(int id, String name, String course, double grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%-10d %-20s %-20s %-10.2f", id, name, course, grade);
    }
}
