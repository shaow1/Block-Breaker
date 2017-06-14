package BlockBreaker;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.*;

public class Brick 
{
	private int brickX, brickY, hitTime;
	private Color color;
	
	public Brick(int x, int y, int hitTime)
	{
		brickX=x;
		brickY=y;
		this.hitTime= hitTime;
		if(hitTime==1)
		{
			color=Color.blue;
		}
		else if(hitTime==2)
		{
			color=Color.green;
		}
		else if(hitTime==3)
		{
			color=Color.RED;
		}
	}
	public Color getColor()
	{
		return color;
	}
	public int getBlockX()
	{
		return brickX;
	}
	
	public int getBlockY()
	{
		return brickY;
	}
	public int getHitTime()
	{
		return hitTime;
	}
	public void setColor()
	{
		if(this.getHitTime()==1)
		{
			color=Color.blue;
		}
		else if(this.getHitTime()==2)
		{
			color=Color.green;
		}
		else
		{
			return;
		}
		
	}


	public void decade()
	{
		hitTime-=1;
	}
}
