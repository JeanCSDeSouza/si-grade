package br.com.pm_2017.si_grade.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;

public class JubilateRuleTest {

	private JubilateRule jb;
	private Student student;
	private Map<String, Discipline> disciplines;

	@Before
	public void setUp() throws Exception {
		jb = new JubilateRule();
		student = new Student();
		disciplines = new HashMap<String, Discipline>();
	}

	/**
	 * Test for CRA=3.9 and Fails=3
	 */
	@Test
	public void lessCraLessFailsTestMustReturnFalse() {
		Discipline d1 = new Discipline();
		d1.setTimesFailure(3);

		disciplines.put("d1", d1);

		student.setCra(3.9f);
		student.setDisciplines(disciplines);

		assertFalse(jb.isJubilate(student));
	}

	/**
	 * Test for CRA=3.9 and Fails=4
	 */
	@Test
	public void lessCraEqualFailsTestMustReturnTrue() {
		Discipline d1 = new Discipline();
		d1.setTimesFailure(4);

		disciplines.put("d1", d1);

		student.setCra(3.9f);
		student.setDisciplines(disciplines);

		assertTrue(jb.isJubilate(student));
	}

	/**
	 * Test for CRA=3.9 and Fails=5
	 */
	@Test
	public void lessCraMoreFailsTestMustReturnTrue() {
		Discipline d1 = new Discipline();
		d1.setTimesFailure(5);

		disciplines.put("d1", d1);

		student.setCra(3.9f);
		student.setDisciplines(disciplines);

		assertTrue(jb.isJubilate(student));
	}

	/**
	 * Test for CRA=4 and Fails=3
	 */
	@Test
	public void equalCraLessFailsTestMustReturnFalse() {
		Discipline d1 = new Discipline();
		d1.setTimesFailure(3);

		disciplines.put("d1", d1);

		student.setCra(4);
		student.setDisciplines(disciplines);

		assertFalse(jb.isJubilate(student));
	}

	/**
	 * Test for CRA=4 and Fails=4
	 */
	@Test
	public void equalCraEqualFailsTestMustReturnFalse() {
		Discipline d1 = new Discipline();
		d1.setTimesFailure(4);

		disciplines.put("d1", d1);

		student.setCra(4);
		student.setDisciplines(disciplines);

		assertFalse(jb.isJubilate(student));
	}
	
	/**
	 * Test for CRA=4 and Fails=5
	 */
	@Test
	public void equalCraMoreFailsTestMustReturnFalse() {
		Discipline d1 = new Discipline();
		d1.setTimesFailure(5);

		disciplines.put("d1", d1);

		student.setCra(4);
		student.setDisciplines(disciplines);

		assertFalse(jb.isJubilate(student));
	}

	/**
	 * Test for CRA=4.1 and Fails=3
	 */
	@Test
	public void moreCraLessFailsTestMustReturnFalse() {
		Discipline d1 = new Discipline();
		d1.setTimesFailure(3);

		disciplines.put("d1", d1);

		student.setCra(4.1f);
		student.setDisciplines(disciplines);

		assertFalse(jb.isJubilate(student));
	}
	
	/**
	 * Test for CRA=4.1 and Fails=4
	 */
	@Test
	public void moreCraEqualFailsTestMustReturnFalse() {
		Discipline d1 = new Discipline();
		d1.setTimesFailure(4);

		disciplines.put("d1", d1);

		student.setCra(4.1f);
		student.setDisciplines(disciplines);

		assertFalse(jb.isJubilate(student));
	}
	
	/**
	 * Test for CRA=4.1 and Fails=5
	 */
	@Test
	public void moreCraMoreFailsTestMustReturnFalse() {
		Discipline d1 = new Discipline();
		d1.setTimesFailure(5);

		disciplines.put("d1", d1);

		student.setCra(4.1f);
		student.setDisciplines(disciplines);

		assertFalse(jb.isJubilate(student));
	}
}
