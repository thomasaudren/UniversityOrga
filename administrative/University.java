package administrative;

import java.util.ArrayList;
import java.util.Iterator;

import buildings.Building;

public class University {
	private String location;
	private ArrayList<UFR> UfrList = new ArrayList<UFR>(); 
	private ArrayList<Laboratory> LabList = new ArrayList<Laboratory>(); 
	private ArrayList<Department> DepList = new ArrayList<Department>(); 
	
	public University() {
		this.location = null;
	}
	
	public University(String location) {
		this.location = location;
	}
	
	public University(University univ) {
		this.location = univ.location;
	}

	public String getLocation() {
		return location;
	}

	private void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Université " + location;
	}
	
	@Override
	public Object clone() {
	    try {
			return (University) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error();
		}
	}
	
	public void addDep(Department dep)
	{
		DepList.add(dep);
	}
	
	public void addLab(Laboratory lab)
	{
		LabList.add(lab);
	}
	
	public void addUfr(UFR ufr)
	{
		UfrList.add(ufr);
	}
	public ArrayList<UFR> getUfrList() {
		return UfrList;
	}

	public void setUfrList(ArrayList<UFR> ufrList) {
		UfrList = ufrList;
	}

	public ArrayList<Laboratory> getLabList() {
		return LabList;
	}

	public void setLabList(ArrayList<Laboratory> labList) {
		LabList = labList;
	}

	public ArrayList<Department> getDepList() {
		return DepList;
	}

	public void setDepList(ArrayList<Department> depList) {
		DepList = depList;
	}

	public String listUfr(){
		String list = "";
		for (UFR u : UfrList)
		{
			list += u.toString()+"\n";
		}
		return list;
	}
	
	public String listDep(){
		String list = "";
		for (Department d : DepList)
		{
			list += d.toString()+"\n";
		}
		return list;
	}
	
	public String listLab(){
		String list = "";
		for (Laboratory l : LabList)
		{
			list += l.toString()+"\n";
		}
		return list;
	}
	
}
