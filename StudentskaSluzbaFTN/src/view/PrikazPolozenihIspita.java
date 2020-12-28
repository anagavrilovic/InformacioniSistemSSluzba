package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PrikazPolozenihIspita extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrikazPolozenihIspita() {
		
		this.setBackground(Color.WHITE);
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		this.setLayout(new BorderLayout());
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.WHITE);
		panelNorth.setLayout(new GridBagLayout());
		
		JButton btnPonistiOcenu = new JButton("Poništi ocenu");
		btnPonistiOcenu.setBackground(new Color(90, 216, 252));
		btnPonistiOcenu.setForeground(Color.WHITE);
		panelNorth.add(btnPonistiOcenu, new GridBagConstraints(0, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(20, 20, 20, 20), 0, 0));
		this.add(panelNorth, BorderLayout.NORTH);
		
		
		
	}
	
	
	
	
	
	
}
