package model;

public class City {

	private long postalCode;
	private String name;
	public City(long postalCode, String name) {
		super();
		this.postalCode = postalCode;
		this.name = name;
	}
	public long getPostanskiBroj() {
		return postalCode;
	}
	public void setPostanskiBroj(long postalCode) {
		this.postalCode = postalCode;
	}
	public String getNaziv() {
		return name;
	}
	public void setNaziv(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "City [postalCode=" + postalCode + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (postalCode ^ (postalCode >>> 32));
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postalCode != other.postalCode)
			return false;
		return true;
	}
	
}
