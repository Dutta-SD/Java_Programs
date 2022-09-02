package recursion;

public class PalindromeCheck {
    public static void main(String[] args) {
        char[] charArray = "MAgDAM".toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        System.out.println((checkPalindrome(charArray, start, end)));
    }

    private static boolean checkPalindrome(char[] charArray, int start, int end) {
        if (charArray[start] != charArray[end]) return false;
        if (start >= end) return true;
        return checkPalindrome(charArray, start + 1, end - 1);
    }
}
