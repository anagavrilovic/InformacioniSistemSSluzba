package controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.Main;
import view.GlavniProzor;

public class HelpDialog {
	
	public HelpDialog(GlavniProzor gp) {
		
		JDialog dialog = new JDialog(gp, "Help", false);
		dialog.setSize(500, 600);
		dialog.setResizable(true);
		dialog.setLocationRelativeTo(null);

		JTextArea textArea = new JTextArea("\tDetaljan opis o načinu korišćenja aplikacije:\n\n");
		textArea.setVisible(true);
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVisible(true);
		
		// dodavati tekst pomocu textArea.append("neki tekst");
	
		
		
		Font f = new Font("sans-serif", Font.PLAIN, 12);
		Main.changeFont(scrollPane, f);		
		
		dialog.add(scrollPane);
		dialog.setVisible(true);
	}
}
