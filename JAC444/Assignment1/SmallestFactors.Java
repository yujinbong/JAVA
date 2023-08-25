
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
public class SmallestFactors {
 
public static void main(String[] args) {
 
Scanner input = new Scanner(System.in);
 
System.out.print("Enter a positive integer: ");
 
int number = input.nextInt();
 
ArrayList<Integer> result = new ArrayList<>();
 
// Find and store all the smallest factors
 
for (int i = 2; i <= number; i++) {
 
while (number % i == 0) {
 
result.add(i);
 
number /= i; // i로 나눈후의 값이 저장된다.
 
}
 
}
 
// Sort the factors in decreasing order
 
Collections.sort(result, Collections.reverseOrder()
);
 
// Display the factors
 
System.out.print("factors: [");
 
for (int i = 0; i < result.size(); i++) {
 
System.out.print(result.get(i)
);
 
if (i < result.size() - 1) {
 
System.out.print(", ");
 
}
 
}
 
System.out.println("]");
 
}
