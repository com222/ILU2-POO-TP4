package produit;

public enum Unite {
	G("g"), KG("kg"), L("l"), CL("cl"), ML("ml"), PIECE("piece");

	private final String valeur;

	private Unite(String valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return valeur;
	}
}
