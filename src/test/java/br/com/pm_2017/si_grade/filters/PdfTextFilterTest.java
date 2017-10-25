package br.com.pm_2017.si_grade.filters;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import br.com.pm_2017.si_grade.io.PDFIO;



public class PdfTextFilterTest {
	PDFIO op;
	
	@Before
	public void setUp() throws Exception {
		op = mock(PDFIO.class);
	}
	@Test
	public void filterDisciplinesFromPdfTextEqualsTest() {
		List<String> toMock = new ArrayList<String>();
		toMock.add("TIN0011 TÉCNICAS DE PROGRAMAÇÃO II 5 90 100,00 DIS - Dispensa sem nota");
		PdfTextFilter ptf = new PdfTextFilter();
		ArrayList<String> test = (ArrayList<String>) ptf.filterDisciplinesFromPdfText(toMock);
		assertNotNull( "Should not be null", test);
		assertEquals("failure - strings are not equal", test, toMock);
	}
	@Test
	public void filterDisciplinesFromPdfTextNullTest() {
		List<String> mocked = mock(List.class);
		when(mocked.isEmpty()).thenReturn(true);
		PdfTextFilter ptf = new PdfTextFilter();
		ArrayList<String> test = (ArrayList<String>) ptf.filterDisciplinesFromPdfText(mocked);
		assertNull( "Should be null", test);
	}
	
}
