import java.util.*;

import src.Constraint;
import src.Student;

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

	public void swap(Student a, Student b) {
		int rangeeB = b.getRangee();
		int placeB = b.getPlace();
		this.classPlan[a.getRangee()][a.getPlace()] = b;
		b.setBoth(a.getRangee(), a.getPlace());
		this.classPlan[rangeeB][placeB] = a;
		a.setBoth(rangeeB, placeB);
	}
	
	public void init() {
		int a = 0;
		for(int rangee = 0; rangee<this.classPlan.length; rangee++) {
			for(int place = 0; place < this.classPlan[rangee].length; place++) {
				this.classPlan[rangee][place] = this.students.get(a);
				this.students.get(a).setBoth(rangee, place);
				a++;
				if(a >= this.students.size()) {
					return;
				}
			}
		}
		return;
	}
	
	public void algo(List<Constraint> constraints) {
		this.init();
		Student a,b;
		Random alea = new Random();
		int iteration = 0;
		int size = constraints.size();
		float score = 0;
		while(iteration < 50 || iteration < size*size ) {
			score = this.evaluate(constraints);
			if( score == 1.0) {break ; }
			a = this.students.get(alea.nextInt(this.students.size()));
			b = this.students.get(alea.nextInt(this.students.size()));
			this.swap(a,b);
			if(score > this.evaluate(constraints)) {
				this.swap(a, b);
			}
			iteration++;
		}
		return;
	}
	
	@Override
	public String toString() {
		
	}
}
