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

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import controller.IspitiController;
import main.Main;
import model.BazaPredmeti;


public class PrikazNepolozenihIspita extends JPanel{
	
	private JButton btnDodaj;
	private JButton btnObrisi;
	private JButton btnPolaganje;
	private JTable nepolozeniIspitiTab;
	private String index;
	
	public PrikazNepolozenihIspita (String index) {
		
		this.index = index;
		
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
		
		PrikazNepolozenihIspita p = this;
		this.btnPolaganje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpisOcene upis = new UpisOcene (p);
			}
		});
		
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
		this.nepolozeniIspitiTab = new PredmetTable(atmp);
		JScrollPane spPredmet = new JScrollPane(nepolozeniIspitiTab);
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		this.add(spPredmet);
		
		Font f = new Font("sans-serif", Font.PLAIN, 13);
		Main.changeFont(this, f);		
		
		IspitiController.getInstance().setPrikazNepolozenih(this);
	}
	
	public void azurirajPrikazPredmet(String akcija, int vrednost) {
		AbstractTableModelNepolozeniPredmeti model = (AbstractTableModelNepolozeniPredmeti) nepolozeniIspitiTab.getModel();
		model.fireTableDataChanged();
		validate();
	}
	

	public JTable getNepolozeniIspitiTab() {
		return nepolozeniIspitiTab;
	}

	public void setNepolozeniIspitiTab(JTable nepolozeniIspitiTab) {
		this.nepolozeniIspitiTab = nepolozeniIspitiTab;
	}



	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
	
	public String nadjiSifruPredmeta() {
		int row = nepolozeniIspitiTab.getSelectedRow();
		
		if(row != -1) {
			return (String) nepolozeniIspitiTab.getValueAt(row, 0);
		} else {
			return "";
		}
	}
	
}
