
package asignment2;

import java.util.ArrayList;

public class StudentList {
    private final ArrayList<Student> studentList;

    // Constructor
    public StudentList() {
        studentList = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // Update a student by id
    public void updateStudentById(String id, float gpa, String major) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setGpa(gpa);
            student.setMajor(major);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete a student by id
    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.getId().equals(id));
    }

    // Find a student by id
    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : studentList) {
                student.displayInfo();
                System.out.println("----------");
            }
        }
    }

    // Find the student with the highest GPA
    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }

        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }

    // Find students with a scholarship
    public ArrayList<Student> findScholarshipStudents() {
        ArrayList<Student> scholarshipStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.isScholarship()) {
                scholarshipStudents.add(student);
            }
        }
        return scholarshipStudents;
    }

    // Calculate total tuition of all students
    public double calculateTuitionOfAllStudents() {
        double totalTuition = 0;
        for (Student student : studentList) {
            totalTuition += student.calculateTuition();
        }
        return totalTuition;
    }
}
