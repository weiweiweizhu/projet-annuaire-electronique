package model.plus;

public class Personne implements Comparable<Personne> {
	private String nom;
	private String prenom;
	private int id;
	private static int counter;
	
	public Personne(String nom, String prenom) {
		counter++;
		id += counter;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int compareTo(Personne p) {
		return this.nom.compareTo(p.getNom());
	}
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "ID : " + this.id + "\nNom : " + this.nom + "\nPrenom : " + this.prenom;
	}

}
