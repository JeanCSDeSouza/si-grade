package br.com.pm_2017.si_grade.filters;

import java.util.ArrayList;
import java.util.List;

public class PdfTextFilter {
	/**
	 * Filter the text from historic pdf to find discipline lines
	 * @param textFromPdf List of the lines of the historic pdf
	 * @return The discipline lines in the pdf
	 */
	public List<String> filterDisciplinesFromPdfText(List<String> textFromPdf){
		if(textFromPdf.isEmpty())
			return null;
		else {
			List<String> linesList = new ArrayList<String>();
			textFromPdf.forEach( ( line ) -> {
				if(RegexConstants.isPdfDiscipline(line))
					linesList.add(line);
			});
			return linesList;
		}
	}
}
