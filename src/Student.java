package src;

public class Student {

	private String surname;
	private String firstname;
	private boolean rightHanded;
	private boolean girl;
	
	public Student(String surname, String firstname) {
		this.surname = surname;
		this.firstname = firstname;
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

	public String getName() {
		return surname;
	}

	public String getFirstname() {
		return firstname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
}
