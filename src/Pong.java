//Student version
//Name -
//Date -
//Lab  - Pong

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;


	public Pong()
	{
		//**instantiate a new Ball object
		//**instantiate a new leftPaddle object
		//**instantiate a new rightPaddle object
		ball = new Ball();
		leftPaddle = new Paddle(20,300,20, 50, 5);
		rightPaddle = new Paddle(740,300, 20, 50, 5);

		keys = new boolean[4];


    	setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}

   public void update(Graphics w){
	   paint(w);
   }

   
   public boolean ballWithinPaddleRange(Paddle rPad, Paddle lPad, Ball b) { 
	   // rPad.y 
	   
	   boolean rPadWithinY = (b.getY() > rPad.getTop()) && (b.getY() < rPad.getBottom());  
	   boolean rPadWithinX = (b.getX() >= rPad.getX() - rPad.getWidth()); 
	   boolean rPadWithinRange = rPadWithinY && rPadWithinX; 
	  
	   boolean lPadWithinY = (b.getY() > lPad.getTop()) && (b.getY() < lPad.getBottom());  
	   boolean lPadWithinX = (b.getX() <= lPad.getX() + lPad.getWidth()); 
	   boolean lPadWithinRange = lPadWithinY && lPadWithinX; 
	   
	   return rPadWithinRange || lPadWithinRange; 
	   
   }
   public void paint(Graphics w)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)w;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics window = back.createGraphics();


		ball.moveAndDraw(window);
		leftPaddle.draw(window);
		rightPaddle.draw(window);
		int h = getHeight();
		int wi = getWidth();



		//see if ball hits top wall or bottom wall
		if(!(ball.getY()>=10 && ball.getY()<=(getHeight()-10)))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		//**see if the ball hits the left paddle OR if the ball hits the right paddle

		if(ballWithinPaddleRange(rightPaddle, leftPaddle, ball))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}


		


		






		//**see if the paddles need to be moved (I did left paddle)
		if(keys[0] == true)
		{
			leftPaddle.moveUpAndDraw(window);
		}
		if(keys[1] == true)
		{
			leftPaddle.moveDownAndDraw(window);
		}
		if(keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(window);
		}
		if(keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(window);
		}





		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}