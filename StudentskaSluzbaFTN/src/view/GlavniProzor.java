package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class GlavniProzor extends JFrame{
	

	private static final long serialVersionUID = 1L;
	public Dimension screenSize;
	public static int heigth;
	public static int width;
	
	public static GlavniProzor instance = null;
	
	public static GlavniProzor getInstance() {
		
		if (instance == null) {
			instance = new GlavniProzor();
		}
		return instance;
	}
	

	public GlavniProzor() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = tk.getScreenSize();
		//this.heigth = screenSize.height;
		//this.width = screenSize.width;
		//setSize(this.width * 3/4, this.heigth * 3/4);
		
		GlavniProzor.heigth = screenSize.height;
		GlavniProzor.width = screenSize.width;
		setSize(GlavniProzor.width * 3/4, GlavniProzor.heigth * 3/4);
		
		Font f = new Font("", Font.BOLD, 18);
		setFont(f);
		setTitle("Studentska služba");
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	
		
		MenuBar mb = new MenuBar();
		setJMenuBar(mb);

		ToolBar tb = new ToolBar();
		add(tb, BorderLayout.NORTH);
		
		JTabbedPane tp = TabbedPane.getInstance();
		add(tp, BorderLayout.CENTER);
		
		StatusBar sb = new StatusBar();
		add(sb, BorderLayout.SOUTH);	
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