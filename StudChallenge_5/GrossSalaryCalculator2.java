import java.util.Scanner;

public class GrossSalaryCalculator2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter per day payment: ");

        double perDayPayment = scanner.nextDouble();

        if (perDayPayment <= 0) {
            System.out.println("Invalid input. Per day payment must be greater than 0.");
            return;
        }
        
        System.out.print("Enter number of days: ");

        int noOfDays = scanner.nextInt();

        if (noOfDays <= 0) {
            System.out.println("Invalid input. Number of days must be greater than 0.");
            return;
        }
        
        // Calculate the basic salary by multiplying the per day payment by the number of days
        double basicSalary = perDayPayment * noOfDays;
        
        // Declare the arrays as final so that they can be accessed within the anonymous inner classes(the Runnable classes within the Thread constructors)

        final double[] allowances = new double[1];
        final double[] epf = new double[1];
        final double[] employerContribution = new double[1];

        // METHOD 2 -  Using anonymous inner classes to create threads
        
        // Create a thread to calculate the allowances
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                // Calculate the allowances by multiplying the basic salary by 5%
                allowances[0] = basicSalary * 0.05;
            }
        });
        t2.start();

        // Create a thread to calculate the EPF contribution
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                // Calculate the EPF contribution by multiplying the basic salary by 8%
                epf[0] = basicSalary * 0.08;
            }
        });
        t3.start();

        // Create a thread to calculate the employer contribution
        Thread t4 = new Thread(new Runnable() {
            public void run() {
                // Calculate the employer contribution by multiplying the basic salary by 12%
                employerContribution[0] = basicSalary * 0.12;
            }
        });
        t4.start();


        // Wait for all threads to complete
        try {
            t2.join();
            t3.join();
            t4.join();

        } catch (InterruptedException e) {
            // Print the stack trace of the exception
            e.printStackTrace();
        }

        // Calculate the gross salary by adding the basic salary, allowances, and EPF contribution
        double grossSalary = basicSalary + allowances[0] + epf[0];

        System.out.printf("Gross Salary: USD %.2f\n", grossSalary);
        System.out.printf("Employer Contribution: USD %.2f\n", employerContribution[0]);
    }
}
