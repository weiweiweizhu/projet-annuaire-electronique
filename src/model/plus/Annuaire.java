package model.plus;

import java.util.*;
import java.util.Map.Entry;

public class Annuaire {
	private HashMap<Personne, Coordonnees> map;
	private String nom;
	private static boolean valide;

	Scanner in = new Scanner(System.in);

	public Annuaire() {
		this.map = new HashMap<Personne, Coordonnees>();
	}

	public void ajout(Personne p, Coordonnees c) {
		map.put(p, c);
	}

	public Coordonnees affichCoord(Personne p) {
		return map.get(p);
	}

	public void modifCoord(Personne p, Coordonnees c) {
		map.replace(p, c);
	}

	public void suppresion(Personne p) {
		map.remove(p);
	}

	public Set<Personne> listerNoms() {
		return map.keySet();
	}

	public String getTelephone(Coordonnees c) {
		return c.getTel();
	}

	public String listerTel() {
		ArrayList<String> al = new ArrayList<String>();
		for (Entry<Personne, Coordonnees> line : map.entrySet()) {
			al.add(line.getValue().getTel());
		}
		return Arrays.toString(al.toArray());
	}

	public String listerAdr() {
		ArrayList<String> al = new ArrayList<String>();
		for (Entry<Personne, Coordonnees> line : map.entrySet()) {
			al.add(line.getValue().getAdr());
		}
		return Arrays.toString(al.toArray());
	}

	public void trouverCoordParNom(String nom) {
		ArrayList<Personne> al = new ArrayList<Personne>();
		for (Entry<Personne, Coordonnees> line : map.entrySet()) {
			al.add(line.getKey());
		}

		ArrayList<Personne> choisi = new ArrayList<Personne>();
		for (Personne p : al) {
			if (p.getNom().equals(nom)) {
				choisi.add(p);
			}
		}
		if (choisi.size() == 1) {
			System.out.println(choisi.get(0));
			System.out.println(map.get(choisi.get(0)));
			return;
		} else if (choisi.size() > 1) {
			System.out.println("Il y a " + choisi.size() + " " + nom);
			System.out.println("Veillez saisir le prenom");
			String prenom = in.nextLine();
			for (Personne p2 : choisi) {
				if (p2.getPrenom().equals(prenom)) {
					System.out.println(p2);
					System.out.println(map.get(p2));
					return;
				}
			}
		}
		System.out.println("Cette personne n'exsite pas");
	}

	public void trouverCoordParPrenom(String prenom) {
		ArrayList<Personne> al = new ArrayList<Personne>();
		for (Entry<Personne, Coordonnees> line : map.entrySet()) {
			al.add(line.getKey());
		}

		ArrayList<Personne> choisi = new ArrayList<Personne>();
		for (Personne p : al) {
			if (p.getPrenom().equals(prenom)) {
				choisi.add(p);
			}
		}
		if (choisi.size() == 1) {
			System.out.println(choisi.get(0));
			System.out.println(map.get(choisi.get(0)));
			return;
		} else if (choisi.size() > 1) {
			System.out.println("Il y a " + choisi.size() + " " + nom);
			System.out.println("Veillez saisir le nom");
			String nom = in.nextLine();
			for (Personne p2 : choisi) {
				if (p2.getNom().equals(nom)) {
					System.out.println(p2);
					System.out.println(map.get(p2));
					return;
				}
			}
		}
		System.out.println("Cette personne n'exsite pas");
	}

	public void trouverCoordParId(int id) {
		ArrayList<Personne> al = new ArrayList<Personne>();
		for (Entry<Personne, Coordonnees> line : map.entrySet()) {
			al.add(line.getKey());
		}

		for (Personne p : al) {
			if (p.getId() == id) {
				System.out.println(al.get(0));
				System.out.println(map.get(al.get(0)));
				valide = true;
				return;
			}
			System.out.println("Cette personne n'exsite pas");
			valide = false;
		}
	}

	public static boolean isValide() {
		return valide;
	}

	public void modifierNom(int id) {
		ArrayList<Personne> al = new ArrayList<Personne>();
		for (Entry<Personne, Coordonnees> line : map.entrySet()) {
			al.add(line.getKey());
		}

		for (Personne p : al) {
			if (p.getId() == id) {
				System.out.println("Saissisez le nouveau nom");
				p.setNom(in.nextLine());
				System.out.println("La modification est bien prise en compte");
				System.out.println(al.get(0));
				System.out.println(map.get(al.get(0)));
				return;
			}
			System.out.println("Cette personne n'exsite pas");
		}
	}

	public void modifierPrenom(int id) {
		ArrayList<Personne> al = new ArrayList<Personne>();
		for (Entry<Personne, Coordonnees> line : map.entrySet()) {
			al.add(line.getKey());
		}

		for (Personne p : al) {
			if (p.getId() == id) {
				System.out.println("Saissisez le nouveau prenom");
				p.setPrenom(in.nextLine());
				System.out.println("La modification est bien prise en compte");
				System.out.println(al.get(0));
				System.out.println(map.get(al.get(0)));
				return;
			}
			System.out.println("Cette personne n'exsite pas");
		}
	}

	public void modifierTel(int id) {
		ArrayList<Personne> al = new ArrayList<Personne>();
		for (Entry<Personne, Coordonnees> line : map.entrySet()) {
			al.add(line.getKey());
		}

		for (Personne p : al) {
			if (p.getId() == id) {

				String num = "";
				do {
					System.out.println(
							"Saisissez son numero de telephone (10 chiffres). Si vous ne connaissez pas, tapez la touch retour");
					num = in.nextLine();
				} while (!((num.length() == 10 && num.substring(0, 2).equals("03"))
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
				
				map.get(al.get(0)).setTel(num);
				System.out.println("La modification est bien prise en compte");
				System.out.println(al.get(0));
				System.out.println(map.get(al.get(0)));
				return;
			}
			System.out.println("Cette personne n'exsite pas");
		}
	}

	public void modifierAdr(int id) {
		ArrayList<Personne> al = new ArrayList<Personne>();
		for (Entry<Personne, Coordonnees> line : map.entrySet()) {
			al.add(line.getKey());
		}

		for (Personne p : al) {
			if (p.getId() == id) {
				System.out.println("Saissisez le nouveau adresse");

				String adr =in.nextLine();
				if(adr.length()==0) {
					adr = "vide";
				}
				map.get(al.get(0)).setAdr(adr);
				System.out.println("La modification est bien prise en compte");
				System.out.println(al.get(0));
				System.out.println(map.get(al.get(0)));
				return;
			}
			System.out.println("Cette personne n'exsite pas");
		}
	}

	public void affichAnnuaire() {

		ArrayList<Personne> al = new ArrayList<Personne>();
		for (Entry<Personne, Coordonnees> line : map.entrySet()) {
			al.add(line.getKey());
		}

		Collections.sort(al);
		for (Personne per : al) {
			System.out.println("----------");
			System.out.println(per);
			System.out.println(map.get(per));
		}
//		al.forEach(System.out::println);
	}

	public static void init() {
		System.out.println("Veuillez choisir votre action : ");
		System.out.println("\t0 - quitte l'application");
		System.out.println("\t1 - ajout personne à l'annuaire");
		System.out.println("\t2 - affichage coordonnée d'une personne");
		System.out.println("\t3 - modification coordonnées");
		System.out.println("\t4 - affichage toute l'annuaire");
	}

	public int statistiques() {
		return map.size();
	}

}
