package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import controller.PretragaProfesora;

public class ToolBar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnSearch;

	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		this.btnSearch = new JButton();
		
		CreateDocumentActionNew cdnew = new CreateDocumentActionNew();
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
		text.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String unos = text.getText();
 
				if(TabbedPane.getInstance().getIndex() == 0) {
 
				} else if(TabbedPane.getInstance().getIndex() == 1) {
					boolean validanUnos = PretragaProfesora.getInstance().validacijaUnosa(unos);
 
					if(validanUnos) {
						btnSearch.setEnabled(true);
						if(e.getKeyCode() == KeyEvent.VK_ENTER)
							PretragaProfesora.getInstance().pronadjiProfesore();
					}
					else {
						btnSearch.setEnabled(false);
					}
 
				} else if(TabbedPane.getInstance().getIndex() == 2) {
 
				}
 
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(text);
		
		addSeparator();
		
		btnSearch.setToolTipText("Pretraga entiteta");
		btnSearch.setIcon(GlavniProzor.resizeIcon(new ImageIcon("images/search.png")));
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(TabbedPane.getInstance().getIndex() == 0) {
					
				} else if(TabbedPane.getInstance().getIndex() == 1) {
					PretragaProfesora.getInstance().pronadjiProfesore();
				} else if(TabbedPane.getInstance().getIndex() == 2) {
					
				}
			}
		});
		add(btnSearch);
	}
	
}