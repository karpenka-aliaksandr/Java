package HomeWork01;

import java.util.Scanner;

/**
 * hw_001
 */
public class hw_001 {
    public static void main(String[] args) {
        System.out.println(getNumber("Введите число: "));
    }
    
    static int getNumber(String request) {
        System.out.print(request);
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        return number;
    }
}