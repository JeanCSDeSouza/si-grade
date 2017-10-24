package br.com.pm_2017.si_grade.filters;

import java.util.ArrayList;
import java.util.List;

import br.com.pm_2017.si_grade.io.PDFIO;

public class PdfTextFilter {
	
	public List<String> filterDisciplinesFromPdfText(PDFIO pdfIO){
		List<String> linesList = new ArrayList<String>();
		pdfIO.getLinesList().forEach( ( line ) -> {
			if(RegexConstants.isDiscipline(line))
				linesList.add(line);
		});
		return linesList;	
	}
}
