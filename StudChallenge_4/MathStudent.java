public class MathStudent extends Student {
    public MathStudent(String firstName, String lastName, int... grades) {
        super(firstName, lastName, "Math", grades);
    }
    
    @Override
    public double getAverage() {
        int[] grades = getGrades();
        return 0.15 * ((grades[0] + grades[1] + grades[2] + grades[3] + grades[4]) / 5.0)
                + 0.3 * grades[5] + 0.2 * grades[6] + 0.35 * grades[7];
    }
}
