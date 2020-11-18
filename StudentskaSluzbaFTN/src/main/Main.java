package main;

import java.awt.Image;

import javax.swing.ImageIcon;

import view.GlavniProzor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GlavniProzor gp = new GlavniProzor();
		gp.setIconImage(new ImageIcon("images/user_group.png").getImage());
		gp.setVisible(true);
	}

}
