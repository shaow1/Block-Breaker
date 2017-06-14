package BlockBreaker;
import java.awt.Graphics;
import java.awt.Shape;

import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RectangularShape;


public class Paint extends JPanel
{
	private final Level levelA;
	private final Level levelB;
	private final Level levelC;
	private final Level levelD;
	private final Level levelE;
	private Bat myBat;
	private Ball myBall;
	private int level=1;
	private boolean launched;
	private boolean restart;
	private int x=-1, y=-1;
	private final int leftWall=0, rightWall=400;
	private final int topWall=30;
	private boolean ballFallDown = false;
	
	public Paint()
	{
		levelA=new Level(new File("LevelA.txt"));
		levelB=new Level(new File("LevelB.txt"));
		levelC=new Level(new File("LevelC.txt"));
		levelD=new Level(new File("LevelD.txt"));
		levelE=new Level(new File("LevelE.txt"));
		
		level=1;
		myBat= new Bat();
		myBall=new Ball();
		launched=false;
		restart=false;
	}
	
	
	private boolean getLaunch()
	{
		return launched;
	}
	private boolean getRestart()
	{
		return restart;
	}
	private void setRestart(boolean b)
	{
		restart=b;
	}
	private void setLaunched(boolean b)
	{
		launched= b;
	}
	public void paintComponent (Graphics g)
	{
		
		super.paintComponent(g);
		//The game layout
		g.setColor(Color.gray);
		g.fillRect(0, 0, 400, 315);

		//functional area
		g.setColor(Color.green);
		if (BlockBreaker.bat==true)
			g.setColor(Color.black);
		else
			g.setColor(Color.WHITE);
		 g.fill3DRect(myBat.getX(),myBat.getY(),60,10, true);
		 
		 //level1 initiation
		 if(getRestart())
		 {		
			setLaunched(false);
			setRestart(false);
		 }
		  //fill level into graph
		 	fill(g,level);
		 	 //check the ball if it launched
			  if(!getLaunch())
			  {
				  myBall.setBallX(myBat.getX()+15);
				  myBall.setBallY(myBat.getY()-15);
			  }
			  g.setColor(Color.black);
			  if (BlockBreaker.ball==true)
				  g.setColor(Color.GREEN);
			  else
				  g.setColor(Color.cyan);

			  g.fillOval(myBall.getBallX(), myBall.getBallY(), 15, 15);	
			//get the ball move
			  //collision with the wall
			  if(myBall.getBallX()<leftWall||(myBall.getBallX()+15)>rightWall)
			  {
				  x*=-1;
			  }
			  
			 if(myBall.getBallY()<topWall)
			 {
				 y*=-1;
			 }
			 //collision with the bat
			 if((myBall.getBallY()+14)==(myBat.getY())&& (myBall.getBallY()+14<=myBat.getY()+10))
			 {
				 if((myBat.getX()<(myBall.getBallX()+8))&&myBat.getX()+60>(myBall.getBallX()))
				 {
					 y*=-1;
				 }
			 }
			 //check if it launch
			if(this.getLaunch())
			{
				
				myBall.move(x,y);
			}
			//collision with the block
			//checkBlockSetting(level);
			if(level==1)
			collisionWithBrick(levelA);
			else if(level==2)
				collisionWithBrick(levelB);
			else if(level==3)
				collisionWithBrick(levelC);
			else if(level==4)
				collisionWithBrick(levelD);
			else if(level==5)
				collisionWithBrick(levelE);
		
	}
	

	//
	public void restartGame()
	{
		if(this.level==1)
			this.levelA.restart();
		else if(this.level==2)
			this.levelB.restart();
		else if(this.level==3)
			this.levelC.restart();
		else if(this.level==4)
			this.levelD.restart();
		else if(this.level==5)
			this.levelE.restart();
		setRestart(true);
	}
	public boolean breakThough()
	{
		if(this.level>5)
				return true;
		return false;
	}
	//function for BlockBreaker file to update status
	public boolean levelPass(int level)
	{
		switch (level){
		case 1:{
			return isClear(levelA);
		}
		case 2:{
			return isClear(levelB);
		}
		case 3:{
			return isClear(levelC);
		}
		case 4:{
			return isClear(levelD);
		}
		case 5:{
			return isClear(levelE);
		}
		default:
			return false;
		}
		
	}
	//
	private boolean isClear(Level current)
	{
	for(int i=0; i<current.getLength(); i++)
		{
			if(current.checkBlock(i))
			{
				return false;
			}
		}
		return true;
	}
	//
	public int levelInfo()
	{
		return level;
	}
	//
	public void nextLevel()
	{
		level++;
		launched=false;
		
	}
	//
	public void updateLeft()
	{
		if(myBat.getX()>0)
		myBat.moveLeft(); 
		
	}
	//
	public void updateRight()
	{
		if(myBat.getX()<350)
		myBat.moveRight();
	}
	//
	public void doLaunch()
	{
		launched=true;
	}
	//
	public boolean isBallDrop()
	{
		if (myBall.getBallY()<myBat.getY())
			return false;
		return true;
	}
	
	//private function for filling the brick into the JFrame
	private void fill(Graphics g,int level)
	{
		
		switch (level) {
		case 1: {
			for (int i = 0; i < levelA.getLength(); i++) {
				if (levelA.checkBlock(i)) {
					g.setColor(levelA.getColor(i));
					g.fill3DRect((levelA.getBlockX(i)),
							levelA.getBlockY(i), 30, 10, true);
				}
			}
			g.setColor(Color.black);
			break;
		}
		case 2: {
			for (int i = 0; i < levelB.getLength(); i++) {
				if (levelB.checkBlock(i)) {
					g.setColor(levelB.getColor(i));
					g.fill3DRect((levelB.getBlockX(i)),
							levelB.getBlockY(i), 30, 10, true);
				}
			}
			g.setColor(Color.black);
			break;
		}
		case 3: {
			for (int i = 0; i < levelC.getLength(); i++) {
				if (levelC.checkBlock(i)) {
					g.setColor(levelC.getColor(i));
					g.fill3DRect((levelC.getBlockX(i)),
							levelC.getBlockY(i), 30, 10, true);
				}
			}
			g.setColor(Color.black);
			break;
		}
		case 4: {
			for (int i = 0; i < levelD.getLength(); i++) {
				if (levelD.checkBlock(i)) {
					g.setColor(levelD.getColor(i));
					g.fill3DRect((levelD.getBlockX(i)),
							levelD.getBlockY(i), 30, 10, true);
				}
			}
			g.setColor(Color.black);
			break;
		}
		case 5: {
			for (int i = 0; i < levelE.getLength(); i++) {
				if (levelE.checkBlock(i)) {
					g.setColor(levelE.getColor(i));
					g.fill3DRect((levelE.getBlockX(i)),
							levelE.getBlockY(i), 30, 10, true);
				}
			}
			g.setColor(Color.black);
			break;
		}
		default:
		{
			break;
		}

		}
	}
	//private function for collision with the Brick;
	/*private void checkBlockSetting(int level)
	{
		switch (level){
			case 1:
			{
				collisionWithBrick(levelA);
			}
			case 2:
			{
				collisionWithBrick(levelB);
			}
			case 3:
			{
				collisionWithBrick(levelC);
			}
			case 4:
			{
				collisionWithBrick(levelD);
			}
			case 5:
			{
				collisionWithBrick(levelE);
			}
			default:
			{
				break;
			}
		}
	}
	*/
	private void collisionWithBrick(Level current)
	{
		for (int i = 0; i < current.getLength(); i++) 
		{
			   if (current.checkBlock(i)) //top and bottom collision
			   {
				   if (((myBall.getBallX()>current.getBlockX(i) && 
						   myBall.getBallX()<(current.getBlockX(i)+30)&&
						   (myBall.getBallY()<(current.getBlockY(i)+15) && 
								    myBall.getBallY()>current.getBlockY(i))))||(myBall.getBallX()>current.getBlockX(i) && 
											   myBall.getBallX()<(current.getBlockX(i)+30)&&
											   (myBall.getBallY()>(current.getBlockY(i)-15) && 
													    myBall.getBallY()<current.getBlockY(i)+15)))
				   {
					   
					   
					   current.decade(i);			  
					   y=-y;
					   
				   } 
				   //left and right collision
				   else if(((myBall.getBallX()>current.getBlockX(i)-15 && 
						   myBall.getBallX()<(current.getBlockX(i))&&
						   (myBall.getBallY()<(current.getBlockY(i)+3) && 
								    myBall.getBallY()>current.getBlockY(i)-3)))||(myBall.getBallX()>current.getBlockX(i)+30 && 
											   myBall.getBallX()<(current.getBlockX(i)+45)&&
											   (myBall.getBallY()>(current.getBlockY(i)-4) && 
													    myBall.getBallY()<current.getBlockY(i)+4)))
				   {
					   
					   current.decade(i);	 
					   x=-x;
				   }
				   
				   
			   }
			   
			
		}	
		
	}



	
}