package br.com.pm_2017.si_grade.parser;

import java.util.ArrayList;
import java.util.List;

import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;
import br.com.pm_2017.si_grade.utils.PdfCharacterRaplacer;
import br.com.pm_2017.si_grade.utils.PdfStudentConstants;
import br.com.pm_2017.si_grade.utils.StudentFieldsConstants;
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
	 * @param pdfLines The text from the historic PDF 
	 * @return Student class without the disciplines list
	 */
	public static Student generateStudent(List<String> pdfLines) {
		if(pdfLines.isEmpty()) {
			return null;
		}else {
			Student student = new Student();
			List<Float> periodsCr = new ArrayList<Float>();
			pdfLines.forEach( ( line ) -> {
				if( line.contains( PdfStudentConstants.STUDENT_PERIOD_CR.getValue( ) ) )
					periodsCr.add( Float.parseFloat( line.substring( 
							line.length( ) -  PdfStudentConstants.STUDENT_PERIOD_CR.getBegin( ),
							line.length( ) - PdfStudentConstants.STUDENT_PERIOD_CR.getEnd( ) )
							.replace( PdfCharacterRaplacer.PDF_DECIMAL_MARKER.getValue( ), PdfCharacterRaplacer.PDF_DECIMAL_MARKER_REPLACER.getValue( ) ) ) );				
				else {
					if( line.contains( PdfStudentConstants.STUDENT_NAME.getValue( ) ) )
						student.setName( line.substring( PdfStudentConstants.STUDENT_NAME.getBegin( ) ) );
					else {
						if( line.contains( PdfStudentConstants.STUDENT_REGISTRY.getValue( ) ) )
							student.setRegistry( line.substring( PdfStudentConstants.STUDENT_REGISTRY.getBegin(),
									PdfStudentConstants.STUDENT_REGISTRY.getEnd( ) ) );
						else {
							if( line.contains( PdfStudentConstants.STUDENT_CRA.getValue( ) ) ) 
								student.setCra( Float.parseFloat( ( line.substring( PdfStudentConstants.STUDENT_CRA.getBegin(),
										PdfStudentConstants.STUDENT_CRA.getEnd( ) ) )
										.replace( PdfCharacterRaplacer.PDF_DECIMAL_MARKER.getValue( ), PdfCharacterRaplacer.PDF_DECIMAL_MARKER_REPLACER.getValue( ) ) ) );
						}
					}
				}	
			});
			student.setPeriodsCr( periodsCr );
			int yearOfRegistry = -1;
			if( !student.getRegistry( ).isEmpty( ) )
				yearOfRegistry = parseYearFromRegistry( student );
				if( yearOfRegistry != -1 )
					student.setYearOfResgitry(yearOfRegistry);
			return student;
		}
	}
	/**
	 * Parse the student registry year from the 4 first characters from the registry
	 * <p>
	 * @param student
	 * @return The year of registry or -1 if has no registry to parse  
	 */
	public static int parseYearFromRegistry( Student student ) {
		if( student == null || student.getRegistry() == null )
			throw new StudentException(ExceptionConstants.STUDENT_NULL.getMessage());
		int year = -1;
		if( student.getRegistry().length() < 11 || student.getRegistry().isEmpty() )
			return year;	
		try {
			year = Integer.parseInt( student.getRegistry().substring(0, 4) );
		}catch(NumberFormatException nfe){
			nfe.getMessage();
		}
		return year;
	}
	public static int countElectives(String hours) {
		int numberOfElectives = Integer.parseInt(hours);
		if(numberOfElectives > 0)
			numberOfElectives = numberOfElectives / StudentFieldsConstants.ELECTIVE_HOURS_DIVISOR.getValue();
		return numberOfElectives;
	}
}