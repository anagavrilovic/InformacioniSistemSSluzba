package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GlavniProzor extends JFrame{
	
	public Dimension screenSize;
	public static int heigth;
	public static int width;
	
	public GlavniProzor() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = tk.getScreenSize();
		this.heigth = screenSize.height;
		this.width = screenSize.width;
		
		setSize(this.width * 3/4, this.heigth * 3/4);
		setTitle("Studentska služba");
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	
		
		MenuBar mb = new MenuBar();
		setJMenuBar(mb);

		ToolBar tb = new ToolBar();
		add(tb, BorderLayout.NORTH);
		
		StatusBar sb = new StatusBar();
		add(sb, BorderLayout.SOUTH);
		
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		JLabel l = new JLabel("TODO: Prikaz entiteta sistema");
		panel.add(l);
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Dimension getScreenSize() {
		return screenSize;
	}		
	
}