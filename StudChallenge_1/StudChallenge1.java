import java.util.Scanner;

class StudChallenge1{

    public int value(char symbol){

            if( symbol == 'I'){
                return 1;
            }

            if( symbol == 'V'){
                return 5;
            }

            if( symbol == 'X'){
                return 10;
            }

            if( symbol == 'L'){
                return 50;
            }

            if( symbol == 'C'){
                return 100;
            }

            if( symbol == 'D'){
                return 500;
            }

            if( symbol == 'M'){
                return 1000;
            }
		   
	    // for invalid inputs 
	    return -1;

    }


    public int romanToInt(String s) {

        int res = 0;


       //loop iterate over the string (given roman numeral)  
       //getting value from symbol s1[i] 
       for (int i = 0; i < s.length(); i++) {
           
            int s1 = value(s.charAt(i));
 
            //getting value of symbol s2[i+1]  
            if (i + 1 < s.length()) {
                int s2 = value(s.charAt(i + 1));
 
                //comparing the current symbol from its right symbol   
                if (s1 >= s2) {
                    res = res + s1; //if the value of current symbol is greater or equal to the next symbol  

                }

                else {
                 // Value of current symbol is
                // less than the next symbol
                    res = res + s2 - s1;
                    i++;
                }
            }
            else {
                res = res + s1;
            }
        }
 
        return res;
    }

    public static void main(String args[])
    {
        StudChallenge1 ob = new StudChallenge1();

        Scanner sc = new Scanner(System.in); // reading inputs

        System.out.print("s = ");

        String roman = sc.nextLine();
 
        System.out.println(ob.romanToInt(roman));
    }

}

