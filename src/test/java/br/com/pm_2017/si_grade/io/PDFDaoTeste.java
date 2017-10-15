package br.com.pm_2017.si_grade.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PDFDaoTeste{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	PDFIO op;
	File file;
	
	@Before
	public void setUp() throws Exception {
		op = new PDFIO("historico.pdf");
	}
	
	@After
	public void close() throws Exception {
		op.closeDocument();
	}
	
	public void pdfIOEncriptedPdfTest() {
		
	}
	
	@Test
	public void pdfIONullTest() {
		thrown.expect(IllegalArgumentException.class);
		PDFIO op = new PDFIO("e.pdf");
	}
	
	/**
	 * Method built to be used at the getTextTest
	 * @return the text of a pdf document in a string
	 * @throws IOException
	 */
	public String PDFBoxPreTest() throws IOException {
		PDDocument document = null;
        String fileName = "historico.pdf";
        try {
        	document = PDDocument.load( new File(fileName) );
        	
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition( true );
            stripper.setStartPage( 0 );
            stripper.setEndPage( document.getNumberOfPages() );
            return stripper.getText(document);
        }
        finally {
            if( document != null ) {
                document.close();
            }
        }
	}
	
	@Test
	public void getTextTest() throws InvalidPasswordException, IOException {
		String pdfText = op.getText();
		assertNotNull( "Should not be null", pdfText);
		assertEquals("failure - strings are not equal", pdfText, PDFBoxPreTest());
		
	}
	@Test
	public void getLinesListTest() throws IOException {
		String pdfText = PDFBoxPreTest();
		List<String> list = new ArrayList<String>();
		Collections.addAll(list, pdfText.split(System.lineSeparator()));
		assertEquals("Failure - Lists are not qual", list, op.getLinesList());
	}
	
}
