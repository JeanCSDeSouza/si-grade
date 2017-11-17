package br.com.pm_2017.si_grade.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;

public class RegisteredDisciplinesRuleTest {

	RegisteredDisciplinesRule rd;
	
	public RegisteredDisciplinesRuleTest() {
		rd = new RegisteredDisciplinesRule();
	}
	
	@Test
	public void lessThanNeededDisciplinesMustReturnFalse() {	
		Student student = new Student();
		Discipline d1 = new Discipline();
		Discipline d2 = new Discipline();
		d1.setSituation(-1);
		d2.setSituation(-1);
		
		Map<String, Discipline> disciplines = new HashMap<String, Discipline>();
		
		disciplines.put("d1", d1);
		disciplines.put("d2", d2);
		student.setDisciplines(disciplines);
		
		assertFalse(rd.rule(student));
	}
	
	@Test
	public void moreThanNeededDisciplinesMustReturnTrue() {	
		Student student = new Student();
		Discipline d1 = new Discipline();
		Discipline d2 = new Discipline();
		Discipline d3 = new Discipline();
		Discipline d4 = new Discipline();
		d1.setSituation(-1);
		d2.setSituation(-1);
		d3.setSituation(-1);
		d4.setSituation(-1);
		
		Map<String, Discipline> disciplines = new HashMap<String, Discipline>();
		
		disciplines.put("d1", d1);
		disciplines.put("d2", d2);
		disciplines.put("d3", d3);
		disciplines.put("d4", d4);
		student.setDisciplines(disciplines);
		
		assertTrue(rd.rule(student));
	}
	
	@Test
	public void equallyNeededDisciplinesMustReturnTrue() {
		Student student = new Student();
		Discipline d1 = new Discipline();
		Discipline d2 = new Discipline();
		Discipline d3 = new Discipline();
		d1.setSituation(-1);
		d2.setSituation(-1);
		d3.setSituation(-1);
		
		Map<String, Discipline> disciplines = new HashMap<String, Discipline>();
		
		disciplines.put("d1", d1);
		disciplines.put("d2", d2);
		disciplines.put("d3", d3);
		student.setDisciplines(disciplines);
		
		assertTrue(rd.rule(student));
	}
}
