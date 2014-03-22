package de.friemen.samples;

public class Employee {
	private String name;
	private String branch;
	private int salary;

	public Employee() {
	}

	public Employee(String name, String branch, int salary) {
		this.name = name;
		this.branch = branch;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
