package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;
import produit.Produit;

public interface IEtal {
	Gaulois getVendeur();
	int contientProduit(String produit, int quantitéSouhaitee);
	int acheterProduit(int quantiteSouhaitee); 
	String etatEtal(); 
}