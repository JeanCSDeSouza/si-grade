package br.com.pm_2017.si_grade.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

public class PDFDaoTeste{
	PDFDao op = new PDFDao();
	
	@Test
	public void fileOpenTest() throws IOException {
		assertNotNull("Should not be null",op.fileOpen("historico.pdf"));
	}
	
	@Test
	public void loadDocumentTest() throws IOException {
		op.loadDocument( op.fileOpen( "historico.pdf" ) ) ;
		assertNotNull( "Should not be null", op.getDocument());
		op.closeDocument();
	}
	
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
		op.loadDocument( op.fileOpen( "historico.pdf" ) ) ;
		String pdfText = op.getText();
		assertNotNull( "Should not be null", pdfText);
		assertEquals("failure - strings are not equal", pdfText, PDFBoxPreTest());
		
	}
	
	
}
