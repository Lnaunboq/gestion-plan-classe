public class NeighbourConstraint implements Constraint {

	private Student s1;
	private Student s2;
	private boolean neighbour;

	public NeighbourConstraint(Student s1, Student s2, boolean neighbour) {
		this.s1 = s1;
		this.s2 = s2;
		this.neighbour = neighbour;
	}

	@Override
	public boolean isSatisfiedBy(Student[][] instance) {
		if(this.neighbour)
			return Math.abs(this.s1.getRangee() - this.s2.getRangee()) == 0 && Math.abs(this.s1.getPlace() - this.s2.getPlace()) == 1;
		else
			return Math.abs(this.s1.getRangee() - this.s2.getRangee()) > 1 || Math.abs(this.s1.getPlace() - this.s2.getPlace()) > 1;
	}
}
