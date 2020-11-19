package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

// klasa pisana po ugledu na klasu MyMenuBar iz materijala sa vezbi
public class MenuBar extends JMenuBar{

	public MenuBar() {
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		Font f = new Font("sans-serif", Font.PLAIN, 12);
		UIManager.put("Menu.font", f);
		UIManager.put("MenuItem.font", f);
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem newFile = new JMenuItem("New");
		newFile.setIcon(new ImageIcon("images/add.png"));
		newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		JMenuItem close = new JMenuItem("Close");
		close.setIcon(new ImageIcon("images/close.png"));
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		file.add(newFile);
		file.addSeparator();
		file.add(close);
		
		
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		JMenuItem editFile = new JMenuItem("Edit");
		editFile.setIcon(new ImageIcon("images/edit.png"));
		editFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		JMenuItem delete = new JMenuItem("Delete");
		delete.setIcon(new ImageIcon("images/trash.png"));
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		edit.add(editFile);
		edit.addSeparator();
		edit.add(delete);
		
		
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem helpItem = new JMenuItem("Help");
		helpItem.setIcon(new ImageIcon("images/question.png"));
		helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		
		JMenuItem about = new JMenuItem("About");
		about.setIcon(new ImageIcon("images/info.png"));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		help.add(helpItem);
		help.addSeparator();
		help.add(about);
		
		
		
		add(file);
		add(edit);
		add(help);
		
		
	}
}
