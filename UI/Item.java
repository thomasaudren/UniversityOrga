package UI;

public class Item {
	private String Nom;
	
	public Item(String nom) {
		super();
		Nom = nom;
	}
	
	
	public String getNom(){
		return this.Nom;
	}
	
	@Override
	public String toString(){
		return this.Nom;
	}
	
	
}
