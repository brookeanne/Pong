
//Name - brooke anne jennings
//Date - 2/27/15
//Lab  - Ball


import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(100,100);
		xSpeed = 3;
		ySpeed = 1;
	}

	//**finish the other Ball constructors, use xSpeed=3 and ySpeed=1 for now.
	//**super the x and y -- then set the speeds manually
	public Ball(int x, int y)
   {
   		super (x,y);
   		xSpeed = 3;
		ySpeed = 1;


   }

   public Ball(int x, int y, int wid, int ht)
   {
   		super (x,y,wid,ht);
   		xSpeed = 3;
		ySpeed = 1;

   }

   public Ball(int x, int y, int wid, int ht, Color col)
   {
   		super (x,y,wid,ht,col);
 		xSpeed = 3;
		ySpeed = 1;
   }

   public Ball(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	 	super (x,y,wid,ht);
   		xSpeed=xSpd;
   		ySpeed=ySpd;
   }

   public Ball(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
   		super (x,y,wid,ht,col);
   		xSpeed=xSpd;
   		ySpeed=ySpd;

   }
  //**add the set methods
 	public void setXSpeed(int x)
	{
	xSpeed = x;
	}
	public void setYSpeed(int y)
	{
	ySpeed = y;
	}
	public int getXSpeed()
	{
	return xSpeed;
	}
	public int getYSpeed()
	{
	return ySpeed;
	}


   public void moveAndDraw(Graphics window)
   {
   	 draw(window,Color.white);     //draws a white ball at old ball location -- "erases" the current ball

      setX(getX()+xSpeed);
      setY(getY()+ySpeed);

	  draw(window);			 //draws the ball at its new location
   }

   	//**balls are equal if super "blocks" are equal and xSpeed and ySpeed are equal
	public boolean equals(Object obj)
	{
		Ball rhs = (Ball)obj;
		boolean x = super.equals(obj);

		if (rhs.getXSpeed()==getXSpeed() && rhs.getYSpeed()==getYSpeed() && x)
			return true;
		else
			return false;

	}

   //**add the get methods
   public String toString()
   {
	String output = "";
	output+=super.toString();
	output+=" "+getXSpeed()+" "+getYSpeed();

	return output;
}

   //**add a toString() method that shows block toString with ball attributes (on one line)
}