
abstract class Shape
{
	abstract void display();
	abstract void show();
	void draw()
	{
		System.out.println("concrete method");
	}
}

class Rectangle extends Shape
{
	void display()
	{
		System.out.println("display method");
	}
	void show()
	{
		System.out.println("show method");
	}
}

public class AbstractClass {

	public static void main(String[] args) {
		
		Rectangle r = new Rectangle();
		r.display();
		r.show();
		r.draw();
	}
}
