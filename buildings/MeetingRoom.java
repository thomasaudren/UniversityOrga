package buildings;

public class MeetingRoom extends Room {

	public MeetingRoom(Building build, int nbPlace) {
		super(build, nbPlace);
		build.addMeetingRoom(this);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return super.toString() +  " (Salle de réunion)";
	}

}
