package BlockBreaker;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class BreakThoughWindow extends JFrame{
	
	private JButton Restart;
	private JButton Exit;
	private JLabel textLabel;
	public BreakThoughWindow ()
	{
		super("Congratulation!!!!!");
		setLayout(new FlowLayout());	
		textLabel= new JLabel("OMG!!!   YOU BREAK US ALL!!");
		textLabel.setSize(200,100);
		add(textLabel);
		
		Exit= new JButton("Exit");
		Exit.setLocation(180,80);
		Exit.setSize(getPreferredSize());
		
		
		
		add(Exit);
		Handler myHandle= new Handler();
		Exit.addActionListener(myHandle);
	}
	
	private class Handler implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent event) {

			if(event.getSource()==Exit)
			{
				System.exit(0);
			}
			
		}
	}
}
