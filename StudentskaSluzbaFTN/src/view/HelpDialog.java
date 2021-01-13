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
		
		textArea.append(" \nAko radite sa tabom profesori, izborom neke od opcija za izmenu, otvara se dijalog koji sadrži 2 taba.\n"
				+ "Tab informacije pruža osnovne informacije o profesoru, koje je moguće izmeniti, ukoliko unesete validne podatke.\n" 
				+ "Tab predmeti predstavlja listu predmeta koje izabrani profesor predaje.\n" 
				+ "U okviru taba postoje i 2 dugmeta- dodaj predmet i ukloni predmet.\n" 
				+ "Pritiskom na dugme dodaj predmet, otvara se lista predmeta koji se mogu dodati u listu predmeta koje profesor predaje.\n" 
				+ "Ukoliko već postoji profesor na tom predmetu, dobićete poruku upozorenja.\n" 
				+ "Pritiskom na dugme ukloni, predmet se uklanja iz liste predmeta koje predaje profesor.\n" 
				+ "\n" 
				+ "Dijalog za izmenu predmeta sadrži informacije o predmetu, koje je moguće izmeniti, unošenjem validnih podataka.\n" 
				+ "U okviru ovog dijaloga moguće je i dodati predmetnog profesora, pritiskom na dugme \"+\", nakon čega se otvara lista svih profesora koji postoje u sistemu. \n"
				+ "Selektovanjem profesora i klikom na dugme dodaj, dodaje se profesor na predmet. "
				+ "Takođe je moguće i ukloniti postojećeg predmetnog profesora pritiskom na dugme \"-\".\n" 
				+ "\n"
				+ "Nakon pritiska na dugme potvrdi, vrši se ažuriranje podataka u sistemu i dijalog za izmenu se zatvara, " 
				+ "kako biste mogli da nastavite dalji rad.\n"
				+ "\n\n" 
				+ "Brisanje entiteta iz sistema- nakon što ste selektovali entitet u odgovarajućoj tabeli, " 
				+ "pritiskom na dugme Toolbar-a, izborom stavke menija Edit ili upotrebom odgovarajuceg mnemonika, " 
				+ "moguće je ukloniti ga iz sistema.\n"
				+ "\n" 
				+ "U okviru sistema, moguće je izvršiti i pretragu entiteta, pritiskom na dugme za pretragu ili taster enter nakon "
				+ "unošenja ključnih reči u tekstualno polje. \n"
				+ "Za pretragu studenata, obavezno je unošenje barem jedne reči koja predstavlja deo prezimena, a ostale reči " 
				+ "se mogu odnositi na ime i broj indeksa, redom. \n" 
				+ "Za pretragu profesora obavezno je uneti deo prezimena, a može se uneti i deo imena, redom. \n" 
				+ "Ukoliko pretražujete predmete, morate uneti samo reč koja predstavlja deo šifre predmeta. \n"
				+ "Za povratak iz režima pretrage, izbrišite sve karaktere iz tekstualnog polja i pritisnite enter ili dugme za pretragu. \n"
				+ "");
	
		
		
		Font f = new Font("sans-serif", Font.PLAIN, 12);
		Main.changeFont(scrollPane, f);		
		
		dialog.add(scrollPane);
		dialog.setVisible(true);
	}
}