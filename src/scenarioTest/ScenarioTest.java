package scenarioTest;

import villagegaulois.Etal;
import villagegaulois.IEtal;
import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;

public class ScenarioTest {

	public static void acheterProduit(IEtal[] marche, String produit, int quantiteSouhaitee) {
		int quantiteRestante = quantiteSouhaitee;
		for (int i = 0; i < marche.length && quantiteRestante != 0; i++) {
			IEtal etal = marche[i];
			int quantiteDisponible = etal.contientProduit(produit, quantiteRestante);
			if (quantiteDisponible != 0) {
				int prix = etal.acheterProduit(quantiteDisponible);
				String chaineProduit = accorderNomProduit(produit, quantiteDisponible);
				System.out.println("A l'étal n° " + (i + 1) + ", j'achete " + quantiteDisponible + " " + chaineProduit
						+ " et je paye " + prix + " sous.");
				quantiteRestante -= quantiteDisponible;
			}
		}
		String chaineProduit = accorderNomProduit(produit, quantiteSouhaitee);
		System.out.println("Je voulais " + quantiteSouhaitee + " " + chaineProduit + ", j'en ai acheté "
				+ (quantiteSouhaitee - quantiteRestante) + ".");
	}

	private static String accorderNomProduit(String produit, int quantiteSouhaitee) {
		String chaineProduit = produit;
		if (quantiteSouhaitee > 1) {
			chaineProduit = produit + "s";
		}
		return chaineProduit;
	}

	public static void main(String[] args) {
		// creation gaulois
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9); 
		Gaulois obelix = new Gaulois("Obélix",20); 
		Gaulois asterix = new Gaulois("Asterix", 6); 
		
		// creation tableau de produits 
		Sanglier sanglier1 = new Sanglier(2000, obelix); 
		Sanglier sanglier2 = new Sanglier(1500, obelix); 
		Sanglier sanglier3 = new Sanglier(1000, asterix); 
		Sanglier sanglier4 = new Sanglier(500, asterix);
		Sanglier[] sangliersObelix = {sanglier1, sanglier2}; 
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4}; 
		
		Poisson poisson1 = new Poisson("lundi");  
		Poisson[] poissons = {poisson1}; 
		
		// creation marche 
		
		IEtal[] marche = new IEtal[3];
		
		Etal <Sanglier> etalSanglier1 = new Etal<>();
		Etal <Sanglier>  etalSanglier2 = new Etal<>();
		Etal <Poisson>  etalPoisson = new Etal<>();
		
		marche[0] = etalSanglier1;
		marche[1] = etalSanglier2;
		marche[2] = etalPoisson; 
		
		// installation vendeurs 
		etalSanglier1.installerVendeur(asterix, sangliersAsterix, 10);
		etalSanglier2.installerVendeur(obelix, sangliersObelix, 8);
		etalPoisson.installerVendeur(ordralfabetix, poissons, 7);
		
		// test des méthodes 
		for (int i =0; i<3; i++) {
			System.out.println(marche[i].etatEtal());
		}
		// Asterix vend 2 produits : 
		//   - sanglier de 1000 kg chasse par Asterix.
		//   - sanglier de 500 kg chasse par Asterix.
		// Obelix vend 2 produits : 
		//   - sanglier de 2000 kg chasse par Obelix.
		//   - sanglier de 1500 kg chasse par Obelix. 
		// Ordrafabetix vend 1 produits :
		//   - poisson peche lundi. 
		
		acheterProduit(marche, "sanglier", 3);
		// a l'etal n°1, j'achete 2 sangliers et je paye 12 sous.
		// a l'etal n°2, j'achete 1 sanglier et je paye 15 sous.
		// Je voulais 3 sangliers, j'en ai achete 3.
		
		for (int i =0; i<3; i++) {
			System.out.println(marche[i].etatEtal());
		}
		// Asterix n'a plus rien a vendre.
		// Obelix vend 1 produits: 
		//   - sanglier de 2000 kg chasse par Obelix. 
		// Ordrafabetix vend 1 produits :
		//   - poisson peche lundi.
	}

}
