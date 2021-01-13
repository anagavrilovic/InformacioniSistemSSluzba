package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import controller.ProfesorContoller;
import model.BazaProfesori;

import controller.StudentController;

import model.BazaStudenti;
import serijalizacija.SerijalizacijaPredmeta;
import serijalizacija.SerijalizacijaProfesora;
import serijalizacija.SerijalizacijaStudenta;
import view.GlavniProzor;

public class Main implements Serializable{

	public static void main(String[] args) throws IOException {
		
		/*
		SerijalizacijaStudenta.ucitajStudente();
		SerijalizacijaProfesora.ucitajProfesore();
		SerijalizacijaPredmeta.ucitajPredmete();
		*/
		
		/** REFERENCA: https://stackoverflow.com/questions/26913923/how-do-you-change-the-size-and-font-of-a-joptionpane */
		UIManager.put("OptionPane.messageFont", new Font("sans-serif", Font.PLAIN, 13));
		UIManager.put("OptionPane.buttonFont", new Font("sans-serif", Font.PLAIN, 13));
		
		GlavniProzor gp = GlavniProzor.getInstance();
		gp.setIconImage(new ImageIcon("images/user_group.png").getImage());
		gp.setVisible(true);
		
		BazaStudenti.getInstance();
		BazaProfesori.getInstance();
		ProfesorContoller.getInstance();
		StudentController.getInstance();
	}
	
	
	/** REFERENCA: https://stackoverflow.com/questions/12730230/set-the-same-font-for-all-component-java */
	// metoda koja menja font svakoj komponenti na prosledjenoj roditeljskoj komponenti
	public static void changeFont (Component component, Font font) {
	    component.setFont (font);
	    if (component instanceof Container) {
	        for (Component child : ((Container) component).getComponents ()) {
	            changeFont (child, font);
	        }
	    }
	}

}
