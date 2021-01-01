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
import model.BazaProfesori;
import model.BazaStudenti;

public class DodavanjeProfesoraPredmetu {

	
	private JDialog dialog;
	private JPanel panel;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private JTable profesoriTable;
	private String sifraPredmeta;
	
	public DodavanjeProfesoraPredmetu(String sifraPredmeta) {
		
		this.sifraPredmeta = sifraPredmeta;
		
		dialog = new JDialog(GlavniProzor.getInstance(), "Odaberi profesora", true);
		
		dialog.setSize(550, 450);
		dialog.setResizable(false);
		dialog.setIconImage(GlavniProzor.resizeIcon(new ImageIcon("images/add-user.png")).getImage());
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
		
		btnDodaj = new JButton(" Potvrdi ");
		btnDodaj.setBackground(new Color(90, 216, 252));
		btnDodaj.setForeground(Color.WHITE);
		btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dodaj();
				IzmenaPredmetaView.azurirajProfesora();
			}
			
		});
		
		dialog.getRootPane().setDefaultButton(btnDodaj);
		panelSouth.add(btnDodaj, new GridBagConstraints(0, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(20, 150, 20, 0), 0, 0));
		
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
		
		JScrollPane sp = new JScrollPane(profesoriTable);
		panel.add(sp, BorderLayout.CENTER);

		
		Font f = new Font("sans-serif", Font.PLAIN, 13);
		Main.changeFont(dialog, f);
		
		IspitiController.getInstance().setDodavanjeProfesoraPredmetu(this);
		
		dialog.add(panel);
		dialog.setIconImage(GlavniProzor.resizeIcon(new ImageIcon("images/add-user.png")).getImage());
		dialog.setVisible(true);
	}
	
	
	private void dodajTabelu() {
		
		profesoriTable = new JTable(BazaProfesori.getInstance().getProfesori().size(), 1);
		profesoriTable.setRowSelectionAllowed(true);
		profesoriTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		profesoriTable.setGridColor(Color.LIGHT_GRAY);
		profesoriTable.setRowHeight(25);
		profesoriTable.setIntercellSpacing(new Dimension(15, 4));
		profesoriTable.setTableHeader(null);
		
		AbstractTableModelDodavanjeProfesora atmdp = new AbstractTableModelDodavanjeProfesora();
		profesoriTable.setModel(atmdp);
	}
	
	public void dodaj() {
		if(getBrojLKFromSelectedRow().equals("")) {
			JOptionPane.showMessageDialog(dialog, "Selektujte profesora!", "Nije selektovan nijedan profesor", JOptionPane.INFORMATION_MESSAGE, 
					GlavniProzor.resizeIcon(new ImageIcon("images/minus.png")));
			return;
		}
		
		IspitiController.getInstance().dodajProfesoraPredmetu(sifraPredmeta, getBrojLKFromSelectedRow());
		
		dialog.dispose();
	}
	
	public void azurirajPrikazPredmet(String akcija, int vrednost) {
		AbstractTableModelDodavanjeProfesora modelPredm = (AbstractTableModelDodavanjeProfesora) profesoriTable.getModel();
		modelPredm.fireTableDataChanged();
		profesoriTable.validate();
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		
		Component c = profesoriTable.prepareRenderer(renderer, row, column);
		if (profesoriTable.isRowSelected(row)) {
			c.setBackground(new Color(224, 224, 224));
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public String getBrojLKFromSelectedRow() {
		int row = profesoriTable.getSelectedRow();
		
		if(row != -1) {
			StringTokenizer st = new StringTokenizer((String) profesoriTable.getValueAt(row, 0));
			return st.nextToken();
		} else {
			return "";
		}
	}
}
