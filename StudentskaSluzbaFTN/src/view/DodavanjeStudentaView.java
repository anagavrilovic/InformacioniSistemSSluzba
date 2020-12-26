package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import controller.StudentController;
import main.Main;
import model.Student.Status;

public class DodavanjeStudentaView {
	private JDialog dialog;
	private JPanel panel;
	
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
	
	
	public DodavanjeStudentaView(GlavniProzor gp) {
		
		dialog = new JDialog(gp, "Dodavanje studenta", true);
		dialog.setSize(500, 600);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setVisible(true);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(new GridBagLayout());
		
		Font f = new Font("sans-serif", Font.PLAIN, 13);
		
		GridBagConstraints gbcLeft = new GridBagConstraints();
		gbcLeft.weightx = 100;
		gbcLeft.insets = new Insets(10, 50, 10, 0);
		gbcLeft.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints gbcRight = new GridBagConstraints();
		gbcRight.weightx = 100;
		gbcRight.insets = new Insets(10, 0, 10, 50);
		gbcRight.anchor = GridBagConstraints.EAST;
		
		//Ime
		JLabel jlIme = new JLabel("Ime*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 0;
		panel.add(jlIme, gbcLeft);
		
		jtfIme = new JTextField(20);
		gbcRight.gridx = 1;
		gbcRight.gridy = 0;
		panel.add(jtfIme, gbcRight);
		
		//Prezime
		JLabel jlPrezime = new JLabel("Prezime*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 1;
		panel.add(jlPrezime, gbcLeft);
		
		jtfPrezime = new JTextField(20);
		gbcRight.gridx = 1;
		gbcRight.gridy = 1;
		panel.add(jtfPrezime, gbcRight);
		
		//Datum rodjenja
		JLabel jlDatum = new JLabel("Datum rodjenja*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 2;
		panel.add(jlDatum, gbcLeft);
		
		jtfDatum = new JTextField(20);
		gbcRight.gridx = 1;
		gbcRight.gridy = 2;
		panel.add(jtfDatum, gbcRight);
		
		//Adresa stanovanja
		JLabel jlAdresa = new JLabel("Adresa stanovanja*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 3;
		panel.add(jlAdresa, gbcLeft);
		
		jtfAdresa = new JTextField(20);
		gbcRight.gridx = 1;
		gbcRight.gridy = 3;
		panel.add(jtfAdresa, gbcRight);
		
		//Broj telefona
		JLabel jlBrojTel = new JLabel("Broj telefona*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 4;
		panel.add(jlBrojTel, gbcLeft);
		
		jtfBrojTel = new JTextField(20);
		gbcRight.gridx = 1;
		gbcRight.gridy = 4;
		panel.add(jtfBrojTel, gbcRight);
		
		//E-mail adresa
		JLabel jlEmail = new JLabel("E-mail adresa*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 5;
		panel.add(jlEmail, gbcLeft);
		
		jtfEmail = new JTextField(20);
		gbcRight.gridx = 1;
		gbcRight.gridy = 5;
		panel.add(jtfEmail, gbcRight);
		
		//Broj indeksa
		JLabel jlBrInd = new JLabel("Broj indeksa*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 6;
		panel.add(jlBrInd, gbcLeft);
		
		jtfBrInd = new JTextField(20);
		gbcRight.gridx = 1;
		gbcRight.gridy = 6;
		panel.add(jtfBrInd, gbcRight);
		
		//Godina upisa
		JLabel jlGodUpisa = new JLabel("Godina upisa*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 7;
		panel.add(jlGodUpisa, gbcLeft);
		
		jtfGodUpisa = new JTextField(20);
		gbcRight.gridx = 1;
		gbcRight.gridy = 7;
		panel.add(jtfGodUpisa, gbcRight);
		
		//Trenutna godina studija
		JLabel jlTrGod = new JLabel("Trenutna godina studija*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 8;
		panel.add(jlTrGod, gbcLeft);
		
		String[] god = {"I (prva)                                          ", "II (druga)", "III (treća)", "IV (četvrta)"};
		cbTrGod = new JComboBox<String>(god);
		cbTrGod.setEditable(false);
		gbcRight.gridx = 1;
		gbcRight.gridy = 8;
		panel.add(cbTrGod, gbcRight);
		
		//Način finansiranja 
		JLabel jlFin = new JLabel("Način finansiranja*:");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 9;
		panel.add(jlFin, gbcLeft);
		
		String[] nacin = {"Budžet                                          ", "Samofinansiranje"};
		cbFin = new JComboBox<String>(nacin);
		cbTrGod.setEditable(false);
		gbcRight.gridx = 1;
		gbcRight.gridy = 9;
		panel.add(cbFin, gbcRight);
		
		JLabel label1 = new JLabel(" ");
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 10;
		panel.add(label1, gbcLeft);
		
		JLabel label2 = new JLabel(" ");
		gbcRight.gridx = 1;
		gbcRight.gridy = 10;
		panel.add(label2, gbcRight);
		
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				potvrdi();
			}
			
		});
		gbcLeft.gridx = 0;
		gbcLeft.gridy = 11;
		gbcLeft.insets = new Insets(0, 120, 0, 0);
		panel.add(btnPotvrdi, gbcLeft);
		
		btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();
			}
			
		});
		gbcRight.gridx = 1;
		gbcRight.gridy = 11;
		gbcRight.insets = new Insets(0, 0, 0, 120);
		panel.add(btnOdustani, gbcRight);
		
		
		Main.changeFont(panel, f);
		dialog.add(panel);
		dialog.setVisible(true);
		
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
		
		String message = StudentController.getInstance().dodajStudenta(ime, prezime, datRodj, adresa, brTel, email, brojInd, godUpisa, trGod, status);
			
		JOptionPane.showMessageDialog(dialog, message);
		
	}
	
}