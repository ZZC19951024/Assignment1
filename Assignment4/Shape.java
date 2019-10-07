package Assignment;

public class Shape {
	private String name;
	private double perimiter;
	private double area;
	
	public void draw() {};
	public void getArea() { };
	public void getPerimeter() {};
	
	public static void main(String arg[]) {
		Shape s = new Shape();
		Rectangle r = new Rectangle(2.0,3.0);
		Circle c = new Circle(4.0);
		Square sq = new Square(4.0);
		
		r.getArea();
		r.getPerimeter();
		c.getArea();
		c.getPerimeter();
		sq.getArea();
		sq.getPerimeter();
		r.draw();
		c.draw();
		sq.draw();
		
	}
}

 class Circle extends Shape {
	private double radius;
	Circle(double radius){
		this.radius = radius;
	}
	public void draw() {
		System.out.println("drawing circle");
	}
	public void getArea() {
		System.out.println(3.14125 * radius *radius);
	}
	public void getPerimeter() {
		System.out.println(3.14125 * 2 * radius);
	}
}
 
 class Rectangle extends Shape{
	 private double width;
	 private double height;
	 Rectangle(double width, double height){
		 this.width = width;
		 this.height = height;
	 }
	 public void draw() {
		 System.out.println("drawing rectangle");
	 } 
	 public void getArea() {
		 System.out.println(width * height);
	 }
	 public void getPerimeter() {
		 System.out.println(2 * (width + height));
	 }
 }
 
 class Square extends Shape{
	 private double side;
	 Square(double side){
		 this.side = side;
	 }
	 public void draw() {
		 System.out.println("drawing rectangle");
	 } 
	 public void getArea() {
		 System.out.println(side * side);
	 }
	 public void getPerimeter() {
		 System.out.println(4 * side);
	 }
 }
