package UI;

import java.util.ArrayList;

import administrative.Department;

public class Menu {
	private String Nom;
	private ArrayList<Item> Items = new ArrayList<Item>();
	
	public Menu(String nom) {
		this.Nom = nom;
	}
	
	public String getNom() {
		return this.Nom;
	}
	
	public void addItem(Item item){
		Items.add(item);
	}
	
	public void addItemByArrayList(ArrayList<? extends Object> tab){
		Item item = null;
		for (int i = 0; i < tab.size(); i++) {
			item = new Item((String) tab.get(i).toString());
			this.addItem(item);
		}
	}
	
	public void removeItem(Item item){
		Items.remove(item);
	}
	
	public void afficher(){
		
			String list = this.Nom+"\n";
			int y = 0;
			int l = this.Items.size()-2;
			for (Item i : this.Items)
			{	
					if(this.getNom().equals("Menu")){
						if(l-y > 0){
						
							list +=y+" - "+i.toString()+"\n";
						}
						else if(l-y == 0){
							list +="save - "+i.toString()+"\n";
						}
						else{
							list +="exit - "+i.toString()+"\n";
						}
					}
					else{
						list +=y+"- "+i.toString()+"\n";
					}
					y++;

				
			}
			System.out.println(list);
	}
	
	
}
