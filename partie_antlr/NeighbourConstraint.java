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
		int[] positions = this.getPosition(instance);
		if(this.neighbour)
			return Math.abs(positions[0] - positions[2]) == 0 && Math.abs(positions[1] - positions[3]) == 1;
		else
			return Math.abs(positions[0] - positions[2]) > 1 || Math.abs(positions[1] - positions[3]) > 1;
	}

	private int[] getPosition(Student[][] instance) {
		int[] positions = new int[4];
		for(int i = 0; i < instance.length; i++) {
			for(int j = 0; j < instance[i].length; j++) {
				if(instance[i][j].equals(s1)) {
					positions[0] = i;
					positions[1] = j;
				}
				if(instance[i][j].equals(s2)) {
					positions[2] = i;
					positions[3] = j;
				}
			}
		}
		return positions;
	}
}
