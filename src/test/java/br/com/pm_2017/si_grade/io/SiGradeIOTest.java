package br.com.pm_2017.si_grade.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SiGradeIOTest {
	SiGradeIO sio;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		sio = new SiGradeIO("svg.svg");
	}

	@Test
	public void InstantiationTest() throws IOException {
		SiGradeIO sio = new SiGradeIO("svg.svg");
		assertNotNull("Should not be null", sio);
	}

	@Test
	public void constructorIAETest() {
		thrown.expect(IllegalArgumentException.class);
		@SuppressWarnings("unused")
		SiGradeIO sio = new SiGradeIO("grade");
	}

	public List<String> svgLinesPreTest() {
		Path wiki_path = Paths.get("svg.svg");

		Charset charset = Charset.forName("UTF-8");
		List<String> lines = null;
		try {
			lines = Files.readAllLines(wiki_path, charset);
		} catch (IOException e) {
			System.out.println(e);
		}
		return lines;
	}

	@Test
	public void getDocumentTest() throws IOException {
		assertNotNull("Should not be null", sio.getDocument());
		assertEquals("failure - strings are not equal", svgLinesPreTest(), sio.getDocument());
	}
}
