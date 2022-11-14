package lambdas.fi.consumer;

class Student {
	
	  public String name;
	  public double gpa;

	  Student(String name, double g) {
	    this.name = name;
	    this.gpa = g;
	  }
	  
	  Student() {

	  }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	  public String toString() {
		  
		  return name +" " +gpa;
	  }
	}