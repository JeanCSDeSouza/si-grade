package br.com.pm_2017.si_grade.io;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import br.com.pm_2017.si_grade.exceptions.PDFIsEncryptedException;

public class PDFDao {
	
	PDDocument document;
	
	public PDFDao(String filePath){
		File file = fileOpen(filePath);
		if( file.canRead() ){
			PDDocument pddDocument = loadDocument(file);
			if(pddDocument.isEncrypted())
				throw new PDFIsEncryptedException("Could not read pdf: Is encrypted");
			document = pddDocument;
		}else {
			throw new IllegalArgumentException("Could not read pdf: InvalidPath");
		}
	}
	
	private File fileOpen(String fileName){
		return new File(fileName);
	}
	
	private PDDocument loadDocument(File file){
		PDDocument document = null;
		try{
			document = PDDocument.load( file );
			if(document.isEncrypted()) {
				this.document = null;
			}
			
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return document;
	}
	
	public void closeDocument() throws IOException {
		try {
			document.close();
		}catch( IOException ioe) {
			ioe.getStackTrace();
		}
	}
	
	public String getText() throws InvalidPasswordException, IOException{
		//Condition to test null just in case
		if( document.equals( null ) ) 
			return null;
		else {
			PDFTextStripper stripper = new PDFTextStripper();
			stripper.setSortByPosition( true );
			stripper.setStartPage( 0 );
			stripper.setEndPage( document.getNumberOfPages() );
			String pdfText = stripper.getText( document );
			return pdfText;
		}	
	}

	public PDDocument getDocument() {
		return document;
	}
}
