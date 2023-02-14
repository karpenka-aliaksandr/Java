package HomeWork01;

import java.util.Scanner;

/**
 * hw_001 Вычисление n-го треугольного числа
 */
public class hw_001 {
    public static void main(String[] args) {
        int number = getNumber("Введите число int: ");
        long triangleNumber = getTriangleNumber(number);
        System.out.printf("Треугольное число номер %d равно %d\n",number,triangleNumber);
    }
    
    static int getNumber(String request) {
        System.out.print(request);
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        return number;
    }
    static long getTriangleNumber(int number) {
        long triangleNumber = number * (number + 1) / 2;
        return triangleNumber;
    }
}