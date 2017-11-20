package br.com.pm_2017.si_grade.rules;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;

public class GraduationTimeRuleTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	GraduationTimeRule gtr; 
	@Before
	public void setUp() {
		gtr = new GraduationTimeRule(); 
	}
	@Test
	public void graduationTimeRespectedTrueTest() {
		// Based on the fact that the student has only 8 periods
		List<Float> periodsCr = new ArrayList<Float>();
		periodsCr.add((float) 6.8000);
		periodsCr.add((float) 7.7790);
		Student student = mock(Student.class);
		// Total are 51 disciplines - 2(6 disciplines in 2 periods) = 39 
		when(student.remaining()).thenReturn(39);
		when(student.getPeriodsCr()).thenReturn(periodsCr);
		assertEquals("Failure - should be true", true,  gtr.isGraduationTimeRespected(student));
		assertEquals("Failure - should be true", true,  gtr.execute(student));
	}
	@Test
	public void graduationTimeRespectedFalseTest() {
		// Based on the fact that the student has only 8 periods
		List<Float> periodsCr = new ArrayList<Float>();
		periodsCr.add((float) 6.8000);
		periodsCr.add((float) 7.7790);
		Student student = mock(Student.class);
		// Total are 51 disciplines - 2(6 disciplines in 2 periods) = 39 
		when(student.remaining()).thenReturn(40);
		when(student.getPeriodsCr()).thenReturn(periodsCr);
		assertEquals("Failure - should be true", false,  gtr.isGraduationTimeRespected(student));
		assertEquals("Failure - should be true", false,  gtr.execute(student));
	}
	@Test
	public void graduationTimeRespectedStudentNullTest () {
		thrown.expect(StudentException.class);
		Student student = null;
		gtr.execute(student);
	}
	@Test
	public void graduationTimeRespectedStudentPeriodsCrNullTest () {
		thrown.expect(EmptyCollectionException.class);
		Student student = new Student();
		student.setPeriodsCr(null);
		gtr.execute(student);
	}
	@Test
	public void graduationTimeRespectedStudentPeriodsCrEmptyTest () {
		thrown.expect(EmptyCollectionException.class);
		Student student = new Student();
		gtr.execute(student);
	}
	
}
