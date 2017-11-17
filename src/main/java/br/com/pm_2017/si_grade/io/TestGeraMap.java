package br.com.pm_2017.si_grade.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.pm_2017.si_grade.filters.PdfTextFilter;
import br.com.pm_2017.si_grade.model.Discipline;

public class TestGeraMap {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PDFIO pdfIO = new PDFIO("historico.pdf");
		PdfTextFilter ptf = new PdfTextFilter(); 
		ptf.filterDisciplinesFromPdfText(pdfIO.getLinesList());
		
		
	}
}
