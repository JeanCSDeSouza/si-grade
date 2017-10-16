package br.com.pm_2017.si_grade.io;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SVGIOTest {
	SVGIO sio;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		sio = new SVGIO("grade.svg");
	}
	
	@After
	public void close() throws Exception {
		sio.closeDocument();
	}
	
	@Test
	public void InstantiationTest() throws IOException {
		SVGIO sio = new SVGIO("grade.svg");
		assertNotNull("Should not be null", sio);
		sio.closeDocument();
	}
	
	@Test
	public void constructorIAETest() {
		thrown.expect(IllegalArgumentException.class);
		SVGIO sio = new SVGIO("grade");
	}
	
	public String svgLinesPreTest() throws IOException {
		FileReader fr = new FileReader("grade.svg");
		BufferedReader br = new BufferedReader(fr);
		String sparring = null;
		while( br.ready() )
			sparring = br.readLine();
		br.close();
		return sparring;
	}
	
	@Test
	public void svgLinesTest() {
		String preTest = svgLinesPreTest();
		assertNull("Should not be null", sio.getText());
		assertEquals("failure - strings are not equal", preTest, sio.getText());
	}
}
