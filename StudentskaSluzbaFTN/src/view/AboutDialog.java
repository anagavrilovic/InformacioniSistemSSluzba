package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JTextArea;

import main.Main;

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
		
		textArea.append("  Verzija aplikacije: 1.0.0\n\n" 
					+ "  Kratak opis apikacije: Aplikacija predstavlja "
					+ "implementaciju informacionog sistema studentske sluÅ¾be "
					+ "Fakulteta tehniÄ�kih nauka u Novom Sadu. "
					+ "Namenjena je za referenta studentske sluÅ¾be.\n\n");
		
		textArea.append("  Autori: \n\n");
		
		textArea.append("  Student 1\n"
				+ " Ana GavriloviÄ‡, roÄ‘ena 23. septembra 1999. u Å apcu. ZavrÅ¡ila Å abaÄ�ku gimnaziju u Å apcu. "
				+ "Student Fakulteta tehniÄ�kih nauka, smer RaÄ�unarstvo i automatika, 3. godina.\n"
				+ "Broj indeksa: RA65/2018\n\n");
		
		textArea.append("  Student 2\n"
				+ " Marija KljeÅ¡tan, roÄ‘ena 6. avgusta 1999. u Loznici. ZavrÅ¡ila Gimnaziju \"Petar KoÄ�iÄ‡\" u Zvorniku. "
				+ "Student Fakulteta tehniÄ�kih nauka, smer RaÄ�unarstvo i automatika, 3. godina.\n"
				+ "Broj indeksa: RA55/2018");
		
		
		Font f = new Font("sans-serif", Font.PLAIN, 12);
		Main.changeFont(textArea, f);	
		
		dialog.setIconImage(new ImageIcon("images/information.png").getImage());
		dialog.add(textArea);
		dialog.setVisible(true);
		
	}
}