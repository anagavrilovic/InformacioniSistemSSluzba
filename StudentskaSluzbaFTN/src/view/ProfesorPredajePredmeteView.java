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
import javax.swing.border.EtchedBorder;

import model.BazaPredmeti;

public class ProfesorPredajePredmeteView extends JPanel{
	
	private JButton btnDodajPredmet;
	private JButton btnUkloniPredmet;
	private JTable predmetiTabela;
	private String brLK;
	
	public ProfesorPredajePredmeteView(String brLK) {
		
		this.brLK = brLK;
		
		Dimension dim = new Dimension(200, 25);
		
		this.btnDodajPredmet = new JButton("Dodaj predmet");
		this.btnDodajPredmet.setBackground(new Color(90, 216, 252));
		this.btnDodajPredmet.setForeground(Color.white);
		this.btnDodajPredmet.setPreferredSize(dim);
		
		this.btnUkloniPredmet = new JButton("Ukloni Predmet");
		this.btnUkloniPredmet.setBackground(new Color(90, 216, 252));
		this.btnUkloniPredmet.setForeground(Color.white);
		this.btnUkloniPredmet.setPreferredSize(dim);
		
		this.setLayout(new BorderLayout());
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
		Dimension panDimX = new Dimension(600, 50);
		Dimension panDimY = new Dimension(30, 500);
		
		JPanel jpNorth = new JPanel();
		jpNorth.setLayout(new GridBagLayout());
		jpNorth.setPreferredSize(panDimX);
		jpNorth.setBackground(Color.white);
		jpNorth.add(btnDodajPredmet, new GridBagConstraints(0, 0, 1, 1, 0.1, 0, GridBagConstraints.WEST,
               GridBagConstraints.NONE, new Insets(15, 30, 10, 0), 0, 0));
		jpNorth.add(btnUkloniPredmet, new GridBagConstraints(1, 0, 1, 1, 0.1, 0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(15, 10, 10, 190), 0, 0));
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
		jpSouth.setPreferredSize(panDimX);
		jpSouth.setBackground(Color.white);
		this.add(jpSouth, BorderLayout.SOUTH);
		
		BazaPredmeti.getInstance().nadjiPredmeteKojePredajeProfesor(brLK);
		AbstractTableModelProfesorPredajePredmete atmppp = new AbstractTableModelProfesorPredajePredmete();
		predmetiTabela = new PredmetTable(atmppp);
		JScrollPane jsp = new JScrollPane(predmetiTabela);
		this.add(jsp);
	}

}
