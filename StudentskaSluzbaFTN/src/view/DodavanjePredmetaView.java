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

import controller.KeyListenerPredmet;
import controller.PredmetController;
import main.Main;
import model.Predmet.Semestar;

public class DodavanjePredmetaView {
	private JDialog dialog;
	private JPanel panel;
	
	private JTextField jtfSifraPred;
	private JTextField jtfNazivPred;
	private JComboBox<String> cbSemestar;
	private JComboBox<String> cbGodStudija;
	private JTextField jtfEspb;
	
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	
	private JLabel jlSifraPred;
	private JLabel jlNazivPred;
	private JLabel jlSemestar;
	private JLabel jlGodStudija;
	private JLabel jlEspb;
	
	private GridBagConstraints gbcLeft;
	private GridBagConstraints gbcRight;
	
	private PredmetFocusListener predmetFocusListener;
	private KeyListenerPredmet predmetKeyListener;
	
	
	public DodavanjePredmetaView(GlavniProzor gp) {
		
		dialog = new JDialog(gp, "Dodavanje predmeta", true);
		dialog.setSize(500, 600);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setIconImage(GlavniProzor.resizeIcon(new ImageIcon("images/plus.png")).getImage());
		
		dialog.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e)
		      {
				String[] options = {"Da", "Ne" };
				int opcija = JOptionPane.showOptionDialog(dialog, "Da li ste sigurni da želite da prekinete unos predmeta?",
						"Prekid unosa predmeta?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
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
		
		Font f = new Font("sans-serif", Font.PLAIN, 13);
		predmetFocusListener = new PredmetFocusListener();
		predmetKeyListener = new KeyListenerPredmet(this);
		
		gbcLeft = new GridBagConstraints();
		gbcLeft.weightx = 100;
		gbcLeft.insets = new Insets(10, 50, 10, 0);
		gbcLeft.anchor = GridBagConstraints.WEST;
		
		gbcRight = new GridBagConstraints();
		gbcRight.weightx = 100;
		gbcRight.insets = new Insets(10, 0, 10, 50);
		gbcRight.anchor = GridBagConstraints.EAST;
		
		dodajSifruPredmeta();
		dodajNazivPredmeta();
		dodajSemestar();
		dodajGodinuStudija();
		dodajEsbp();
		dodajPrazanRed1();
		dodajPrazanRed2();
		
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(new Color(90, 216, 252));
		btnPotvrdi.setForeground(Color.WHITE);
		btnPotvrdi.setEnabled(false);
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				potvrdi();
			}
			
		});
		
		dialog.getRootPane().setDefaultButton(btnPotvrdi);
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 7;
		gbcLeft.insets = new Insets(0, 120, 0, 0);
		panel.add(btnPotvrdi, gbcLeft);
		
		btnOdustani = new JButton("Odustani");
		btnOdustani.setBackground(Color.WHITE);
		btnOdustani.setForeground(new Color(90, 216, 252));
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] options = {"Da", "Ne" };
				int opcija = JOptionPane.showOptionDialog(dialog, "Da li ste sigurni da želite da prekinete unos predmeta?",
						"Prekid unosa predmeta?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						GlavniProzor.resizeIcon(new ImageIcon("images/question.png")), 
						options, options[0]);
				if (opcija == JOptionPane.YES_OPTION) {
					dialog.dispose();
				} 
			}
			
		});
		gbcRight.gridx = 1;
		gbcRight.gridy = 7;
		gbcRight.insets = new Insets(0, 0, 0, 120);
		panel.add(btnOdustani, gbcRight);
		
		
		Main.changeFont(panel, f);
		dialog.add(panel);
		dialog.setVisible(true);
		
	}
	
	public class PredmetFocusListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setBackground(Color.WHITE);
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			JTextField txt = (JTextField) arg0.getComponent();
			JLabel label = izaberiLabelu(txt);
			
			if(txt.getText() == null || txt.getText().trim().isEmpty()) {
				label.setForeground(Color.RED);
			}
			
			if(!(txt.getText() == null || txt.getText().trim().isEmpty())) {
				label.setForeground(Color.black);
			}
			
			txt.setBackground(new Color(224, 224, 224));
			
		}
		
	}
	
	public JLabel izaberiLabelu(JTextField txt) {
		if(txt.getName().equals("txtSifraPred"))
			return jlSifraPred;
		else if(txt.getName().equals("txtNazivPred"))
			return jlNazivPred;
		else 
			return jlEspb;
	}
	

	public void potvrdi() {
		String sifraPred = jtfSifraPred.getText();
		String nazivPred = jtfNazivPred.getText();
		String espb = jtfEspb.getText();
		
		int godStudija = cbGodStudija.getSelectedIndex() + 1;
		Semestar semestar;
		if(cbSemestar.getSelectedIndex() == 0) {
			semestar = Semestar.ZIMSKI;
		} else {
			semestar = Semestar.LETNJI;
		}
		
		String message = PredmetController.getInstance().dodajPredmet(sifraPred, nazivPred, semestar, godStudija, espb);
			
		dialog.dispose();
		
		
	}
	
	private void dodajSifruPredmeta() {
		jlSifraPred = new JLabel("Šifra predmeta*:");
		gbcRight.gridx = 0;
		gbcRight.gridy = 0;
		panel.add(jlSifraPred, gbcLeft);
		
		jtfSifraPred = new JTextField();
		jtfSifraPred.setPreferredSize(new Dimension(205, 23));
		jtfSifraPred.setBackground(new Color(224, 224, 224));
		jtfSifraPred.setName("txtSifraPred");
		jtfSifraPred.addFocusListener(predmetFocusListener);
		jtfSifraPred.addKeyListener(predmetKeyListener);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 0;
		panel.add(jtfSifraPred, gbcRight);
	}
	
	private void dodajNazivPredmeta() {
		jlNazivPred = new JLabel("Naziv predmeta*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 1;
		panel.add(jlNazivPred, gbcLeft);
		
		jtfNazivPred = new JTextField();
		jtfNazivPred.setPreferredSize(new Dimension(205, 23));
		jtfNazivPred.setBackground(new Color(224, 224, 224));
		jtfNazivPred.setName("txtNazivPred");
		jtfNazivPred.addFocusListener(predmetFocusListener);
		jtfNazivPred.addKeyListener(predmetKeyListener);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 1;
		panel.add(jtfNazivPred, gbcRight);
	}
	
	private void dodajSemestar() {
		jlSemestar = new JLabel("Semestar*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 2;
		panel.add(jlSemestar, gbcLeft);
		
		String[] semestar = {"                       Zimski",
		 					 "                        Letnji"};
		cbSemestar = new JComboBox<String>(semestar);
		cbSemestar.setPreferredSize(new Dimension(205, 23));
		cbSemestar.setEditable(false);
		cbSemestar.setBackground(new Color(224, 224, 224));
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 2;
		panel.add(cbSemestar, gbcRight);
	}
	
	private void dodajGodinuStudija() {
		jlGodStudija = new JLabel("Godina studija*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 3;
		panel.add(jlGodStudija, gbcLeft);
		
		String[] god = {"                       I (prva)", 
				        "                       II (druga)", 
				        "                       III (treća)", 
				        "                       IV (četvrta)"};
		cbGodStudija = new JComboBox<String>(god);
		cbGodStudija.setPreferredSize(new Dimension(205, 23));
		cbGodStudija.setEditable(false);
		cbGodStudija.setBackground(new Color(224, 224, 224));
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 3;
		panel.add(cbGodStudija, gbcRight);
	}
	
	private void dodajEsbp() {
		jlEspb = new JLabel("Broj ESPB bodova:*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 4;
		panel.add(jlEspb, gbcLeft);
		
		jtfEspb = new JTextField();
		jtfEspb.setPreferredSize(new Dimension(205, 23));
		jtfEspb.setBackground(new Color(224, 224, 224));
		jtfEspb.setName("txtESPB");
		jtfEspb.addFocusListener(predmetFocusListener);
		jtfEspb.addKeyListener(predmetKeyListener);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 4;
		panel.add(jtfEspb, gbcRight);
	}
	
	private void dodajPrazanRed1() {
		JLabel label1 = new JLabel(" ");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 5;
		panel.add(label1, gbcLeft);
		
		JLabel label2 = new JLabel(" ");
		gbcRight.gridx = 1;
		gbcRight.gridy = 5;
		panel.add(label2, gbcRight);
	}
	
	private void dodajPrazanRed2() {
		JLabel label1 = new JLabel(" ");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 6;
		panel.add(label1, gbcLeft);
		
		JLabel label2 = new JLabel(" ");
		gbcRight.gridx = 1;
		gbcRight.gridy = 6;
		panel.add(label2, gbcRight);
	}
	
	public void osveziDugmad(boolean omoguci) {
		if(omoguci)
			btnPotvrdi.setEnabled(true);
		else
			btnPotvrdi.setEnabled(false);
	}
	
}
