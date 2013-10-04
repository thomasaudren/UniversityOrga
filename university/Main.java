package university;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import staff.Lecturer;
import staff.PRAG;
import staff.Professor;
import staff.ProfessorResearcher;
import jdom.Load;
import jdom.Save;
import buildings.*;
import UI.Item;
import UI.Menu;
import administrative.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		University univ = null;
		boolean run = true;
		Scanner lectureClavier = new Scanner(System.in);
		String rep="";
		File file = new File("Universite.xml");
		
		//Si le fichier n'existe pas
		if(!file.exists())
		{
			System.out.println("Entrer le Nom de l'universite");
			rep = lectureClavier.nextLine();
			univ = new University(rep);
			
			System.out.println("Entrer le nom d'un laboratoire");
			rep = lectureClavier.nextLine();
			Laboratory lab1 = new Laboratory(univ, rep);
			
			System.out.println("Entrer le nom d'un UFR");
			rep = lectureClavier.nextLine();
			UFR ufr1 = new UFR(univ, rep);
			
			System.out.println("Entrer le nom d'un departement de l'UFR "+ufr1.getName());
			rep = lectureClavier.nextLine();
			Department dep1 = new Department(ufr1, rep);
			Building buil1 = new Building(ufr1);
			ClassRoom classRoom1 = new ClassRoom(buil1, 0);
		}
		
		//Si il existe déjà alors chargement du fichier
		else
		{
			Load load = new Load();
			univ = load.getUniversity();
		}
		
		do
		{
		Menu menu0 = new Menu("Menu"); //Menu général
		Item item0 = new Item("Creation d'un UFR");
		menu0.addItem(item0);
		Item item1 = new Item("Creation d'un Departement");
		menu0.addItem(item1);
		Item item2 = new Item("Creation d'un Laboratoire");
		menu0.addItem(item2);
		Item item3 = new Item("Creation d'un Batiment");
		menu0.addItem(item3);
		Item item4 = new Item("Creation d'une salle");
		menu0.addItem(item4);
		Item item5 = new Item("Creation d'un enseignant");
		menu0.addItem(item5);
		Item itemSave = new Item("Faire une sauvegarde");
		menu0.addItem(itemSave);
		Item itemExit = new Item("Quitter le programme");
		menu0.addItem(itemExit);
		menu0.afficher();
		
		/*Menu qui permet de choisir la salle*/
		Menu menuSalle = new Menu("Salles");
		Item bureau = new Item("Bureau");
		menuSalle.addItem(bureau);
		Item salleCours = new Item("Salle de cours");
		menuSalle.addItem(salleCours);
		Item salleReunion = new Item("Salle de reunion");
		menuSalle.addItem(salleReunion);
		Item salleTP = new Item("Salle de TP");
		menuSalle.addItem(salleTP);
		/*------------------------------------*/
		
		rep = lectureClavier.nextLine();
		
		if(rep.equals("0")) //UFR
		{
			System.out.println("Entrer le nom de l'UFR");
			rep = lectureClavier.nextLine();
			UFR ufr2 = new UFR(univ, rep);
			System.out.println(univ.listUfr());
		}
		else if(rep.equals("1")) //Département
		{
			System.out.println("Choisissez un UFR");
			Menu menuUFR = new Menu("UFR");
			menuUFR.addItemByArrayList(univ.getUfrList());
			menuUFR.afficher();
			rep = lectureClavier.nextLine();
			if(Integer.parseInt(rep) <= univ.getUfrList().size() && Integer.parseInt(rep) >= 0)
			{
				int UFRid = Integer.parseInt(rep);
				System.out.println("Entrez le nom du departement");
				rep = lectureClavier.nextLine();
				Department d = new Department(univ.getUfrList().get(UFRid), rep);
			}
		}
		else if(rep.equals("2")) //Laboratoire
		{
			System.out.println("Entrer le nom d'un Laboratoire");
			rep = lectureClavier.nextLine();
			Laboratory lab2 = new Laboratory(univ, rep);
			System.out.println(univ.listUfr());
		}
		else if(rep.equals("3")) //Batiment
		{
			System.out.println("Choisissez un UFR");
			Menu menuUFR = new Menu("UFR");
			menuUFR.addItemByArrayList(univ.getUfrList());
			menuUFR.afficher();
			rep = lectureClavier.nextLine();
			if(Integer.parseInt(rep) <= univ.getUfrList().size() && Integer.parseInt(rep) >= 0)
			{
				int UFRid = Integer.parseInt(rep);
				Building d = new Building(univ.getUfrList().get(UFRid));
				System.out.println("Veuillez creer une salle");
				System.out.println("Choisissez le type de salle souhaite");
				menuSalle.afficher();
				
				rep= lectureClavier.nextLine();
				int pl;
				
				if(rep.equals("0"))
				{
					System.out.println("Combien de place ?");
					pl = lectureClavier.nextInt();
					
					Office office = new Office(d, pl);
				}
				if(rep.equals("1"))
				{
					System.out.println("Combien de place ?");
					pl = lectureClavier.nextInt();
					
					ClassRoom classRoom = new ClassRoom(d, pl);
				}
				if(rep.equals("2"))
				{
					System.out.println("Combien de place ?");
					pl = lectureClavier.nextInt();
					
					MeetingRoom meetingRoom = new MeetingRoom(d, pl);
				}
				if(rep.equals("3"))
				{
					System.out.println("Combien de place ?");
					pl = lectureClavier.nextInt();
					
					PracticalRoom TP = new PracticalRoom(d, pl);
				}
			}
		}
		else if(rep.equals("4")) //Salle
		{
			System.out.println("Choisissez un UFR");
			Menu menuUFR = new Menu("UFR");
			menuUFR.addItemByArrayList(univ.getUfrList());
			menuUFR.afficher();
			rep = lectureClavier.nextLine();
			if(Integer.parseInt(rep) <= univ.getUfrList().size() && Integer.parseInt(rep) >= 0)
			{
				int UFRid = Integer.parseInt(rep);
				System.out.println("Choisissez un batiment");
				Menu menuDep = new Menu("batiment");
				menuDep.addItemByArrayList(univ.getUfrList().get(UFRid).getBuildList());
				menuDep.afficher();
				rep = lectureClavier.nextLine();
				if(Integer.parseInt(rep) <= univ.getUfrList().get(UFRid).getBuildList().size() && Integer.parseInt(rep) >= 0)
				{
					Building d = univ.getUfrList().get(UFRid).getBuildList().get(Integer.parseInt(rep));
					
					System.out.println("Choisissez le type de salle souhaite");
					menuSalle.afficher();
					
					rep= lectureClavier.nextLine();
					int pl;
					
					if(rep.equals("0"))
					{
						System.out.println("Combien de place ?");
						pl = lectureClavier.nextInt();
						
						Office office = new Office(d, pl);
					}
					if(rep.equals("1"))
					{
						System.out.println("Combien de place ?");
						pl = lectureClavier.nextInt();
						
						ClassRoom classRoom = new ClassRoom(d, pl);
					}
					if(rep.equals("2"))
					{
						System.out.println("Combien de place ?");
						pl = lectureClavier.nextInt();
						
						MeetingRoom meetingRoom = new MeetingRoom(d, pl);
					}
					if(rep.equals("3"))
					{
						System.out.println("Combien de place ?");
						pl = lectureClavier.nextInt();
						
						PracticalRoom TP = new PracticalRoom(d, pl);
					}
				}
			}
		}
		else if(rep.equals("5")) //Profs
		{
			System.out.println("Choisissez un UFR");
			Menu menuUFR = new Menu("UFR");
			menuUFR.addItemByArrayList(univ.getUfrList());
			menuUFR.afficher();
			rep = lectureClavier.nextLine();
			if(Integer.parseInt(rep) <= univ.getUfrList().size() && Integer.parseInt(rep) >= 0)
			{
				int UFRid = Integer.parseInt(rep);
				System.out.println("Choisissez un bâtiment");
				Menu menuBat = new Menu("Bâtiment");
				menuBat.addItemByArrayList(univ.getUfrList().get(UFRid).getBuildList());
				menuBat.afficher();
				rep = lectureClavier.nextLine();
				if(Integer.parseInt(rep) <= univ.getUfrList().get(UFRid).getBuildList().size() && Integer.parseInt(rep) >= 0)
				{
					int BatId=Integer.parseInt(rep);
					System.out.println("Choisissez le bureau ou vous voulez affilier le personnel");
					Menu menuOff = new Menu("Bureau");
					menuOff.addItemByArrayList(univ.getUfrList().get(UFRid).getBuildList().get(Integer.parseInt(rep)).getOfficeList());
					menuOff.afficher();
					rep = lectureClavier.nextLine();
					if(Integer.parseInt(rep) <= univ.getUfrList().get(UFRid).getBuildList().get(BatId).getOfficeList().size() && Integer.parseInt(rep) >= 0)
					{
						int officeId=Integer.parseInt(rep);
						
						System.out.println("Choisir le type de personnel");
						Menu menuProf = new Menu("Type d'employé");
						Item PRAG = new Item("PRAG");
						Item professor = new Item("Enseignant");
						Item professorRes = new Item("Chargé de recherche");
						Item Lecturer = new Item("Maître de conférence");
						menuProf.addItem(PRAG);
						menuProf.addItem(professor);
						menuProf.addItem(professorRes);
						menuProf.addItem(Lecturer);
						
						menuProf.afficher();
						rep = lectureClavier.nextLine();
						//Quand un personnel est affilié à une salle, il faut enlever une place dans la salle.
						if(rep.equals("0"))
						{
							Date date = new Date();
							System.out.println("Saisir le nom du personnel");
							String lastName = lectureClavier.nextLine();
							System.out.println("Saisir le prénom du personnel");
							String firstName = lectureClavier.nextLine();
							
							PRAG p = new PRAG(univ.getUfrList().get(UFRid).getBuildList().get(BatId).getOfficeList().get(officeId), lastName, firstName, date);
						}
						else if(rep.equals("1"))
						{
							Date date = new Date();
							System.out.println("Saisir le nom du personnel");
							String lastName = lectureClavier.nextLine();
							System.out.println("Saisir le prénom du personnel");
							String firstName = lectureClavier.nextLine();
							
							Professor p = new Professor(univ.getUfrList().get(UFRid).getBuildList().get(BatId).getOfficeList().get(officeId), lastName, firstName, date);
						}
						else if(rep.equals("2"))
						{
							Date date = new Date();
							System.out.println("Saisir le nom du personnel");
							String lastName = lectureClavier.nextLine();
							System.out.println("Saisir le prénom du personnel");
							String firstName = lectureClavier.nextLine();
							
							ProfessorResearcher p = new ProfessorResearcher(univ.getUfrList().get(UFRid).getBuildList().get(BatId).getOfficeList().get(officeId), lastName, firstName, date);
						}
						else if(rep.equals("3"))
						{
							Date date = new Date();
							System.out.println("Saisir le nom du personnel");
							String lastName = lectureClavier.nextLine();
							System.out.println("Saisir le prénom du personnel");
							String firstName = lectureClavier.nextLine();
							
							Lecturer p = new Lecturer(univ.getUfrList().get(UFRid).getBuildList().get(BatId).getOfficeList().get(officeId), lastName, firstName, date);
						}
						
						
					}
				}
			}
			
		}
		else if(rep.equals("save")) //Sauvegarde
		{
			System.out.println("Sauvegarde");
			Save save = new Save(univ);
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			save.enregistre("Universite.xml");
		}
		
		else if(rep.equals("exit"))
		{
			run = false;
		}
		else if(rep.equals("load"))
		{
			Load load = new Load();
			univ = load.getUniversity();
		}
		}while(run);
		System.exit(0);
		
		
	}
}
