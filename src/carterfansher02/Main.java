package carterfansher02;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        File myFile = new File("C:\\Users\\s566740\\Documents\\NetBeansProjects\\CarterFansher02\\src\\carterfansher02\\input.csv");
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of UG students: ");
        int numUG = scanner.nextInt();
        System.out.print("Enter number of Graduate students: ");
        int numGrad = scanner.nextInt();
        System.out.print("Enter number of Online students: ");
        int numOnline = scanner.nextInt();

        StudentFees[] students = new StudentFees[numUG + numGrad + numOnline];
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String line;
            int index = 0;
            
            for (int i = 0; i < numUG; i++) {
                line = reader.readLine();
                String[] data = line.split(",");
                students[index++] = new UGStudent(data[0], data[1], Boolean.parseBoolean(data[2]), Integer.parseInt(data[3]), Boolean.parseBoolean(data[4]), Double.parseDouble(data[5]));
            }
            
            for (int i = 0; i < numGrad; i++) {
                line = reader.readLine();
                String[] data = line.split(",");
                students[index++] = new GraduateStudent(data[0], data[1], Boolean.parseBoolean(data[2]), Integer.parseInt(data[3]), Boolean.parseBoolean(data[4]), data[5]);
            }
            
            for (int i = 0; i < numOnline; i++) {
                line = reader.readLine();
                String[] data = line.split(",");
                students[index++] = new OnlineStudent(data[0], data[1], Boolean.parseBoolean(data[2]), Integer.parseInt(data[3]));
            }
        }

        // Statistics
        double totalUG = 0, totalGrad = 0, totalOnline = 0;
        int ugCount = 0, gradCount = 0, onlineCount = 0;
        int ugScholarships = 0, gradAssistants = 0;
        int ugCourses = 0, gradCourses = 0;

        for (StudentFees student : students) {
            if (student instanceof UGStudent) {
                UGStudent s = (UGStudent) student;
                if (s.enrolled) {
                    ugCount++;
                    totalUG += s.getPayableAmount();
                    ugCourses += s.coursesEnrolled;
                    if (s.hasScholarship) ugScholarships++;
                }
            } else if (student instanceof GraduateStudent) {
                GraduateStudent s = (GraduateStudent) student;
                if (s.enrolled) {
                    gradCount++;
                    totalGrad += s.getPayableAmount();
                    gradCourses += s.coursesEnrolled;
                    if (s.isGraduateAssistant) gradAssistants++;
                }
            } else if (student instanceof OnlineStudent) {
                OnlineStudent s = (OnlineStudent) student;
                if (s.enrolled) {
                    onlineCount++;
                    totalOnline += s.getPayableAmount();
                }
            }
        }

        System.out.println("**********Undergraduate Students**********");
        System.out.println("Average Fee: " + (ugCount > 0 ? totalUG / ugCount : 0));
        System.out.println("Scholarship Count: " + ugScholarships);
        System.out.println("Total UG Courses: " + ugCourses);

        System.out.println("**********Graduate Students**********");
        System.out.println("Average Fee: " + (gradCount > 0 ? totalGrad / gradCount : 0));
        System.out.println("Graduate Assistants: " + gradAssistants);
        System.out.println("Total Graduate Courses: " + gradCourses);

        System.out.println("**********Online Students**********");
        System.out.println("Average Fee: " + (onlineCount > 0 ? totalOnline / onlineCount : 0));
    }
}
