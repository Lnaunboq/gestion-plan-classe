public class LineConstraint implements Constraint {

	private Student student;
	private int rank;

	public LineConstraint(Student student, int rank) {
		this.student = student;
		this.rank = rank - 1;
	}

	@Override
	public boolean isSatisfiedBy(Student[][] instance) {
		for(int j = 0; j < instance[this.rank].length; j++) {
			if(instance[this.rank][j].equals(this.student))
				return true;
		}
		return false;
	}
}
