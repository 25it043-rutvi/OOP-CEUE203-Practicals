abstract class Shape { abstract double area(); }
class Circle extends Shape { double r; Circle(double r){this.r=r;} double area(){return Math.PI*r*r;} }
class Rectangle extends Shape { double w,h; Rectangle(double w,double h){this.w=w;this.h=h;} double area(){return w*h;} }
class Triangle extends Shape { double b,h; Triangle(double b,double h){this.b=b;this.h=h;} double area(){return b*h/2;} }
public class ShapeDemo {
    public static void main(String[] args){Shape[] a={new Circle(2),new Rectangle(3,4),new Triangle(5,2)};double total=0,largest=0;for(Shape s:a){double x=s.area();System.out.println(s.getClass().getSimpleName()+" area="+x);total+=x;largest=Math.max(largest,x);}System.out.println("Total="+total+", Largest="+largest);}
}
