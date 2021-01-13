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
		
		textArea.append("Aplikacija predstavlja implementaciju informacionog sistema studentske službe Fakulteta tehničkih nauka u Novom Sadu.\n"
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
		
		textArea.append("\n        Aplikacija pruža sledeće mogućnosti: \n\n"
				+ "Dodavanje entiteta sistema- moguće je na 4 načina: pritiskom prvog dugmeta u ToolBar-u, izborom stavke menija New, "
				+ "upotrebom odgovarajućih mnemonika, upotrebom odgovarajućeg akceleratora. Sva polja moraju biti validno popunjena, "
				+ "u suprotnom je pritisak na dugme potvrdi onemogućen. Nakon uspešnog dodavanja, dijalog za dodavanje se automatski zatvara."
				+ "\r\n\n"
				+ "Izmena entiteta sistema- nakon što ste selektovali entitet u tabeli, moguće je "
				+ "izvršiti njegovu izmenu na 3 načina: pritiskom drugog dugmeta na ToolBar-u, \r\n"
				+ "izborom stavke menija Edit ili upotrebom odgovarajućih mnemonika, nakon čega se otvara dijalog za izmenu, "
				+ "koji se razlikuje za svaki entitet."
				+ "\r\n\n"
				+ "Ukoliko trenutno radite sa entitetom Student, dijalog za izmenu sadrži 3 taba:\r\n"
				+ "1. Tab informacije pruža osnovne informacije o studentu, koje je moguće izmeniti, ukoliko unesete validne podatke.\r\n"
				+ "2. Tab položeni predmeti prikazuje spisak položenih predmeta selektovanog studenta, prosečnu ocenu i broj ostvarenih ESPB bodova. "
				+ "U okviru ovog taba je moguće izvršiti i poništavanje ocene, što rezultira uklanjanjem predmeta iz spiska položenih i "
				+ "svrstava ga u nepoložene predmete.\r\n"
				+ "3. Tab nepoloženi predmeti prikazuje spisak nepoloženih predmeta. "
				+ "Pritiskom na dugme dodaj, otvara se lista predmeta koje student može da sluša i izborom nekog predmeta, "
				+ "on se dodaje u listu nepoloženih.\r\n"
				+ "Selektovanjem određenog predmeta i pritiskom na dugme obriši, moguće je ukloniti predmet iz liste nepoloženih.\r\n"
				+ "U okviru ovog taba se vrši i upis ocene, nakon položenog ispita, čime se predmet iz liste nepoloženih "
				+ "premešta u listu položenih predmeta, što dovodi do ažuriranja prosečne ocene i ostvarenih ESPB bodova.\n\n");
	
		
		
		Font f = new Font("sans-serif", Font.PLAIN, 12);
		Main.changeFont(scrollPane, f);		
		
		dialog.add(scrollPane);
		dialog.setVisible(true);
	}
}