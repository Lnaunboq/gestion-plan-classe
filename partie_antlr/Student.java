package src;

public class Student {

	private String identifiant;
	private boolean rightHanded;
	private boolean girl;
	
	public Student(String identifiant) {
		this.identifiant = identifiant;
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
