public class EnglishStudent extends Student {
    public EnglishStudent(String firstName, String lastName, int... grades) {
        super(firstName, lastName, "English", grades);
    }
    
    @Override
    public double getAverage() {
        int[] grades = getGrades();
        return 0.3 * grades[0] + 0.3 * grades[1] + 0.4 * grades[2];
    }
}

