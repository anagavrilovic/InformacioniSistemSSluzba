package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import main.Main;
import model.BazaStudenti;

public class PrikazPolozenihIspita extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JButton btnPonistiOcenu;
	private JTable predmetTable;

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
		this.add(panelNorth, BorderLayout.NORTH);
		
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.WHITE);
		panelWest.setPreferredSize(new Dimension(80, 660));
		this.add(panelWest, BorderLayout.WEST);
		
		JPanel panelEast = new JPanel();
		panelEast.setBackground(Color.WHITE);
		panelEast.setPreferredSize(new Dimension(80, 660));
		this.add(panelEast, BorderLayout.EAST);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setPreferredSize(new Dimension(800, 100));
		panelSouth.setBackground(Color.WHITE);
		panelSouth.setLayout(new GridBagLayout());
		this.add(panelSouth, BorderLayout.SOUTH);
		
		
		AbstractTableModelPolozeniIspiti atmPI = new AbstractTableModelPolozeniIspiti(index);
		this.predmetTable = new PredmetTable(atmPI);
		JScrollPane spPredmet = new JScrollPane(predmetTable);
		this.add(spPredmet, BorderLayout.CENTER);
		
		
		String ocena = "Prosečna ocena: " + BazaStudenti.getInstance().pronadjiStudenta(index).getProsecnaOcena();
		JLabel prosecnaOcena = new JLabel(ocena);
		panelSouth.add(prosecnaOcena, new GridBagConstraints(0, 0, 1, 1, 100, 0, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(10, 0, 5, 80), 0, 0));
		
		String espb = "Ukupno ESPB: " + BazaStudenti.getInstance().pronadjiStudenta(index).getUkupnoESPB();
		JLabel espbBodovi = new JLabel(espb);
		panelSouth.add(espbBodovi, new GridBagConstraints(0, 1, 1, 1, 100, 0, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(5, 0, 10, 80), 0, 0));
		
		
		
		
		Font f = new Font("sans-serif", Font.PLAIN, 13);
		Main.changeFont(this, f);
	}
	
	
	public void azurirajPrikaz() {
		AbstractTableModelPolozeniIspiti model = (AbstractTableModelPolozeniIspiti)  predmetTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
}
