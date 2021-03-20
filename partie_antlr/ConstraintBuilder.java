package src;

import java.util.*;

public class ConstraintBuilder {
	
	private List<Constraint> constraints;
		
	public ConstraintBuilder() {
		this.constraints = new LinkedList<Constraint>();
	}

	public void build(String antlr, Student s1, Student s2) {
		switch(antlr) {
		case "loin de" :
			this.constraints.add(new NeighbourConstraint(s1,s2,false));
			break;
		case "a cote de":
			this.constraints.add(new NeighbourConstraint(s1,s2,true));
			break;
		default:
			return;
		}
	}
	
	public void build(String antlr, Student s, int rank) {
		switch(antlr) {
		case "au rang" :
			this.constraints.add(new LineConstraint(s, rank));
			break;
		default :
			return;
		}
	}
	
	public List<Constraint> getConstraints() {
		return this.constraints;
	}	
}
