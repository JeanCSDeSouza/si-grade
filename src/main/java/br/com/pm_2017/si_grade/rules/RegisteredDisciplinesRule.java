package br.com.pm_2017.si_grade.rules;


import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.exceptions.StudentNullException;
import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.strategy.Strategy;
import br.com.pm_2017.si_grade.utils.CurricularGradeConstants;
import br.com.pm_2017.si_grade.utils.DisciplineStatus;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;

public class RegisteredDisciplinesRule implements Strategy{

	public boolean execute(Student student) {
		if(student == null)
			throw new StudentNullException(ExceptionConstants.STUDENT_NULL.getMessage());

		if(student.getDisciplines().isEmpty()) 
			throw new EmptyCollectionException(ExceptionConstants.STUDENT_MAP_EMPTY.getMessage());
		
		if(hasAtLeast3Remaining(student)) 
			return (student.attending() >= 3) ? true : false;
		
		return true;
	}

	public boolean hasAtLeast3Remaining(Student student) {
		return (student.remaining() >= 3 ) ? true : false;
	}
}
