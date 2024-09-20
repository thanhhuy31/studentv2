package asignment2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Update a student by ID");
            System.out.println("3. Delete a student by ID");
            System.out.println("4. Display all students");
            System.out.println("5. Find the student with the highest GPA");
            System.out.println("6. Display scholarship students");
            System.out.println("7. Display total tuition of all students");
            System.out.println("0. Exit");
            System.out.print("Enter an option: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    // Add a new student
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    System.out.print("Enter major: ");
                    scanner.nextLine();  // Consume newline
                    String major = scanner.nextLine();
                    studentList.addStudent(new Student(id, fullName, new Date(), gpa, major));
                    break;
                case 2:

                    System.out.print("Enter student ID to update: ");
                    id = scanner.nextLine();
                    System.out.print("Enter new GPA: ");
                    gpa = scanner.nextFloat();
                    System.out.print("Enter new major: ");
                    scanner.nextLine();
                    major = scanner.nextLine();
                    studentList.updateStudentById(id, gpa, major);
                    break;
                case 3:

                    System.out.print("Enter student ID to delete: ");
                    id = scanner.nextLine();
                    studentList.deleteStudentById(id);
                    break;
                case 4:

                    studentList.displayAllStudents();
                    break;
                case 5:

                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top Student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                case 6:

                    ArrayList<Student> scholarshipStudents = studentList.findScholarshipStudents();
                    if (!scholarshipStudents.isEmpty()) {
                        System.out.println("Scholarship Students:");
                        for (Student student : scholarshipStudents) {
                            student.displayInfo();
                        }
                    } else {
                        System.out.println("No students with scholarships found.");
                    }
                    break;
                case 7:

                    System.out.println("Total Tuition of All Students: " + studentList.calculateTuitionOfAllStudents());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);

        scanner.close();
    }
}
