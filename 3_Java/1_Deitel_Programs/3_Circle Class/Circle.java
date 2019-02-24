interface Fillable
{
	int RED = 1;
	int GREEN = 2;
	int BLUE = 3;
	int BLACK = 4;
	void fill(int color);
}

interface Drawable //declares an interface called drawable
{
	int RED = 1;
	int GREEN = 2;
	int BLUE = 3;
	int BLACK = 4;
	
	void draw(int color); //declares a method to the Drawable interface
}

class Point implements Drawable, Fillable //Point is implementing the Drawable interface
{
	private int x, y; //coordinates x and y of point
	
	Point(int x, int y) //constructor of the point 
	{
		this.x = x; //init x 
		this.y = y; //init y 
	}
	
	int getX() 
	{
		return x;
	}
	
	int getY()
	{
		return y;
	}
	
	@Override //Overriding the toString method to return (x,y)
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
	
	@Override //Overriding the draw method from the interface
	public void draw(int color)
	{
		System.out.println("Point drawn at " + toString() + " in color " + color);
	}
	
	@Override
	public void fill(int color)
	{
		System.out.println("Point filled with " + color);
	}
	
	
}

class Circle extends Point implements Drawable, Fillable
{
	private int radius; //radius of circle. 
	
	Circle(int x, int y, int radius) //constructor of circle
	{
		super(x, y); //calls the constructor of the point class
		this.radius = radius; // init the radius of the circle
	}
	
	int getRadius()
	{
		return radius;
	}
	
	@Override //overrides the to string to return the radius
	public String toString()
	{
		return "" + radius;
	}
	
	@Override //overrides the draw method of the point base class to print Circle message
	public void draw(int color)
	{
		System.out.println("Circle drawn at " + super.toString() + " with radius "
		+ toString() + " in color " + color);
	}
	
	@Override
	public void fill(int color)
	{
		System.out.println("Circle filled with " + color);
	}
	
		public static void main(String[] args) //main function of Circle class that is exec.
	{
		Drawable[] drawables = new Drawable[]{new Point(10, 20),new Circle(10, 20, 30)}; 
		for (int i = 0; i < drawables.length; i++) 
		drawables[i].draw(Drawable.RED); 
		
		Fillable[] fillables = new Fillable[drawables.length];
		for (int i = 0; i < drawables.length; i++)
		{
			fillables[i] = (Fillable) drawables[i];	
			
			if (fillables[i] instanceof Point) 
			fillables[i].fill(Fillable.GREEN);
			
			if (fillables[i] instanceof Circle)
			fillables[i].fill(Fillable.RED);
			
		}
		
		
	}
}

	

