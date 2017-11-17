package br.com.pm_2017.si_grade.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.parser.StudentParser;

public class TesteTT {

	public static void main(String[] args) {
		final Pattern path = Pattern.compile("^(\\s){4}<path(\\s)id");
		Path wiki_path = Paths.get("svg.svg");
		
		Charset charset = Charset.forName("UTF-8");
		List<String> lines;
		try {
			PDFIO pdfIo = new PDFIO("historico.pdf");
			lines = Files.readAllLines(wiki_path, charset);
			int j = 1;
			
			for(String line: pdfIo.getLinesList()) {
				System.out.println(line);
				
				//Matcher matcher = path.matcher(line);
				//if(matcher.find()) {
					//System.out.println("Linha"+j + " :" + line);
					//j++;
				//}	
			}
			StudentParser sp = new StudentParser();
			Student student = sp.generateStudent( pdfIo.getLinesList() );
			System.out.println( student.toString());
			List<String> teste = new ArrayList<String>();
			if(teste.isEmpty())
				System.out.println("Lista null vale como empty");
		} catch (IOException e) {
			System.out.println(e);
		}

	}
	public static List<String> svgLinesPreTest() throws IOException {
		FileReader fr = new FileReader("svg.svg");
		BufferedReader br = new BufferedReader(fr);
		List<String> list = new ArrayList<String>();
		while( br.ready() )
			list.add(br.readLine());
		br.close();
		return list;
	}
}