package controller;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.GlavniProzor;

public class DodavanjeProfesora {
	
	private JDialog jd;
	private JPanel jp;
	private JTextField jtfIme;
	private JTextField jtfPrz;
	private JTextField jtfDatum;
	private JTextField jtfAdresaStan;
	private JTextField jtfBrTel;
	private JTextField jtfeMail;
	private JTextField jtfAdresaKanc;
	private JTextField jtfBrLK;
	private JTextField jtfTitula;
	private JTextField jtfZvanje;
	
	
	public DodavanjeProfesora() {
		super();
		this.jd = new JDialog();
		this.jp = new JPanel();
		this.jtfIme = new JTextField();
		this.jtfPrz = new JTextField();
		this.jtfDatum = new JTextField();
		this.jtfAdresaStan= new JTextField();
		this.jtfBrTel = new JTextField();
		this.jtfeMail = new JTextField();
		this.jtfAdresaKanc = new JTextField();
		this.jtfBrLK = new JTextField();
		this.jtfTitula = new JTextField();
		this.jtfZvanje = new JTextField();
	}
	
	public DodavanjeProfesora(GlavniProzor gp) {
		super();
		jp = new JPanel();
	
		
		jd.setDefaultLookAndFeelDecorated(true);
		jd = new JDialog(gp, "Dodavanje profesora", true);
		jd.setSize(500,600);
		jd.setResizable(false);
		jd.setLocationRelativeTo(null);
		
		
		jp.setVisible(true);
		jp.setBackground(Color.WHITE);
		jp.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		jp.setLayout(new GridBagLayout());

		JLabel jlIme = new JLabel("Ime*");
		GridBagConstraints gbcLabIme = new GridBagConstraints();
		gbcLabIme.gridx = 0;
		gbcLabIme.gridy = 0;
		gbcLabIme.gridwidth = 5;
		gbcLabIme.insets = new Insets(20, 20, 0, 0);
		gbcLabIme.anchor = GridBagConstraints.LINE_START;
		jp.add(jlIme, gbcLabIme);
		
		jtfIme = new JTextField(20); 
		GridBagConstraints gbctfIme = new GridBagConstraints();
		gbctfIme.gridx = 5;
		gbctfIme.gridy = 0;
		gbctfIme.weightx = 100;
		gbctfIme.fill = GridBagConstraints.HORIZONTAL;
		gbctfIme.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfIme, gbctfIme);
		
		JLabel jlPrz = new JLabel("Prezime*");
		GridBagConstraints gbcLabPrz = new GridBagConstraints();
		gbcLabPrz.gridx = 0;
		gbcLabPrz.gridy = 1;
		gbcLabPrz.gridwidth = 5;
		gbcLabPrz.insets = new Insets(20, 20, 0, 0);
		gbcLabPrz.anchor = GridBagConstraints.LINE_START;
		jp.add(jlPrz, gbcLabPrz);
		
		jtfPrz = new JTextField(20); 
		GridBagConstraints gbctfPrz = new GridBagConstraints();
		gbctfPrz.gridx = 5;
		gbctfPrz.gridy = 1;
		gbctfPrz.weightx = 100;
		gbctfPrz.fill = GridBagConstraints.HORIZONTAL;
		gbctfPrz.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfPrz, gbctfPrz);
		
		JLabel jlDatum = new JLabel("Datum rođenja*");
		GridBagConstraints gbcLabDatum = new GridBagConstraints();
		gbcLabDatum.gridx = 0;
		gbcLabDatum.gridy = 2;
		gbcLabDatum.gridwidth = 5;
		gbcLabDatum.insets = new Insets(20, 20, 0, 0);
		gbcLabDatum.anchor = GridBagConstraints.LINE_START;
		jp.add(jlDatum, gbcLabDatum);
		
		jtfDatum = new JTextField(20); 
		GridBagConstraints gbctfDatum = new GridBagConstraints();
		gbctfDatum.gridx = 5;
		gbctfDatum.gridy = 2;
		gbctfDatum.weightx = 100;
		gbctfDatum.fill = GridBagConstraints.HORIZONTAL;
		gbctfDatum.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfDatum, gbctfDatum);
		
		jd.add(jp);
		jd.setVisible(true);

	}
	
}


