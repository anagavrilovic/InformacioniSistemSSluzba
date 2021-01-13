package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import controller.IspitiController;
import main.Main;
import model.BazaPredmeti;
import model.BazaProfesori;
import model.Profesor;

public class DodavanjePredmetaProfesoru {
	
	private JPanel panel;
	private JDialog dialog;
	private JButton btnPotvrdi;
	private JButton btnOdustani;
	private JTable predmetiTabela;
	
	private String brLK;
	
	public DodavanjePredmetaProfesoru(String brLK) {
		
		this.brLK = brLK;
		
		Font f = new Font("sans-serif", Font.PLAIN, 13);
		
		dialog = new JDialog(GlavniProzor.getInstance(), "Dodavanje predmeta", true);
		
		dialog.setSize(550, 450);
		dialog.setResizable(false);
		dialog.setIconImage(GlavniProzor.resizeIcon(new ImageIcon("images/add.png")).getImage());
		dialog.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(new BorderLayout());
		
		JLabel labela = new JLabel("Predmeti: ");
		Main.changeFont(labela, f);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.white);
		panelNorth.setPreferredSize(new Dimension(550, 30));
	/*	panelNorth.add(labela, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(10, 40, 20, 550), 0, 0));   */
		panelNorth.add(labela, new FlowLayout(FlowLayout.LEFT));
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
		
		btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(new Color(90, 216, 252));
		btnPotvrdi.setForeground(Color.WHITE);
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(getSifraPredFromSelectedRow().equals("")) {
					JOptionPane.showMessageDialog(dialog, "Selektujte predmet!", "Nije selektovan nijedan predmet", JOptionPane.INFORMATION_MESSAGE, 
							GlavniProzor.resizeIcon(new ImageIcon("images/minus.png")));
					return;
				}
				
				if(!BazaPredmeti.getInstance().pronadjiPredmet(getSifraPredFromSelectedRow()).getProfesor().getBrojLicneKarte().equals("")) {
					
					String[] options = {"Da", "Ne" };
					int code = JOptionPane.showOptionDialog(dialog,"Da li ste sigurni da želite da zamenite postojećeg \n profesora na selektovanom predmetu?",
							"Izmena profesora", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
							GlavniProzor.resizeIcon(new ImageIcon("images/question.png")), options, options[1]);
					
					if (code != JOptionPane.YES_OPTION) {
						dialog.dispose();
					} else {
						IspitiController.getInstance().dodajPredmetProfesoru(brLK, getSifraPredFromSelectedRow());
					}
				}
				else {
					IspitiController.getInstance().dodajPredmetProfesoru(brLK, getSifraPredFromSelectedRow());
				}
			}
		});
		
		dialog.getRootPane().setDefaultButton(btnPotvrdi);
		
		panelSouth.add(btnPotvrdi, new GridBagConstraints(0, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(20, 340, 20, 0), 0, 0));
		
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
                GridBagConstraints.NONE, new Insets(20, 0, 20, 20), 0, 0));
		
		BazaProfesori.getInstance().nadjiPredmeteKojeNePredajeProfesor(brLK);
		predmetiTabela = new PredmetiTabela();
		
		
		JScrollPane sp = new JScrollPane(predmetiTabela);
		panel.add(sp, BorderLayout.CENTER);
		
		
		Main.changeFont(dialog, f);
		
		IspitiController.getInstance().setDodavanjePredmetaProfesoru(this);
		
		this.dialog.add(panel);
		this.dialog.setIconImage(GlavniProzor.resizeIcon(new ImageIcon("images/plus.png")).getImage());
		this.dialog.setVisible(true);
		
	}
	
	public class PredmetiTabela extends JTable {
		
		public PredmetiTabela() {
			this.setRowSelectionAllowed(true);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			this.setGridColor(Color.LIGHT_GRAY);
			this.setRowHeight(25);
			this.setIntercellSpacing(new Dimension(15, 4));
			this.setTableHeader(null);
			
			AbstractTableModelSpisakPredmeta model = new AbstractTableModelSpisakPredmeta(brLK);
			this.setModel(model);
		}
		
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			
			Component c = super.prepareRenderer(renderer, row, column);
			if (isRowSelected(row)) {
				c.setBackground(new Color(224, 224, 224));
			} else {
				c.setBackground(Color.WHITE);
			}
			return c;
		}	
	}
	
	public void azurirajPrikazPredmet(String akcija, int vrednost) {
		AbstractTableModelSpisakPredmeta model = (AbstractTableModelSpisakPredmeta) predmetiTabela.getModel();
		model.fireTableDataChanged();
		predmetiTabela.validate();
	}
	
	public String getSifraPredFromSelectedRow() {
		int row = predmetiTabela.getSelectedRow();
		
		if(row != -1) {
			StringTokenizer st = new StringTokenizer((String) predmetiTabela.getValueAt(row, 0));
			return st.nextToken();
		} else {
			return "";
		}
	}
	
	public class AbstractTableModelSpisakPredmeta extends AbstractTableModel {
		
		public AbstractTableModelSpisakPredmeta(String brLK) {}

		public int getRowCount() {
			if(!(BazaProfesori.getInstance().getProfesorNePredaje() == null))
				return BazaProfesori.getInstance().getProfesorNePredaje().size();
			else
				return -1;
		}
		
		public int getColumnCount() {
			return 1;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			return BazaProfesori.getInstance().getProfesorNePredaje().get(rowIndex).getSifraNaziv();
		}
	}
}
