package src;

public class Main {

	public static void main(String[] args) {

		Class c = new Class(3);
		c.addStudent("Grassi", "Marion");
		c.addStudent("Grassi", "Paul");
		c.addStudent("Grassi", "Louis");
		c.addStudent("Grassi", "Olivier");
		c.addStudent("Grassi", "Karine");
		c.addStudent("Dore", "Tybo");
		c.addStudent("Boiteau", "Antoine");
		c.addStudent("Tani", "Mateo");
		c.addStudent("Toto", "Titi");
		
		c.setNumberOfPlace(1, 3);
		c.setNumberOfPlace(2, 3);
		c.setNumberOfPlace(3, 3);

		c.setStudentPosition(c.getStudent("Grassi", "Marion"), 1, 1);
		c.setStudentPosition(c.getStudent("Grassi", "Louis"), 1, 2);
		c.setStudentPosition(c.getStudent("Grassi", "Paul"), 1, 3);
		c.setStudentPosition(c.getStudent("Grassi", "Olivier"), 2, 1);
		c.setStudentPosition(c.getStudent("Grassi", "Karine"), 2, 2);
		c.setStudentPosition(c.getStudent("Dore", "Tybo"), 2, 3);
		c.setStudentPosition(c.getStudent("Boiteau", "Antoine"), 3, 1);
		c.setStudentPosition(c.getStudent("Tani", "Mateo"), 3, 2);
		c.setStudentPosition(c.getStudent("Toto", "Titi"), 3, 3);
		
		ConstraintBuilder cb = new ConstraintBuilder();
		cb.build("loin de", c.getStudent("Grassi", "Marion"), c.getStudent("Grassi", "Paul"));
		cb.build("au rang", c.getStudent("Dore", "Tybo"), 2);
		cb.build("a cote de", c.getStudent("Boiteau", "Antoine"), c.getStudent("Tani", "Mateo"));
		
		System.out.println(c.evaluate(cb.getConstraints()));
		
	}

}
