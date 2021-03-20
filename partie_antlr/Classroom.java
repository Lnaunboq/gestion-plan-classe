import java.util.*;

public class Classroom {

	private List<Student> students;
	private Student[][] classPlan;

	public Classroom(int lines) {
		this.students = new LinkedList<Student>();
		this.classPlan = new Student[lines][];
	}

	public void setNumberOfPlace(int line, int places) {
		if(line > this.classPlan.length || line < 1)
			return;
		this.classPlan[line-1] = new Student[places];
	}

	public Student getStudent(String identifiant) {
		for(Student s : this.students) {
			if(s.getIdentifiant().equals(identifiant))
				return s;
		}
		return null;
	}

	public void addStudent(String identifiant) {
		this.students.add(new Student(identifiant));
	}

	public void setStudentPosition(Student s, int line, int place) {
		this.classPlan[line - 1][place - 1] = s;
	}

	public float evaluate(List<Constraint> constraints) {
		if(constraints.isEmpty())
			return (float) 0;
		int satisfied = 0;
		for(Constraint c : constraints) {
			if(c.isSatisfiedBy(this.classPlan))
				satisfied++;
		}
		return (float) satisfied / constraints.size();
	}

	public List<Student> getEleves() {
		return this.students;
	}

	public Student[][] getClassPlan() {
		return this.classPlan;
	}

	public int getRowNumber() {
		return this.classPlan.length;
	}

}
