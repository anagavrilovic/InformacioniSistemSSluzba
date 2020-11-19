package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class StatusBar extends JPanel{

	public StatusBar() {
		
		Font f = new Font("sans-serif", Font.PLAIN, 12);
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		setPreferredSize(new Dimension(GlavniProzor.width, 20));
		setLayout(new BorderLayout());
		
		JLabel nazivAplikacije = new JLabel("  Studentska služba");
		nazivAplikacije.setFont(f);
		add(nazivAplikacije, BorderLayout.WEST);
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm   dd.MM.yyyy.  ");
		LocalDateTime now = LocalDateTime.now();
		JLabel datumVreme = new JLabel(dtf.format(now));
		datumVreme.setFont(f);
		add(datumVreme, BorderLayout.EAST);
		
	}
	
}
