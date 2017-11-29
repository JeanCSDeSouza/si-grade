package br.com.pm_2017.si_grade.rules;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.pm_2017.si_grade.model.Student;

/**
 * The class that carries the rules applied to a student. It has a map <String,
 * boolean> where the key is the getMessage() that returns the rule constant and
 * the Boolean value that expresses whether or not the rule applies to the
 * student
 */
public class RulesCache {
	List<Rule> rules = Arrays.asList(
			new GraduationTimeRule(), // rule.get(0)
			new IntegralizationPlanNeededRule(), // rule.get(1)
			new IntegralizationPlanPeriodsCrRespectedRule(),// rule.get(2) 
			new JubilateRule(),// rule.get(3) 
			new RegisteredDisciplinesRule(),// rule.get(4)
			new CraRule());// rule.get(5)

	/**
	 * The rules makes a previous test on GraduationTime since that rule makes not
	 * necessary the application of IntegralizationRule and
	 * IntegralizationPlanPeriodsCrRespectedRule.
	 * 
	 * @param student
	 * @return Map(getMessage(),Boolean) where message is the given property used on the HTML 
	 */
	public Map<String, Boolean> execute(Student student) {
		Map<String, Boolean> answer = new HashMap<String, Boolean>();
		if (rules.get(0).execute(student)) {// If the student can graduate in time, there is no need for testing 
											// IntegralizationRule and IntegralizationPlanPeriodsCrRespectedRUle
			answer.put(rules.get(0).getMessage(), true);// The student can graduate in time 
			answer.put(rules.get(1).getMessage(), false);// Then IntegralizationPlan is not needed
			answer.put(rules.get(2).getMessage(), true);// And IntegralizationPlanPeriodsRespected is also not needed
			for (int i = 3; i < rules.size(); i++) {
				answer.put(rules.get(i).getMessage(), rules.get(i).execute(student));
			}
		} else // Its possible to student to not respect GraduationTime and not need IntegralizationPlan
			for (int i = 0; i < rules.size(); i++)
				answer.put(rules.get(i).getMessage(), rules.get(i).execute(student));
		return answer;
	}
}
