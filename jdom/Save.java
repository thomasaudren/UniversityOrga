package jdom;

import java.io.*;
import java.util.ArrayList;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import staff.Staff;
import buildings.Building;
import buildings.Office;
import buildings.Room;
import administrative.*;
import jdom.*;

public class Save {
	
	private University univ;
	private Element racine = null;
	private Document document = null;
	
	public Save(University univ){
		this.univ = univ;
		this.racine = new Element("University");
		Attribute name = new Attribute("location", univ.getLocation());
		racine.setAttribute(name);
		ArrayList<UFR> filsUfr = univ.getUfrList();
		ArrayList<Laboratory> filsLab = univ.getLabList();
		ArrayList<Building> filsBuilding = null;
		ArrayList<Room> filsRoom = null;
		ArrayList<Office> filsOffice = null;
		ArrayList<Staff> filsStaff = null;
		for(int i = 0; i <filsUfr.size(); i++) 
		{
			
			Element element = new Element("UFR");
			name = new Attribute("name",filsUfr.get(i).getName());
			element.setAttribute(name);
			racine.addContent(element);
			filsBuilding = filsUfr.get(i).getBuildList();
			
			for(int j = 0; j <filsBuilding.size(); j++) 
			{
				Element building = new Element("Building");
				element.addContent(building);
				filsRoom = filsBuilding.get(j).getRoomList();
				filsOffice = filsBuilding.get(j).getOfficeList();
				
				for(int k = 0; k <filsRoom.size(); k++) 
				{
					Element room = new Element("Room");
					name = new Attribute("type",filsRoom.get(k).getClass().getName());
					room.setAttribute(name);
					name = new Attribute("nbPlaces",String.valueOf(filsRoom.get(k).getNbPlace()));
					room.setAttribute(name);
					building.addContent(room);
					if(filsRoom.get(k).getClass().getName().equals("buildings.Office"))
					{
						Office o = (Office) filsRoom.get(k);
						filsStaff = o.getStaffList();
						if (filsStaff.size()>0)
						{
							for(int e=0; e<filsStaff.size(); e++)
							{
								Element prof = new Element("Personnel");
								name = new Attribute("type",filsStaff.get(e).getClass().getName());
								prof.setAttribute(name);
								name = new Attribute("prenom",String.valueOf(filsStaff.get(e).getFirstName()));
								prof.setAttribute(name);
								name = new Attribute("nom",String.valueOf(filsStaff.get(e).getLastName()));
								prof.setAttribute(name);
								name = new Attribute("date_emb",String.valueOf(filsStaff.get(e).getEmbauche().getTime()));
								prof.setAttribute(name);
								room.addContent(prof);
							}
						}
					}
				}			
			}
			
		}
		for(int i = 0; i <filsLab.size(); i++) 
		{
			Element element = new Element("Laboratory");
			name = new Attribute("name",filsLab.get(i).getName());
			element.setAttribute(name);
			racine.addContent(element);
			
		}
		this.document = new Document(racine);
		
	}
	
	   public void affiche()
	   {
	      try
	      {
	         //On utilise ici un affichage classique avec getPrettyFormat()
	         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	         sortie.output(document, System.out);
	      }
	      catch (java.io.IOException e){}
	   }

	   public void enregistre(String fichier)
	   {
	      try
	      {
	         //On utilise ici un affichage classique avec getPrettyFormat()
	         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	         //Remarquez qu'il suffit simplement de créer une instance de FileOutputStream
	         //avec en argument le nom du fichier pour effectuer la sérialisation.
	         sortie.output(document, new FileOutputStream(fichier));
	      }
	      catch (java.io.IOException e){}
	   }
}

