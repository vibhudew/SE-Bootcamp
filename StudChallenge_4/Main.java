import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        List<Student> students = readStudentsFromFile("input.txt");
        
        try (PrintWriter output = new PrintWriter(new File("output.txt"))) {
            List<Student> englishStudents = new ArrayList<>();
            List<Student> scienceStudents = new ArrayList<>();
            List<Student> mathStudents = new ArrayList<>();
            
            for (Student student : students) {
                if (student.getCourse().equals("English")) {
                    englishStudents.add(student);
                } else if (student.getCourse().equals("Science")) {
                    scienceStudents.add(student);
                } else if (student.getCourse().equals("Math")) {
                    mathStudents.add(student);
                }
            }
            
            // Print English students
            output.println("Student Grade Summary");
            output.println("---------------------");
            output.println();
            output.println("ENGLISH CLASS");
            output.println();
            output.println("Student                                   Final Final   Letter");
            output.println("Name                                      Exam  Avg     Grade");
            output.println("----------------------------------------------------------------------");
            for (Student student : englishStudents) {
                output.printf("%-40s %3d    %6.2f   %s%n", student.getFirstName() + " " + student.getLastName(), student.getGrades()[2], student.getAverage(), student.getLetterGrade());
            }
            output.println();
            
            // Print Science students
            output.println("Science CLASS");
            output.println();
            output.println("Student                                   Final Final   Letter");
            output.println("Name                                      Exam  Avg     Grade");
            output.println("----------------------------------------------------------------------");
            for (Student student : scienceStudents) {
                output.printf("%-40s %3d    %6.2f   %s%n", student.getFirstName() + " " + student.getLastName(), student.getGrades()[3], student.getAverage(), student.getLetterGrade());
            }
            output.println();
            
            // Print Math students
            output.println("MATH CLASS");
            output.println();
            output.println("Student                                   Final Final   Letter");
            output.println("Name                                      Exam  Avg     Grade");
            output.println("----------------------------------------------------------------------");
            for (Student student : mathStudents) {
                output.printf("%-40s %3d    %6.2f   %s%n", student.getFirstName() + " " + student.getLastName(), student.getGrades()[7], student.getAverage(), student.getLetterGrade());
            }
            output.println();

            // Print grade distribution
            Map<String, Integer> gradeCounts = new HashMap<>();
            for (Student student : students) {
                String letterGrade = student.getLetterGrade();
                int count = gradeCounts.getOrDefault(letterGrade, 0);
                gradeCounts.put(letterGrade, count + 1);
            }
            output.println("OVERALL GRADE DISTRIBUTION");
            output.println();
            for (Map.Entry<String, Integer> entry : gradeCounts.entrySet()) {
                output.printf("%s:   %d%n", entry.getKey(), entry.getValue());
            }
            
            //testing purposes only
            System.out.println("output.txt is created.");
        }
    }

    private static List<Student> readStudentsFromFile(String fileName) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();
        Scanner input = new Scanner(new File(fileName));
        int numStudents = input.nextInt();
        input.nextLine(); // Consume the remaining newline character
        
        for (int i = 0; i < numStudents; i++) {
            String nameLine = input.nextLine();
            String[] nameParts = nameLine.split(", ");
            String lastName = nameParts[0];
            String firstName = nameParts[1];
            
            String courseLine = input.nextLine();
            String[] courseParts = courseLine.split(" ");
            String course = courseParts[0];
            int[] grades = new int[courseParts.length - 1];
            for (int j = 1; j < courseParts.length; j++) {
                grades[j - 1] = Integer.parseInt(courseParts[j]);
            }
            
            if (course.equals("English")) {
                students.add(new EnglishStudent(firstName, lastName, grades));
            } else if (course.equals("Science")) {
                students.add(new ScienceStudent(firstName, lastName, grades));
            } else if (course.equals("Math")) {
                students.add(new MathStudent(firstName, lastName, grades));
            }
        }
        
        input.close();
        return students;
    }
 
}
