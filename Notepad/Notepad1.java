import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

//JFileChooser
//showOpenDialog()
//showSaveDialog()

class Notepad1 implements ActionListener
{
	JFrame fr;
	JMenuBar bar;
	JMenu m,n,p;
	JMenuItem m1,m2,m3,m4,n1,n2,n3,p1,p2,p3,p4;
	static JTextArea ta;
	JToolBar tb; 
	JButton tb1,tb2,tb3;
	
	
	Notepad1()
	{
		fr=new JFrame("Notepad");
		fr.setSize(500,500);
		//fr.setLayout(null);
		
		
		bar=new JMenuBar();
		fr.setJMenuBar(bar);
		
		tb=new JToolBar();
		//tb.setBounds(10,10,200,30);
		fr.add(tb);
	
		tb1=new JButton(new ImageIcon("copy.png"));
		tb2=new JButton(new ImageIcon("cut.gif"));
		tb3=new JButton(new ImageIcon("paste.gif"));
		tb.add(tb1);
		tb.add(tb2);
		tb.add(tb3);
		
		
		
		
		ta=new JTextArea();
		fr.add(ta);
		
		m=new JMenu("File");
		n=new JMenu("Edit");
		p=new JMenu("Format");
		
		bar.add(m);
		bar.add(n);
		bar.add(p);
		
		m1=new JMenuItem("Open");
		m2=new JMenuItem("Save");
		m3=new JMenuItem("Print");
		m4=new JMenuItem("Exit");
		
		m.add(m1);
		m.add(m2);
		m.add(m3);
		m.add(m4);
		n1=new JMenuItem("Cut");
		n2=new JMenuItem("Copy");
		n3=new JMenuItem("Paste");
		n.add(n1);
		n.add(n2);
		n.add(n3);

		p1=new JMenuItem("Find");
		p2=new JMenuItem("Replace");
		p3=new JMenuItem("BackColor");
		p4=new JMenuItem("ForeColor");
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		n1.addActionListener(this);
		n2.addActionListener(this);
		n3.addActionListener(this);
		p1.addActionListener(this);
		p2.addActionListener(this);
		p3.addActionListener(this);
		p4.addActionListener(this);
		tb1.addActionListener(this);
		tb2.addActionListener(this);
		tb3.addActionListener(this);
		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
		fr.setVisible(true);				//DO_NOTHING_ON_CLOSE
	}										//HIDE_ON_CLOSE
	public static void main(String s[])
	{
		new Notepad1();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==m1)
		{
			try{
			JFileChooser jf=new JFileChooser();
			jf.showOpenDialog(fr);
			File filename=jf.getSelectedFile();
			//is used to read File stream 
			FileInputStream fin =new FileInputStream(filename);
			//no of bytes in file stream
			int size=fin.available();
			//prepare byte array to read data 
			byte b[]=new byte[size];
			fin.read(b);
			//To convert byte array into string 
			String data=new String(b);
			ta.setText(data);
			}
			catch(Exception ee)
			{}
			
		}
		if(e.getSource()==m2)
		{
			try{
			JFileChooser jf=new JFileChooser();
			jf.showSaveDialog(fr);
			File filename=jf.getSelectedFile();
			PrintStream ps=new PrintStream(filename);
			String data=ta.getText();
			ps.println(data);
			}
			catch(Exception ee)
			{}
			
		}
		if(e.getSource()==m3)
		{
			try
			{
			ta.print();
			}
			catch(Exception ee)
			{}
		}
		if(e.getSource()==m4)
		{
			System.exit(0);
		}
		if(e.getSource()==n1 || e.getSource()==tb2)
		{
			ta.cut();
			
		}
		if(e.getSource()==n2 || e.getSource()==tb1)
		{
			ta.copy();
		}
		if(e.getSource()==n3 || e.getSource()==tb3)
		{
			
			ta.paste();
		}
		if(e.getSource()==p3)
		{
			Color c=JColorChooser.showDialog(fr,"ColorDialog",Color.red);
			ta.setBackground(c);
		}
		if(e.getSource()==p4)
		{
			Color c=JColorChooser.showDialog(fr,"ColorDialog",Color.red);
			ta.setForeground(c);
			
		}
		if(e.getSource()==p1)
		{
			new Find();
		}
		
		if(e.getSource()==p2)
		{
			new Replace();
		}
			
		
		
	}
}


