package view;

//Kod napisan po uzoru na materijale sa vežbi

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import controller.PredmetController;

import controller.ProfesorContoller;
import controller.StudentController;


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
			izvrsiBrisanjeStudenta();
		} else if(TabbedPane.getInstance().getIndex() == 1) {
			izvrsiBrisanjeProfesora();
		} else if(TabbedPane.getInstance().getIndex() == 2) {
			brisanjePredmeta();
		}
		
	}
	
	private void izvrsiBrisanjeStudenta() {

		if(TabbedPane.getInstance().getIndexFromSelectedRow().equals("")) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Selektujte studenta!", "Nije selektovan nijedan student", 
					JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/minus.png")));
			return;
		}
		
		String[] options = {"Da", "Ne" };
		int opcija = JOptionPane.showOptionDialog(GlavniProzor.getInstance(), "Da li ste sigurni da želite da izbrišete studenta?",
				"Brisanje studenta?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
				GlavniProzor.resizeIcon(new ImageIcon("images/trash.png")), 
				options, options[1]);
		if (opcija != JOptionPane.YES_OPTION) {
			return;
		} else {
			String message = StudentController.getInstance().izbrisiStudenta(TabbedPane.getInstance().getIndexFromSelectedRow());
		}
		
	}
	
	private void izvrsiBrisanjeProfesora() {
		
		if(TabbedPane.getInstance().nadjiKlljuc().equals("")) {
			JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Selektujte profesora!", "Nije selektovan nijedan profesor", 
					JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/minus.png")));
			return;
		}
		
		String[] options = {"Da", "Ne" };
		int opcija = JOptionPane.showOptionDialog(GlavniProzor.getInstance(), "Da li ste sigurni da želite da izbrišete profesora?",
				"Brisanje profesora?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
				GlavniProzor.resizeIcon(new ImageIcon("images/trash.png")), 
				options, options[1]);
		if (opcija != JOptionPane.YES_OPTION) {
			return;
		} else {
			String message = ProfesorContoller.getInstance().izbrisiProfesora(TabbedPane.getInstance().nadjiKlljuc());
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
				 GlavniProzor.resizeIcon(new ImageIcon("images/trash.png")), options, options[1]);
		
		if (code == JOptionPane.YES_OPTION) {
			String ret = PredmetController.getInstance().izbrisiPredmet(TabbedPane.getInstance().getSifraPredFromSelectedRow());
			/*JOptionPane.showMessageDialog(frame, ret, "Brisanje predmeta", JOptionPane.INFORMATION_MESSAGE,
										   GlavniProzor.resizeIcon(new ImageIcon("images/trash.png")));	*/
		} else 
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

}