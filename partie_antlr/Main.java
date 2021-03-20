package src;

public class Main {

	public static void main(String[] args) {

		Classroom c = new Classroom(3);
		c.addStudent("Marion");
		c.addStudent("Paul");
		c.addStudent("Louis");
		c.addStudent("Olivier");
		c.addStudent("Karine");
		c.addStudent("Tybo");
		c.addStudent("Antoine");
		c.addStudent("Mateo");
		c.addStudent("Titi");
		
		c.setNumberOfPlace(1, 3);
		c.setNumberOfPlace(2, 3);
		c.setNumberOfPlace(3, 3);

		c.setStudentPosition(c.getStudent("Marion"), 1, 1);
		c.setStudentPosition(c.getStudent("Louis"), 1, 2);
		c.setStudentPosition(c.getStudent("Paul"), 1, 3);
		c.setStudentPosition(c.getStudent("Olivier"), 2, 1);
		c.setStudentPosition(c.getStudent("Karine"), 2, 2);
		c.setStudentPosition(c.getStudent("Tybo"), 2, 3);
		c.setStudentPosition(c.getStudent("Antoine"), 3, 1);
		c.setStudentPosition(c.getStudent("Mateo"), 3, 2);
		c.setStudentPosition(c.getStudent("Titi"), 3, 3);
		
		ConstraintBuilder cb = new ConstraintBuilder();
		cb.build("loin de", c.getStudent("Marion"), c.getStudent("Paul"));
		cb.build("au rang", c.getStudent("Tybo"), 2);
		cb.build("a cote de", c.getStudent("Antoine"), c.getStudent("Mateo"));
		
		System.out.println(c.evaluate(cb.getConstraints()));
		
	}

}
