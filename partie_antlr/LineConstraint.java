public class LineConstraint implements Constraint {

	private Student student;
	private int row;

	public LineConstraint(Student student, int row) {
		this.student = student;
		this.row = row - 1;
	}

	@Override
	public boolean isSatisfiedBy(Student[][] instance) {
		for(int j = 0; j < instance[this.rank].length; j++) {
			if(instance[this.rank][j] != null && instance[this.rank][j].equals(this.student))
				return true;
		}
		return false;
	}
}
