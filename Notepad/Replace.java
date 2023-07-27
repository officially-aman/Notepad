

import javax.swing.*;
import java.awt.event.*;


class Replace extends JDialog implements ActionListener
{
	JTextField tf1,tf2;
	JLabel lb1,lb2;
	JButton b1,b2;
	
	
	Replace()
	{
		setSize(500,300);
		setLayout(null);
		
		lb1=new JLabel("Find");
		lb1.setBounds(50,50,100,30);
		lb2=new JLabel("Replace");
		lb2.setBounds(50,100,100,30);
		add(lb1);
		add(lb2);
		tf1=new JTextField();
		tf1.setBounds(170,50,200,30);
		tf2=new JTextField();
		tf2.setBounds(170,100,200,30);
		add(tf1);
		add(tf2);
		
		b1=new JButton("Find");
		b1.setBounds(100,150,100,30);
		add(b1);
		b2=new JButton("Replace");
		b2.setBounds(220,150,100,30);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setVisible(true);
	}
	public static void main(String s[])
	{
		new Replace();
	
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
		
		if(e.getSource()==b2){
			Notepad1.ta.replaceSelection(tf2.getText());
		}
		
		
	}
}