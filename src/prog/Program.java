package prog;

import java.util.Scanner;

import model.plus.Annuaire;
import model.plus.Coordonnees;
import model.plus.Personne;

public class Program {
	public static void main(String[] args) {

		Annuaire a1 = new Annuaire();
		Personne p1;

		Scanner in = new Scanner(System.in);
		int choix = 0;

		try {
			do {
				System.out.println("Bonjour");
				Annuaire.init();

				choix = in.nextInt();
			} while (choix < 0 || choix > 4);

			while (true) {
				in.nextLine();
				if (choix == 0) {
					System.out.println("Au revoir");
					break;
				} else if (choix == 1) {
					System.out.println("Vouz pouvez ajouter une personne dans l'annuaire\nVeuillez saisir le nom");
					String nom = in.nextLine();
					System.out.println("Saisissez son prenom");
					String prenom = in.nextLine();
					String num;

					do {
					System.out.println(
							"Saisissez son numero de telephone (10 chiffres). Si vous ne connaissez pas, tapez la touch retour");
					num = in.nextLine();
					}while(!((num.length() == 10 && num.substring(0, 2).equals("03"))
							|| (num.length() == 10 && num.substring(0, 2).equals("06"))
							|| (num.length() == 10 && num.substring(0, 2).equals("08")) || num.length() == 0));

					if (num.length() == 0) {
						num = "vide";
					}
					
					if (num.length() == 10) {
						String regex = "(.{2})";
						num = num.replaceAll(regex, "$1.");
						num = num.substring(0, num.length() - 1);
					}

					System.out.println("Saisissez son adresse");
					String adr = in.nextLine();
					if(adr.length()==0) {
						adr = "vide";
					}

					p1 = new Personne(nom, prenom);
					Coordonnees coord = new Coordonnees(num, adr);

					a1.ajout(p1, coord);
					System.out.println("Il est bien enreigistre das l'annuaire");
					Annuaire.init();
					choix = in.nextInt();
				} else if (choix == 2) {
					System.out.println("Vous pouvez trouver les coordonnees d'une personne : " + "\n\t0 - par son nom"
							+ "\n\t1 - par son prenom" + "\n\t2 - par son id");

					choix = in.nextInt();

					switch (choix) {
					case 0:
						in.nextLine();
						System.out.println("Veuillez saisir le nom");
						String nom = in.nextLine();
						a1.trouverCoordParNom(nom);
						Annuaire.init();
						choix = in.nextInt();
						break;

					case 1:
						in.nextLine();
						System.out.println("Veuillez saisir le prenom");
						String prenom = in.nextLine();
						a1.trouverCoordParPrenom(prenom);
						Annuaire.init();
						choix = in.nextInt();
						break;

					case 2:
						in.nextLine();
						System.out.println("Veuillez saisir le id");
						int id = in.nextInt();
						a1.trouverCoordParId(id);
						Annuaire.init();
						choix = in.nextInt();
						break;
					}

				} else if (choix == 3) {
					System.out.println(
							"Vous pouvez modifier les info d'une personne : \n\tVeuillez saisir le ID\n\tSi vous ne connaissez pas le ID, veuillez tapez 0");
					int id = in.nextInt();

					if (id == 0) {
						in.nextLine();
						Annuaire.init();
						choix = in.nextInt();

					} else {
						in.nextLine();
						a1.trouverCoordParId(id);
						int choix2;
						if (Annuaire.isValide()) {
							System.out.println(
									"Veuillez choisir ce que vous voulez modifier : \n\t0 - nom\n\t1 - prenom\n\t2 - numero de telephone\n\t3 - adresse");

							choix2 = in.nextInt();

							switch (choix2) {
							case 0:
								a1.modifierNom(id);
								Annuaire.init();
								choix = in.nextInt();
								break;

							case 1:
								a1.modifierPrenom(id);
								Annuaire.init();
								choix = in.nextInt();
								break;

							case 2:
								a1.modifierTel(id);
								Annuaire.init();
								choix = in.nextInt();
								break;

							case 3:
								a1.modifierAdr(id);
								Annuaire.init();
								choix = in.nextInt();
								break;
							}
						} else {
							Annuaire.init();
							choix2 = in.nextInt();

						}
					}
				} else if (choix == 4) {
					a1.affichAnnuaire();
					Annuaire.init();
					choix = in.nextInt();
				}
			}
		} catch (

		Exception e) {
			System.out.println("Desole, votre saisie n'est pas valable, le program est termine");
		}
	}

}
