package buildings;

public class PracticalRoom extends Room {

	public PracticalRoom(Building build, int nbPlace) {
		super(build, nbPlace);
		build.addPracticalRoom(this);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() +  " (Salle de TP)";
	}


}
