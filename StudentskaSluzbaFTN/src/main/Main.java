package main;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;

import model.BazaStudenti;
import view.GlavniProzor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GlavniProzor gp = GlavniProzor.getInstance();
		gp.setIconImage(new ImageIcon("images/user_group.png").getImage());
		gp.setVisible(true);
		
		BazaStudenti.getInstance();
	}
	
	
	// Metoda preuzeta sa stackoverflow-a
	// https://stackoverflow.com/questions/12730230/set-the-same-font-for-all-component-java
	public static void changeFont (Component component, Font font) {
	    component.setFont (font);
	    if (component instanceof Container) {
	        for (Component child : ((Container) component).getComponents ()) {
	            changeFont (child, font);
	        }
	    }
	}

}
