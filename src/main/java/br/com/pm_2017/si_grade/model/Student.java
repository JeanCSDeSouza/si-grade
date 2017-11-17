package br.com.pm_2017.si_grade.model;

import java.util.List;
import java.util.Map;

public class Student {
	private String name;
	private float cra;
	private String registry;
	private List<Float> periodsCr;
	private int yearOfRegistry;
	Map<String, Discipline> disciplines;
	
	public Student() {
	}
	
	public Student(String name, float cra) {
		this.name = name;
		this.cra = cra;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCra() {
		return cra;
	}

	public void setCra(float cra) {
		this.cra = cra;
	}
	
	public String getRegistry() {
		return registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}
	
	public List<Float> getPeriodsCr() {
		return periodsCr;
	}

	public void setPeriodsCr(List<Float> periodsCr) {
		this.periodsCr = periodsCr;
	}
	
	public int getYearOfRegistry() {
		return yearOfRegistry;
	}

	public void setYearOfResgitry(int yearOfRegistry) {
		this.yearOfRegistry = yearOfRegistry;
	}

	public Map<String, Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(Map<String, Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", cra=" + cra + ", registry=" + registry + ", periodsCr=" + periodsCr
				+ ", yearOfRegistry=" + yearOfRegistry + ", disciplines=" + disciplines + "]";
	}

	/*@Override
	public String toString() {
		return "Student [name=" + name + ", cra=" + cra + ", registry=" + registry + ", periodsCr=" + periodsCr + "]";
	}
	*/
}
