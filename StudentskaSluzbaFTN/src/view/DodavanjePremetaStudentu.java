package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableCellRenderer;

import controller.IspitiController;
import main.Main;
import model.BazaStudenti;
import model.Predmet;

public class DodavanjePremetaStudentu {
	
	private JDialog dialog;
	private JPanel panel;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private JTable predmetiTable;
	private String index;
	
	public DodavanjePremetaStudentu(String index) {
		
		this.index = index;
		BazaStudenti.getInstance().pronadjiStudenta(index).setListaPredmetaZaDodavanje();
		
		dialog = new JDialog(GlavniProzor.getInstance(), "Dodavanje predmeta", true);
		
		dialog.setSize(550, 450);
		dialog.setResizable(false);
		dialog.setIconImage(GlavniProzor.resizeIcon(new ImageIcon("images/add.png")).getImage());
		dialog.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(new BorderLayout());
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.white);
		panelNorth.setPreferredSize(new Dimension(550, 30));
		panel.add(panelNorth, BorderLayout.NORTH);
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.white);
		panelWest.setPreferredSize(new Dimension(40, 450));
		panel.add(panelWest, BorderLayout.WEST);
		
		JPanel panelEast = new JPanel();
		panelEast.setBackground(Color.white);
		panelEast.setPreferredSize(new Dimension(40, 450));
		panel.add(panelEast, BorderLayout.EAST);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(Color.white);
		panelSouth.setPreferredSize(new Dimension(550, 90));
		panelSouth.setLayout(new GridBagLayout());
		panel.add(panelSouth, BorderLayout.SOUTH);
		
		btnDodaj = new JButton(" Dodaj ");
		btnDodaj.setBackground(new Color(90, 216, 252));
		btnDodaj.setForeground(Color.WHITE);
		btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dodaj();
			}
			
		});
		
		panelSouth.add(btnDodaj, new GridBagConstraints(0, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(20, 150, 20, 0), 0, 0));
		dialog.getRootPane().setDefaultButton(btnDodaj);
		
		btnOdustani = new JButton("Odustani");
		btnOdustani.setBackground(Color.WHITE);
		btnOdustani.setForeground(new Color(90, 216, 252));
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();
			}
			
		});
		panelSouth.add(btnOdustani, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(20, 0, 20, 150), 0, 0));
		
		dodajTabelu();
		
		JScrollPane sp = new JScrollPane(predmetiTable);
		panel.add(sp, BorderLayout.CENTER);
		
		
		Font f = new Font("sans-serif", Font.PLAIN, 13);
		Main.changeFont(dialog, f);
		
		IspitiController.getInstance().setDodavanjePredmeta(this);
		
		dialog.add(panel);
		dialog.setIconImage(GlavniProzor.resizeIcon(new ImageIcon("images/plus.png")).getImage());
		dialog.setVisible(true);
		
		
		
		
	}
	
	private void dodajTabelu() {
		
		predmetiTable = new JTable(BazaStudenti.getInstance().pronadjiStudenta(index).getListaPredZaDodavanje().size(), 1);
		predmetiTable.setRowSelectionAllowed(true);
		predmetiTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		predmetiTable.setGridColor(Color.LIGHT_GRAY);
		predmetiTable.setRowHeight(25);
		predmetiTable.setIntercellSpacing(new Dimension(15, 4));
		predmetiTable.setTableHeader(null);
		
		AbstractTableModelDodavanjePredmeta atmdp = new AbstractTableModelDodavanjePredmeta(index);
		predmetiTable.setModel(atmdp);
	}
	
	public void dodaj() {
		if(getSifraPredFromSelectedRow().equals("")) {
			JOptionPane.showMessageDialog(dialog, "Selektujte predmet!", "Nije selektovan nijedan predmet", JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/minus.png")));
			return;
		}
		
		IspitiController.getInstance().dodajPredmetStudentu(index, getSifraPredFromSelectedRow());
		//dialog.dispose();
	}
	
	public void azurirajPrikazPredmet(String akcija, int vrednost) {
		AbstractTableModelDodavanjePredmeta modelPredm = (AbstractTableModelDodavanjePredmeta) predmetiTable.getModel();
		modelPredm.fireTableDataChanged();
		predmetiTable.validate();
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		
		Component c = predmetiTable.prepareRenderer(renderer, row, column);
		if (predmetiTable.isRowSelected(row)) {
			c.setBackground(new Color(224, 224, 224));
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public String getSifraPredFromSelectedRow() {
		int row = predmetiTable.getSelectedRow();
		
		if(row != -1) {
			StringTokenizer st = new StringTokenizer((String) predmetiTable.getValueAt(row, 0));
			return st.nextToken();
		} else {
			return "";
		}
	}
}
