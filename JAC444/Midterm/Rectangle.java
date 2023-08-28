
import java.util.Scanner;
public class Rectangle extends GeometricShape {
 
private double w;
 
private double h;
 
//no-arg constructor creates a default rectangle.
 
public Rectangle() {
 
w = 3.0;
 
h = 4.0;
 
}
 
public Rectangle(double newWidth, double newHeight) {
 
w = newWidth;
 
h = newHeight;
 
}
 
public double getWidth() {
 
return w;
 
}
 
public void setWidth(double newWidth) {
 
w = newWidth;
 
}
 
public double getHeight() {
 
return h;
 
}
 
public void setHeight(double newHeight) {
 
h = newHeight;
 
}
 
public double getPerimeter() {
 
return 2 * (w + h);
 
}
 
// method named getArea() that returns the area of this rectangle.
 
public double getArea() {
 
return w * h;
 
}
 
// method named toString() that returns a string description for the rectangle.
 
public String toString() {
 
return "Rectangle: width = " + w + " and height = " + h;
 
}
 
public static void main(String[] args) {
 
Scanner scanner = new Scanner(System.in);
 
System.out.print("Enter the width : ");
 
double width = scanner.nextDouble();
 
System.out.print("Enter the height : ");
 
double height = scanner.nextDouble();
 
System.out.print("Enter the color : ");
 
String color = scanner.next();
 
System.out.print("Is the rectangle filled?(True or False)
: ");
 
boolean filled = scanner.nextBoolean();
 
Rectangle rectangle = new Rectangle(width, height);
 
rectangle.setColor(color);
 
rectangle.setFilled(filled);
 
System.out.println("Area: " + rectangle.getArea()
);
 
System.out.println("Perimeter: " + rectangle.getPerimeter()
);
 
System.out.println("Color: " + rectangle.getColor()
);
 
System.out.println("Filled: " + rectangle.isFilled()
);
 
}
}
