package br.com.pm_2017.si_grade.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.pm_2017.si_grade.filters.PdfTextFilter;
import br.com.pm_2017.si_grade.io.PDFIO;
import br.com.pm_2017.si_grade.model.Discipline;

public class DisciplineParserTest {
	DisciplineParser dp;
	
	@Before
	public void setUp() throws Exception {
		dp = new DisciplineParser();
	}
	@Test
	public void generateDisciplinesListEqualsTest() {
		List<String> toMock = new ArrayList<String>();
		toMock.add("TIN0011 TÉCNICAS DE PROGRAMAÇÃO II 5 90 100,00 APV- Aprovado");
		ArrayList<Discipline> test = (ArrayList<Discipline>) dp.generateDisciplinesList(toMock);
		assertNotNull( "Should not be null", test);
		assertEquals("failure - strings are not equal", test, toMock);
	}
	@Test
	public void generateDisciplinesListNullTest() {
		List<String> mocked = mock(List.class);
		when(mocked.isEmpty()).thenReturn(true); 
		ArrayList<Discipline> test = (ArrayList<Discipline>) dp.generateDisciplinesList(mocked);
		assertNull( "Should be null", test);
	}
}
