public abstract class Student{ //Base class

    protected char[] firstName = new char[30];
    protected char[] lastName = new char[25];
    protected char[] course = new char[8];
    protected double finalAvg;

    public Student(){ //default constructor
    };

    public Student(char[] fn , char[] ln , char[] cs){ //parameterized constructor
        firstName = fn;
        lastName = ln;
        course = cs;
    };

    public abstract double calFinalAvg();

    public abstract void getMarkSheet();

    //public final char courseVal(){
        // returns Course[0] value
    //};

    public void displayHeading(){
        System.out.println("Student Grade Summary");
    };

    public void displaySubHeading(int c){
        
        if( c == 1){
            System.out.println("\n\nENGLISH CLASS\n\n");
            System.out.println("Student \t\t\t\t Final   Final   Letter\n");
            System.out.println("Name \t\t\t\t\t Exam    Avg     Grade\n");
        }

        else if( c == 2){
            System.out.println("\n\nSCIENCE CLASS\n\n");
            System.out.println("Student \t\t\t\t Final   Final   Letter\n");
            System.out.println("Name \t\t\t\t\t Exam    Avg     Grade\n");

        }

        else{
            System.out.println("\n\nMATH CLASS\n\n");
            System.out.println("Student \t\t\t\t Final   Final   Letter\n");
            System.out.println("Name \t\t\t\t\t Exam    Avg     Grade\n");

        }
    };




}

class studentEnglish extends Student{

    private double termPaperGrade;
    private double midTermGrade;
    private double finalExamGrade;


    public studentEnglish(){

    };

    public double calFinalAvg(){
        finalAvg = (termPaperGrade * 0.25) + (midTermGrade * 0.35) + (finalExamGrade * 0.4);
        return finalAvg;  
    };

    public void getMarkSheet(){

    };

    public double getFinalExamGrade(){

        return this.finalExamGrade;

    };

}

class studentScience extends Student{

    private double attendanceGrade;
    private double projectGrade;
    private double midTermGrade;
    private double finalExamGrade;


    public studentScience(){

    };

    public double calFinalAvg(){
        finalAvg = (attendanceGrade * 0.1) + (projectGrade * 0.3)+ (midTermGrade * 0.3) + (finalExamGrade * 0.3);
        return finalAvg;
        
    };

    public void getMarkSheet(){

    };

    public double getFinalExamGrade(){

        return this.finalExamGrade;

    };

}


class studentMath extends Student{

    private double gradeQuiz1,gradeQuiz2,gradeQuiz3,gradeQuiz4,gradeQuiz5;
    private double gradeTest1 , gradeTest2;
    private double finalExamGrade;


    public studentMath(){

    };

    public double calFinalAvg(){ 
        finalAvg = (((gradeQuiz1 + gradeQuiz2 + gradeQuiz3 + gradeQuiz4 + gradeQuiz5) / 5) * 0.15) + gradeTest1 * 0.25 + gradeTest1 * 0.25 + finalExamGrade * 0.35;
        return finalAvg;
    };

    public void getMarkSheet(){

    };

    public double getFinalExamGrade(){

        return this.finalExamGrade;

    };

}