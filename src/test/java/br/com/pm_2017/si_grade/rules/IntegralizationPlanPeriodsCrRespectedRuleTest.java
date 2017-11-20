package br.com.pm_2017.si_grade.rules;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;

public class IntegralizationPlanPeriodsCrRespectedRuleTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	IntegralizationPlanPeriodsCrRespectedRule ippcrr; 
	@Before
	public void setUp() {
		ippcrr = new IntegralizationPlanPeriodsCrRespectedRule(); 
	}
	@Test
	public void  IntegralizationPlanPeriodsCrRespectedNewCurriculumTrueTest () {
		@SuppressWarnings("unchecked")
		List<Float> periodsCr = mock(List.class);
		when(periodsCr.size()).thenReturn(8);
		when(periodsCr.get(anyInt())).thenReturn((float)5.00);
		Student student = mock(Student.class);
		when(student.getPeriodsCr()).thenReturn(periodsCr);
		when(student.getYearOfRegistry()).thenReturn(2014);
		assertEquals("Failure - should be true", true, ippcrr.execute(student));
		verify(periodsCr, times(1)).get(anyInt());
	}
	@Test
	public void  IntegralizationPlanPeriodsCrRespectedNewCurriculumFalseTest () {
		@SuppressWarnings("unchecked")
		List<Float> periodsCr = mock(List.class);
		when(periodsCr.size()).thenReturn(8);
		when(periodsCr.get(anyInt())).thenReturn((float)4.99);
		Student student = mock(Student.class);
		when(student.getPeriodsCr()).thenReturn(periodsCr);
		when(student.getYearOfRegistry()).thenReturn(2014);
		assertEquals("Failure - should be true", false, ippcrr.execute(student));
		verify(periodsCr, times(1)).get(anyInt());
	}
	@Test
	public void  IntegralizationPlanPeriodsCrRespectedOldCurriculumTrueTest () {
		@SuppressWarnings("unchecked")
		List<Float> periodsCr = mock(List.class);
		when(periodsCr.size()).thenReturn(13);
		when(periodsCr.get(anyInt())).thenReturn((float)5.00);
		Student student = mock(Student.class);
		when(student.getPeriodsCr()).thenReturn(periodsCr);
		when(student.getYearOfRegistry()).thenReturn(2013);
		assertEquals("Failure - should be true", true, ippcrr.execute(student));
		verify(periodsCr, times(1)).get(anyInt());
	}
	@Test
	public void  IntegralizationPlanPeriodsCrRespectedOldCurriculumFalseTest () {
		@SuppressWarnings("unchecked")
		List<Float> periodsCr = mock(List.class);
		when(periodsCr.size()).thenReturn(13);
		when(periodsCr.get(anyInt())).thenReturn((float)4.99);
		Student student = mock(Student.class);
		when(student.getPeriodsCr()).thenReturn(periodsCr);
		when(student.getYearOfRegistry()).thenReturn(2013);
		assertEquals("Failure - should be true", false, ippcrr.execute(student));
		verify(periodsCr, times(1)).get(anyInt());
	}
	@Test
	public void  IntegralizationPlanPeriodsCrRespectedStudentNullTest () {
		thrown.expect(StudentException.class);
		Student student = null;
		ippcrr.execute(student);
	}
	@Test
	public void  IntegralizationPlanPeriodsCrRespectedStudentPeriodsCrNullTest () {
		thrown.expect(EmptyCollectionException.class);
		Student student = new Student();
		student.setPeriodsCr(null);
		ippcrr.execute(student);
	}
	@Test
	public void  IntegralizationPlanPeriodsCrRespectedStudentPeriodsCrEmptyTest () {
		thrown.expect(EmptyCollectionException.class);
		Student student = new Student();
		ippcrr.execute(student);
	}
	@Test
	public void  IntegralizationPlanPeriodsCrRespectedYearWithExceptionTest() {
		thrown.expect(StudentException.class);
		List<Float> periodsCr = new ArrayList<Float>();
		periodsCr.add((float) 7.88);
		Student student = mock(Student.class);
		when(student.getPeriodsCr()).thenReturn(periodsCr);
		when(student.getYearOfRegistry()).thenReturn(1999);
		ippcrr.execute(student);
	}
}
