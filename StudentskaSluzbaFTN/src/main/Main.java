package main;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;


import controller.ProfesorContoller;
import model.BazaProfesori;

import controller.StudentController;

import model.BazaStudenti;
import model.Student;
import view.GlavniProzor;

public class Main {

	public static void main(String[] args) {
		GlavniProzor gp = GlavniProzor.getInstance();
		gp.setIconImage(new ImageIcon("images/user_group.png").getImage());
		gp.setVisible(true);
		
		BazaStudenti.getInstance();
		BazaProfesori.getInstance();
		ProfesorContoller.getInstance();
		StudentController.getInstance();
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
