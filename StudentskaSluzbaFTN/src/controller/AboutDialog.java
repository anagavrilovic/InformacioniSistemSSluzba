package controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JTextArea;

import main.Main;
import view.GlavniProzor;

public class AboutDialog {
	private JDialog dialog;
	private JTextArea textArea;
	
	public AboutDialog(GlavniProzor gp) {
		
		dialog = new JDialog(gp, "About", false);
		dialog.setSize(500, 350);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		
		textArea = new JTextArea("\n");
		textArea.setVisible(true);
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		textArea.append("  Verzija aplikacije: 2020/2021\n\n" 
					+ "  Kratak opis apikacije: Aplikacija predstavlja "
					+ "implementaciju informacionog sistema studentske službe "
					+ "Fakulteta tehničkih nauka u Novom Sadu. "
					+ "Namenjena je za referenta studentske službe.\n\n");
		
		textArea.append("  Autori: \n\n");
		
		textArea.append("  Student 1\n"
				+ " Ana Gavrilović, rođena 23. septembra 1999. u Šapcu. Završila Šabačku gimnaziju u Šapcu. "
				+ "Student Fakulteta tehničkih nauka, smer Računarstvo i automatika, 3. godina.\n"
				+ "Broj indeksa: RA65/2018\n\n");
		
		textArea.append("  Student 2\n"
				+ " Marija Klještan, rođena 6. avgusta 1999. u Loznici. Završila Gimnaziju \"Petar Kočić\" u Zvorniku. "
				+ "Student Fakulteta tehničkih nauka, smer Računarstvo i automatika, 3. godina.\n"
				+ "Broj indeksa: RA55/2018");
		
		
		Font f = new Font("sans-serif", Font.PLAIN, 12);
		Main.changeFont(textArea, f);		
		
		dialog.add(textArea);
		dialog.setVisible(true);
		
	}
}
