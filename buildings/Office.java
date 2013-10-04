package buildings;

import java.util.ArrayList;

import staff.ProfessorResearcher;
import staff.Staff;

public class Office extends Room {
	
	private ArrayList<Staff> staffList = new ArrayList<Staff>();
	
	public Office(Building build, int nbPlace) {
		super(build, nbPlace);
		build.addOffice(this);
		// TODO Auto-generated constructor stub
	}

	public void addStaff(Staff s)
	{
		staffList.add(s);	
	}
	
	public ArrayList<Staff> getStaffList() {
		return staffList;
	}

	@Override
	public String toString() {
		return super.toString() +  " (Bureau)";
	}
	

}
