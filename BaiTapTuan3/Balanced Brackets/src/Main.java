import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for ( char c : s.toCharArray()) {
            if ( c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if ( c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!isMatchingPair(top, c)) return false;
            }
        }
        return stack.empty();
    }
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        String[] s = new String[n];
        for ( int i = 0; i < n; i++) {
            s[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(isValid(s[i]) ? "YES" : "NO");
        }
        sc.close();
    }
}