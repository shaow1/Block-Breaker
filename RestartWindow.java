package BlockBreaker;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RestartWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton restart;
	private JButton restartFromFirstLevel;
	private JButton end;
	
	public RestartWindow()
	{
		super("Game Status");
		setTitle("Game Over!!!");
		setLayout(new FlowLayout());
		restart= new JButton("Restart");
		add(restart);
		
		end= new JButton("Exit");
		add(end);
		Handler myHandler= new Handler();
		restart.addActionListener(myHandler);
		end.addActionListener(myHandler);
		
	}
	private static int i;
	private class Handler implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==restart)
			{
				System.out.println("Restart");
				i=0;
				dispose();
			}

			else if(event.getSource()==end)
			{
				System.out.println("Program End");
				i=2;
				System.exit(0);
			}
		}


		
	}
	
	public int resultReturn()
	{
		return i;
	}
}