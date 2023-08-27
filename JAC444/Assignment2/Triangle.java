
import java.util.Scanner;
public class Triangle {
 
private double side1;
 
private double side2;
 
private double side3;
 
private String color;
 
private boolean filled;
 
public Triangle() {
 
side1 = 3.0;
 
side2 = 4.0;
 
side3 = 5.0;
 
color = "No color";
 
filled = false;
 
}
 
public Triangle(double s1, double s2, double s3) {
 
side1 = s1;
 
side2 = s2;
 
side3 = s3;
 
}
 
public double getSide1() {
 
return side1;
 
}
 
public double getSide2() {
 
return side2;
 
}
 
public double getSide3() {
 
return side3;
 
}
 
public double getPerimeter() {
 
return side1 + side2 + side3;
 
}
 
public double getArea() {
 
double s = getPerimeter() / 2;
 
//heron's formula -> reference:https://www.scaler.com/topics/area-of-triangle-in-java/
 
double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)
);
 
return area;
 
}
 
public String toString() {
 
return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
 
}
 
public void setColor(String color) {
 
this.color = color;
 
}
 
public String getColor() {
 
return color;
 
}
 
public void setFilled(boolean filled) {
 
this.filled = filled;
 
}
 
public boolean isFilled() {
 
return filled;
 
}
 
public static void main(String[] args) {
 
Scanner scanner = new Scanner(System.in);
 
// 사용자로부터 삼각형의 세 변 입력 받기
 
System.out.print("Enter the length of side 1: ");
 
double side1 = scanner.nextDouble();
 
System.out.print("Enter the length of side 2: ");
 
double side2 = scanner.nextDouble();
 
System.out.print("Enter the length of side 3: ");
 
double side3 = scanner.nextDouble();
 
// 사용자로부터 색상 및 채움 여부 입력 받기
 
System.out.print("Enter the color: ");
 
String color = scanner.next();
 
System.out.print("Is the triangle filled? (true/false)
: ");
 
boolean filled = scanner.nextBoolean();
 
// Triangle 객체 생성
 
Triangle triangle = new Triangle(side1, side2, side3);
 
triangle.setColor(color);
 
triangle.setFilled(filled);
 
// 삼각형 정보 출력
 
System.out.println("Area: " + triangle.getArea()
);
 
System.out.println("Perimeter: " + triangle.getPerimeter()
);
 
System.out.println("Color: " + triangle.getColor()
);
 
System.out.println("Filled: " + triangle.isFilled()
);
 
System.out.println(triangle.toString()
);
 
}
