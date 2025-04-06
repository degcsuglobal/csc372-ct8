package csc372ct8;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.util.Collections;

public class StudentDriver {

    public static void main(String[] args) {

        // Create a linked list to store students
        LinkedList<Student> studentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        // Loop to prompt user for student data
        while (true) {
            System.out.print("Enter student name (or blank to finish): ");
            String name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }

            System.out.print("Enter student address: ");
            String address = scanner.nextLine();

            System.out.print("Enter student GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            // call isValidGPA to validate the GPA
            if (!Student.isValidGPA(gpa)) {
                System.out.println("Invalid GPA. Please enter a GPA between 0.0 and 4.0.");
                continue; // Start over again for this student 
            }

            // Create a new student object and add it to the list
            Student student = new Student(name, address, gpa);
            studentList.add(student);
        }

        // Sort the list in ascending order by name
        Collections.sort(studentList, new StudentNameComparator());

        // Output to file 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : studentList) {
                writer.write("Name: " + student.getName() + ", Address: " + student.getAddress() + ", GPA: " + student.getGpa());
                writer.newLine();
            }
            System.out.println("Student data has been written to students.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // Close the scanner
        scanner.close();
    }
}
