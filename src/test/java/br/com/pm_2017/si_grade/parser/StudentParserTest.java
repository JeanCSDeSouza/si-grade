package br.com.pm_2017.si_grade.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;

public class StudentParserTest {
	StudentParser sp;
	List<String> toMock;
	
	@Before
	public void setUp() throws Exception {
		sp = new StudentParser();
		List<String> toMock = new ArrayList<String>();
		toMock.add("Matrícula: 20161210015 Período Atual: 4º Semestre");
		toMock.add("Nome Aluno: JEAN CARLOS SILVA DE SOUZA");
		toMock.add("Total Créditos/Carga Horária cursados no Período: : 60 930 Coeficiente de Rendimento: 7,6600");
		toMock.add("Total Créditos/Carga Horária cursados no Período: : 60 930 Coeficiente de Rendimento: 7,6600");
		toMock.add("Total Créditos/Carga Horária cursados no Período: : 60 930 Coeficiente de Rendimento: 7,6600");
		toMock.add("Total Créditos/Carga Horária cursados no Período: : 60 930 Coeficiente de Rendimento: 0,0000");
		toMock.add("Total Geral Créditos/Carga Horária cursados no Período 103 1590 Coeficiente de Rendimento Geral: 7,6600");
		this.toMock = toMock;
	}
	
	@Test
	public void generateStudentNullTest() {
		@SuppressWarnings("unchecked")
		List<String> mocked = mock(List.class);
		when(mocked.isEmpty()).thenReturn(true); 
		Student test = sp.generateStudent(mocked);
		assertNull( "Should be null", test);
	}
	
	@Test
	public void generateDisciplinesMapEqualsTest() {
		Student mocked = mock(Student.class);
		when(mocked.toString()).thenReturn
		("Student [name=JEAN CARLOS SILVA DE SOUZA, cra=7.66, resgistry=20161210015, periodsCr=[7.66, 7.66, 7.66, 0.0]]");

		Student test = sp.generateStudent(toMock);
		assertNotNull( "Should not be null", test);
		
		assertEquals("failure - strings are not equal", mocked.toString(), test.toString());
		
		
		assertEquals("failure - int number entries in periodsCR aren't equal", 4, test.getPeriodsCr().size());
		assertEquals("failure - int value of registry lenth should be 11 ", 11, test.getRegistry().length());
	}
}