package staff;

import java.util.ArrayList;
import java.util.Date;

import administrative.UFR;
import buildings.Office;
import buildings.Room;

public class Staff {
	private Office off;
	private String lastName;
	private String firstName;
	private Date embauche;
	private int id_r;
	private static int id=0;
	private ArrayList<PRAG> pragList = new ArrayList<PRAG>(); 
	private ArrayList<Lecturer> lectList = new ArrayList<Lecturer>(); 
	private ArrayList<Professor> profList = new ArrayList<Professor>();
	private ArrayList<ProfessorResearcher> PRList = new ArrayList<ProfessorResearcher>();
	
	public Staff(Office off, String lastName, String firstName, Date embauche) {
		this.off = off;
		this.lastName = lastName;
		this.firstName = firstName;
		this.embauche = embauche;
		this.id_r=id++;
		off.addStaff(this);
	}

	public Office getOff() {
		return off;
	}

	public void setOff(Office off) {
		this.off = off;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getEmbauche() {
		return embauche;
	}

	private void setEmbauche(Date embauche) {
		this.embauche = embauche;
	}

	public int getId_r() {
		return id_r;
	}

	private void setId_r(int id_r) {
		this.id_r = id_r;
	}

	@Override
	public String toString() {
		return "Staff [off=" + off + ", lastName=" + lastName + ", firstName="
				+ firstName + ", birthday=" + embauche + ", id_r=" + id_r + "]";
	}
	
	public void addProf(Professor prof)
	{
		profList.add(prof);
	}
	public void addPR(ProfessorResearcher PR)
	{
		PRList.add(PR);
	}
	public void addLect(Lecturer lect)
	{
		lectList.add(lect);
	}
	public void addPRAG(PRAG prag)
	{
		pragList.add(prag);
	}
	
	@Override
	public Object clone() {
	    try {
			return (Staff) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error();
		}
	}
}
