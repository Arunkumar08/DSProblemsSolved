package arun.problems.ds.graphs.model;

public class Person {

	private String name;
	private int empId;
	
	public Person(final String name, final int empId) {
		this.name = name;
		this.empId = empId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) {
			return false;
		}
		Person that = (Person) obj;
		return (this.name.equals(that.getName())) && (this.empId == that.getEmpId());
	}
	
	@Override
	public int hashCode() {
		return empId;
	}
}
