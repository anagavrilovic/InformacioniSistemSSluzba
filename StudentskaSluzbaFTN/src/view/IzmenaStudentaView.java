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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

import controller.StudentController;
import main.Main;
import model.BazaStudenti;
import model.Student;
import model.Student.Status;

public class IzmenaStudentaView {
	
	private JDialog dialog;
	private JPanel panelInfo;
	private PrikazPolozenihIspita panelPolozeni;
	private JPanel panelNepolozeni;
	
	private JTextField jtfIme;
	private JTextField jtfPrezime;
	private JTextField jtfDatum;
	private JTextField jtfAdresa;
	private JTextField jtfBrojTel;
	private JTextField jtfEmail;
	private JTextField jtfBrInd;
	private JTextField jtfGodUpisa;
	private JComboBox<String> cbTrGod;
	private JComboBox<String> cbFin;
	
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	
	private JLabel jlIme;
	private JLabel jlPrezime;
	private JLabel jlDatum;
	private JLabel jlAdresa;
	private JLabel jlBrojTel;
	private JLabel jlEmail;
	private JLabel jlBrInd;
	private JLabel jlGodUpisa;
	private JLabel jlTrGod;
	private JLabel jlFin;

	
	private GridBagConstraints gbcLeft;
	private GridBagConstraints gbcRight;
	
	private StudentFocusListener studentFocusListener;
	private Student student;
	
	
	public IzmenaStudentaView(GlavniProzor gp, String index) {
		
		if(index.equals("")) {
			JOptionPane.showMessageDialog(dialog, "Selektujte red!", "Nije selektovan nijedan red", JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/minus.png")));
			return;
		}
		
		student = BazaStudenti.getInstance().pronadjiStudenta(index);
		
		dialog = new JDialog(gp, "Izmena studenta", true);
		dialog.setSize(800, 600);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setIconImage(GlavniProzor.resizeIcon(new ImageIcon("images/edit.png")).getImage());
		
		dialog.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e)
		      {
				String[] options = {"Da", "Ne" };
				int opcija = JOptionPane.showOptionDialog(dialog, "Da li ste sigurni da želite da prekinete izmenu studenta?",
						"Prekid izmene studenta?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						GlavniProzor.resizeIcon(new ImageIcon("images/question.png")), 
						options, options[0]);
				if (opcija != JOptionPane.YES_OPTION) {
					dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				} else {
					dialog.dispose();
				}
		      }
			
		});
		
		panelInfo = new JPanel();
		panelInfo.setVisible(true);
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panelInfo.setLayout(new GridBagLayout());
		
		Font f = new Font("sans-serif", Font.PLAIN, 13);
		studentFocusListener = new StudentFocusListener();
		
		gbcLeft = new GridBagConstraints();
		gbcLeft.weightx = 100;
		gbcLeft.insets = new Insets(10, 200, 10, 0);
		gbcLeft.anchor = GridBagConstraints.WEST;
		
		gbcRight = new GridBagConstraints();
		gbcRight.weightx = 100;
		gbcRight.insets = new Insets(10, 0, 10, 200);
		gbcRight.anchor = GridBagConstraints.EAST;
		
		dodajIme();
		dodajPrezime();
		dodajDatumRodjenja();
		dodajAdresu();
		dodajBrojTelefona();
		dodajEmail();
		dodajBrojIndeksa();
		dodajGodUpisa();
		dodajTrenutnuGodStudija();
		dodajNacinFin();
		dodajPrazanRed();
		
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(new Color(90, 216, 252));
		btnPotvrdi.setForeground(Color.WHITE);
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				potvrdi();
			}
			
		});
		
		dialog.getRootPane().setDefaultButton(btnPotvrdi);
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 11;
		gbcLeft.insets = new Insets(0, 270, 0, 0);
		panelInfo.add(btnPotvrdi, gbcLeft);
		
		btnOdustani = new JButton("Odustani");
		btnOdustani.setBackground(Color.white);
		btnOdustani.setForeground(new Color(90, 216, 252));
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] options = {"Da", "Ne" };
				int opcija = JOptionPane.showOptionDialog(dialog, "Da li ste sigurni da želite da prekinete izmenu studenta?",
						"Prekid izmene studenta?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						GlavniProzor.resizeIcon(new ImageIcon("images/question.png")), 
						options, options[0]);
				if (opcija == JOptionPane.YES_OPTION) {
					dialog.dispose();
				} 
			}
			
		});
		gbcRight.gridx = 1;
		gbcRight.gridy = 11;
		gbcRight.insets = new Insets(0, 0, 0, 270);
		panelInfo.add(btnOdustani, gbcRight);
		
		panelPolozeni = new PrikazPolozenihIspita(index);
		panelNepolozeni =new PrikazNepolozenihIspita(index);
		
		Main.changeFont(panelInfo, f);
		
		JTabbedPane tp = new JTabbedPane();
		tp.setBackground(new Color(90, 216, 252));
		tp.setForeground(Color.WHITE);
		
		tp.addTab("Informacije", panelInfo);
		tp.addTab("Položeni", panelPolozeni);
		tp.addTab("Nepoloženi", panelNepolozeni);
		dialog.add(tp);
		dialog.setVisible(true);
	}
	
	public class StudentFocusListener implements FocusListener {

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
		if(txt.getName().equals("txtIme"))
			return jlIme;
		else if(txt.getName().equals("txtPrezime"))
			return jlPrezime;
		else if(txt.getName().equals("txtAdresa"))
			return jlAdresa;
		else if(txt.getName().equals("txtBrInd"))
			return jlBrInd;
		else if(txt.getName().equals("txtBrojTel"))
			return jlBrojTel;
		else if(txt.getName().equals("txtDatum"))
			return jlDatum;
		else if(txt.getName().equals("txtEmail"))
			return jlEmail;
		else
			return jlGodUpisa;
	}
	

	public void potvrdi() {
		String ime = jtfIme.getText();
		String prezime = jtfPrezime.getText();
		String datRodj = jtfDatum.getText();
		String adresa = jtfAdresa.getText();
		String brTel = jtfBrojTel.getText();
		String email = jtfEmail.getText();
		String brojInd = jtfBrInd.getText();
		String godUpisa = jtfGodUpisa.getText();
		int trGod = cbTrGod.getSelectedIndex() + 1;
		Status status;
		if(cbFin.getSelectedIndex() == 0) {
			status = Status.B;
		} else {
			status = Status.S;
		}
		
		String message = StudentController.getInstance().izmeniStudenta(student.getBrojIndeksa(), ime, prezime, datRodj, adresa, brTel, email, 
				brojInd, godUpisa, trGod, status);
		
		if (!message.equals("Student uspešno izmenjen!")) {
			JOptionPane.showMessageDialog(dialog, message, "Nisu ispravno uneti svi podaci", JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/remove-user.png")));
		} else  {
			JOptionPane.showMessageDialog(dialog, message, "Uspešno uneti podaci", JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/add-user.png")));
			dialog.dispose();
		}
	}
	
	private void dodajIme() {
		jlIme = new JLabel("Ime*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 0;
		panelInfo.add(jlIme, gbcLeft);
		
		jtfIme = new JTextField(20);
		jtfIme.setBackground(new Color(224, 224, 224));
		jtfIme.setName("txtIme");
		jtfIme.setText(student.getIme());
		jtfIme.addFocusListener(studentFocusListener);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 0;
		panelInfo.add(jtfIme, gbcRight);
	}
	
	private void dodajPrezime() {
		jlPrezime = new JLabel("Prezime*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 1;
		panelInfo.add(jlPrezime, gbcLeft);
		
		jtfPrezime = new JTextField(20);
		jtfPrezime.setBackground(new Color(224, 224, 224));
		jtfPrezime.setName("txtPrezime");
		jtfPrezime.setText(student.getPrezime());
		jtfPrezime.addFocusListener(studentFocusListener);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 1;
		panelInfo.add(jtfPrezime, gbcRight);
	}
	
	private void dodajDatumRodjenja() {
		jlDatum = new JLabel("Datum rodjenja*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 2;
		panelInfo.add(jlDatum, gbcLeft);
		
		jtfDatum = new JTextField(20);
		jtfDatum.setBackground(new Color(224, 224, 224));
		jtfDatum.setToolTipText("dd.MM.yyyy.");
		jtfDatum.setName("txtDatum");
		jtfDatum.setText(dateToString(student.getDatumRodjenja()));
		jtfDatum.addFocusListener(studentFocusListener);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 2;
		panelInfo.add(jtfDatum, gbcRight);
	}
	
	private void dodajAdresu() {
		jlAdresa = new JLabel("Adresa stanovanja*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 3;
		panelInfo.add(jlAdresa, gbcLeft);
		
		jtfAdresa = new JTextField(20);
		jtfAdresa.setBackground(new Color(224, 224, 224));
		jtfAdresa.setName("txtAdresa");
		jtfAdresa.setText(student.getAdresaStanovanja());
		jtfAdresa.addFocusListener(studentFocusListener);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 3;
		panelInfo.add(jtfAdresa, gbcRight);
	}
	
	private void dodajBrojTelefona() {
		jlBrojTel = new JLabel("Broj telefona*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 4;
		panelInfo.add(jlBrojTel, gbcLeft);
		
		jtfBrojTel = new JTextField(20);
		jtfBrojTel.setBackground(new Color(224, 224, 224));
		jtfBrojTel.setName("txtBrojTel");
		jtfBrojTel.setText(student.getKontaktTelefon());
		jtfBrojTel.addFocusListener(studentFocusListener);
		jtfBrojTel.addKeyListener(new KeyListener() {
			 
			@Override
			public void keyTyped(KeyEvent e) {
			}
 
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				char c = e.getKeyChar();
				if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
						&& c != '9') {
					JOptionPane.showMessageDialog(dialog, "Dozvoljen je unos samo brojeva!", "Greška", JOptionPane.INFORMATION_MESSAGE, 
							GlavniProzor.resizeIcon(new ImageIcon("images/cancel.png")));
					JTextField txt = (JTextField) e.getComponent();
					txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
				}
			}
 
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				JTextField txt = (JTextField) e.getComponent();
				if (txt.getText().length() >= 10) {
					JOptionPane.showMessageDialog(null, "Možete uneti maksimalno 10 karaktera!", "Greška", JOptionPane.INFORMATION_MESSAGE, 
							GlavniProzor.resizeIcon(new ImageIcon("images/cancel.png")));
					txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
				}
			}
		});
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 4;
		panelInfo.add(jtfBrojTel, gbcRight);
	}
	
	private void dodajEmail() {
		jlEmail = new JLabel("E-mail adresa*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 5;
		panelInfo.add(jlEmail, gbcLeft);
		
		jtfEmail = new JTextField(20);
		jtfEmail.setBackground(new Color(224, 224, 224));
		jtfEmail.setName("txtEmail");
		jtfEmail.setText(student.getEmail());
		jtfEmail.addFocusListener(studentFocusListener);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 5;
		panelInfo.add(jtfEmail, gbcRight);
	}
	
	private void dodajBrojIndeksa() {
		jlBrInd = new JLabel("Broj indeksa*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 6;
		panelInfo.add(jlBrInd, gbcLeft);
		
		jtfBrInd = new JTextField(20);
		jtfBrInd.setBackground(new Color(224, 224, 224));
		jtfBrInd.setName("txtBrInd");
		jtfBrInd.setText(student.getBrojIndeksa());
		jtfBrInd.addFocusListener(studentFocusListener);
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 6;
		panelInfo.add(jtfBrInd, gbcRight);
	}
	
	private void dodajGodUpisa() {
		jlGodUpisa = new JLabel("Godina upisa*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 7;
		panelInfo.add(jlGodUpisa, gbcLeft);
		
		jtfGodUpisa = new JTextField(20);
		jtfGodUpisa.setBackground(new Color(224, 224, 224));
		jtfGodUpisa.setName("txtGodUpisa");
		jtfGodUpisa.setText(godinaUpisaToString(student.getGodinaUpisa()));
		jtfGodUpisa.addFocusListener(studentFocusListener);
		jtfGodUpisa.addKeyListener(new KeyListener() {
			 
			@Override
			public void keyTyped(KeyEvent e) {
			}
 
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				char c = e.getKeyChar();
				if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
						&& c != '9') {
					JOptionPane.showMessageDialog(dialog, "Dozvoljen je unos samo cifara!", "Greška", JOptionPane.INFORMATION_MESSAGE, 
							GlavniProzor.resizeIcon(new ImageIcon("images/cancel.png")));
					JTextField txt = (JTextField) e.getComponent();
					txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
				}
			}
 
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				JTextField txt = (JTextField) e.getComponent();
				if (txt.getText().length() >= 4) {
					JOptionPane.showMessageDialog(null, "Morate uneti tačno 4 karaktera!", "Greška", JOptionPane.INFORMATION_MESSAGE, 
							GlavniProzor.resizeIcon(new ImageIcon("images/cancel.png")));
					txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
				}
			}
		});
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 7;
		panelInfo.add(jtfGodUpisa, gbcRight);
	}
	
	private void dodajTrenutnuGodStudija() {
		jlTrGod = new JLabel("Trenutna godina studija*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 8;
		panelInfo.add(jlTrGod, gbcLeft);
		
		String[] god = {"                    I (prva)                    ", 
				        "                    II (druga)                  ", 
				        "                    III (treća)                 ", 
				        "                    IV (četvrta)                "};
		cbTrGod = new JComboBox<String>(god);
		cbTrGod.setSelectedIndex(student.getTrGodStudija() - 1);
		cbTrGod.setEditable(false);
		cbTrGod.setBackground(new Color(224, 224, 224));
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 8;
		panelInfo.add(cbTrGod, gbcRight);
	}
	private void dodajNacinFin() {
		jlFin = new JLabel("Način finansiranja*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 9;
		panelInfo.add(jlFin, gbcLeft);
		
		String[] nacin = {"                    Budžet              ", 
				          "               Samofinansiranje         "};
		cbFin = new JComboBox<String>(nacin);

		if(student.getStatus() == Status.B)
			cbFin.setSelectedIndex(0);
		else
			cbFin.setSelectedIndex(1);
		
		cbFin.setEditable(false);
		cbFin.setBackground(new Color(224, 224, 224));
		
		gbcRight.gridx = 1;
		gbcRight.gridy = 9;
		panelInfo.add(cbFin, gbcRight);
	}
	private void dodajPrazanRed() {
		JLabel label1 = new JLabel(" ");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 10;
		panelInfo.add(label1, gbcLeft);
		
		JLabel label2 = new JLabel(" ");
		gbcRight.gridx = 1;
		gbcRight.gridy = 10;
		panelInfo.add(label2, gbcRight);
	}
	
	private String dateToString(Date date) {
		if(date != null) {
			String retVal;
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
			retVal = sdf.format(date);
			return retVal;
		} 
		
		return "";
	}
	
	private String godinaUpisaToString(int god) {
		if(god != 0)
			return String.valueOf(student.getGodinaUpisa());
		else
			return "";
	}
}
