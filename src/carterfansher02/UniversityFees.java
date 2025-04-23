/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carterfansher02;

/**
 *
 * @author S566740
 */

import java.io.*;
import java.util.*;

public class UniversityFees {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the no of UG students: ");
        int numUGStudents = scanner.nextInt();
        System.out.print("Enter the no of Graduate students: ");
        int numGraduateStudents = scanner.nextInt();
        System.out.print("Enter the no of online students: ");
        int numOnlineStudents = scanner.nextInt();

        StudentFees[] students = new StudentFees[numUGStudents + numGraduateStudents + numOnlineStudents];

        BufferedReader reader = new BufferedReader(new FileReader("input.csv"));
        String line;
        int index = 0;

        // Read UG students
        for (int i = 0; i < numUGStudents; i++) {
            line = reader.readLine();
            String[] data = line.split(",");
            students[index++] = new UGStudent(data[0], data[1], Boolean.parseBoolean(data[2]), Integer.parseInt(data[3]), Boolean.parseBoolean(data[4]), Double.parseDouble(data[5]));
        }

        // Read Graduate students
        for (int i = 0; i < numGraduateStudents; i++) {
            line = reader.readLine();
            String[] data = line.split(",");
            students[index++] = new GraduateStudent(data[0], data[1], Boolean.parseBoolean(data[2]), Integer.parseInt(data[3]), Boolean.parseBoolean(data[4]), data[5]);
        }

        // Read Online students
        for (int i = 0; i < numOnlineStudents; i++) {
            line = reader.readLine();
            String[] data = line.split(",");
            students[index++] = new OnlineStudent(data[0], data[1], Boolean.parseBoolean(data[2]), Integer.parseInt(data[3]));
        }

        reader.close();

        // Display student data and calculate averages
        double totalUGFees = 0.0;
        int ugScholarshipCount = 0;
        int totalUGCourses = 0;
        double totalGraduateFees = 0.0;
        int graduateAssistantshipCount = 0;
        int totalGraduateCourses = 0;
        double totalOnlineFees = 0.0;

        System.out.println("**********Undergraduate students list**********");
        for (StudentFees student : students) {
            if (student instanceof UGStudent) {
                UGStudent ugStudent = (UGStudent) student;
                System.out.println("Student name: " + ugStudent.name);
                System.out.println("Student id: " + ugStudent.id);
                System.out.println("Enrolled: " + ugStudent.enrolled);
                System.out.println("Scholarship: " + ugStudent.hasScholarship);
                System.out.println("Scholarship amount: " + ugStudent.scholarshipAmount);
                System.out.println("Courses enrolled: " + ugStudent.coursesEnrolled);
                System.out.println("Payable amount: " + ugStudent.getPayableAmount());
                if (ugStudent.enrolled) {
                    totalUGFees += ugStudent.getPayableAmount();
                    totalUGCourses += ugStudent.coursesEnrolled;
                    if (ugStudent.hasScholarship) {
                        ugScholarshipCount++;
                    }
                }
            }
        }

        System.out.println("**********Graduate students list**********");
        for (StudentFees student : students) {
            if (student instanceof GraduateStudent) {
                GraduateStudent gradStudent = (GraduateStudent) student;
                System.out.println("Student name: " + gradStudent.name);
                System.out.println("Student id: " + gradStudent.id);
                System.out.println("Enrolled: " + gradStudent.enrolled);
                System.out.println("Graduate assistant: " + gradStudent.isGraduateAssistant);
                System.out.println("Graduate assistant type: " + gradStudent.graduateAssistantType);
                System.out.println("Courses enrolled: " + gradStudent.coursesEnrolled);
                System.out.println("Payable amount: " + gradStudent.getPayableAmount());
                if (gradStudent.enrolled) {
                    totalGraduateFees += gradStudent.getPayableAmount();
                    totalGraduateCourses += gradStudent.coursesEnrolled;
                    if (gradStudent.isGraduateAssistant) {
                        graduateAssistantshipCount++;
                    }
                }
            }
        }

        System.out.println("**********Online students list**********");
        for (StudentFees student : students) {
            if (student instanceof OnlineStudent) {
                OnlineStudent onlineStudent = (OnlineStudent) student;
                System.out.println("Student name: " + onlineStudent.name);
                System.out.println("Student id: " + onlineStudent.id);
                System.out.println("Enrolled: " + onlineStudent.enrolled);
                System.out.println("No of months: " + onlineStudent.noOfMonths);
                System.out.println("Payable amount: " + onlineStudent.getPayableAmount());
                if (onlineStudent.enrolled) {
                    totalOnlineFees += onlineStudent.getPayableAmount();
                }
            }
        }

        System.out.println("**********Undergraduate Students details**********");
        System.out.println("Average Students fee: " + (totalUGFees / numUGStudents));
        System.out.println("Scholarship count: " + ugScholarshipCount);
        System.out.println("Total number of courses: " + totalUGCourses);

        System.out.println("**********Graduate Students details**********");
        System.out.println("Average Students fee: " + (totalGraduateFees / numGraduateStudents));
        System.out.println("Graduate Assistantship count: " + graduateAssistantshipCount);
        System.out.println("Total number of courses: " + totalGraduateCourses);

        System.out.println("**********Online Students details**********");
        System.out.println("Average Students fee: " + (totalOnlineFees / numOnlineStudents));
    }
}
    

