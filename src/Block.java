
//Name - brooke anne jennings
//Date - 2/27/15
//Lab  - Block

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int width;
	private int height;

	private int xPos;
	private int yPos;

	private Color color;

	public Block()				  //**default constructor -- do not use all zeros
	{
		width = 10;
		height = 10;
		xPos = 10;
		yPos = 40;
		color = Color.black;


	//**ALL constructors NEED 5 lines
	}

	public Block(int x, int y)  //**initialization constructor
   	{
   		xPos = x;
   		yPos = y;
   		width = 30;
		height = 50;
		color = Color.black;

  	}

   	public Block(int x, int y, int wid, int ht)  //**initialization constructor
   	{
   		xPos = x;
   		yPos = y;
   		width = wid;
   		height = ht;
   		color = Color.black;

   	}

	public Block(int x, int y, int wid, int ht, Color col)  //**initialization constructor
	{
		xPos = x;
   		yPos = y;
   		width = wid;
   		height = ht;
   		color = col;
	}

	public void setX(int x)
	{
	xPos = x;
	}
	public void setY(int y)
	{
	yPos = y;
	}
	public void setWidth(int w)
	{
	width=w;
	}
	public void setHeight(int h)
	{
	height=h;
	}
	public int getX()
	{
	return xPos;
	}
	public int getY()
	{
	return yPos;
	}
	public int getWidth()
	{
	return width;
	}
	public int getHeight()
	{
	return height;
	}

	public void setColor(Color c)
	{
	color=c;
	}
	public Color getColor()
	{
		return color;
	}
	public void setPos (int x, int y)
	{
		xPos = x;
		yPos = y;
	}
	
	//**Added a few more get methods for ease of use
	public int getTop() { 
		return yPos; 
	}
	
	public int getBottom() {
		return yPos + height; 
	}

	//**add the mutator methods (setters)

   public void draw(Graphics window)
   {
   	//**uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
		//**finish by modifying the 'draw' method above
		window.setColor(color.white);
      window.fillRect(getX(), getY(), getWidth(), getHeight());

   }

	//**two blocks are equal if all 5 attributes are equal
	public boolean equals(Object obj)
	{
		Block rhs = (Block)obj;
		if (rhs.getWidth()==getWidth() && rhs.getHeight()==getHeight() && rhs.getX()==getX() && rhs.getY()==getY() && rhs.getColor()==getColor())
			return true;
		else
			return false;			//downcasting
	}

   //**add the other get methods

public String toString()
{
	String output = getX()+" "+getY()+" "+getWidth()+" "+getHeight()+" "+getColor();
	return output;
}
   //**add a toString() method to print x,y,width,height,color on one line separated by spaces
}