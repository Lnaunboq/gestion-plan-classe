public class Main {

	public static void main(String[] args) {

		Classroom c = new Classroom(3);
		c.addStudent("Marion");
		c.addStudent("Paul");
		c.addStudent("Louis");

		c.setNumberOfPlace(1, 3);
		c.setNumberOfPlace(2, 3);
		c.setNumberOfPlace(3, 3);

		ConstraintBuilder cb = new ConstraintBuilder();
		cb.build("loin de", c.getStudent("Marion"), c.getStudent("Paul"));
		cb.build("au rang", c.getStudent("Louis"), 2);
		cb.build("a cote de", c.getStudent("Marion"), c.getStudent("Louis"));
		
		c.algo(cb.getConstraints());
		System.out.println(c);
		System.out.println(c.evaluate(cb.getConstraints()));
	}

}
