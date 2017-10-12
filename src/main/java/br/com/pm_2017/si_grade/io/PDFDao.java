package br.com.pm_2017.si_grade.io;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFDao {
	
	PDDocument document;
	
	public File fileOpen(String fileName){
		return new File(fileName);
	}
	
	public void loadDocument(File file){
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
		this.document = document;
	}
	
	public void closeDocument() throws IOException {
		try {
			document.close();
		}catch( IOException ioe) {
			ioe.getStackTrace();
		}
	}
	
	public String getText() throws InvalidPasswordException, IOException{
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
