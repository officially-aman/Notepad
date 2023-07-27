

import javax.swing.*;
import java.awt.event.*;


class Find extends JDialog implements ActionListener
{
	JTextField tf1;
	JLabel lb1;
	JButton b1;
	
	
	Find()
	{
		setSize(500,300);
		setLayout(null);
		
		lb1=new JLabel("Find");
		lb1.setBounds(50,50,100,30);
		add(lb1);
		
		tf1=new JTextField();
		tf1.setBounds(170,50,200,30);
		add(tf1);
		
		
		b1=new JButton("Find");
		b1.setBounds(100,150,100,30);
		add(b1);
		b1.addActionListener(this);
		
		setVisible(true);
	}
	public static void main(String s[])
	{
		new Find();
	
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			String search=tf1.getText();
			String main=Notepad1.ta.getText();
			int in=main.indexOf(search);
			Notepad1.ta.select(in,in+search.length());
			Notepad1.ta.requestFocus();
		}
		
		
		
	}
}