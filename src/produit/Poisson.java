package produit;

public class Poisson extends Produit{
	private String datePeche;
	
	public Poisson(String datePeche) {
		super("poisson", Unite.PIECE);
		this.datePeche = datePeche; 
	}

	@Override
	public void decrireProduit() {
		System.out.println("poisson peche " + datePeche);
		
	}

}
