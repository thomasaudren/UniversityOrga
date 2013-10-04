package buildings;

public class ClassRoom extends Room {

	public ClassRoom(Building build, int nbPlace) {
		super(build, nbPlace);
		build.addClassRoom(this);
		
	}
	
	@Override
	public String toString() {
		return super.toString() +  " (Salle de classe)";
	}
}
