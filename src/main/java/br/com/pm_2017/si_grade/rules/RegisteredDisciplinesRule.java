package br.com.pm_2017.si_grade.rules;


import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.exceptions.StudentNullException;
import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.DisciplineConstants;
import br.com.pm_2017.si_grade.utils.DisciplineStatus;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;

public class RegisteredDisciplinesRule {

	public boolean rule(Student student) {
		if(student == null)
			throw new StudentNullException(ExceptionConstants.STUDENT_NULL.getMessage());

		if(student.getDisciplines().isEmpty()) 
			throw new EmptyCollectionException(ExceptionConstants.STUDENT_MAP_EMPTY.getMessage());
		
		if(hasAtLeast3Remaining(student)) 
			return (attending(student) >= 3) ? true : false;
		
		return true;
	}

	public boolean hasAtLeast3Remaining(Student student) {
		return (remaining(student) >= 3 ) ? true : false;
	}
	
	public int remaining(Student student) {
		int numberDisciplines = student.getDisciplines().size() - attending(student);
		int totalDisciplines = DisciplineConstants.TOTAL_NUMBER_DISCIPLINES.getValue();
		
		int remainingDisciplines = totalDisciplines - numberDisciplines;
		
		return remainingDisciplines;
	}
	
	public int attending(Student student) {
		int count = 0;
		
		for(Discipline discipline : student.getDisciplines().values()) 
			if(discipline.getSituation() == DisciplineStatus.MATRICULA.getStatus())
				count++;
		
		return count;
	}
}
