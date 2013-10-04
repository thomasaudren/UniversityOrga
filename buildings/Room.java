package buildings;


	public class Room {
		private int numb_r=0;
		private static int numb=1;
		private int nbPlace;
		private Building building; 
		

		public Room(Building build,int nbPlace) {
			this.numb_r=numb++;
			this.building = build;
			this.building.addRoom(this);
			this.nbPlace = nbPlace;
		}
		
		public int getNbPlace() {
			return nbPlace;
		}


		public void setNbPlace(int nbPlace) {
			this.nbPlace = nbPlace;
		}


		public int getNumb_r() {
			return numb_r;
		}

		private void setNumb_r(int numb_r) {
			this.numb_r = numb_r;
		}

	

		@Override
		public String toString() {
			return "Salle " + numb_r + " - Nombre de place : " + nbPlace;
		}

		@Override
		public Object clone() {
		    try {
				return (Room) super.clone();
			} catch (CloneNotSupportedException e) {
				throw new Error();
			}
		}
		
	}

