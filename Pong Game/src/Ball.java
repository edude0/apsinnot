import java.awt.Color;
import java.awt.Graphics;

public class Ball 
{
	private int positionX;
	private int positionY;
	private boolean isUp = true;
	private boolean isRight = true;
	private int moveDistance = 8;
	
	public Ball(int x, int y)
	{
		int ran = (int) (Math.random()*2);
		isRight = (ran == 1);
		
		ran = (int) (Math.random()*2);
		isUp = (ran == 1);

		positionX = x;
		positionY = y;
	}
	
	public void move()
	{
		if (isRight)
		{
			positionX += moveDistance;
		}
		else 
		{
			positionX -= moveDistance;
		}
		
		if (isUp)
		{
			positionY += moveDistance;
		}
		else 
		{
			positionY -= moveDistance;
		}
	}
	
	public void bounceUpDown()
	{
		isUp = !isUp;
	}
	
	public void bounceLeftRight()
	{
		isRight = !isRight;
	}
	public int getX()
	{
		return positionX;
	}
	
	public int getY()
	{
		return positionY;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.red);
		g.fillRect(positionX, positionY, 10, 10);
	}
}

