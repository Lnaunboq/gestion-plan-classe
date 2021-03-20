public interface Constraint {

	/**
	 * check whether the constraint is satisfied by an instance
	 * @param instance an instance of
	 * @return whether the constraint satisfy the constraint
	 */
	public boolean isSatisfiedBy(Student[][] instance);

}
