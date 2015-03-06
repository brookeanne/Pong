//Name -
//Date -
//Lab  - Paddle

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
	  super(10,10,10,10);
      speed =5;
   }

   //**finish the other Paddle constructors
   public Paddle(int x, int y)
   {
   	super (x,y);
   	speed =5;

   }

   public Paddle(int x, int y, int s)
   {
	super (x,y);
   	speed =s;
   }

   public Paddle(int x, int y, int wid, int ht, int s)
   {
	super (x,y,wid,ht);
   	speed =s;
   }

   public Paddle(int x, int y, int wid, int ht, Color col, int s)
   {
   		super (x,y,wid,ht,col);
   		speed =s;

   }
   	public void setSpeed(int s)
	{
	speed = s;
	}
	public int getSpeed()
	{
	return speed;
	}

	//**add set method

   public void moveUpAndDraw(Graphics window)		//this method is finished
   {
	  draw(window,Color.white);
      setY(getY()-getSpeed());
      draw(window);
   }

   public void moveDownAndDraw(Graphics window)		//**you need to finish this one
   {
		draw(window,Color.white);
     	setY(getY()+getSpeed());
      	draw(window);

   }

   //**add get method

   public String toString()
   {
	String output = "";
	output+=super.toString();
	output+=" "+getSpeed();

	return output;
}
   //**add a toString() method to add speed to other toString()s
}