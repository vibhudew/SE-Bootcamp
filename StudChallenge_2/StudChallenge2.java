import java.util.Stack;
import java.util.Scanner;

class StudChallenge2{
    public static boolean isValid(String s) {

        Stack<Character> parenthese = new Stack<>();

        // Loop for each character of the string
        for (char c : s.toCharArray()) {
             switch (c) {
                case '(': parenthese.push(c); break;
                case '{': parenthese.push(c); break;
                case '[': parenthese.push(c); break;
                case ')': if (parenthese.empty() || parenthese.peek()!='(') return false; else parenthese.pop(); break;
                case '}': if (parenthese.empty() || parenthese.peek()!='{') return false; else parenthese.pop(); break;
                case ']': if (parenthese.empty() || parenthese.peek()!='[') return false; else parenthese.pop(); break;
                default: return false; // because s consists only parentheses ()[]{} .
            }
        }

        return parenthese.isEmpty();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); // for reading inputs

        System.out.println("Input a string which contains only parentheses ()[]{} : ");

        String s = sc.nextLine();
 
        System.out.println(isValid(s));
    }

}