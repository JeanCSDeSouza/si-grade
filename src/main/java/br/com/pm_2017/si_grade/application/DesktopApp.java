package br.com.pm_2017.si_grade.application;

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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DesktopApp {

	public static void main(String[] args) throws IOException, URISyntaxException {
		StudentController studentController = new StudentController();

		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF files", "pdf");
		String filePathPDF = openFile(filter);

		if (filePathPDF != null) {
			List<String> document = studentController.generateDocumentLinesList(filePathPDF);
			Student student = studentController.getStudentFromPdf(document);

			Map<String, Boolean> rulesCache = studentController.generateRuleMap(student);

			filter = new FileNameExtensionFilter("SVG files", "svg");
			String filePathSVG = openFile(filter);

			if (filePathSVG != null) {
				List<String> lines = studentController.generateSvgStringList(filePathSVG);

				String linesAsString = studentController.generateColoredSvg(student, lines);

				List<String> html = studentController.generateHtmlLinesList("si_grade.html");

				List<String> finalHtml = studentController.generateHtmlPageForStudent(html, student, rulesCache,
						linesAsString);
				String finalHtmlAsString = String.join("\n", finalHtml);
				// System.out.println(finalHtmlAsString);
				File file = File.createTempFile("grade-" + student.getName(), ".html");
				// Delete temp file when program exits.
				file.deleteOnExit();
				// Write to temp file
				BufferedWriter out = new BufferedWriter(new FileWriter(file));
				out.write(finalHtmlAsString);
				out.close();
				String os = System.getProperty("os.name").toLowerCase();
				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().browse(file.toURI());
				}else {
					Runtime runtime = Runtime.getRuntime();
					if(os.indexOf("mac") >= 0) {
						runtime.exec("open " + file.toURI());
					}else {
			            try {
			                runtime.exec("xdg-open " + file.toURI());
			            } catch (IOException e) {
			                e.printStackTrace();
			            }
					}
				}
			}
		}
	}

	public static String openFile(FileNameExtensionFilter filter) {
		JOptionPane.showMessageDialog(null, "Selecione o arquivo " + filter.getExtensions()[0].toUpperCase());
		while (true) {
			JFileChooser chooser = new JFileChooser(System.getProperty("java.class.path"));
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String filePath = chooser.getSelectedFile().getAbsolutePath();
				if (filePath.substring(filePath.length() - 3).equalsIgnoreCase(filter.getExtensions()[0])) {
					return (filePath);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione arquivo válido");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado. Encerrando.");
				break;
			}
		}
		return null;
	}
}
