public abstract class Student {

    private String firstName;
    private String lastName;
    private String course;
    private int[] grades;
    
    public Student(String firstName, String lastName, String course, int... grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.grades = grades;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getCourse() {
        return course;
    }
    
    public int[] getGrades() {
        return grades;
    }
    
    public abstract double getAverage();
    
    public String getLetterGrade() {
        double average = getAverage();
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s %s - Final Exam: %d - Average: %.2f - Grade: %s", firstName, lastName, grades[grades.length - 1], getAverage(), getLetterGrade());
    }

    public static class EnglishStudent extends Student {
        public EnglishStudent(String firstName, String lastName, int[] grades) {
            super(firstName, lastName, "English", grades);
        }
        
        @Override
        public double getAverage() {
            int[] grades = getGrades();
            return (0.3 * grades[0] + 0.3 * grades[1] + 0.4 * grades[2]) / 100;
        }
    }

    public static class MathStudent extends Student {
        public MathStudent(String firstName, String lastName, int[] grades) {
            super(firstName, lastName, "Math", grades);
        }
        
        @Override
        public double getAverage() {
            int[] grades = getGrades();
            double quizAverage = (grades[0] + grades[1] + grades[2] + grades[3] + grades[4]) / 5.0;
            return (0.15 * quizAverage + 0.3 * grades[5] + 0.2 * grades[6] + 0.35 * grades[7]) / 100;
        }
    }

    public static class ScienceStudent extends Student {
        public ScienceStudent(String firstName, String lastName, int[] grades) {
            super(firstName, lastName, "Science", grades);
        }
        
        @Override
        public double getAverage() {
            int[] grades = getGrades();
            return (0.1 * grades[0] + 0.3 * grades[1] + 0.3 * grades[2] + 0.3 * grades[3]) / 100;
        }
    }
}
