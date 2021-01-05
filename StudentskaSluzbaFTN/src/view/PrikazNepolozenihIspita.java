package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import controller.IspitiController;


import model.BazaPredmeti;
import model.Predmet;

public class PrikazNepolozenihIspita extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnDodaj;
	private JButton btnObrisi;
	private JButton btnPolaganje;
	private JTable nepolozeniIspitiTab;
	private String index;
	
	private Predmet brisanjePredmeta;
	
	public PrikazNepolozenihIspita (String index) {
		
		this.index = index;
		
		Dimension dim = new Dimension(100, 25);
		
		this.btnDodaj = new JButton("Dodaj");
		this.btnDodaj.setBackground(new Color(90, 216, 252));
		this.btnDodaj.setForeground(Color.white);
		this.btnDodaj.setPreferredSize(dim);
		this.btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				DodavanjePremetaStudentu dps = new DodavanjePremetaStudentu(index);
			}
		});
		
		this.btnObrisi = new JButton("Obriši");
		this.btnObrisi.setBackground(new Color(90, 216, 252));
		this.btnObrisi.setForeground(Color.white);
		this.btnObrisi.setPreferredSize(dim);
		this.btnObrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ukloniPredmet();
			}
		});
		
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
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		
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
		
		this.index = index;
		BazaPredmeti.getInstance().nadjiNepolozeneIspite(index);
		AbstractTableModelNepolozeniPredmeti atmp = new AbstractTableModelNepolozeniPredmeti();
		nepolozeniIspitiTab = new PredmetTable(atmp);
		this.nepolozeniIspitiTab.getColumnModel().getColumn(0).setPreferredWidth(30);
		this.nepolozeniIspitiTab.getColumnModel().getColumn(1).setPreferredWidth(200);
		this.nepolozeniIspitiTab.getColumnModel().getColumn(2).setPreferredWidth(15);
		this.nepolozeniIspitiTab.getColumnModel().getColumn(3).setPreferredWidth(15);
		this.nepolozeniIspitiTab.getColumnModel().getColumn(4).setPreferredWidth(30);
		
		JScrollPane spPredmet = new JScrollPane(nepolozeniIspitiTab);
		this.add(spPredmet);
		
		IspitiController.getInstance().setPrikazNepolozenih(this);			
	}
	
	private void ukloniPredmet() {
		if(getSifraPredFromSelectedRow().equals("")) {
			JOptionPane.showMessageDialog(this.getParent(), "Selektujte predmet!", "Nije selektovan nijedan predmet", JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/minus.png")));
			return;
		}
		
		brisanjePredmeta = BazaPredmeti.getInstance().pronadjiPredmet(getSifraPredFromSelectedRow());
		
		String[] options = {"Da", "Ne" };
		int opcija = JOptionPane.showOptionDialog(GlavniProzor.getInstance(), "Da li ste sigurni da želite da uklonite predmet?",
				"Uklanjanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
				GlavniProzor.resizeIcon(new ImageIcon("images/question.png")), 
				options, options[1]);
		if (opcija != JOptionPane.YES_OPTION) {
			return;
		} else {
			IspitiController.getInstance().ukloniPredmetStudentu(index, brisanjePredmeta);
		}
	}
	
	public String getSifraPredFromSelectedRow() {
		int row = nepolozeniIspitiTab.getSelectedRow();
		
		if(row != -1) {
			return (String) nepolozeniIspitiTab.getValueAt(row, 0);
		}else {
			return "";
		}
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
