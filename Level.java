package BlockBreaker;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;

public class Level {
	private int i=0;
	private Brick[] level;
	private Scanner dataReader = null;
	File store;
	public Level(File a) {
		
		
		store= a;
		try{
			dataReader= new Scanner(a);
		}catch (FileNotFoundException e)
		{
			System.out.println("Level Reading Error.");
			System.exit(0);
		}
		
		
		while(dataReader.hasNextLine())
		{
			dataReader.nextLine();
			i++;
		}
		level= new Brick[i];
		try{
			dataReader= new Scanner(a);
		}catch (FileNotFoundException e)
		{
			System.out.println("Level Reading Error.");
			System.exit(0);
		}
		int count=0;
		while(dataReader.hasNextLine())
		{
			String content= dataReader.nextLine();
			String[] split= content.split("\\,");
			int[] data= new int[3];
			for(int j=0;j<3;j++)
			{
				data[j]= Integer.parseInt(split[j]);
			}
			level[count]= new Brick(data[0], data[1], data[2]);
			count++;
		}
		
		dataReader.close();
	}
	public void restart()
	{
		try{
			dataReader= new Scanner(store);
		}catch (FileNotFoundException e)
		{
			System.out.println("Level Reading Error.");
			System.exit(0);
		}
		int count=0;
		while(dataReader.hasNextLine())
		{
			String content= dataReader.nextLine();
			String[] split= content.split("\\,");
			int[] data= new int[3];
			for(int j=0;j<3;j++)
			{
				data[j]= Integer.parseInt(split[j]);
			}
			level[count]= new Brick(data[0], data[1], data[2]);
			count++;
		}
		dataReader.close();
	}
	public Color getColor(int pos)
	{
		return level[pos].getColor();
	}
	
	public int getBlockX(int pos)
	{
		return level[pos].getBlockX();
	}
	
	public boolean checkBlock(int pos)
	{
		if (level[pos]==null)
			return false;
		return true;
	}
	
	public int getBlockY(int pos)
	{
		return level[pos].getBlockY();
	}
	
	public int getHitTime(int pos)
	{
		return level[pos].getHitTime();
	}
	
	public void setColor(int pos)
	{
		 level[pos].setColor();
		
	}

	public int getLength()
	{
		return level.length;
	}
	public void decade(int pos) 
	{
		level[pos].decade();
		 if(level[pos].getHitTime()==0)
		   {
			   level[pos]=null;
		   }
		   else
		   {
			   level[pos].setColor();
		   }
	}
	
	

	}



