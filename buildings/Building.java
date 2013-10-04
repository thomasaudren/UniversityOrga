package buildings;
import java.util.ArrayList;

import administrative.Department;
import administrative.Laboratory;
import administrative.UFR;

public class Building {
	private UFR ufr;
	private int numb_r=0;
	private static int numb=1;
	private ArrayList<Room> roomList = new ArrayList<Room>(); 
	private ArrayList<ClassRoom> classRoomList = new ArrayList<ClassRoom>(); 
	private ArrayList<Office> officeList = new ArrayList<Office>(); 
	private ArrayList<PracticalRoom> practicalRoomList = new ArrayList<PracticalRoom>(); 
	private ArrayList<MeetingRoom> meetingRoomList = new ArrayList<MeetingRoom>();

	public Building(UFR ufr) {
		this.ufr = ufr;
		this.numb_r=numb++;
		this.ufr.addBuild(this);
	}

	
	public ArrayList<Room> getRoomList() {
		return roomList;
	}


	public UFR getUfr() {
		return (UFR)ufr.clone();
	}

	private void setUfr(UFR ufr) {
		this.ufr = ufr;
	}

	public int getNumb_r() {
		return numb_r;
	}

	private void setNumb_r(int numb_r) {
		this.numb_r = numb_r;
	}

	
	
	public ArrayList<ClassRoom> getClassRoomList() {
		return classRoomList;
	}

	public ArrayList<Office> getOfficeList() {
		return officeList;
	}

	public ArrayList<PracticalRoom> getPracticalRoomList() {
		return practicalRoomList;
	}

	public ArrayList<MeetingRoom> getMeetingRoomList() {
		return meetingRoomList;
	}


	@Override
	public String toString() {
		return "Bâtiment " + numb_r + " - " + ufr;
	}

	@Override
	public Object clone() {
	    try {
			return (Building) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error();
		}
	}
	
	public int nbRoom(){
		return roomList.size();
	}
	
	public void addRoom(Room room)
	{
		roomList.add(room);
	}
	
	public void addClassRoom(ClassRoom room)
	{
		classRoomList.add(room);
	}
	
	public void addMeetingRoom(MeetingRoom room)
	{
		meetingRoomList.add(room);
	}
	
	public void addOffice(Office room)
	{
		officeList.add(room);
	}
	public void addPracticalRoom(PracticalRoom room)
	{
		practicalRoomList.add(room);
	}
	
}
