package br.com.pm_2017.si_grade.io;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import br.com.pm_2017.si_grade.controller.StudentController;
import br.com.pm_2017.si_grade.model.Student;

public class Si_Grade_App {

	public static void main(String[] args) throws IOException, URISyntaxException {
		StudentController studentController = new StudentController();
		
		List<String> document = studentController.generateDocumentLinesList("historico2.pdf");//modificar para generateDocumentLinesList
		
		Student student = studentController.getStudentFromPdf(document);
		Map<String, Boolean> rulesCache = studentController.generateRuleMap(student);

		List<String> lines = studentController.generateSvgStringList("svg.svg");//generateSvgLinesList
		
		
		String linesAsString = studentController.generateColoredSvg(student, lines);
		
		List<String> html = studentController.generateHtmlLinesList("si_grade.html");
		
		List<String> finalHtml = studentController.generateHtmlPageForStudent(html, student, rulesCache, linesAsString)	;	
		String finalHtmlAsString = String.join("\n", finalHtml);
		//System.out.println(finalHtmlAsString);
		File file = File.createTempFile("grade-" + student.getName(), ".html" );
		// Delete temp file when program exits.
	    file.deleteOnExit();

	    // Write to temp file
	    BufferedWriter out = new BufferedWriter(new FileWriter(file));
	    out.write(finalHtmlAsString);
	    out.close();		
		if(Desktop.isDesktopSupported()) {
			Desktop.getDesktop().browse(file.toURI());
		}
	}
}