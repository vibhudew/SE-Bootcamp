public class ScienceStudent extends Student {
    public ScienceStudent(String firstName, String lastName, int... grades) {
        super(firstName, lastName, "Science", grades);
    }
    
    @Override
    public double getAverage() {
        int[] grades = getGrades();
        return 0.1 * grades[0] + 0.3 * grades[1] + 0.3 * grades[2] + 0.3 * grades[3];
    }
}
