import java.applet.*;
import java.awt.event.*;

import java.awt.*;

public class Pong extends Applet implements KeyListener, Runnable
{
	private boolean gameOver = false;
	Thread animation;
	static final int REFRESH_RATE = 40;
	Graphics offscreen;
	Image image;
	
	Ball ball;
	Paddle leftPaddle;
	Paddle rightPaddle;
	private static final int sizeX = 500;
	private static final int sizeY = 300;
	private int paddleHeight = 70;
	
	public void init()
	{
		gameOver = false;
		
		ball = new Ball(sizeX/2, sizeY/2);
		leftPaddle = new Paddle(0, sizeY/2);
		rightPaddle = new Paddle(sizeX-10, sizeY/2);
		
		addKeyListener(this);
		requestFocus();
		setSize(500,300);
		image = createImage(sizeX, sizeY);
        offscreen = image.getGraphics();
	}
	
	public void paint(Graphics g)
    {
		if (gameOver)
		{
			g.drawString("GAME OVER!", sizeX/2-45, sizeY/2);
		}
		else 
		{
			//clear offscreen
			offscreen.setColor(Color.white);
			offscreen.fillRect(0,0,sizeX, sizeY);
			
			//modify code so that drawing is offscreen
			ball.draw(offscreen);
			leftPaddle.draw(offscreen);
			rightPaddle.draw(offscreen);
			requestFocus();

			//copy offscreen to visible screen
			g.drawImage(image, 0, 0, this);
		}
    }
	
	public void update(Graphics g)
    {
  		paint(g);
    }

	public void start()
	{
		animation = new Thread(this);
		if (animation != null)
		{
			animation.start();
		}
	}

	@Override
	public void run()
	{
		while (!gameOver)
		{
			ball.move();
			if (ball.getY() >= sizeY || ball.getY() <= 0)
			{
				ball.bounceUpDown();
			}
			
			if (ball.getX() <= 0)
			{
				if ((ball.getY() >= leftPaddle.yPos()) && (ball.getY() <= leftPaddle.yPos() + paddleHeight))
				{
					ball.bounceLeftRight();
				}
				
				else
				{
					stop();
				}
			}
			
			if (ball.getX() >= sizeX)
			{
				if ((ball.getY() >= rightPaddle.yPos()) && (ball.getY() <= rightPaddle.yPos() + paddleHeight))
				{
					ball.bounceLeftRight();
				}
				
				else
				{
					stop();
				}
			}
			/*if ((ball.getX() <= 0 && ((ball.getY() <= leftPaddle.yPos() + paddleHeight/2) && (ball.getY() >= leftPaddle.yPos() - paddleHeight/2))) || 
	
				(ball.getX() >= sizeX && ((ball.getY() <= rightPaddle.yPos() + paddleHeight/2) && (ball.getY() >= rightPaddle.yPos() - paddleHeight/2))))
			{
				ball.bounce();
			}*/
			
			repaint();
				
			try
			{
				Thread.sleep(REFRESH_RATE);
			}
				
			catch(Exception exc){System.out.println(exc.getMessage());};
		}
	}
	
	public void stop()
	{
		animation = null;
		gameOver = true;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{

        char X = (char) e.getKeyCode();
        if(X == 'A')
        leftPaddle.moveUp();

        if(X == 'Z')
        leftPaddle.moveDown();

        if(X == 'K')
        rightPaddle.moveUp();

        if(X == 'M')
        	rightPaddle.moveDown();

        repaint();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
}
