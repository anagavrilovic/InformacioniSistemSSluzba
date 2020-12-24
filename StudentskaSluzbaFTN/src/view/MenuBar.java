package view;

import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

// klasa pisana po ugledu na klasu MyMenuBar iz materijala sa vežbi
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
		
		CreateDocumentActionHelp cdHelp = new CreateDocumentActionHelp();
		CreateDocumentActionAbout cdAbout = new CreateDocumentActionAbout();
		
		help.add(cdHelp);
		help.addSeparator();
		help.add(cdAbout);
		
		
		add(file);
		add(edit);
		add(help);
		
	}
}
