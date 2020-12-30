package controller;

public class PretragaProfesora {
	
	private static PretragaProfesora instance = null;

	public static  PretragaProfesora getInstance() {
		if (instance == null) {
			instance = new  PretragaProfesora();
		}
		return instance;
	}
	
	private String prezime;
	private String ime;
	
	public PretragaProfesora() {
		this.prezime = "";
		this.ime = "";
	}
	
	public boolean validacijaUnosa(String unos) {
		
		return false;
	}
	
	public void pronadjiProfesore() {
		
	}
}
