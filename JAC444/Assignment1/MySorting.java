import java.text.DecimalFormat;
import java.util.Scanner;
public class MySorting {
 
public static void displaySortedNumbers(double num1, double num2, double num3) {
 
double N3, N2, N1;
 
// maximum number
 
if (num1 >= num2 && num1 >= num3) {
 
N1 = num1;
 
} else if (num2 >= num1 && num2 >= num3) {
 
N1 = num2;
 
} else {
 
N1 = num3;
 
}
 
// minimum number
 
if (num1 <= num2 && num1 <= num3) {
 
N3 = num1;
 
} else if (num2 <= num1 && num2 <= num3) {
 
N3 = num2;
 
} else {
 
N3 = num3;
 
}
 
// middle number
 
N2 = num1 + num2 + num3 - N3 - N1;
 
System.out.println("List of Numbers: " + N3 + ", " + N2 + ", " + N1);
 
}
 
public static void main(String[] args) {
 
Scanner s = new Scanner(System.in);
 
System.out.print("Enter number1: ");
 
double num1 = s.nextDouble();
 
System.out.print("Enter number2: ");
 
double num2 = s.nextDouble();
 
System.out.print("Enter number3: ");
 
double num3 = s.nextDouble();
 
displaySortedNumbers(num1, num2, num3);
 
