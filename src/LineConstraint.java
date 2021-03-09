package src;

public class LineConstraint implements Constraint {

	private Student student;
	private int rank;
	
	public LineConstraint(Student student, int rank) {
		this.student = student;
		this.rank = rank - 1;
	}

	@Override
	public boolean isSatisfiedBy(Student[][] instance) {
		for(int i = 0; i < instance.length; i++) {
			for(int j = 0; j < instance[i].length; j++) {
				if(instance[i][j].equals(this.student) && i == this.rank)
					return true;
			}
		}
		return false;
	}
}
