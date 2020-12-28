package view;

//Kod napisan po uzoru na materijale sa vježbi

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import controller.PredmetController;

public class CreateDocumentActionDelete extends AbstractAction {

	private static final long serialVersionUID = 1583426086994634757L;

	public CreateDocumentActionDelete() {
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Brisanje entiteta (Ctrl-D)");
		putValue(SMALL_ICON, GlavniProzor.resizeIcon(new ImageIcon("images/trash.png")));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(TabbedPane.getInstance().getIndex() == 0) {
			
		} else if(TabbedPane.getInstance().getIndex() == 1) {
			
		} else if(TabbedPane.getInstance().getIndex() == 2) {
			brisanjePredmeta();
		}
	}
	
	private void brisanjePredmeta() {
		
		JFrame frame = GlavniProzor.getInstance();
		
		String[] options = {"Da", "Ne" };
		
		if(TabbedPane.getInstance().getSifraPredFromSelectedRow().equals("")) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Morate selektovati red!", 
										  "Nije selektovan nijedan red", JOptionPane.INFORMATION_MESSAGE, 
										  GlavniProzor.resizeIcon(new ImageIcon("images/minus.png")));
			return;
		}
		
		int code = JOptionPane.showOptionDialog(frame.getContentPane(),"Da li ste sigurni da želite da izbrišete selektovani predmet?",
				"Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				 GlavniProzor.resizeIcon(new ImageIcon("images/trash.png")), options, null);
		
		if (code == JOptionPane.YES_OPTION) {
			String ret = PredmetController.getInstance().izbrisiPredmet(TabbedPane.getInstance().getSifraPredFromSelectedRow());
			//JOptionPane.showMessageDialog(frame, ret, "Brisanje predmeta", JOptionPane.INFORMATION_MESSAGE,
			//							   GlavniProzor.resizeIcon(new ImageIcon("images/trash.png")));	
		} else 
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}