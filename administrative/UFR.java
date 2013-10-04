package administrative;

import java.util.ArrayList;

import buildings.Building;

public class UFR {
	private University univ;
	private String name;
	private int id_r=0;
	private static int id=0;
	private ArrayList<Department> DepList = new ArrayList<Department>(); 
	private ArrayList<Building> BuildList = new ArrayList<Building>(); 
	
	


	public UFR(University univ, String name) {
		this.univ = univ;
		this.name = name;
		this.id_r=id++;
		this.univ.addUfr(this);
	}
	
	public University getUniv() {
		return this.univ;
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
	
	public ArrayList<Department> getDepList() {
		return DepList;
	}

	public ArrayList<Building> getBuildList() {
		return BuildList;
	}
	
	public int getId_r() {
		return id_r;
	}

	private void setId_r(int id_r) {
		this.id_r = id_r;
	}

	@Override
	public String toString() {
		return "UFR " + name + " - " + univ;
	}
	
	@Override
	public Object clone() {
	    try {
			return (UFR) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error();
		}
	}
	
	public void addDep(Department dep)
	{
		DepList.add(dep);
	}
	
	public void addBuild(Building build)
	{
		BuildList.add(build);
	}
	
	public String listDep(){
		String list = "";
		for (Department d : DepList)
		{
			list += d.toString()+"\n";
		}
		return list;
	}
	
	public String listBuild(){
		String list = "";
		for (Building b : BuildList)
		{
			list += b.toString()+"\n";
		}
		return list;
	}
}
