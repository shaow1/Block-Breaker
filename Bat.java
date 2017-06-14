package BlockBreaker;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.*;

public class Bat 
{
	Color color= Color.cyan;
	int colorControl=0;
	private int length, position;
	private int x,y;
	private boolean Left=false, Right=false;
	public Bat()
	{
		x=196;
		y=290;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public void moveLeft()
	{
		x-=5;
	}
	public void moveRight()
	{
		x+=5;
	}
	public Color batGetColor()
	{
		return color;
	}
	public void changeColor()
	{
		colorControl++;
		if(colorControl%3==0)
		{
			color= Color.cyan;
		}
		else if(colorControl%3==1)
		{
			color= Color.blue;
		}
		else if(colorControl%3==2)
		{
			color= Color.red;
		}
	}

}
