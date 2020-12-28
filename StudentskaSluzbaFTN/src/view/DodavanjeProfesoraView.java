package view;

import java.awt.Color;
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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.ProfesorContoller;
import main.Main;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class DodavanjeProfesoraView {
	
	private JDialog jd;
	private JPanel jp;
	
	private JLabel jlIme;
	private JLabel jlPrz;
	private JLabel jlDatum;
	private JLabel jlAdresaStan;
	private JLabel jlBrTel;
	private JLabel jleMail;
	private JLabel jlAdresaKanc;
	private JLabel jlBrLK;
	
	private JTextField jtfIme;
	private JTextField jtfPrz;
	private JTextField jtfDatum;
	private JTextField jtfAdresaStan;
	private JTextField jtfBrTel;
	private JTextField jtfeMail;
	private JTextField jtfAdresaKanc;
	private JTextField jtfBrLK;
	
	private JComboBox<String> cbTit;
	private JComboBox<String> cbZv;
	
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	
	private MyFocusListener focusListener;

	public DodavanjeProfesoraView() {
		super();
		this.jd = new JDialog();
		this.jp = new JPanel();
	}
	
	public DodavanjeProfesoraView(GlavniProzor gp) {
		super();
	
		focusListener  = new MyFocusListener();
		
		jd = new JDialog(gp, "Dodavanje profesora", true);
		jd.setSize(500,600);
		jd.setResizable(false);
		jd.setLocationRelativeTo(null);
		
		jd.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				String[] options = {"Da", "Ne" };
				int opcija = JOptionPane.showOptionDialog(jd, "Da li ste sigurni da želite da prekinete unos profesora?",
						"Prekid unosa profesora", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						GlavniProzor.resizeIcon(new ImageIcon("images/question.png")), 
						options, options[0]);
				
				if (opcija == JOptionPane.YES_OPTION) 
					jd.dispose();
				else 
					jd.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			}
		});
		
		jp = new JPanel();
		jp.setVisible(true);
		jp.setBackground(Color.WHITE);
		jp.setBorder(BorderFactory.createCompoundBorder());
		jp.setLayout(new GridBagLayout());
		Font f = new Font("sans-serif", Font.PLAIN, 13);
		
		dodajIme();
		dodajPrezime();
		dodajDatum();
		dodajAdresuStan();
		dodajBrojTel();
		dodajEMail();
		dodajAdresuKanc();
		dodajBrLK();
		dodajTitulu();
		dodajZvanje();

		btnPotvrdi = new JButton("Potvrdi");
		GridBagConstraints gbcPotvrdi = new GridBagConstraints();
		gbcPotvrdi.gridx = 3;
		gbcPotvrdi.gridy = 11;
		gbcPotvrdi.gridwidth = 3;
		gbcPotvrdi.insets = new Insets(40, 10, 0, 150);
		jp.add(btnPotvrdi, gbcPotvrdi);
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				potvrdi();
			}
		});
		
		jd.getRootPane().setDefaultButton(btnPotvrdi);
		
		btnOdustani = new JButton("Odustani");
		GridBagConstraints gbcOdustani = new GridBagConstraints();
		gbcOdustani.gridx = 5;
		gbcOdustani.gridy = 11;
		gbcOdustani.gridwidth = 3;
		gbcOdustani.insets = new Insets(40, 20, 0, 20);
		jp.add(btnOdustani, gbcOdustani);
		
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] options = {"Da", "Ne" };
				int opcija = JOptionPane.showOptionDialog(jd, "Da li ste sigurni da želite da prekinete unos profesora?",
						"Prekid unosa profesora", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						GlavniProzor.resizeIcon(new ImageIcon("images/question.png")), 
						options, options[0]);

				if (opcija == JOptionPane.YES_OPTION) 
					jd.dispose();
				else 
					jd.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			}
		});
		
		Main.changeFont(jp, f);
		jd.setIconImage(GlavniProzor.resizeIcon(new ImageIcon("images/plus.png")).getImage());
		jd.add(jp);
		jd.setVisible(true);		
	}
	
public void potvrdi() {
		
		String ime = jtfIme.getText().trim();
		String prezime = jtfPrz.getText().trim();
		String datum = jtfDatum.getText().trim();
		String adresaStan = jtfAdresaStan.getText().trim();
		String brTel = jtfBrTel.getText().trim();
		String eMail = jtfeMail.getText().trim();
		String adresaKanc = jtfAdresaKanc.getText().trim();
		String brLK = jtfBrLK.getText().trim();
		
		Titula tit;
		if(this.cbTit.getSelectedIndex() == 0) 
			tit = Titula.BSc;
		else if(this.cbTit.getSelectedIndex() == 1)
			tit = Titula.MSc;
		else if(this.cbTit.getSelectedIndex() == 2)
			tit = Titula.mr;
		else if(this.cbTit.getSelectedIndex() == 3)
			tit = Titula.dr;
		else 
			tit = Titula.ProfDr;
		
		Zvanje zv;
		if(this.cbZv.getSelectedIndex() == 0)
			zv = Zvanje.SaradnikUNastavi;
		else if(this.cbZv.getSelectedIndex() == 1)
			zv = Zvanje.Asistent;
		else if(this.cbZv.getSelectedIndex() == 2)
			zv = Zvanje.AsistentSaDoktoratom;
		else if(this.cbZv.getSelectedIndex() == 3)
			zv = Zvanje.Docent;
		else if(this.cbZv.getSelectedIndex() == 4)
			zv = Zvanje.VanredniProfesor;
		else if(this.cbZv.getSelectedIndex() == 5)
			zv = Zvanje.RedovniProfesor;
		else 
			zv = Zvanje.VanredniProfesor;
		
		String message = ProfesorContoller.getInstance().dodajProfesora(ime, prezime, datum, 
										adresaStan, brTel, eMail, adresaKanc, brLK, tit, zv);

		//JOptionPane.showMessageDialog(jd, message);
		
		if(message.equals("Uspešno ste uneli profesora!")) {
			
			JOptionPane.showMessageDialog(jd, message, "Uspešan unos", 
					JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/add-user.png")));
			
			jtfIme.setText("");
			jtfPrz.setText("");
			jtfDatum.setText("");
			jtfAdresaStan.setText("");
			jtfBrTel.setText("");
			jtfeMail.setText("");
			jtfAdresaKanc.setText("");
			jtfBrLK.setText("");
			cbTit.setSelectedIndex(0);
			cbZv.setSelectedIndex(0);
		}
		else {
			JOptionPane.showMessageDialog(jd, message, "Nisu uneti svi podaci", 
					JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/remove-user.png")));
		}
	}
	
	class MyFocusListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField txt = (JTextField) e.getComponent();
			txt.setBackground(Color.white);
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField txt = (JTextField) e.getComponent();
			JLabel label = izaberiLabelu(txt);
			
			if(txt.getText() == null || txt.getText().trim().isEmpty()) 
				label.setForeground(Color.RED);
			else 
				label.setForeground(Color.black);

			txt.setBackground(new Color(224, 224, 224));
		} 
		
		public JLabel izaberiLabelu(JTextField txt) {
			if(txt.getName().equals("txtIme")) 
				return jlIme;
			else if (txt.getName().equals("txtPrz"))
				return jlPrz;
			else if (txt.getName().equals("txtDatum"))
				return jlDatum;
			else if (txt.getName().equals("txtAdresaStan"))
				return jlAdresaStan;
			else if (txt.getName().equals("txtBrTel"))
				return jlBrTel;
			else if (txt.getName().equals("txteMail"))
				return jleMail;
			else if (txt.getName().equals("txtAdresaKanc"))
				return jlAdresaKanc;
			else if (txt.getName().equals("txtBrLK"))
				return jlBrLK;
			else 
				return null;
		}
	}
	
	private GridBagConstraints gdbcLabele (GridBagConstraints gbc, int y) {
		gbc.gridx = 0;
		gbc.gridy = y;
		gbc.gridwidth = 5;
		gbc.insets = new Insets(20, 60, 0, 0);
		gbc.anchor = GridBagConstraints.LINE_START;
		return gbc;
	}
	
	private GridBagConstraints gdbcTxt(GridBagConstraints gbc, int y) {
		gbc.gridx = 5;
		gbc.gridy = y;
		gbc.weightx = 100;
		gbc.insets = new Insets(20, 20, 0, 20);
		return gbc;
	}
	
	private void dodajIme() {
		jlIme = new JLabel("Ime*");
		GridBagConstraints gbcLabIme = new GridBagConstraints();
		gbcLabIme = gdbcLabele(gbcLabIme, 0);
		jp.add(jlIme, gbcLabIme);
		
		jtfIme = new JTextField(20);
		jtfIme.setBackground(new Color(224, 224, 224));
		jtfIme.setName("txtIme");
		jtfIme.addFocusListener(focusListener);
		
		GridBagConstraints gbctfIme = new GridBagConstraints();
		gbctfIme = gdbcTxt(gbctfIme, 0);
		jp.add(jtfIme, gbctfIme);
	}
	
	private void dodajPrezime() {
		jlPrz = new JLabel("Prezime*");
		GridBagConstraints gbcLabPrz = new GridBagConstraints();
		gbcLabPrz = gdbcLabele(gbcLabPrz, 1);
		jp.add(jlPrz, gbcLabPrz);
		
	    jtfPrz = new JTextField(20); 
	    jtfPrz.setBackground(new Color(224, 224, 224));
	    jtfPrz.setName("txtPrz");
	    jtfPrz.addFocusListener(focusListener);
		
		GridBagConstraints gbctfPrz = new GridBagConstraints();
		gbctfPrz = gdbcTxt(gbctfPrz, 1);
		jp.add(jtfPrz, gbctfPrz);
	}
	
	private void dodajDatum() {
		jlDatum = new JLabel("Datum rođenja*");
		GridBagConstraints gbcLabDatum = new GridBagConstraints();
		gbcLabDatum = gdbcLabele(gbcLabDatum, 2);
		jp.add(jlDatum, gbcLabDatum);
		
		jtfDatum = new JTextField(20); 
		jtfDatum.setBackground(new Color(224, 224, 224));
		jtfDatum.setName("txtDatum");
		jtfDatum.addFocusListener(focusListener);
		jtfDatum.setToolTipText("Format: dd.MM.yyyy.");
		GridBagConstraints gbctfDatum = new GridBagConstraints();
		gbctfDatum = gdbcTxt(gbctfDatum, 2);
		jp.add(jtfDatum, gbctfDatum);
	}
	
	private void dodajAdresuStan() {
		jlAdresaStan = new JLabel("Adresa stanovanja*");
		GridBagConstraints gbcLabAdresaStan = new GridBagConstraints();
		gbcLabAdresaStan = gdbcLabele(gbcLabAdresaStan, 3);
		jp.add(jlAdresaStan, gbcLabAdresaStan);
		
		jtfAdresaStan = new JTextField(20); 
		jtfAdresaStan.setBackground(new Color(224, 224, 224));
		jtfAdresaStan.setName("txtAdresaStan");
		jtfAdresaStan.addFocusListener(focusListener);
		GridBagConstraints gbctfAdresaStan = new GridBagConstraints();
		gbctfAdresaStan = gdbcTxt(gbctfAdresaStan, 3);
		jp.add(jtfAdresaStan, gbctfAdresaStan);
	}
	
	private void dodajBrojTel() {
		jlBrTel = new JLabel("Kontakt telefon*");
		GridBagConstraints gbcLabBrTel = new GridBagConstraints();
		gbcLabBrTel = gdbcLabele(gbcLabBrTel, 4);
		jp.add(jlBrTel, gbcLabBrTel);
		
		jtfBrTel= new JTextField(20); 
		jtfBrTel.setBackground(new Color(224, 224, 224));
		jtfBrTel.setName("txtBrTel");
		jtfBrTel.addFocusListener(focusListener);
		
		jtfBrTel.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				char c = e.getKeyChar();
				if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
						&& c != '9') {
					JOptionPane.showMessageDialog(jd, "Dozvoljen je unos samo cifara!",
											 "Greška", JOptionPane.INFORMATION_MESSAGE,
						  GlavniProzor.resizeIcon(new ImageIcon("images/cancel.png")));
					JTextField txt = (JTextField) e.getComponent();
					txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				JTextField txt = (JTextField) e.getComponent();
				if (txt.getText().length() >= 10) {
					JOptionPane.showMessageDialog(null, "Možete uneti maksimalno 10 karaktera!",
													  "Greška", JOptionPane.INFORMATION_MESSAGE,
								   GlavniProzor.resizeIcon(new ImageIcon("images/cancel.png")));
					txt.setText(txt.getText().substring(0, 10));
				}
			}
		});
		
		GridBagConstraints gbctfBrTel = new GridBagConstraints();
		gbctfBrTel = gdbcTxt(gbctfBrTel, 4);
		jp.add(jtfBrTel, gbctfBrTel);
	}
	
	private void dodajEMail() {
		jleMail = new JLabel("E-mail adresa*");
		GridBagConstraints gbcLabeMail = new GridBagConstraints();
		gbcLabeMail = gdbcLabele(gbcLabeMail, 5);
		jp.add(jleMail, gbcLabeMail);
		
		jtfeMail = new JTextField(20);
		jtfeMail.setBackground(new Color(224, 224, 224));
		jtfeMail.setName("txteMail");
		jtfeMail.addFocusListener(focusListener);
		GridBagConstraints gbctfeMail = new GridBagConstraints();
		gbctfeMail = gdbcTxt(gbctfeMail, 5);
		jp.add(jtfeMail, gbctfeMail);
	}
	
	private void dodajAdresuKanc() {
		jlAdresaKanc = new JLabel("Adresa kancelarije*");
		GridBagConstraints gbcLabelAdresaKanc = new GridBagConstraints();
		gbcLabelAdresaKanc = gdbcLabele(gbcLabelAdresaKanc, 6);
		jp.add(jlAdresaKanc, gbcLabelAdresaKanc);
		
		jtfAdresaKanc= new JTextField(20); 
		jtfAdresaKanc.setBackground(new Color(224, 224, 224));
		jtfAdresaKanc.setName("txtAdresaKanc");
		jtfAdresaKanc.addFocusListener(focusListener);
		GridBagConstraints gbctfAdresaKanc = new GridBagConstraints();
		gbctfAdresaKanc = gdbcTxt(gbctfAdresaKanc, 6);
		jp.add(jtfAdresaKanc, gbctfAdresaKanc);
	}
	
	private void dodajBrLK() {
		jlBrLK = new JLabel("Broj lične karte*");
		GridBagConstraints gbcBrLK = new GridBagConstraints();
		gbcBrLK = gdbcLabele(gbcBrLK, 7);
		jp.add(jlBrLK , gbcBrLK);
		
		jtfBrLK= new JTextField(20); 
		jtfBrLK.setBackground(new Color(224, 224, 224));
		jtfBrLK.setName("txtBrLK");
		jtfBrLK.addFocusListener(focusListener);
		
		jtfBrLK.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				char c = e.getKeyChar();
				if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
						&& c != '9') {
					JOptionPane.showMessageDialog(jd, "Dozvoljen je unos samo cifara!",
											 "Greška", JOptionPane.INFORMATION_MESSAGE,
					      GlavniProzor.resizeIcon(new ImageIcon("images/cancel.png")));
					JTextField txt = (JTextField) e.getComponent();
					txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
				}

			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
						|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				JTextField txt = (JTextField) e.getComponent();
				if (txt.getText().length() >= 9) {
					JOptionPane.showMessageDialog(null, "Morate uneti tačno 9 cifara!",
													  "Greška", JOptionPane.INFORMATION_MESSAGE,
							       GlavniProzor.resizeIcon(new ImageIcon("images/cancel.png")));
					txt.setText(txt.getText().substring(0, 9));
				}
			}
		});
		
		GridBagConstraints gbctfBrLK = new GridBagConstraints();
		gbctfBrLK = gdbcTxt(gbctfBrLK, 7);
		jp.add(jtfBrLK, gbctfBrLK );
	}
	
	private void dodajTitulu() {
		JLabel jlTitula = new JLabel("Titula*");
		GridBagConstraints gbcTitula = new GridBagConstraints();
		gbcTitula = gdbcLabele(gbcTitula, 8);
		jp.add(jlTitula, gbcTitula);
		
		
		String[] titulaProf = {"                     BSc                          ", 
							   "                     MSc                          ", 
							   "                     mr                           ", 
							   "                     dr                           ", 
							   "                     Prof. dr                     "
							   };
		this.cbTit = new JComboBox<String>(titulaProf);
		GridBagConstraints gbctfTitula = new GridBagConstraints();
		cbTit.setEditable(false);
		gbctfTitula.gridx = 5;
		gbctfTitula.gridy = 8;
		gbctfTitula.insets = new Insets(20, 20, 0, 20);
		jp.add(cbTit, gbctfTitula);
	}
	
	private void dodajZvanje() {
		JLabel jlZvanje = new JLabel("Zvanje*");
		GridBagConstraints gbcZvanje = new GridBagConstraints();
		gbcZvanje = gdbcLabele(gbcZvanje, 9);
		jp.add(jlZvanje, gbcZvanje);
		
		
		String[] zvanjeProf = {"            Saradnik u nastavi          ", 
							   "            Asistent                    ", 
							   "			Asistent sa doktoratom		", 
							   "			Docent						",
							   "			Vanredni profesor			", 
							   "			Redovni profesor			", 
							   "			Profesor emeritus			"
							   };
		this.cbZv = new JComboBox<String>(zvanjeProf);
		GridBagConstraints gbctfZvanje = new GridBagConstraints();
		cbZv.setEditable(false);
		gbctfZvanje.gridx = 5;
		gbctfZvanje.gridy = 9;
		gbctfZvanje.insets = new Insets(20, 20, 0, 20);
		jp.add(cbZv, gbctfZvanje);
	}	
}
