package src;

import java.util.*;

public class Class {

	private List<Student> students;
	private Student[][] classPlan;
	
	public Class(int lines) {
		this.students = new LinkedList<Student>();
		this.classPlan = new Student[lines][];
	}
	
	public void setNumberOfPlace(int line, int places) {
		if(line > this.classPlan.length || line < 1)
			return;
		this.classPlan[line-1] = new Student[places];
	}
	
	public Student getStudent(String surname, String firstname) {
		for(Student s : this.students) {
			if(s.getFirstname().equals(firstname) && s.getName().equals(surname))
				return s;
		}
		return null;
	}
	
	public void addStudent(String surname, String firstname) {
		this.students.add(new Student(surname, firstname));
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
	
}
