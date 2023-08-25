
import java.util.Scanner;
public class Palindrome {
 
public boolean isPalindrome(int number) {
 
String s = String.valueOf(number);
 
int i = 0;
 
int j = s.length() - 1; // 마지막 부분
 
while(i <= j)
 
{
 
if(s.charAt(i) != s.charAt(j)
)
 
return false;
 
i++;
 
j--;
 
}
 
return true;
 
}
 
public static void main(String[] args) {
 
Scanner s = new Scanner(System.in);
 
System.out.println("Enter the numbers: ");
 
int number = s.nextInt();
 
Palindrome p = new Palindrome();
 
boolean isPalindrome = p.isPalindrome(number);
 
if (isPalindrome) {
 
System.out.println(number + " is a palindrome.");
 
} else {
 
System.out.println(number + " is not a palindrome.");
 
}
 
}
