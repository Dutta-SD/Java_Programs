package patterns;

import java.util.Scanner;

public class SimplePattern3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfLines = scanner.nextInt();
        int numCharPerLine = scanner.nextInt();
        printPattern(numOfLines, numCharPerLine);
    }

    private static void printPattern(int numOfLines, int numCharPerLine) {
        for (int lineNo = 0; lineNo < numOfLines; lineNo++) {
            for (int charNo = 0; charNo < lineNo + 1; charNo++) {
                System.out.print(charNo + 1);
            }
            System.out.print("\n");
        }
    }
}
