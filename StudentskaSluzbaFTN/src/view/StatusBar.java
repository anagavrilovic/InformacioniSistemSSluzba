package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class StatusBar extends JPanel{

	public StatusBar() {
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		setPreferredSize(new Dimension(GlavniProzor.width, 20));
		setLayout(new BorderLayout());
		
		JLabel nazivAplikacije = new JLabel("  Studentska služba");
		add(nazivAplikacije, BorderLayout.WEST);
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm   dd.MM.yyyy.  ");
		LocalDateTime now = LocalDateTime.now();
		JLabel datumVreme = new JLabel(dtf.format(now));
		add(datumVreme, BorderLayout.EAST);
		
	}
	
}
