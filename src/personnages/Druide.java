package personnages;
import java.util.*;

public class Druide {
	private String nom;
	private int forcePotion = 1;
	private int effetPotionMin;
	private int effetPotionMax;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller "
				+ "d'une force de " + effetPotionMin + " à " + effetPotionMax + ".");
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public int preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMin, effetPotionMax + 1);
		if (forcePotion > 7) {
			parler("J'ai préparé une super potion de force " + forcePotion + ".");
		} else {
			parler("Je n'ai pas trouvé tous les ingédients, ma potion est seulement de force " + forcePotion + ".");
		}
		this.forcePotion = forcePotion;
		return forcePotion;
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			parler("Non, Obélix !... Tu n'auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}
	
	
	
	
	
}

