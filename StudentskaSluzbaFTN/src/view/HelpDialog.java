package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.Main;

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
		
		textArea.append("Aplikacija predstavlja implementaciju informacionog sistema studentske službe Fakulteta tehničkih nauka u Novom Sadu.\n\n"
				+ "        Aplikacija pruža sledeće mogućnosti: \n\n"
				+ "Prikaz entiteta sistema: svaki entitet je predstavljen tabelom u oviru taba glavnog prozora;"
				+ "Prikazane entitete je moguće sortirati dvoklikom na naziv kolone po kojoj želite sortiranje.\n\n"
				+ "Dodavanje entiteta sistema: moguća su 4 načina (pritisak prvog dugmeta u ToolBar-u, izbor stavke menija New, "
				+ "upotrebom odgovarajućih mnemonika, upotrebom odgovarajućeg akceleratora)\n"
				+ "\n        Mnemonici:\n\n"
				+ "File meni: Alt + F\n"
				+ "Edit meni: Alt + E\n"
				+ "Help meni: Alt + H\n"
				+ "Izbor Help prozora: Alt + H -> Alt + H\n"
				+ "Izbor About prozora: Alt + H -> Alt + A\n"
				+ "Dodavanje novog entiteta: Alt + F -> Alt + N\n"
				+ "Zatvaranje aplikacije: Alt + F -> Alt + C\n"
				+ "\n        Akceleratori:\n\n"
				+ "Dodavanje novog entiteta: Ctrl + N\n"
				+ "Zatvaranje aplikacije: Ctrl + C\n"
				+ "Izbor Help prozora: Ctrl + H\n"
				+ "Izbor About prozora: Ctrl + A\n");
	
		
		
		Font f = new Font("sans-serif", Font.PLAIN, 12);
		Main.changeFont(scrollPane, f);		
		
		dialog.add(scrollPane);
		dialog.setVisible(true);
	}
}