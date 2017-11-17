package br.com.pm_2017.si_grade.parser;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import br.com.pm_2017.si_grade.exceptions.StudentNullException;
import br.com.pm_2017.si_grade.model.Student;

public class RegistryParserTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void parseYearFromRegistryStudentNullTest( ) {
		thrown.expect(StudentNullException.class);
		Student student = null;
		RegistryParser.parseYearFromRegistry(student);
	}
	@Test
	public void parseYearFromRegistryLengthTest( ) {
		Student student = mock(Student.class);
		Mockito.when(student.getRegistry()).thenReturn("1235111111");
		int answer = RegistryParser.parseYearFromRegistry(student);
		assertEquals("Should be equal", -1, answer);
	}
	@Test
	public void parseYearFromRegistryemptyTest( ) {
		Student student = mock(Student.class);
		Mockito.when(student.getRegistry()).thenReturn("");
		int answer = RegistryParser.parseYearFromRegistry(student);
		assertEquals("Should be equal", -1, answer);
	}
	@Test
	public void parseYearFromRegistryStringNullTest( ) {
		thrown.expect(StudentNullException.class);
		
		Student student = new Student();
		student.setRegistry(null);
		RegistryParser.parseYearFromRegistry(student);
	}
	@Test
	public void parseYearFromRegistryEqualsTest( ) {
		Student student = mock(Student.class);
		String registry = "20111210020";
		Mockito.when( student.getRegistry() ).thenReturn(registry);
		int answer = RegistryParser.parseYearFromRegistry(student);
		assertEquals("Should be equal", 2011, answer);
	}
}
