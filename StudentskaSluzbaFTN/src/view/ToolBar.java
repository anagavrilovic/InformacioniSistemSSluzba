package view;

//Kod preuzet sa materijala sa vjezbi

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

import view.CreateDocumentAction;

public class ToolBar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		CreateDocumentAction cda = new CreateDocumentAction();
		String ak="Accelerator Key";
		String mk="Mnemonic Key";
		
		cda.putValue(ak, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		cda.putValue(mk, KeyEvent.VK_N);
		JButton btnNew = new JButton(cda);
		btnNew.setToolTipText("Dodavanje novog entiteta (CTRL+N)");
		btnNew.setIcon(new ImageIcon("images/add.png"));
		add(btnNew);
		
		addSeparator();
		
		cda.putValue(ak, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
		cda.putValue(mk, KeyEvent.VK_E);
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Izmena postojeceg entiteta (CTRL+E)");
		btnEdit.setIcon(new ImageIcon("images/edit.png"));
		add(btnEdit);
		
		addSeparator();
		
		cda.putValue(ak, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
		cda.putValue(mk, KeyEvent.VK_D);
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Brisanje entiteta (CTRL+D )");
		btnDelete.setIcon(new ImageIcon("images/delete.png"));
		add(btnDelete);
		
		addSeparator();
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = tk.getScreenSize();
		int heigth = screenSize.height;
		int width = screenSize.width;
		
		//add(Box.createHorizontalStrut(width/2));
		add(Box.createGlue());
		
		JTextField text = new JTextField();
		Dimension dim = new Dimension(width*5, heigth/20);
		text.setMaximumSize(dim);
		add(text);
		
		addSeparator();
		
		cda.putValue(ak, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		cda.putValue(mk, KeyEvent.VK_S);
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Pretraga entiteta (CTRL+S)");
		btnSearch.setIcon(new ImageIcon("images/search.png"));
		add(btnSearch);		
	}

}