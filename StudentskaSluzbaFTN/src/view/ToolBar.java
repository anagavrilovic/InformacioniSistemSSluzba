package view;

//Kod napisan po uzoru na materijale sa vježbi

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		CreateDocumentActionNew cdnew = new CreateDocumentActionNew();
		JButton btnNew = new JButton(cdnew);
		add(btnNew);
		
		addSeparator();
		
		CreateDocumentActionEdit cdedit = new CreateDocumentActionEdit();
		JButton btnEdit = new JButton(cdedit);
		add(btnEdit);
		
		addSeparator();
		
		CreateDocumentActionDelete cddelete = new CreateDocumentActionDelete();
		JButton btnDelete = new JButton(cddelete);
		add(btnDelete);
		
		addSeparator();
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = tk.getScreenSize();
		int heigth = screenSize.height;
		int width = screenSize.width;
		
		//add(Box.createHorizontalStrut(width/3));
		add(Box.createGlue());
		
		JTextField text = new JTextField();
		Dimension dim = new Dimension(width*5, heigth/20);
		text.setToolTipText("Unesite kriterijum pretrage");
		text.setMaximumSize(dim);
		add(text);
		
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Pretraga entiteta");
		btnSearch.setIcon(new ImageIcon("images/search.png"));
		add(btnSearch);		
	}

}