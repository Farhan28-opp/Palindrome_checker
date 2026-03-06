public class PalindromeCheckerApp {

    public static void main(String[] args) {

    
        String input = "Madam In Eden Im Adam";

      
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = true;

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

      
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }
    }
}
