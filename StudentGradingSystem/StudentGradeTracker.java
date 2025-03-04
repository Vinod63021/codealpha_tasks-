import java.util.ArrayList;
import java.util.Scanner;

class StudentGradeTracker {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentGradeTracker() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter the number of students to add: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Student Course: ");
            String course = scanner.nextLine();
            System.out.print("Enter Student Grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            students.add(new Student(id, name, course, grade));
        }
        System.out.println("Student(s) added successfully!");
    }

    public void calculateAndDisplayGrades() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double totalGrade = 0, highestGrade = Double.MIN_VALUE, lowestGrade = Double.MAX_VALUE;
        System.out.println("\n-----------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-10s\n", "ID", "Name", "Course", "Grade");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Student student : students) {
            System.out.println(student);
            totalGrade += student.getGrade();
            highestGrade = Math.max(highestGrade, student.getGrade());
            lowestGrade = Math.min(lowestGrade, student.getGrade());
        }
        System.out.println("-----------------------------------------------------------------------------------");

        double averageGrade = totalGrade / students.size();
        System.out.printf("%-40s: %.2f\n", "Average Grade", averageGrade);
        System.out.printf("%-40s: %.2f\n", "Highest Grade", highestGrade);
        System.out.printf("%-40s: %.2f\n", "Lowest Grade", lowestGrade);
    }

    public void viewStudent() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n---------------- Select View: -----------------");
        System.out.println("1. View All Students");
        System.out.println("2. View Student by ID");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                calculateAndDisplayGrades();
                break;
            case 2:
                System.out.print("Enter Student ID: ");
                int id = scanner.nextInt();
                boolean found = false;
                for (Student student : students) {
                    if (student.getId() == id) {
                        System.out.println(student);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found!");
                }
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }

    public void login() {
        int attempts = 3;
        while (attempts > 0) {
            System.out.println("\n................ Student Grade Tracker .................\n");
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (username.equals("admin") && password.equals("123")) {
                System.out.println("Login Successful!\n");
                menu();
                return;
            } else {
                attempts--;
                System.out.println("Invalid Username or Password. Attempts left: " + attempts);
            }
        }
        System.out.println("Too many failed attempts. Exiting...");
    }

    public void menu() {
        while (true) {
            System.out.println("\n**** Menu ****");
            System.out.println("1. Add Student and Grade");
            System.out.println("2. View Students Grade");
            System.out.println("3. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentGradeTracker tracker = new StudentGradeTracker();
        tracker.login();
    }
}