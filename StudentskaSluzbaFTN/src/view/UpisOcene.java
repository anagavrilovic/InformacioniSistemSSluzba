package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

import controller.IspitiController;
import main.Main;
import model.BazaPredmeti;
import model.Predmet;
import model.Predmet.Semestar;

public class UpisOcene {
	
	private JDialog dialog;
	private JPanel panel;
	
	private JTextField jtfSifraPred;
	private JTextField jtfNazivPred;
	private JComboBox  <Integer> cbOcena;
	private JTextField jtfDatum;
	
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	
	private String sifraPredmeta;
	private String nazivPredmeta;
	private int espb;
	private int godina;
	private Semestar semestar;
	
	private boolean validan;
	
	public UpisOcene(PrikazNepolozenihIspita pni) {
		
		if(pni.nadjiSifruPredmeta().equals("")) {
			JOptionPane.showMessageDialog(dialog, "Selektujte predmet!", "Nije selektovan nijedan predmet", 
					JOptionPane.INFORMATION_MESSAGE, GlavniProzor.resizeIcon(new ImageIcon("images/minus.png")));
			return;
		}
		
		this.sifraPredmeta = pni.nadjiSifruPredmeta();
		this.nazivPredmeta = BazaPredmeti.getInstance().pronadjiPredmet(sifraPredmeta).getNazivPredmeta();
		this.espb = BazaPredmeti.getInstance().pronadjiPredmet(sifraPredmeta).getEspb();
		this.godina = BazaPredmeti.getInstance().pronadjiPredmet(sifraPredmeta).getGodinaStudija();
		this.semestar = BazaPredmeti.getInstance().pronadjiPredmet(sifraPredmeta).getSemestar();
		
		dialog = new JDialog(GlavniProzor.getInstance(), "Unos ocene", true);
		dialog.setSize(350, 400);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setIconImage(GlavniProzor.resizeIcon(new ImageIcon("images/add.png")).getImage());
		
		dialog.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e)
		      {
				String[] options = {"Da", "Ne" };
				int opcija = JOptionPane.showOptionDialog(dialog, "Da li ste sigurni da želite da prekinete unos ocene?",
						"Prekid unosa ocene", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						GlavniProzor.resizeIcon(new ImageIcon("images/question.png")), 
						options, options[0]);
				if (opcija != JOptionPane.YES_OPTION) {
					dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				} else {
					dialog.dispose();
				}
		      }
			
		});
		
		panel = new JPanel();
		panel.setVisible(true);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(new GridBagLayout());
		
		dodajSifruPredmeta();
		dodajNazivPredmeta();
		dodajOcenu();
		dodajDatum();
		
		UpisOcene upis = this;
		
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(new Color(90, 216, 252));
		btnPotvrdi.setForeground(Color.WHITE);
		btnPotvrdi.setEnabled(false);
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				 Predmet p = BazaPredmeti.getInstance().pronadjiPredmet(upis.sifraPredmeta);
				 String datum = jtfDatum.getText();

				 int ocena = cbOcena.getSelectedIndex() + 6;
				 
				 IspitiController.getInstance().dodajPredmetUListuPolozenih(p, datum, ocena);
				 PrikazPolozenihIspita.azurirajProsekEspb();

				 dialog.dispose();
			}	
		});
		
		dialog.getRootPane().setDefaultButton(btnPotvrdi);
		GridBagConstraints gbcl = new GridBagConstraints();
		gbcl.gridx = 0;
		gbcl.gridy = 6;
		gbcl.insets = new Insets(0, 20, 30, 0);
		panel.add(btnPotvrdi, gbcl);
		
		btnOdustani = new JButton("Odustani");
		btnOdustani.setBackground(Color.white);
		btnOdustani.setForeground(new Color(90, 216, 252));
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] options = {"Da", "Ne" };
				int opcija = JOptionPane.showOptionDialog(dialog, "Da li ste sigurni da želite da prekinete unos ocene?",
						"Prekid unosa ocene", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						GlavniProzor.resizeIcon(new ImageIcon("images/question.png")), 
						options, options[0]);
				if (opcija == JOptionPane.YES_OPTION) {
					dialog.dispose();
				} 
			}
			
		});
		GridBagConstraints gbcr = new GridBagConstraints();
		gbcr.gridx = 1;
		gbcr.gridy = 6;
		gbcr.insets = new Insets(0, 0, 30, 14);
		panel.add(btnOdustani, gbcr);
		
		dialog.add(panel);
		dialog.setIconImage(GlavniProzor.resizeIcon(new ImageIcon("images/edit.png")).getImage());
		dialog.setVisible(true);
		Font f = new Font("sans-serif", Font.PLAIN, 13);
		Main.changeFont(dialog, f);
		
	}
	
	private void enablePotvrdi() {
		this.btnPotvrdi.setEnabled(true);
	}
	
	private void disablePotvrdi() {
		this.btnPotvrdi.setEnabled(false);
	}
	
	private void dodajSifruPredmeta() {
		JLabel jlSifraPred = new JLabel("Šifra* ");
		GridBagConstraints gbcl = new GridBagConstraints();
		gbcl.gridx = 0;
		gbcl.gridy = 0;
		gbcl.insets = new Insets(20, 20, 0, 40);
		panel.add(jlSifraPred, gbcl);
		
		jtfSifraPred = new JTextField(18);
		jtfSifraPred.setBackground(new Color(224, 224, 224));
		jtfSifraPred.setName("txtSifraPred");
		jtfSifraPred.setText(this.sifraPredmeta);
		jtfSifraPred.setEditable(false);
		
		GridBagConstraints gbctf = new GridBagConstraints();
		gbctf.gridx = 1;
		gbctf.gridy = 0;
		gbctf.insets = new Insets(20, 0, 0, 20);
		panel.add(jtfSifraPred, gbctf);
	}
	
	private void dodajNazivPredmeta() {
		JLabel jlNazivPred = new JLabel("Naziv* ");
		GridBagConstraints gbcl = new GridBagConstraints();
		gbcl.gridx = 0;
		gbcl.gridy = 1;
		gbcl.insets = new Insets(20, 20, 0, 40);
		panel.add(jlNazivPred, gbcl);
		
		jtfNazivPred = new JTextField(18);
		jtfNazivPred.setBackground(new Color(224, 224, 224));
		jtfNazivPred.setName("txtNazivPred");
		jtfNazivPred.setText(this.nazivPredmeta);
		jtfNazivPred.setEditable(false);
		
		GridBagConstraints gbctf = new GridBagConstraints();
		gbctf.gridx = 1;
		gbctf.gridy = 1;
		gbctf.insets = new Insets(20, 0, 0, 20);
		panel.add(jtfNazivPred, gbctf);
	}
	
	private void dodajOcenu() {
		JLabel jlOcena = new JLabel("Ocena* ");
		GridBagConstraints gbcl = new GridBagConstraints();
		gbcl.gridx = 0;
		gbcl.gridy = 2;
		gbcl.insets = new Insets(20, 20, 0, 40);
		panel.add(jlOcena, gbcl);
		
		Integer[] ocena = {6, 7, 8, 9, 10};
		
		cbOcena = new JComboBox<Integer>(ocena);
		cbOcena.setPreferredSize(new Dimension(180, 25));
		//cbOcena.setSelectedIndex(predmet.getGodinaStudija() - 1);
		cbOcena.setEditable(false);
		cbOcena.setBackground(Color.white);
		
		GridBagConstraints gbctf = new GridBagConstraints();
		gbctf.gridx = 1;
		gbctf.gridy = 2;
		gbctf.insets = new Insets(20, 0, 0, 20);
		panel.add(cbOcena, gbctf);
	}
	
	private void dodajDatum() {
		JLabel jlDatum = new JLabel("Datum*");
		GridBagConstraints gbcl = new GridBagConstraints();
		gbcl.gridx = 0;
		gbcl.gridy = 3;
		gbcl.insets = new Insets(20, 20, 100, 40);
		panel.add(jlDatum, gbcl);
		
		jtfDatum = new JTextField(18); 
		jtfDatum.setBackground(Color.white);
		jtfDatum.setName("txtDatum");
		jtfDatum.setToolTipText("Format: dd.MM.yyyy.");
		
		GridBagConstraints gbctf = new GridBagConstraints();
		gbctf.gridx = 1;
		gbctf.gridy = 3;
		gbctf.insets = new Insets(20, 0, 100, 20);
		panel.add(jtfDatum, gbctf);
		
		UpisOcene upis = this;
		
		jtfDatum.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(jtfDatum.getText() == null || jtfDatum.getText().trim().isEmpty()) {
					jlDatum.setForeground(Color.RED);
				}
				
				if(!(jtfDatum.getText() == null || jtfDatum.getText().trim().isEmpty())) {
					validan = IspitiController.getInstance().validirajDatum(jtfDatum.getText());
					
					if(!validan) {
						jlDatum.setForeground(Color.RED);
						upis.disablePotvrdi();
					}
					else {
						jlDatum.setForeground(Color.black);
						upis.enablePotvrdi();
					}	
				}
				
				jtfDatum.setBackground(new Color(224, 224, 224));
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
