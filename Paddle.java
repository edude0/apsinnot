import java.awt.*;

public class Paddle
{
	private int positionX;
	private int positionY;
	private int moveDistance = 20;
	
	public Paddle(int nXpos, int nYpos)
	{
		positionX = nXpos;
		positionY = nYpos;
	}
	
	public void moveUp()
	{
			positionY -= moveDistance;
			if (positionY < 0)
			{
				positionY = 0;
			}
	}
	
	public void moveDown()
	{
		positionY += moveDistance;
		if (positionY > 230)
		{
			positionY = 230;
		}
		
	}
	
	private int randomize = (int) (Math.random() * 12);
	public void draw(Graphics g)
	{
		if (randomize == 1)
			g.setColor(Color.blue);
		if (randomize == 2)
			g.setColor(Color.red);
		if (randomize == 3)
			g.setColor(Color.green);
		if (randomize == 4)
			g.setColor(Color.yellow);
		if (randomize == 5)
			g.setColor(Color.pink);
		if (randomize == 6)
			g.setColor(Color.orange);
		if (randomize == 7)
			g.setColor(Color.black);
		if (randomize == 8)
			g.setColor(Color.cyan);
		if (randomize == 9)
			g.setColor(Color.darkGray);
		if (randomize == 10)
			g.setColor(Color.gray);
		if (randomize == 11)
			g.setColor(Color.lightGray);
		if (randomize == 12)
			g.setColor(Color.magenta);
		
		g.fillRect(positionX, positionY, 10, 70);
	}
	
	public int yPos()
	{
		return positionY;
	}
}
