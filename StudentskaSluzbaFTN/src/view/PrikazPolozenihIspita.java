package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import controller.IspitiController;

import controller.StudentController;

import main.Main;
import model.BazaPredmeti;
import model.BazaStudenti;
import model.Predmet;

public class PrikazPolozenihIspita extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String index;
	private JButton btnPonistiOcenu;
	private JLabel prosecnaOcena;
	private JLabel espbBodovi;
	private JPanel panelSouth;
	
	private PredmetTable predmetTable;
	private Predmet ponistavanjePred;
	

	public PrikazPolozenihIspita(String index) {
		
		this.setBackground(Color.WHITE);
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		this.setLayout(new BorderLayout());
		
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.WHITE);
		panelNorth.setLayout(new GridBagLayout());
		panelNorth.setPreferredSize(new Dimension(800, 80));
		
		btnPonistiOcenu = new JButton("Poništi ocenu");
		btnPonistiOcenu.setBackground(new Color(90, 216, 252));
		btnPonistiOcenu.setForeground(Color.WHITE);
		panelNorth.add(btnPonistiOcenu, new GridBagConstraints(0, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(20, 80, 20, 0), 0, 0));
		btnPonistiOcenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ponistiOcenu();
			}
		});
		this.add(panelNorth, BorderLayout.NORTH);
		
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.WHITE);
		panelWest.setPreferredSize(new Dimension(80, 660));
		this.add(panelWest, BorderLayout.WEST);
		
		JPanel panelEast = new JPanel();
		panelEast.setBackground(Color.WHITE);
		panelEast.setPreferredSize(new Dimension(80, 660));
		this.add(panelEast, BorderLayout.EAST);
		
		panelSouth = new JPanel();
		panelSouth.setPreferredSize(new Dimension(800, 100));
		panelSouth.setBackground(Color.WHITE);
		panelSouth.setLayout(new GridBagLayout());
		this.add(panelSouth, BorderLayout.SOUTH);
		
		
		AbstractTableModelPolozeniIspiti atmPI = new AbstractTableModelPolozeniIspiti(index);

		this.predmetTable = new PredmetTable(atmPI);

		JScrollPane spPredmet = new JScrollPane(predmetTable);
		this.add(spPredmet, BorderLayout.CENTER);
		
		this.index = index;
		String ocena = "Prosečna ocena: " + BazaStudenti.getInstance().pronadjiStudenta(index).izracunajProsecnuOcenu();
		prosecnaOcena = new JLabel(ocena);
		panelSouth.add(prosecnaOcena, new GridBagConstraints(0, 0, 1, 1, 100, 0, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(10, 0, 5, 80), 0, 0));
		
		String espb = "Ukupno ESPB: " + BazaStudenti.getInstance().pronadjiStudenta(index).getUkupnoESPB();
		espbBodovi = new JLabel(espb);
		panelSouth.add(espbBodovi, new GridBagConstraints(0, 1, 1, 1, 100, 0, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(5, 0, 10, 80), 0, 0));
		
		
		Font f = new Font("sans-serif", Font.PLAIN, 13);
		Main.changeFont(this, f);
		
		IspitiController.getInstance().setPrikazPolozenih(this);
	}
	
	public String getSifraPredFromSelectedRow() {
		int row = predmetTable.getSelectedRow();
		
		if(row != -1) {
			return (String) predmetTable.getValueAt(row, 0);
		} else {
			return "";
		}
	}
	

	private void ponistiOcenu() {
		if(getSifraPredFromSelectedRow().equals("")) {
			JOptionPane.showMessageDialog(this.getParent(), "Selektujte predmet!", "Nije selektovan nijedan predmet", JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/minus.png")));
			return;
		}
		
		ponistavanjePred = BazaPredmeti.getInstance().pronadjiPredmet(getSifraPredFromSelectedRow());
		
		String[] options = {"Da", "Ne" };
		int opcija = JOptionPane.showOptionDialog(GlavniProzor.getInstance(), "Da li ste sigurni da želite da poništite ocenu?",
				"Poništavanje ocene?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
				GlavniProzor.resizeIcon(new ImageIcon("images/question.png")), 
				options, options[1]);
		if (opcija != JOptionPane.YES_OPTION) {
			return;
		} else {
			IspitiController.getInstance().ponistiOcenu(index, ponistavanjePred);
			prosecnaOcena.setText("Prosečna ocena: " + BazaStudenti.getInstance().pronadjiStudenta(index).izracunajProsecnuOcenu());
			espbBodovi.setText("Ukupno ESPB: " + BazaStudenti.getInstance().pronadjiStudenta(index).getUkupnoESPB());
		}
		
	}
	

	public void azurirajPrikazPredmet(String akcija, int vrednost) {
		AbstractTableModelPolozeniIspiti modelPredm = (AbstractTableModelPolozeniIspiti) predmetTable.getModel();
		modelPredm.fireTableDataChanged();
		validate();
	}	
}
