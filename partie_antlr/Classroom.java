import java.util.*;

public class Classroom {

	private List<Student> students;
	private Student[][] classPlan;
	private float score;

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
		for(int i = 0; i < this.classPlan.length; i++) {
			if(this.classPlan[i] == null) {
				this.classPlan[i] = new Student[1];
			}
		}
		this.init();
		Student a,b;
		Random alea = new Random();
		int iteration = 0;
		int size = constraints.size();
		float score = 0;
		while(iteration < 1000 || iteration < size*size ) {
			score = this.evaluate(constraints);
			if( score == 1.0) { break; }

			//élève aléatoire parmis les élèves
			a = this.students.get(alea.nextInt(this.students.size()));
			int rangeeA = a.getRangee();
			int placeA = a.getPlace();

			//place aléatoire sur le plan de classe sur laquelle on va deplacer a
			int rangeeB = alea.nextInt(this.classPlan.length);
			int placeB = alea.nextInt(this.classPlan[rangeeB].length);
			b = this.classPlan[rangeeB][placeB];

			//echange de place entre a et b
			this.classPlan[rangeeA][placeA] = b;
			this.classPlan[rangeeB][placeB] = a;
			a.setBoth(rangeeB, placeB);
			if(b != null)
				b.setBoth(rangeeA, placeA);

			//evaluation du score du nouveau plan de classe
			if(score > this.evaluate(constraints)) {
				this.classPlan[rangeeA][placeA] = a;
				this.classPlan[rangeeB][placeB] = b;
				a.setBoth(rangeeA, placeA);
				if(b != null)
					b.setBoth(rangeeB, placeB);
			}
			iteration++;
		}
		this.score = this.evaluate(constraints);
		return;
	}

	public String toString() {
		String ret ="Résultats du l'algorithme :\n\n-Plan de classe\n\n";
		/*for(Student stud : this.students) {
			ret+= stud.getIdentifiant() + ", " + stud.getRangee() + ", " + stud.getPlace() +" \n";
		}*/
		for(int rangee = 0; rangee < this.classPlan.length; rangee++) {
			ret += "Rangée " + (rangee+1) + " : "; 
			for(int place = 0; place < this.classPlan[rangee].length; place++) {
				ret = this.classPlan[rangee][place] != null ? ret + this.classPlan[rangee][place].getIdentifiant() + " " : ret + "Personne ";
			}
			ret += "\n";
		}
		ret += "\n\n-Taux de contraintes satisfaites : " + (this.score*100) + "%\n\n";
		return ret;
	}
}
