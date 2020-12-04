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
		
		CreateDocumentActionNew cdNew = new CreateDocumentActionNew();
		CreateDocumentActionClose cdClose = new CreateDocumentActionClose();
		
		file.add(cdNew);
		file.addSeparator();
		file.add(cdClose);
		
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		CreateDocumentActionEdit cdEdit = new CreateDocumentActionEdit();
		CreateDocumentActionDelete cdDelete = new CreateDocumentActionDelete();
		
		edit.add(cdEdit);
		edit.addSeparator();
		edit.add(cdDelete);
		
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem helpItem = new JMenuItem("Help");
		helpItem.setIcon(new ImageIcon("images/question.png"));
		helpItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		helpItem.setToolTipText("Opis o nacinu koriscenja aplikacije (Ctrl-H)");
		
		JMenuItem about = new JMenuItem("About");
		about.setIcon(new ImageIcon("images/info.png"));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		about.setToolTipText("Opis aplikacije (Ctrl-A)");
		
		help.add(helpItem);
		help.addSeparator();
		help.add(about);
		
		
		add(file);
		add(edit);
		add(help);
		
	}
}
