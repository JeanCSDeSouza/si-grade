package br.com.pm_2017.si_grade.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.DisciplineStatus;

public class RegisteredDisciplinesRuleTest {

	private RegisteredDisciplinesRule rd;
	private Student student;
	private Map<String, Discipline> disciplines;

	@Before
	public void setUp() {
		rd = new RegisteredDisciplinesRule();
		student = new Student();
		disciplines = new HashMap<String, Discipline>();
	}

	/**
	 * Test for 2 attending disciplines
	 */
	@Test
	public void lessThanNeededDisciplinesMustReturnFalse() {
		Discipline d1 = new Discipline();
		Discipline d2 = new Discipline();
		d1.setSituation(DisciplineStatus.MATRICULA.getStatus());
		d2.setSituation(DisciplineStatus.MATRICULA.getStatus());

		disciplines.put("d1", d1);
		disciplines.put("d2", d2);
		student.setDisciplines(disciplines);

		assertFalse(rd.execute(student));
	}

	/**
	 * Test for 4 attending disciplines
	 */
	@Test
	public void moreThanNeededDisciplinesMustReturnTrue() {
		Discipline d1 = new Discipline();
		Discipline d2 = new Discipline();
		Discipline d3 = new Discipline();
		Discipline d4 = new Discipline();
		d1.setSituation(DisciplineStatus.MATRICULA.getStatus());
		d2.setSituation(DisciplineStatus.MATRICULA.getStatus());
		d3.setSituation(DisciplineStatus.MATRICULA.getStatus());
		d4.setSituation(DisciplineStatus.MATRICULA.getStatus());

		disciplines.put("d1", d1);
		disciplines.put("d2", d2);
		disciplines.put("d3", d3);
		disciplines.put("d4", d4);
		student.setDisciplines(disciplines);

		assertTrue(rd.execute(student));
	}

	/**
	 * Test for 3 attending disciplines
	 */
	@Test
	public void equallyNeededDisciplinesMustReturnTrue() {
		Discipline d1 = new Discipline();
		Discipline d2 = new Discipline();
		Discipline d3 = new Discipline();
		d1.setSituation(DisciplineStatus.MATRICULA.getStatus());
		d2.setSituation(DisciplineStatus.MATRICULA.getStatus());
		d3.setSituation(DisciplineStatus.MATRICULA.getStatus());

		disciplines.put("d1", d1);
		disciplines.put("d2", d2);
		disciplines.put("d3", d3);
		student.setDisciplines(disciplines);

		assertTrue(rd.execute(student));
	}
}
