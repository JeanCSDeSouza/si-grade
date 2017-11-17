package br.com.pm_2017.si_grade.io;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.pm_2017.si_grade.filters.PdfTextFilter;
import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.parser.DisciplineParser;
import br.com.pm_2017.si_grade.utils.DisciplineStatus;

@SuppressWarnings("unused")
public class TesteTTTTT {
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje.getYear());
		/*// TODO Auto-generated method stub
		final Pattern path = Pattern.compile("^(\\w){3}(\\d){4}");
		PDFIO pdfio = new PDFIO("historico.pdf");
		List<String> list = pdfio.getLinesList();
		
		PdfTextFilter ptf = new PdfTextFilter();
		
		
		DisciplineParser sp = new DisciplineParser();
		DisciplineParserHashMap dp2 = new DisciplineParserHashMap();
		
		dp2.generateDisciplinesList(ptf.filterDisciplinesFromPdfText(list)).forEach((key, value) -> {
			System.out.println(value.toString());
		});
		
		int j = 1;
		for (Discipline dscp : sp.generateDisciplinesList(ptf.filterDisciplinesFromPdfText(list))) {
			System.out.println(j + " : "+dscp.getCode() + "   E o status aprovado é : " + 
					dscp.getSituation());
			j++;
		}*/
	}

}
