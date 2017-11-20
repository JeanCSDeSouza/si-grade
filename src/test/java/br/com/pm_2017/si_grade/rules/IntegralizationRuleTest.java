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

import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;

public class IntegralizationRuleTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	IntegralizationRule ir; 
	@Before
	public void setUp() {
		ir = new IntegralizationRule(); 
	}
	@SuppressWarnings("unchecked")
	@Test
	public void IntegralizationRuleTrueTest() {
		List<Float> periodsCr = mock(ArrayList.class);
	
		when(periodsCr.size()).thenReturn(7);
		Student student = mock(Student.class);
		when(student.getYearOfRegistry()).thenReturn(2014);
		when(student.getPeriodsCr()).thenReturn(periodsCr);
		assertEquals("Failure - should be true", true, ir.execute(student) );
		when(periodsCr.size()).thenReturn(8);
		assertEquals("Failure - should be true", true, ir.execute(student) );
	}
	@SuppressWarnings("unchecked")
	@Test
	public void IntegralizationRuleFalseTest() {
		List<Float> periodsCr = mock(ArrayList.class);
		when(periodsCr.size()).thenReturn(6);
		Student student = mock(Student.class);
		when(student.getYearOfRegistry()).thenReturn(2014);
		when(student.getPeriodsCr()).thenReturn(periodsCr);
		assertEquals("Failure - should be true", false, ir.execute(student) );
		when(periodsCr.size()).thenReturn(5);
		assertEquals("Failure - should be true", false, ir.execute(student) );
		when(periodsCr.size()).thenReturn(0);
		assertEquals("Failure - should be true", false, ir.execute(student) );
	}
	@Test
	public void IntegralizationRuleExceptionWithNullTest() {
		thrown.expect(StudentException.class);
		Student student = mock(Student.class);
		when(student.getPeriodsCr()).thenReturn(null);
		ir.execute(student);
	}
	@Test
	public void IntegralizationRuleExceptionWithEmptyTest() {
		thrown.expect(StudentException.class);
		Student student = mock(Student.class);
		when(student.getYearOfRegistry()).thenReturn(1999);
		ir.execute(student);
	}
}
