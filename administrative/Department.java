package administrative;

public class Department {
	private UFR ufr;
	private String name;
	private int id_r=0;
	private static int id=1;

	public Department(UFR ufr, String name) {
		this.ufr = ufr;
		this.name = name;
		this.id_r = id++;
		this.ufr.addDep(this);
		this.getUniversity().addDep(this);
		}

	public UFR getUfr() {
		return (UFR)ufr.clone();
	}

	private void setUfr(UFR ufr) {
		this.ufr = ufr;
	}

	public String getName() {
		return name;
	}
	
	public University getUniversity() {
		University univ=this.ufr.getUniv();
		return univ;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId_r() {
		return id_r;
	}

	@Override
	public String toString() {
		return "Departement " + name + " - " + ufr;
	}

	@Override
	public Object clone() {
	    try {
			return (Department) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error();
		}
	}
	
	
}
	