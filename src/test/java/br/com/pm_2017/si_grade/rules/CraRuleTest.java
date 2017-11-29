package br.com.pm_2017.si_grade.rules;

import static org.junit.Assert.assertEquals;
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
		when(student.getCra()).thenReturn((float) 7.0000);
		assertEquals("Failure - Should be true", true, cra.execute(student));
		when(student.getCra()).thenReturn((float) 6.9999);
		assertEquals("Failure - Should be true", false, cra.execute(student));
	}
}
