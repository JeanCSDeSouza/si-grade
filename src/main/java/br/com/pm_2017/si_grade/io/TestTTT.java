package br.com.pm_2017.si_grade.io;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.utils.DisciplineStatus;

public class TestTTT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Pattern path = Pattern.compile("^(\\w){3}(\\d){4}");
		PDFIO pdfio = new PDFIO("historico.pdf");
		List<String> list = pdfio.getLinesList();
		
		int j = 1;
		for(String line: list) {
			Matcher matcher = path.matcher(line);
			if(matcher.find()) {
				System.out.println("Linha"+j + " :" + line);
				j++;
				if(line.contains(DisciplineStatus.APROVADO.getStatusName()) 
						| line.contains(DisciplineStatus.DISPENSA_SEM_NOTA.getStatusName())) {
			
					System.out.println(1 );
				}
			}	
		}
	}

}
