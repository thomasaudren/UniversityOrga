package staff;

import java.util.Date;

import buildings.Office;

public class Professor extends Staff implements Teacher, Researcher {

	public Professor(Office off, String lastName, String firstName,
			Date embauche) {
		super(off, lastName, firstName, embauche);
		// TODO Auto-generated constructor stub
	}

}
