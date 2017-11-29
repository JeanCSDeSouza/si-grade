package br.com.pm_2017.si_grade.rules;

import br.com.pm_2017.si_grade.model.Student;

public interface Rule {
	/**
	 * Working method of the strategy pattern used to get the value of a rule
	 * 
	 * @param student
	 * @return Boolean value of the rule
	 */
	public boolean execute(Student student);

	/**
	 * Return one of the RuleMessageDescriptor constants that describes the
	 * implementations of this interface
	 * <p>
	 * 
	 * @return the String that describes this instance
	 */
	public String getMessage();
}
