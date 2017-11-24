package br.com.pm_2017.si_grade.controller;

import java.util.List;
import java.util.Map;

import br.com.pm_2017.si_grade.dao.GenericDAO;
import br.com.pm_2017.si_grade.dao.PdfDAO;
import br.com.pm_2017.si_grade.io.SiGradeIO;
import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.parser.DisciplineParser;
import br.com.pm_2017.si_grade.parser.HtmlParser;
import br.com.pm_2017.si_grade.parser.StudentParser;
import br.com.pm_2017.si_grade.parser.SvgParser;
import br.com.pm_2017.si_grade.rules.RulesCache;
/**
 * The working controller for student logic
 * <p>
 * @author Cayo Mauríco, Araragi-san, Renata Emmanuelle
 */
public class StudentController {
	private RulesCache rulesCache;
	private Student student;
	public StudentController() {
		rulesCache = new RulesCache();
		this.student = new Student();
	}
	/**
	 * Get student information from a historic and bind it to a
	 * Student. Calls the disciplines generator method and bind the
	 * Return to the current student. 
	 * @param pdfPath
	 * @return
	 */
	public Student getStudentFromPdf(List<String> document) {		
		Student student = StudentParser.generateStudent(document);
		student.setDisciplines( generateDisciplineMap(document) );
		return student;
	}
	/**
	 * Generates a map of Code/Discipline of disciplines from the historic
	 * @param List of disciplines strings from pdf
	 * @return Map with all the disciplines attended by an student 
	 */
	private Map<String, Discipline> generateDisciplineMap(List<String> document){
		Map<String, Discipline> disciplineMap = DisciplineParser.generateDisciplinesMap(document);
		return disciplineMap;
	}
	/**
	 * Uses a implementation of scanner interface to find and run on the 
	 * package of rules in execution time the rules marked by the Use annotation. 
	 * Applies the rules to the student passed creating a map with the message and the 
	 * boolean value. The boolean value is true if the rule is applied to the student
	 * @param student
	 * @return Map<String, Boolean> 
	 */
	public Map<String, Boolean> generateRuleMap(Student student){
		return rulesCache.execute(student);
	}
	/**
	 * Generates List<String> with the historic lines
	 * @return List<String> with the pdf lines
	 */
	public List<String> generateDocumentLinesList(String pdfPath) {
		PdfDAO pdfDAO = new PdfDAO(pdfPath);
		List<String> disciplines = pdfDAO.getDocumentStringList();
		pdfDAO.closePdfDocument();
		return disciplines;
	}
	/**
	 * Returns the lines of the document at the passed path
	 * @param path
	 * @return
	 */
	private List<String> generateLinesListOfFile(String path) {
		GenericDAO genericDao = new GenericDAO(path);
		List<String> fileLines = genericDao.getDocumentStringList();
		return fileLines;
	}
	/**
	 * Generate the String List of lines of the passed svg file
	 * @return the lines of the raw SVG
	 */
	public List<String> generateSvgStringList(String svgPath){
		return generateLinesListOfFile(svgPath);
	}
	/**
	 * Return the colored SVG lines as string as preparation to be saved on the html
	 * @param student a Student class
	 * @param svgLines the List<String> with the svg lines
	 * @return the SVG as string
	 */
	public String generateColoredSvg(Student student, List<String> svgLines){
		List<String> coloredSvgLinesList = SvgParser.parseSvgLinesColoring(student, svgLines);
		String coloredSvgLinesListAsString = String.join(" ",coloredSvgLinesList);
		return coloredSvgLinesListAsString;
	}
	/**
	 * Returns the Html lines as string list of the passed file
	 * @param htmlPath the path to the file 
	 * @return the the lines of the file as list
	 */
	public List<String> generateHtmlLinesList(String htmlPath) {
		return generateLinesListOfFile(htmlPath);
	}
	/**
	 * Generate the final html document ready to be sgiven for the user
	 * @param html lines list of the raw html document
	 * @param student The student for whom this grade applies
	 * @param rulesCache The map String/boolean for the rules applied to student
	 * @param linesAsString The processed SVG lines colored as String
	 * @return return the List<String> of lines from the Html of the grade
	 */
	public List<String> generateHtmlPageForStudent(List<String> html, Student student, Map<String, Boolean> rulesCache, String linesAsString){
		return HtmlParser.generateHtmlPage(html, student, rulesCache, linesAsString);
	}
}
