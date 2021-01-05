package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;


public class StatusBar extends JPanel implements ActionListener{

	JLabel nazivAplikacije;
	JLabel datumVreme;
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm   dd.MM.yyyy.  ");
	
	public StatusBar() {
		
		Font f = new Font("sans-serif", Font.PLAIN, 12);
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		setPreferredSize(new Dimension(GlavniProzor.width, 20));
		setLayout(new BorderLayout());
		
		nazivAplikacije = new JLabel("  Studentska služba");
		nazivAplikacije.setFont(f);
		add(nazivAplikacije, BorderLayout.WEST);
		
		
		// Mali deo koda vezan za postavljanje vremena i datuma preuzet sa Google-a 
		/** REFERENCA:  (https://coderanch.com/t/331575/java/Display-time-date-status-bar) */
		datumVreme = new JLabel(sdf.format(new GregorianCalendar().getTime()));
		datumVreme.setFont(f);
		add(datumVreme, BorderLayout.EAST);
		
		Timer timer = new Timer(1000, this);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent ae) {
		datumVreme.setText(sdf.format(new GregorianCalendar().getTime()));
	}
	
}
