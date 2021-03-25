package model;

public class City {

	private long postanskiBroj;
	private String naziv;
	public City(long postanskiBroj, String naziv) {
		super();
		this.postanskiBroj = postanskiBroj;
		this.naziv = naziv;
	}
	public long getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(long postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	@Override
	public String toString() {
		return "City [postanskiBroj=" + postanskiBroj + ", naziv=" + naziv + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + (int) (postanskiBroj ^ (postanskiBroj >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (postanskiBroj != other.postanskiBroj)
			return false;
		return true;
	}
	
}
