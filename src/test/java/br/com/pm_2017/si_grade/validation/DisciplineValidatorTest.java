package br.com.pm_2017.si_grade.validation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;

public class DisciplineValidatorTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	DisciplineValidator dv;
	
	@Before
	public void setUp( ) throws Exception {
		dv = new DisciplineValidator();	
	}
	@Test
	public void disciplineValidatorStudentNullTest() {
		Student student = null;
		assertEquals("Failure - Should be true", true, dv.checkStudentNullError(student));
	}
	@Test
	public void disciplineValidatorStudentMapTrueTest() {
		Student student = new Student();
		Map<String, Discipline> disciplines;
	
		disciplines = new HashMap<String, Discipline>();
		student.setDisciplines(disciplines);
		assertEquals("Failure - Should be true", true, dv.checkStudentMapError(student));	
	}
	@Test
	public void disciplineValidatorStudentMapNullTrueTest() {
		Map<String, Discipline> disciplines = null;
		Student student = new Student();
		student.setDisciplines(disciplines);
		assertEquals("Failure - Should be true", true, dv.checkStudentMapError(student));	
	}
	@Test
	public void disciplineValidatorStudentMapFalseTest() {
		Map<String, Discipline> disciplines = new HashMap<String, Discipline>();
		Discipline discipline = new Discipline("TIN4545");
		disciplines.put("TIN4545", discipline);
		Student student = new Student();
		student.setDisciplines(disciplines);
		assertEquals("Failure - Should be false", false, dv.checkStudentMapError(student));
	}
}
