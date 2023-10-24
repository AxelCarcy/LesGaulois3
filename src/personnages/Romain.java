package personnages;

import java.util.Iterator;

public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipements;
	private int nbEquipement = 0;
	
	String texte;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		//précondition
//		assert force > 0;
//		int forceAssert = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		// post condition la force a diminuée
//		assert force < forceAssert;
//	}
	
	public void sEquiper(Equipement equip) {
		switch (nbEquipement) {
		
		case 0: 
			equipements[0] = equip;
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equip + ".");
			nbEquipement += 1;
			
		case 1:
			if (equip == equipements[0]) {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipements[0] + ". ");
				break;
			}
			else {
				equipements[1] = equip;
				System.out.println("Le soldat " + nom + " s'équipe avec un " + equip + ". ");
				nbEquipement ++;
			}
			
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;

		default:
			System.out.println("Erreur nbEquipement");
			break;
		}
	}
		
		
		public Equipement[] recevoirCoup(int forceCoup) {
			Equipement[] equipementEjecte = null;
			// précondition
			assert force > 0;
			int oldForce = force;
			forceCoup = calculResistanceEquipement(forceCoup);
			force -= forceCoup;
			// if (force > 0) {
			// 	parler("Aïe");
			// } else {
			// 	equipementEjecte = ejecterEquipement();
			// 	parler("J'abandonne...");
			// }
			if (force == 0) {
				parler("Aîe");
			} else {
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
			}
			// post condition la force a diminuée
			assert force < oldForce;
			return equipementEjecte;
			}
		
		private int calculResistanceEquipement(int forceCoup) {
			texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
			int resistanceEquipement = 0;
			if (nbEquipement != 0) {
				texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
				for (int i = 0; i < nbEquipement; i++) {
					if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
						resistanceEquipement += 8;
					} else {
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
					}
				}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
		
		private Equipement[] ejecterEquipement() {
			Equipement[] equipementEjecte = new Equipement[nbEquipement];
			System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
			int nbEquipementEjecte = 0;
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null) {
					equipementEjecte[nbEquipementEjecte] =
					equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				}
			}
			return equipementEjecte;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		
		minus.prendreParole();
		minus.parler("Bonjour");
//		minus.recevoirCoup(8);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		
		
	}
}
