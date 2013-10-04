package administrative;

public class Laboratory {
	private University univ;
	private String name;
	private int id_r=0;
	private static int id=1;
	
	public Laboratory(University univ, String name) {
		this.univ = univ;
		this.name = name;
		this.id_r=id++;
		this.univ.addLab(this);
	}
	
	public Laboratory(Laboratory lab) {
		this.univ = lab.univ;
		this.name = lab.name;
		this.id_r=id++;
	}
	
	public Laboratory() {
		this.univ = null;
		this.name = null;
	}

	public University getUniv() {
		return new University(univ);
	}

	private void setUniv(University univ) {
		this.univ = univ;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Laboratoire " + name + " - " + univ;
	}
	
	@Override
	public Object clone() {
	    try {
			return (Laboratory) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error();
		}
	}
	
}
