package model.plus;

public class Coordonnees {
	private String tel;
	private String adr;
//	Scanner in = new Scanner(System.in);

	public Coordonnees(String tel, String adr) {
		this.tel = tel;
		this.adr = adr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
//		tel = in.nextLine();
		this.tel = tel;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	@Override
	public String toString() {
		String type = "";
		if (this.tel.substring(0, 2).equals("03")) {
			type = "Numero fixe : ";
		} else if (this.tel.substring(0, 2).equals("06")) {
			type = "Numero mobile : ";
		}else if (this.tel.substring(0, 2).equals("08")) {
			type = "Numero a tarification speciale : ";
		}else {
			type = "Numero : ";
		}

		return type + this.tel + "\nAdresse : " + this.adr;
	}

//	public String listerTel() {
//		
//	}
}
