package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.BazaPredmeti;

public class PrikazNepolozenihIspita extends JPanel{
	
	private JButton btnDodaj;
	private JButton btnObrisi;
	private JButton btnPolaganje;
	private JTable nepolozeniIspitiTab;
	
	public PrikazNepolozenihIspita (String index) {
		
		Dimension dim = new Dimension(100, 25);
		
		this.btnDodaj = new JButton("Dodaj");
		this.btnDodaj.setBackground(new Color(90, 216, 252));
		this.btnDodaj.setForeground(Color.white);
		this.btnDodaj.setPreferredSize(dim);
		
		this.btnObrisi = new JButton("Obriši");
		this.btnObrisi.setBackground(new Color(90, 216, 252));
		this.btnObrisi.setForeground(Color.white);
		this.btnObrisi.setPreferredSize(dim);
		
		this.btnPolaganje = new JButton("Polaganje");
		this.btnPolaganje.setBackground(new Color(90, 216, 252));
		this.btnPolaganje.setForeground(Color.white);
		this.btnPolaganje.setPreferredSize(dim);
		
		this.setLayout(new BorderLayout());
		
		Dimension panDimX = new Dimension(800, 80);
		Dimension panDimY = new Dimension(80, 660);
		Dimension panDimS = new Dimension(800, 100);
		
		JPanel jpNorth = new JPanel();
		jpNorth.setLayout(new GridBagLayout());
		jpNorth.setPreferredSize(panDimX);
		jpNorth.setBackground(Color.white);
		jpNorth.add(btnDodaj, new GridBagConstraints(0, 0, 1, 1, 0.1, 0, GridBagConstraints.WEST,
               GridBagConstraints.NONE, new Insets(30, 80, 25, 0), 0, 0));
		jpNorth.add(btnObrisi, new GridBagConstraints(1, 0, 1, 1, 0.1, 0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(30, 5, 25, 0), 0, 0));
		jpNorth.add(btnPolaganje, new GridBagConstraints(2, 0, 1, 1, 0.1, 0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(40, 5, 35, 440), 0, 0));
		this.add(jpNorth, BorderLayout.NORTH);
		
		JPanel jpWest = new JPanel();
		jpWest.setPreferredSize(panDimY);
		jpWest.setBackground(Color.white);
		this.add(jpWest, BorderLayout.WEST);
		
		JPanel jpEast = new JPanel();
		jpEast.setPreferredSize(panDimY);
		jpEast.setBackground(Color.white);
		this.add(jpEast, BorderLayout.EAST);
		
		JPanel jpSouth = new JPanel();
		jpSouth.setPreferredSize(panDimS);
		jpSouth.setBackground(Color.white);
		this.add(jpSouth, BorderLayout.SOUTH);
		
		BazaPredmeti.getInstance().nadjiNepolozeneIspite(index);
		AbstractTableModelNepolozeniPredmeti atmp = new AbstractTableModelNepolozeniPredmeti();
		JTable predmetTable = new PredmetTable(atmp);
		JScrollPane spPredmet = new JScrollPane(predmetTable);
		this.add(spPredmet);
			
	}
}
