package br.com.pm_2017.si_grade.controller;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import br.com.pm_2017.si_grade.filters.PdfTextFilter;
import br.com.pm_2017.si_grade.io.PDFIO;
import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.parser.DisciplineParser;
import br.com.pm_2017.si_grade.parser.StudentParser;
import br.com.pm_2017.si_grade.utils.RegexConstants;

public class PdfController {
	
	PDFIO pdfio;
	List<String> pdfLines;
	
	public PdfController(String pdfPath) {
		this.pdfio = new PDFIO(pdfPath);
		pdfLines = pdfio.getLinesList();
		
	}
	
	/**
	 * Generates a map of ID/Name of disciplines from a historic
	 * @param pdfPath
	 * @return
	 */
	private Map<String, Discipline> generateDisciplineMapFromPdf() {		
		List<String> disciplines = PdfTextFilter.filterDisciplinesFromPdfText(pdfLines);

		Map<String, Discipline> disciplineMap = DisciplineParser.generateDisciplinesMap(disciplines);
		
		return disciplineMap;
	}
	
	/**
	 * Get student information from a historic
	 * @param pdfPath
	 * @return
	 */
	public Student getStudentFromPdf() {		
		Student student = StudentParser.generateStudent(pdfLines);
		student.setDisciplines(generateDisciplineMapFromPdf());
		
		return student;
	}
}
