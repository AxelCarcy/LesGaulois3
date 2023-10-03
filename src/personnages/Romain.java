package personnages;

import java.util.Iterator;

public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		//précondition
		assert force > 0;
		int forceAssert = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < forceAssert;
	}
	
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
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		
		minus.prendreParole();
		minus.parler("Bonjour");
//		minus.recevoirCoup(8);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		
		
	}
}
