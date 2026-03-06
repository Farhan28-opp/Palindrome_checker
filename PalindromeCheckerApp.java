import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;


interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}


class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return input.equals(reversed);
    }
}


class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}


class PalindromeService {

    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.checkPalindrome(input);
    }
}


public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";

        PalindromeStrategy strategy = new StackStrategy();


        PalindromeService service = new PalindromeService(strategy);

        boolean result = service.check(word);

        if (result) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is NOT a Palindrome.");
        }
    }
}
