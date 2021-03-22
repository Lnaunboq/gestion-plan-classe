public class Student {

	private String identifiant;
	private int rangee, place;
	private boolean rightHanded;
	private boolean girl;
	
	public Student(String identifiant) {
		this.identifiant = identifiant;
		this.rangee = 0;
		this.place = 0;
	}

	public boolean isRightHanded() {
		return rightHanded;
	}

	public void setRightHanded(boolean rightHanded) {
		this.rightHanded = rightHanded;
	}

	public boolean isGirl() {
		return girl;
	}

	public void setGirl(boolean girl) {
		this.girl = girl;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	
	public int getRangee() {
		return this.rangee;
	}
	
	public void setRangee(int nRangee) {
		this.rangee = nRangee;
	}
	
	public int getPlace() {
		return this.place;
	}
	
	public void setPlace(int nPlace) {
		this.place = nPlace;
	}
	
	public void setBoth(int nRangee, int nPlace) {
		this.rangee = nRangee;
		this.place = nPlace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifiant == null) ? 0 : identifiant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (identifiant == null) {
			if (other.identifiant != null)
				return false;
		} else if (!identifiant.equals(other.identifiant))
			return false;
		return true;
	}

}
