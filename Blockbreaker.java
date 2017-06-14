package BlockBreaker;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BlockBreaker extends JPanel implements KeyListener {

	private static boolean Left= false;
	
	private static boolean Right=false;
	private static boolean launch= false;
	
	public static boolean bat = true;
	public static boolean ball = true;

	public BlockBreaker() 
	{
		addKeyListener(this);
		setFocusable(true);
		
	}
	
	
	public static void main(String[] args) 
	{
		boolean flag=false;
		Object[] options= {"Change bat color","change ball color","play"};
		int response=JOptionPane.showOptionDialog(null," Here are your options: ", "Welcome!!!!!!!!!!!", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		if(response==0)
		{
			bat = false;
			flag=true;
		}
		else if (response==1)
		{
			ball=false;
			flag=true;
		
		}
		else if(response==2)
		{
			flag=true;
		}
		else
		{
			System.exit(0);
		}
		while (flag==true)
		{
		BlockBreaker a = new BlockBreaker();
		// Set up the Frame
		JFrame frame = new JFrame();
		frame.setSize(400, 310);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(a);
		

		// Set up the content
		boolean ballDrop = false;
		Paint ob = new Paint();
		frame.add(ob);
		//if u won the game, window pop up
		if(ob.breakThough())
		{
			System.out.println("Game Done");
			BreakThoughWindow myEndWindow= new BreakThoughWindow();
			myEndWindow.setDefaultCloseOperation(myEndWindow.EXIT_ON_CLOSE);
			myEndWindow.setSize(400, 300);
			myEndWindow.setVisible(true);
			
			
		}
		while (!ballDrop) {

			if (Left) {
				ob.updateLeft();
			}
			if (Right) {
				ob.updateRight();
			}
			if (launch) {
			
				ob.doLaunch();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			// check the user input for the board control
			ob.paintComponent(frame.getGraphics());
			
				
			ballDrop = ob.isBallDrop();
			
			if (ob.levelPass(ob.levelInfo())) 
			{
				
				
				System.out.println("Next Level");
				System.out.println(ob.levelInfo());
				ob.nextLevel();
				 ballDrop=false;
				 ob.repaint();
				
			}
			else if (ballDrop)
			{
				
				RestartWindow myWindow = new RestartWindow();
				myWindow.setDefaultCloseOperation(myWindow.EXIT_ON_CLOSE);
				myWindow.setSize(400, 300);
				myWindow.setVisible(true);
				
				if (myWindow.resultReturn() == 0) 
				{
					ob.restartGame();
					System.out.println("BB restart");
					ballDrop = false;
					
				} 
				else
				{
					frame.dispose();
				}
			}
		}
		flag=false;
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	
			Left = true;
			Right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		
			Left = false;
			Right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			launch = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Left = false;
		Right = false;
		launch = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
