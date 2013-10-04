package jdom;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import staff.Lecturer;
import staff.PRAG;
import staff.Professor;
import staff.ProfessorResearcher;

import buildings.*;

import administrative.Laboratory;
import administrative.UFR;
import administrative.University;

public class Load {
	 private Document document = null;
	 private Element racine = null;
	 private University univ = null;
	 
	 
	 
	 public Load(){
		//On cr�e une instance de SAXBuilder
	      SAXBuilder sxb = new SAXBuilder();
	      try
	      {
	         //On cr�e un nouveau document JDOM avec en argument le fichier XML
	         //Le parsing est termin� ;)
	         document = sxb.build(new File("Universite.xml"));
	      }
	      catch(Exception e){}

	      //On initialise un nouvel �l�ment racine avec l'�l�ment racine du document.
	      racine = document.getRootElement();
	      
	      this.univ = this.loadUniversity();
	      this.loadUFR();
	      this.loadLaboratory();
	    
	 }
	 public University loadUniversity(){
		 University univ = null;
		 univ = new University(racine.getAttributeValue("location"));
		 return univ;
	 }
	 
	 public void loadUFR(){
		//On cr�e une List contenant tous les noeuds "etudiant" de l'Element racine
	      List listUFR = racine.getChildren("UFR");

	      //On cr�e un Iterator sur notre liste
	      Iterator i = listUFR.iterator();
	      while(i.hasNext())
	      {
	         //On recr�e l'Element courant � chaque tour de boucle afin de
	         //pouvoir utiliser les m�thodes propres aux Element comme :
	         //s�lectionner un n�ud fils, modifier du texte, etc...
	         Element courant = (Element)i.next();
	         //On affiche le nom de l��l�ment courant

	         UFR ufr = new UFR(this.univ,courant.getAttributeValue("name"));
	         this.loadBuilding(ufr,courant);
	      }
	 }	 
	 
	 public void loadBuilding(UFR ufr, Element eUfr){
			//On cr�e une List contenant tous les noeuds "etudiant" de l'Element racine
		      List listBuilding = eUfr.getChildren("Building");

		      //On cr�e un Iterator sur notre liste
		      Iterator i = listBuilding.iterator();
		      while(i.hasNext())
		      {
		         //On recr�e l'Element courant � chaque tour de boucle afin de
		         //pouvoir utiliser les m�thodes propres aux Element comme :
		         //s�lectionner un n�ud fils, modifier du texte, etc...
		         Element courant = (Element)i.next();
		         //On affiche le nom de l��l�ment courant

		         Building build = new Building(ufr);
		         this.loadRoom(build, courant);
		      }
		 }
	 
	 public void loadRoom(Building build, Element eBuilding){
			//On cr�e une List contenant tous les noeuds "etudiant" de l'Element racine
		      List listRoom = eBuilding.getChildren("Room");

		      //On cr�e un Iterator sur notre liste
		      Iterator i = listRoom.iterator();
		      while(i.hasNext())
		      {
		         //On recr�e l'Element courant � chaque tour de boucle afin de
		         //pouvoir utiliser les m�thodes propres aux Element comme :
		         //s�lectionner un n�ud fils, modifier du texte, etc...
		         Element courant = (Element)i.next();
		         //On affiche le nom de l��l�ment courant
		        int nbPLaces = Integer.parseInt(courant.getAttributeValue("nbPlaces"));
		        String type = courant.getAttributeValue("type");
		   
		         if(type.equals("buildings.ClassRoom")){
		        	 ClassRoom classRoom = new ClassRoom(build,nbPLaces);
		         }
		         else if(type.equals("buildings.MeetingRoom")){
		        	 MeetingRoom meetingRoom = new MeetingRoom(build,nbPLaces);
		         }
		         else if(type.equals("buildings.Office")){
		        	 Office office = new Office(build,nbPLaces);
		        	 this.loadStaff(office, courant);
		         }
		         else if(type.equals("buildings.PracticalRoom")){
		        	 PracticalRoom practicalRoom = new PracticalRoom(build,nbPLaces);
		         }
		         
		      }
		 }
	 
	 private void loadStaff(Office office, Element eOffice) {
		  List listStaff = eOffice.getChildren("Personnel");
		  
		  Iterator i = listStaff.iterator();
	      while(i.hasNext())
	      {
	    	  Element courant = (Element)i.next();
	    	  
		      String pnom = courant.getAttributeValue("prenom");
		      String nom = courant.getAttributeValue("nom");
		      Date emb = new Date(Long.parseLong(courant.getAttributeValue("date_emb")));
		      String type = courant.getAttributeValue("type");
		      
		      if(type.equals("staff.Lecturer")){
		    	  Lecturer lecturer = new Lecturer(office, nom, pnom, emb);
		         }
		         else if(type.equals("staff.PRAG")){
		        	 PRAG prag = new PRAG(office, nom, pnom, emb);
		         }
		         else if(type.equals("staff.Professor")){
		        	 Professor professor = new Professor(office, nom, pnom, emb);
		         }
		         else if(type.equals("staff.ProfessorResearcher")){
		        	 ProfessorResearcher professorResearcher = new ProfessorResearcher(office, nom, pnom, emb);
		         }
		      
		      
	    	  
	      }
		
	}
	public void loadLaboratory(){
			//On cr�e une List contenant tous les noeuds "etudiant" de l'Element racine
		      List listLaboratory = racine.getChildren("Laboratory");

		      //On cr�e un Iterator sur notre liste
		      Iterator i = listLaboratory.iterator();
		      while(i.hasNext())
		      {
		         //On recr�e l'Element courant � chaque tour de boucle afin de
		         //pouvoir utiliser les m�thodes propres aux Element comme :
		         //s�lectionner un n�ud fils, modifier du texte, etc...
		         Element courant = (Element)i.next();
		         //On affiche le nom de l��l�ment courant

		         Laboratory lab = new Laboratory(this.univ,courant.getAttributeValue("name"));
		      }
		 }
	 
	 public University getUniversity(){
		 return univ;
		}
}
