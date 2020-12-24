package controller;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.GlavniProzor;

public class DodavanjeProfesora {
	
	private JDialog jd;
	private JPanel jp;
	private JTextField jtfIme;
	private JTextField jtfPrz;
	private JTextField jtfDatum;
	private JTextField jtfAdresa;
	private JTextField jtfBrTel;
	private JTextField jtfeMail;
	private JTextField jtfBrInd;
	private JTextField jtfGodUpisa;
	private JTextField jtfGodStud;
	private JTextField jtfFinansiranje;
	
	
	public DodavanjeProfesora() {
		super();
		this.jd = new JDialog();
		this.jp = new JPanel();
		this.jtfIme = new JTextField();
		this.jtfPrz = new JTextField();
		this.jtfDatum = new JTextField();
		this.jtfAdresa= new JTextField();
		this.jtfBrTel = new JTextField();
		this.jtfeMail = new JTextField();
		this.jtfBrInd = new JTextField();
		this.jtfGodUpisa = new JTextField();
		this.jtfGodStud = new JTextField();
		this.jtfFinansiranje = new JTextField();
	}
	
	public DodavanjeProfesora(GlavniProzor gp) {
		super();
		this.jd = new JDialog(gp, "Dodavanje profesora", true);
		this.jp = new JPanel();
		jd.setSize(400,400);
		jd.setResizable(false);
		jd.setLocationRelativeTo(gp);
	}
	
}


