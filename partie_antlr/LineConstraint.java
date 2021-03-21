public class LineConstraint implements Constraint {

	private Student student;
	private int row;

	public LineConstraint(Student student, int row) {
		this.student = student;
		this.row = row - 1;
	}

	@Override
	public boolean isSatisfiedBy(Student[][] instance) {
		for(int j = 0; j < instance[this.row].length; j++) {
			if(instance[this.row][j] != null && instance[this.row][j].equals(this.student))
				return true;
		}
		return false;
	}
}
