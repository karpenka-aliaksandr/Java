# Java

https://docs.oracle.com/javase/7/docs/api/overview-tree.html




## Типы

### Примитивные
boolean  
int, short, long и т.д.  
float, double  
Char

### Создание переменной

<тип> <идентификатор>;  
<идентификатор> = <значение>;

### Неявная типизация 

var a = 123;  
System.out.println(getType(a));

### классы-обертки

int Integer  
short Short  
long Long  
byte Byte  
float Float  
double Double  
char Character  
boolean Boolean  

### Массивы
Одномерные

public class Program {  
 public static void main(String[] args) {  
 int[] arr = new int[10];  
 System.out.println(arr.length); // 10  
 arr = new int[] { 1, 2, 3, 4, 5 };  
 System.out.println(arr.length); // 5  
}  
}

Многомерные

public class Program {  
 public static void main(String[] args) {  
 int[][] arr = new int[3][5];  

 for (int i = 0; i < arr.length; i++) {  
 for (int j = 0; j < arr[i].length; j++) {  
 System.out.printf("%d ", arr[i][j]);  
 }  
 System.out.println();  
 }  
 }  
}

### Преобразования

Можно

public class Program {  
 public static void main(String[] args) {  
 int i = 123; double d = i;  
 System.out.println(i); // 123  
 System.out.println(d); // 123.0  
 d = 3.1415; i = (int)d;  
 System.out.println(d); // 3.1415  
 System.out.println(i); // 3  
 d = 3.9415; i = (int)d;  
 System.out.println(d); // 3.9415  
 System.out.println(i); // 3  
 byte b = Byte.parseByte("123");  
 System.out.println(b); // 123  
 b = Byte.parseByte("1234");  
 System.out.println(b); // NumberFormatException: Value out of range  
 }  
}  

## Получение данных из терминала

Строки  
import java.util.Scanner;  
public class Program {  
 public static void main(String[] args) {  
 Scanner iScanner = new Scanner(System.in);  
 System.out.printf("name: ");  
 String name = iScanner.nextLine();  
 System.out.printf("Привет, %s!", name);  
 iScanner.close();  
 }  
}  

Некоторые примитивы

import java.util.Scanner;  
public class Program {  
 public static void main(String[] args) {  
 Scanner iScanner = new Scanner(System.in);  
 System.out.printf("int a: ");  
 int x = iScanner.nextInt();  
 System.out.printf("double a: ");  
 double y = iScanner.nextDouble();  
 System.out.printf("%d + %f = %f", x, y, x + y);  
 iScanner.close();  
}}

Проверка на соответствие получаемого типа

import java.util.Scanner;  
public class Program {  
 public static void main(String[] args) {  
 Scanner iScanner = new Scanner(System.in);  
 System.out.printf("int a: ");  
 boolean flag = iScanner.hasNextInt();  
 System.out.println(flag);  
 int i = iScanner.nextInt();  
 System.out.println(i);  
 iScanner.close();  
 } }  

## Функции и методы

public class Program {  
 static void sayHi() {  
 System.out.println("hi!");  
 }  
 static int sum(int a, int b) {  
 return a+b;  
 }  
 static double factor(int n) {  
 if(n==1)return 1;  
 return n * factor(n-1);  
 }  
 public static void main(String[] args) {  
 sayHi(); // hi!  
 System.out.println(sum(1, 3)); // 4  
 System.out.println(factor(5)); // 120.0  
 }}  

## Управляющие конструкции
### условный оператор
int a = 1;  
 int b = 2;  
 int c;  
 if (a > b) {  
 c = a;  
 } else {  
 c = b;  
 }  
 System.out.println(c);  

### тернарный оператор
 int min = a < b ? a : b;

### Оператор выбора

int mounth = value;  
 String text = "";  
 switch (mounth) {  
 case 1:  
 text = "Autumn";  
 break;  
...  
 default:  
 text = "mistake";  
 break;  
 }  
 System.out.println(text);  
 iScanner.close(); 

## Циклы
Цикл — это многократное выполнение одинаковой
последовательности действий.

В java доступны следующие циклы:

- цикл while;
- цикл do while;
- цикл for; и его модификация for in

Выполнение следующей итерации цикла — continue.  
Прерывание текущей итерации цикла — break. 


## Работа с файлами
### Чтение, Вариант посимвольно
import java.io.FileWriter;  
import java.io.IOException;  
public class Program {  
 public static void main(String[] args) {  
 try (FileWriter fw = new FileWriter("file.txt", false)) {  
 fw.write("line 1");  
 fw.append('\n');  
 fw.append('2');  
 fw.append('\n');  
 fw.write("line 3");  
 fw.flush();  
 } catch (IOException ex) {  
 System.out.println(ex.getMessage());  
 }  
 } }  

### Вариант построчно
import java.io.*;  
public class Program {  
 public static void main(String[] args) throws Exception {  
 BufferedReader br = new BufferedReader(new FileReader("file.txt"));  
 String str;  
 while ((str = br.readLine()) != null) {  
 System.out.printf("== %s ==\n", str);  
 }  
 br.close();  
 }  
}  
