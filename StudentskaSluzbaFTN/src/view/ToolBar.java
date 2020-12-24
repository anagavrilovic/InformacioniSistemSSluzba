package view;



//Kod napisan po uzoru na materijale sa vježbi


import java.awt.BorderLayout;
import java.awt.Desktop.Action;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		CreateDocumentActionNew cdnew = new CreateDocumentActionNew();
		//ActionEvent evt = new ActionEvent();
		//cdnew.actionPerformed(evt);
		add(cdnew);
		
		addSeparator();
		
		CreateDocumentActionEdit cdedit = new CreateDocumentActionEdit();
		add(cdedit);
		
		addSeparator();
		
		CreateDocumentActionDelete cddelete = new CreateDocumentActionDelete();
		add(cddelete);
		
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
		
		CreateDocumentActionSearch cdsearch = new CreateDocumentActionSearch();
		add(cdsearch);	
	}

}