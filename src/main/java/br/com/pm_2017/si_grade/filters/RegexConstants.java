package br.com.pm_2017.si_grade.filters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexConstants {
	private final static Pattern FIND_MEANINGFUL_PATHS_ON_SVG = Pattern.compile("^(\\s){4}<path(\\s)id");
	private final static Pattern FIND_DISCIPLINES_ON_PDF = Pattern.compile("^(\\w){3}(\\d){4}");
	
	/**
	 * Class with only static methods shouldn't be instantiated  
	 */
	private RegexConstants() {		
	}
	
	/**
	 * Tests is the line of the svg document matches the pattern 
	 * @param frase String line of the svg
	 * @return true only if the line follows the desired pattern 
	 */
	public static boolean isDisciplinePath(String frase) {
		Matcher matcher = FIND_MEANINGFUL_PATHS_ON_SVG.matcher(frase);
		return matcher.find();
	}
	
	/**
	 * Tests is the line of the historic pdf document matches the pattern 
	 * @param frase String line of the historic pdf
	 * @return true only if the line follows the desired pattern 
	 */
	public static boolean isDiscipline(String frase) {
		Matcher matcher = FIND_DISCIPLINES_ON_PDF.matcher(frase);
		return matcher.find();
	}
}
