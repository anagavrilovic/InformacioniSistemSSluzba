package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesorContoller;
import main.Main;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class DodavanjeProfesoraView {
	
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
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	private JComboBox<String> cbTit;
	private JComboBox<String> cbZv;

	public DodavanjeProfesoraView() {
		super();
		this.jd = new JDialog();
		this.jp = new JPanel();
	}
	
	public DodavanjeProfesoraView(GlavniProzor gp) {
		super();
		
		jd = new JDialog(gp, "Dodavanje profesora", true);
		jd.setSize(500,600);
		jd.setResizable(false);
		jd.setLocationRelativeTo(null);
		
		jp = new JPanel();
		jp.setVisible(true);
		jp.setBackground(Color.WHITE);
		jp.setBorder(BorderFactory.createCompoundBorder());
		jp.setLayout(new GridBagLayout());
		
		Font f = new Font("sans-serif", Font.PLAIN, 13);

		JLabel jlIme = new JLabel("Ime*");
		GridBagConstraints gbcLabIme = new GridBagConstraints();
		gbcLabIme.gridx = 0;
		gbcLabIme.gridy = 0;
		gbcLabIme.gridwidth = 5;
		gbcLabIme.insets = new Insets(20, 60, 0, 0);
		gbcLabIme.anchor = GridBagConstraints.LINE_START;
		jp.add(jlIme, gbcLabIme);
		
		jtfIme = new JTextField(20); 
		GridBagConstraints gbctfIme = new GridBagConstraints();
		gbctfIme.gridx = 5;
		gbctfIme.gridy = 0;
		gbctfIme.weightx = 100;
		//gbctfIme.fill = GridBagConstraints.HORIZONTAL;
		gbctfIme.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfIme, gbctfIme);
		
		JLabel jlPrz = new JLabel("Prezime*");
		GridBagConstraints gbcLabPrz = new GridBagConstraints();
		gbcLabPrz.gridx = 0;
		gbcLabPrz.gridy = 1;
		gbcLabPrz.gridwidth = 5;
		gbcLabPrz.insets = new Insets(20, 60, 0, 0);
		gbcLabPrz.anchor = GridBagConstraints.LINE_START;
		jp.add(jlPrz, gbcLabPrz);
		
	    jtfPrz = new JTextField(20); 
		GridBagConstraints gbctfPrz = new GridBagConstraints();
		gbctfPrz.gridx = 5;
		gbctfPrz.gridy = 1;
		gbctfPrz.weightx = 100;
		//gbctfPrz.fill = GridBagConstraints.HORIZONTAL;
		gbctfPrz.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfPrz, gbctfPrz);
		
		JLabel jlDatum = new JLabel("Datum rođenja*");
		GridBagConstraints gbcLabDatum = new GridBagConstraints();
		gbcLabDatum.gridx = 0;
		gbcLabDatum.gridy = 2;
		gbcLabDatum.gridwidth = 5;
		gbcLabDatum.insets = new Insets(20, 60, 0, 0);
		gbcLabDatum.anchor = GridBagConstraints.LINE_START;
		jp.add(jlDatum, gbcLabDatum);
		
		jtfDatum = new JTextField(20); 
		GridBagConstraints gbctfDatum = new GridBagConstraints();
		gbctfDatum.gridx = 5;
		gbctfDatum.gridy = 2;
		//gbctfDatum.weightx = 100;
		//gbctfDatum.fill = GridBagConstraints.HORIZONTAL;
		gbctfDatum.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfDatum, gbctfDatum);
		
		JLabel jlAdresaStan = new JLabel("Adresa stanovanja*");
		GridBagConstraints gbcLabAdresaStan = new GridBagConstraints();
		gbcLabAdresaStan.gridx = 0;
		gbcLabAdresaStan.gridy = 3;
		gbcLabAdresaStan.gridwidth = 5;
		gbcLabAdresaStan.insets = new Insets(20, 60, 0, 0);
		gbcLabAdresaStan.anchor = GridBagConstraints.LINE_START;
		jp.add(jlAdresaStan, gbcLabAdresaStan);
		
		jtfAdresaStan = new JTextField(20); 
		GridBagConstraints gbctfAdresaStan = new GridBagConstraints();
		gbctfAdresaStan.gridx = 5;
		gbctfAdresaStan.gridy = 3;
		gbctfAdresaStan.weightx = 100;
		//gbctfAdresaStan.fill = GridBagConstraints.HORIZONTAL;
		gbctfAdresaStan.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfAdresaStan, gbctfAdresaStan);
		
		JLabel jlBrTel = new JLabel("Kontakt telefon*");
		GridBagConstraints gbcLabBrTel = new GridBagConstraints();
		gbcLabBrTel.gridx = 0;
		gbcLabBrTel.gridy = 4;
		gbcLabBrTel.gridwidth = 5;
		gbcLabBrTel.insets = new Insets(20, 60, 0, 0);
		gbcLabBrTel.anchor = GridBagConstraints.LINE_START;
		jp.add(jlBrTel, gbcLabBrTel);
		
		jtfBrTel= new JTextField(20); 
		GridBagConstraints gbctfBrTel = new GridBagConstraints();
		gbctfBrTel.gridx = 5;
		gbctfBrTel.gridy = 4;
		gbctfBrTel.weightx = 100;
		//gbctfBrTel.fill = GridBagConstraints.HORIZONTAL;
		gbctfBrTel.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfBrTel, gbctfBrTel);
		
		JLabel jleMail = new JLabel("E-mail adresa*");
		GridBagConstraints gbcLabeMail = new GridBagConstraints();
		gbcLabeMail.gridx = 0;
		gbcLabeMail.gridy = 5;
		gbcLabeMail.gridwidth = 5;
		gbcLabeMail.insets = new Insets(20, 60, 0, 0);
		gbcLabeMail.anchor = GridBagConstraints.LINE_START;
		jp.add(jleMail, gbcLabeMail);
		
		jtfeMail = new JTextField(20); 
		GridBagConstraints gbctfeMail = new GridBagConstraints();
		gbctfeMail.gridx = 5;
		gbctfeMail.gridy = 5;
		gbctfeMail.weightx = 100;
		//gbctfeMail.fill = GridBagConstraints.HORIZONTAL;
		gbctfeMail.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfeMail, gbctfeMail);
		
		JLabel jlAdresaKanc = new JLabel("Adresa kancelarije*");
		GridBagConstraints gbcLabelAdresaKanc = new GridBagConstraints();
		gbcLabelAdresaKanc.gridx = 0;
		gbcLabelAdresaKanc.gridy = 6;
		gbcLabelAdresaKanc.gridwidth = 5;
		gbcLabelAdresaKanc.insets = new Insets(20, 60, 0, 0);
		gbcLabelAdresaKanc.anchor = GridBagConstraints.LINE_START;
		jp.add(jlAdresaKanc, gbcLabelAdresaKanc);
		
		jtfAdresaKanc= new JTextField(20); 
		GridBagConstraints gbctfAdresaKanc = new GridBagConstraints();
		gbctfAdresaKanc.gridx = 5;
		gbctfAdresaKanc.gridy = 6;
		gbctfAdresaKanc.weightx = 100;
		//gbctfAdresaKanc.fill = GridBagConstraints.HORIZONTAL;
		gbctfAdresaKanc.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfAdresaKanc, gbctfAdresaKanc);
		
		JLabel jlBrLK = new JLabel("Broj lične karte*");
		GridBagConstraints gbcBrLK = new GridBagConstraints();
		gbcBrLK.gridx = 0;
		gbcBrLK.gridy = 7;
		gbcBrLK.gridwidth = 5;
		gbcBrLK.insets = new Insets(20, 60, 0, 0);
		gbcBrLK.anchor = GridBagConstraints.LINE_START;
		jp.add(jlBrLK , gbcBrLK);
		
		jtfBrLK= new JTextField(20); 
		GridBagConstraints gbctfBrLK = new GridBagConstraints();
		gbctfBrLK.gridx = 5;
		gbctfBrLK.gridy = 7;
		gbctfBrLK.weightx = 100;
		//gbctfBrLK.fill = GridBagConstraints.HORIZONTAL;
		gbctfBrLK.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfBrLK, gbctfBrLK );
		
		JLabel jlTitula = new JLabel("Titula*");
		GridBagConstraints gbcTitula = new GridBagConstraints();
		gbcTitula.gridx = 0;
		gbcTitula.gridy = 8;
		gbcTitula.gridwidth = 5;
		gbcTitula.insets = new Insets(20, 60, 0, 0);
		gbcTitula.anchor = GridBagConstraints.LINE_START;
		jp.add(jlTitula, gbcTitula);
		
		/*jtfTitula= new JTextField(20); 
		GridBagConstraints gbctfTitula = new GridBagConstraints();
		gbctfTitula.gridx = 5;
		gbctfTitula.gridy = 8;
		gbctfTitula.weightx = 100;
		//gbctfTitula.fill = GridBagConstraints.HORIZONTAL;
		gbctfTitula.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfTitula, gbctfTitula);*/
		
		String[] titulaProf = {"BSc", "MSc", "mr", "dr", "Prof. dr"};
		this.cbTit = new JComboBox<String>(titulaProf);
		GridBagConstraints gbctfTitula = new GridBagConstraints();
		cbTit.setEditable(false);
		gbctfTitula.gridx = 5;
		gbctfTitula.gridy = 8;
		gbctfTitula.insets = new Insets(20, 97, 0, 10);
		jp.add(cbTit, gbctfTitula);
		
		JLabel jlZvanje = new JLabel("Zvanje*");
		GridBagConstraints gbcZvanje = new GridBagConstraints();
		gbcZvanje.gridx = 0;
		gbcZvanje.gridy = 9;
		gbcZvanje.gridwidth = 5;
		gbcZvanje.insets = new Insets(20, 60, 0, 0);
		gbcZvanje.anchor = GridBagConstraints.LINE_START;
		jp.add(jlZvanje, gbcZvanje);
		
		/*jtfZvanje= new JTextField(20); 
		GridBagConstraints gbctfZvanje = new GridBagConstraints();
		gbctfZvanje.gridx = 5;
		gbctfZvanje.gridy = 9;
		gbctfZvanje.weightx = 100;
		//gbctfZvanje.fill = GridBagConstraints.HORIZONTAL;
		gbctfZvanje.insets = new Insets(20, 20, 0, 20);
		jp.add(jtfZvanje,gbctfZvanje);*/
		
		String[] zvanjeProf = {"Saradnik u nastavi", "Asistent", "Asistent sa doktoratom", "Docent",
							   "Vanredni profesor", "Redovni profesor", "Profesor emeritus"};
		this.cbZv = new JComboBox<String>(zvanjeProf);
		GridBagConstraints gbctfZvanje = new GridBagConstraints();
		cbZv.setEditable(false);
		gbctfZvanje.gridx = 5;
		gbctfZvanje.gridy = 9;
		gbctfZvanje.insets = new Insets(20, 20, 0, 20);
		jp.add(cbZv, gbctfZvanje);
		
		int ind = cbZv.getSelectedIndex();
		
		
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
				jd.dispose();
			}
		});
		
		Main.changeFont(jp, f);
		jd.add(jp);
		jd.setVisible(true);
	}
	
	
	public void potvrdi() {
		
		String ime = jtfIme.getText();
		String prezime = jtfPrz.getText();
		String datum = jtfDatum.getText();
		String adresaStan = jtfAdresaStan.getText();
		String brTel = jtfBrTel.getText();
		String eMail = jtfeMail.getText();
		String adresaKanc = jtfAdresaKanc.getText();
		String brLK = jtfBrLK.getText();
		
		
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
		
		String message = ProfesorContoller.getInstance().updateProfesor(ime, prezime, datum, adresaStan, 
											brTel, eMail, adresaKanc, brLK, tit, zv);

		JOptionPane.showMessageDialog(jd, message);
	}
}
