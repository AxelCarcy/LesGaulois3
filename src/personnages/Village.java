package personnages;

import java.util.Iterator;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois [] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	

	public void setChef(Chef chef) {
	this.chef = chef;
	}
	
	
	public String getNom() {
	return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant(int numGaulois) {
		return villageois[numGaulois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois : ");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		Chef abraracourcix = new Chef("Abraracourcix", 6, 1, village);
		village.setChef(abraracourcix);
		
//		Gaulois gaulois = village.trouverHabitant(30);
//		Index 30 out of bounds for length 30
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);		
//		Car astérix est stocké à 0
		
		village.afficherVillageois();
		
	}

}


