
import java.util.Scanner;
public class MyInteger {
 
private int value;
//정수 값을 매개 변수로 사용하여 생성 중인 개체의 값 변수에 할당하는 생성자.(constructor)
 
MyInteger(int newValue) {
 
this.value = newValue;
 
}
//Getter
 
public int getValue() {
 
return value;
 
}
 
public boolean isEven() {
 
return isEven(value);
 
}
 
public static boolean isEven(int value) {
 
return value % 2 == 0;
 
}
 
/* 그리고 메인에 받을 value에 접근하여 값을 확인하고 */
 
public static boolean isOdd(int value) {
 
return value % 2 != 0;
 
}
 
public boolean isOdd() {
 
return isOdd(value);
 
}
 
public boolean equals(int value) {
 
return this.value == value;
 
}
 
public boolean equals(MyInteger myInteger) {
 
return myInteger.value == this.value;
 
}
 
public static void main(String[] args) {
 
// Create MyInteger objects
 
MyInteger int1;
 
MyInteger int2;
 
Scanner scanner = new Scanner(System.in);
 
System.out.println("Enter the Value1: ");
 
int value1= scanner.nextInt();
 
int1 = new MyInteger(value1);
 
System.out.println("Enter the Value2: ");
 
int value2 = scanner.nextInt();
 
int2 = new MyInteger(value2);
 
System.out.println("Value of int1: " + int1.getValue()
);
 
System.out.println("Is int1 even? " + int1.isEven()
);
 
System.out.println("Is int1 odd? " + int1.isOdd()
);
 
// evan & odd
 
System.out.println("Value of int2: " + int2.getValue()
);
 
System.out.println("Is int2 even? " + MyInteger.isEven(int2.getValue()
)
);
 
System.out.println("Is int2 odd? " + MyInteger.isOdd(int2.getValue()
)
);
 
// equal
 
System.out.println("Is int2 equal to int1? " + int2.equals(int1)
);
 
}
