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

public class DisciplineParserTest {
	DisciplineParser dp;
	List<String> toMock;

	@Before
	public void setUp() throws Exception {
		dp = new DisciplineParser();
		List<String> toMock = new ArrayList<String>();
		toMock.add("TIN0011 TÉCNICAS DE PROGRAMAÇÃO II 5 90 100,00 RPV- Reprovado");
		toMock.add("TIN0011 TÉCNICAS DE PROGRAMAÇÃO II 5 90 100,00 APV- Aprovado");
		toMock.add("TIN0123 TÉCNICAS DE PROGRAMAÇÃO II 5 90 100,00 RPV- Reprovado");
		toMock.add("TIN0123 TÉCNICAS DE PROGRAMAÇÃO II 5 90 100,00 RPV- Reprovado");
		toMock.add("TIN0123 TÉCNICAS DE PROGRAMAÇÃO II 5 90 100,00 ASC - Matrícula");
		toMock.add("TRT0001 TÉCNICAS DE PROGRAMAÇÃO II 5 90 100,00 XXXXXXXXXXXXXXX");
		this.toMock = toMock;
	}

	@Test
	public void generateDisciplinesMapNullTest() {
		@SuppressWarnings("unchecked")
		List<String> mocked = mock(List.class);
		when(mocked.isEmpty()).thenReturn(true); 
		@SuppressWarnings("static-access")
		Map<String,Discipline> test = dp.generateDisciplinesMap(mocked);
		assertNull( "Should be null", test);
	}

	@Test
	public void generateDisciplinesMapEqualsTest() {
		Discipline mocked = mock(Discipline.class);
		when(mocked.getCode()).thenReturn("TIN0011");
		
		Discipline mocked2 = mock(Discipline.class);
		when(mocked2.getCode()).thenReturn("TIN0123");
		
		Discipline mocked3 = mock(Discipline.class);
		when(mocked2.getCode()).thenReturn("TRT0001");
		
		Map<String,Discipline> test = DisciplineParser.generateDisciplinesMap(toMock);
		assertNotNull( "Should not be null", test);
		
		assertEquals("failure - strings are not equal", mocked.getCode(), test.get("TIN0011").getCode());
		
		
		assertEquals("failure - int number of times attended should be 2", 2, test.get("TIN0011").getTimesAttended());
		assertEquals("failure - int number of times attended should be 3", 3, test.get("TIN0123").getTimesAttended());
		assertEquals("failure - int number of times attended should be 3", 1, test.get("TRT0001").getTimesAttended());
		
		assertEquals("failure - int number of size should be 3", 3, test.size());
	}
}
