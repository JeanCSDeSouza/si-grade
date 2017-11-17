package br.com.pm_2017.si_grade.parser;

import java.util.ArrayList;
import java.util.List;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.PdfCharacterRaplacer;
import br.com.pm_2017.si_grade.utils.StudentConstants;
/**
 * The class deals with all the parsing logic to instantiate 
 * an student from the PDF text
 * <p>
 * @author Araragi-San
 *
 */
public class StudentParser {
	/**
	 * Parses a Student from the PDF text
	 * <p>
	 * @param document The text from the historic PDF 
	 * @return Student class without the disciplines list
	 */
	public Student generateStudent(List<String> document) {
		if(document.isEmpty()) {
			return null;
		}else {
			Student student = new Student();
			List<Float> periodsCr = new ArrayList<Float>();
			document.forEach( ( line ) -> {
				if( line.contains( StudentConstants.STUDENT_PERIOD_CR.getValue( ) ) )
					periodsCr.add( Float.parseFloat( line.substring( 
							line.length( ) -  StudentConstants.STUDENT_PERIOD_CR.getBegin( ),
							line.length( ) - StudentConstants.STUDENT_PERIOD_CR.getEnd( ) )
							.replace( PdfCharacterRaplacer.PDF_DECIMAL_MARKER.getValue( ), PdfCharacterRaplacer.PDF_DECIMAL_MARKER_REPLACER.getValue( ) ) ) );				
				else {
					if( line.contains( StudentConstants.STUDENT_NAME.getValue( ) ) )
						student.setName( line.substring( StudentConstants.STUDENT_NAME.getBegin( ) ) );
					else {
						if( line.contains( StudentConstants.STUDENT_REGISTRY.getValue( ) ) )
							student.setRegistry( line.substring( StudentConstants.STUDENT_REGISTRY.getBegin(),
									StudentConstants.STUDENT_REGISTRY.getEnd( ) ) );
						else {
							if( line.contains( StudentConstants.STUDENT_CRA.getValue( ) ) ) 
								student.setCra( Float.parseFloat( ( line.substring( StudentConstants.STUDENT_CRA.getBegin(),
										StudentConstants.STUDENT_CRA.getEnd( ) ) )
										.replace( PdfCharacterRaplacer.PDF_DECIMAL_MARKER.getValue( ), PdfCharacterRaplacer.PDF_DECIMAL_MARKER_REPLACER.getValue( ) ) ) ); 
						}
					}
				}	
			});
			student.setPeriodsCr( periodsCr );
			int yearOfRegistry = -1;
			if( !student.getRegistry( ).isEmpty( ) )
				yearOfRegistry = RegistryParser.parseYearFromRegistry( student );
				if( yearOfRegistry != -1 )
					student.setYearOfResgitry(yearOfRegistry);
			return student;
		}
	}
}