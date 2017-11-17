package br.com.pm_2017.si_grade.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import br.com.pm_2017.si_grade.exceptions.PDFIsEncryptedException;

public class PDFIO {

	PDDocument document;

	/**
	 * Create an instance of PDFIO by the given string that represents the path 
	 * where the PDF file is.
	 * @param filePath String that represents the path of the PDF file
	 * @exception IllegalArgumentException if the path is invalid
	 * @throws  PDFIsEncryptedException if the PDF is encrypted
	 */
	public PDFIO(String filePath){
		File file = fileOpen(filePath);
		if( file.canRead() ){
			PDDocument pdDocument = loadDocument(file);
			if(pdDocument.isEncrypted())
				throw new PDFIsEncryptedException("Could not read pdf: Is encrypted");
			document = pdDocument;
		}else {
			throw new IllegalArgumentException("Could not read pdf: InvalidPath");
		}
	}
	
	/**
	 * Instantiate a java.io.File and returns it. 
	 * @param fileName the path to instantiate the java.io.file
	 * @return java.io.File 
	 */
	private File fileOpen(String fileName){
		return new File(fileName);
	}
	
	/**
	 * Opens a PDFBox document using the java.io.File passed as parameter
	 * @param file, a java.io.File needed by PDFBox PDDocument
	 * @return a PDDocument that encapsulates the PDF document 
	 */
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
	/**
	 * Closes the document opened in the constructor
	 * @throws IOException
	 */
	public void closeDocument() throws IOException {
		try {
			document.close();
		}catch( IOException ioe) {
			ioe.getStackTrace();
		}
	}
	
	/**
	 * Gets the text of a PDDocument 
	 * @return String containing the text of the given PDFDocument
	 */
	public String getText(){
		//Condition to test null just in case
		if( document.equals( null ) ) 
			return null;
		else {
			PDFTextStripper stripper = null;
			String pdfText = null;
			try {
				stripper = new PDFTextStripper();
				stripper.setSortByPosition( true );
				stripper.setStartPage( 0 );
				stripper.setEndPage( document.getNumberOfPages() );
				pdfText = stripper.getText( document );

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pdfText;
		}	
	}
	/**
	 * Gets the instance value of PDDocument
	 */
	public PDDocument getDocument() {
		return document;
	}
	/**
	 * Split the getText() String by line 
	 * @return the List containing the lines of a PDF document
	 */
	public List<String> getLinesList() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		Collections.addAll(list, getText().split(System.lineSeparator()));
		return list;
	}
}