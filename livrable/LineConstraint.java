public class LineConstraint implements Constraint {

	private Student student;
	private int row;

	public LineConstraint(Student student, int row) {
		this.student = student;
		this.row = row - 1;
	}

	@Override
	public boolean isSatisfiedBy(Student[][] instance) {
		return this.student.getRangee() == this.row;
	}
}
