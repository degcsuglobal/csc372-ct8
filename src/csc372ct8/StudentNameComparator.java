package csc372ct8;
import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    // Compare two Student objects by their names
    public int compare(Student student1, Student student2) {
        return student1.getName().compareTo(student2.getName());
    }
}
