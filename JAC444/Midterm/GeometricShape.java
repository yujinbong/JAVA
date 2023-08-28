
public abstract class GeometricShape {
 
private String color; 
// Color of the shape
 
private boolean filled; // Whether the shape is filled or not
 
public GeometricShape() {
 
color = "No color";
 
filled = false;
 
}
 
public GeometricShape(String newColor, boolean newFilled) {
 
color = newColor;
 
filled = newFilled;
 
}
 
public String getColor() {
 
return color;
 
}
 
public void setColor(String newColor) {
 
color = newColor;
 
}
 
public boolean isFilled() {
 
return filled;
 
}
 
public void setFilled(boolean newFilled) {
 
filled = newFilled;
 
}
 
public abstract double getArea();
 
public abstract double getPerimeter();
}
