import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return grades.size() > 0 ? total / grades.size() : 0;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }
}

public class StudentGradeTracker {
    private ArrayList<Student> students;

    public StudentGradeTracker() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name) {
        students.add(new Student(name));
    }

    public Student getStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public double findHighestScore() {
        double highest = Double.MIN_VALUE;
        for (Student student : students) {
            for (double grade : student.getGrades()) {
                if (grade > highest) {
                    highest = grade;
                }
            }
        }
        return highest;
    }

    public double findLowestScore() {
        double lowest = Double.MAX_VALUE;
        for (Student student : students) {
            for (double grade : student.getGrades()) {
                if (grade < lowest) {
                    lowest = grade;
                }
            }
        }
        return lowest;
    }

    public void displayStudentAverages() {
        for (Student student : students) {
            System.out.printf("Average grade for %s: %.2f%n", student.getName(), student.calculateAverage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker gradeTracker = new StudentGradeTracker();

        System.out.println("Enter the number of students:");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter student name:");
            String name = scanner.nextLine();
            gradeTracker.addStudent(name);

            System.out.println("Enter grades for " + name + " (enter -1 to stop):");
            Student student = gradeTracker.getStudent(name);
            while (true) {
                double grade = scanner.nextDouble();
                if (grade == -1) break;
                student.addGrade(grade);
            }
            scanner.nextLine(); // Consume the newline character
        }

        gradeTracker.displayStudentAverages();
        
        System.out.printf("Highest score in class: %.2f%n", gradeTracker.findHighestScore());
        System.out.printf("Lowest score in class: %.2f%n", gradeTracker.findLowestScore());

        scanner.close();
    }
}
