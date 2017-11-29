package br.com.pm_2017.si_grade.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import br.com.pm_2017.si_grade.model.Student;

public class CraRuleTest {
	private CraRule cra;

	@Before
	public void startUp() {
		cra = new CraRule();
	}

	@Test
	public void craGreaterThanTrueTest() {
		Student student = mock(Student.class);
		when(student.getCra()).thenReturn( (float) 7.0000);
		assertTrue("Failure - with 7.0000 should be true", cra.execute(student));
		when(student.getCra()).thenReturn( (float) 7.0001);
		assertTrue("Failure - with 7.0001 should be true", cra.execute(student));
		when(student.getCra()).thenReturn( (float) 7.1000);
		assertTrue("Failure - with 7.1000 should be true", cra.execute(student));
	}
	@Test
	public void craGreaterThanFalseTest() {
		Student student = mock(Student.class);
		when(student.getCra()).thenReturn( (float) 6.9999);
		assertEquals("Failure - with 6.9999 should be false", false, cra.execute(student));
		when(student.getCra()).thenReturn( (float) 6.9);
		assertEquals("Failure - with 9.9 should be false", false, cra.execute(student));
	}
}
