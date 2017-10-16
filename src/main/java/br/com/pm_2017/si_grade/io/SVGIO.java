package br.com.pm_2017.si_grade.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import br.com.pm_2017.si_grade.exceptions.PDFIsEncryptedException;

public class SVGIO {
	BufferedReader document;
	File path;
	
	public SVGIO(String filePath) {
		File file = fileOpen(filePath);
		if( file.canRead() ){
			path = file;
			BufferedReader BufferedDocument = loadDocument(file);
			document =  BufferedDocument;
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
	
	private BufferedReader loadDocument(File file){
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
		}catch(IOException ioe) {
			ioe.getMessage();
		}
		return br;
	}
	
	public void closeDocument() throws IOException {
		document.close();
	}

	public BufferedReader getDocument() {
		return document;
	}

	public Object getText() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
