
package asignment2;

import java.util.Date;


public class Student extends Person {
    private float gpa;
    private String major;
    private final double tuition = 10000000;
    private boolean scholarship;

    // Constructor
    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
        this.scholarship = gpa >= 9.0;
    }

    // Getters and Setters
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
        this.scholarship = gpa >= 9.0;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    // Method to calculate tuition
    public double calculateTuition() {
        if (scholarship) {
            return tuition * 0.5; // 50% reduction if GPA >= 9
        } else {
            return tuition;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        System.out.println("Scholarship: " + (scholarship ? "Yes" : "No"));
        System.out.println("Tuition: " + calculateTuition());
    }
}
