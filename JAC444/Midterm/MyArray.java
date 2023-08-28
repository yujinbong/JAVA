
import java.sql.SQLOutput;
import java.util.Scanner;
public class MyArray {
 
public static void main(String[] args) {
 
int[] numbers = new int[1001];
 
Scanner scanner = new Scanner(System.in);
 
System.out.print("Enter the integers between 1 and 1000: ");
 
int num ;
 
do {
 
num = scanner.nextInt();
 
if (num >= 1 && num <= 1000) {
 
numbers[num]++;
 
}
 
} while (num != 0);
 
for (int i = 1; i <= 1000; i++) {
 
if (numbers[i] > 0) {
 
String times = (numbers[i] == 1) ? "time" : "times";
 
System.out.println(i + " occurs " + numbers[i] + " " + times);
 
}
 
}
 
}
}
