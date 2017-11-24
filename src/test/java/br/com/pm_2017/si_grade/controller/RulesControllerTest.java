package br.com.pm_2017.si_grade.controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;

public class RulesControllerTest {
	/*@Rule
	public ExpectedException thrown = ExpectedException.none();
	RulesController rc; 
	@Before
	public void setUp() {
		rc = new RulesController(); 
	}
	@SuppressWarnings("unchecked")
	@Test
	public void IntegralizationRuleTrueTest() {
		List<Float> periodsCr = mock(ArrayList.class);
		when(periodsCr.get(anyInt())).thenReturn((float)5.00);
		when(periodsCr.size()).thenReturn(8);
		Discipline discipline = mock(Discipline.class);
		when(discipline.getCode()).thenReturn("TIN1122");
		when(discipline.getSituation()).thenReturn(1);
		Map<String, Discipline> disciplines = mock(HashMap.class);
		when(disciplines.get(anyString())).thenReturn(discipline);
		when(periodsCr.size()).thenReturn(7);
		Student student = mock(Student.class);
		when(student.getYearOfRegistry()).thenReturn(2013);
		when(student.getPeriodsCr()).thenReturn(periodsCr);
		when(student.attending()).thenReturn(6);
		when(student.remaining()).thenReturn(6);
		when(student.getCra()).thenReturn((float)7.0);
		when(student.getRegistry()).thenReturn("11111111111");
		when(student.getDisciplines()).thenReturn(disciplines);
		Map<String, Boolean> rules = rc.generateRuleMap(student);
		assertNotNull(rules);
		rules.forEach( (k , v) -> System.out.println("Key: " + k + " com o valor: " + v));
		//assertEquals("Failure - should be true", true, ir.execute(student) );
		//assertEquals("Failure - should be true", true, ir.execute(student) );
	}*/
}
