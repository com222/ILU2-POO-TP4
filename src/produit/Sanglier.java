package produit;

import personnages.Gaulois;

public class Sanglier extends Produit{
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unite.KG);
		this.poids = poids;
		this.chasseur = chasseur; 
	}

	@Override
	public String decrireProduit() {
		StringBuilder stringBuilder = new StringBuilder(); 
		stringBuilder.append("sanglier de ").append(poids);
		stringBuilder.append(unite.toString()).append(" chasse par ").append(chasseur.getNom());
		return stringBuilder.toString(); 
	}
	
	@Override 
	public int calculerPrix(int prix) {
		return (prix * poids) / 1000;
	}

}
