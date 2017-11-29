package br.com.pm_2017.si_grade.model;

import java.util.List;
import java.util.Map;

import br.com.pm_2017.si_grade.utils.CurricularGradeConstants;
import br.com.pm_2017.si_grade.utils.DisciplineCodHelper;
import br.com.pm_2017.si_grade.utils.DisciplineStatus;

/**
 * Represents the acting student in the application. Here is all the information
 * need of an student by the application
 */
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
	/**
	 * Count the remaining disciplines for a student to graduate
	 * 
	 * @return int number of remaining disciplines
	 */
	public int remaining() {
		int numberDisciplines = this.disciplines.size() - attending();
		int totalDisciplines = CurricularGradeConstants.TOTAL_NUMBER_DISCIPLINES.getValue();

		int remainingDisciplines = totalDisciplines - numberDisciplines;

		return remainingDisciplines;
	}

	/**
	 * Counts the number of disciplines an student are attending ate the moment
	 * 
	 * @return
	 */
	public int attending() {
		int count = 0;

		for (Discipline discipline : this.disciplines.values())
			if (discipline.getSituation() == DisciplineStatus.MATRICULA.getStatus())
				count++;

		return count;
	}

	/**
	 * Returns the number of periods attended by the student
	 * 
	 * @return int number of periods
	 */
	public int numberOfValidPeriods() {
		if (this.disciplines.containsKey(DisciplineCodHelper.TRANCAMENTO_GERAL)) {
			return (this.periodsCr.size()
					- this.disciplines.get(DisciplineCodHelper.TRANCAMENTO_GERAL).getTimesAttended());
		} else
			return this.periodsCr.size();

	}
}
