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
	
	@Override
	public boolean equals(Object obj) {
	    if (obj instanceof Borne borne) {
	        return km == borne.getKm();
	    }
	    return false;
	}
	
	@Override
	public int hashCode() {
	    return Integer.hashCode(km);
	}

}
