package br.com.pm_2017.si_grade.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class SiGradeIO{
	List<String> document;
	File path;
	
	public SiGradeIO(String filePath) {
		Path file = fileOpen(filePath);
		if( file.toFile().canRead() ){
			Charset charset = Charset.forName("UTF-8");
			document = loadDocument(file, charset);
		}else {
			throw new IllegalArgumentException("Could not read svg: InvalidPath");
		}	
	}
	
	/**
	 * Instantiate a java.io.File and returns it. 
	 * @param fileName the path to instantiate the java.io.file
	 * @return java.io.File 
	 */
	private Path fileOpen(String fileName){
		 return Paths.get(fileName);
	}
	
	/**
	 * Responsible for opening the document and returning its lines 
	 * Ensures that the document is close at the end
	 * @param file the path of the document 
	 * @param charset the charset used in the document
	 * @return
	 */
	private List<String> loadDocument(Path file, Charset charset){
		List<String> text = null;
		try {
			text = Files.readAllLines(file, charset);
		}catch(IOException ioe) {
			ioe.getMessage();
		}
		return text;
	}
	
	/**
	 * returns the lines list of an document
	 * @return List<String>
	 */
	public List<String> getDocument() {
		return document;
	}
	
}
