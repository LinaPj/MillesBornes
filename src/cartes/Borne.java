package cartes;

public class Borne extends Carte {
	public Borne(int km) {
		this.km = km;
	}

	private int km;

	public int getKm() {
		return km;
	}

	@Override
	public String toString() {

		return getKm() + "KM";
	}

}
