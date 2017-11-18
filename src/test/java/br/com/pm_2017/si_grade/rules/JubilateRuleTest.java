package br.com.pm_2017.si_grade.rules;



import java.util.HashMap;
import java.util.Map;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

import br.com.pm_2017.si_grade.model.Discipline;
import br.com.pm_2017.si_grade.model.Student;

public class JubilateRuleTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	JubilateRule jb;
	
	Map<String, Discipline> disciplines;
	
	
	@Before
	public void setUp( ) throws Exception {
		jb = new JubilateRule();				
	}
	
	@Test
	public void JubilateRuleTrueTest( ) {
		disciplines = new HashMap<String, Discipline>( );
		Discipline discipline = mock( Discipline.class );
		Student student = mock( Student.class );
		
		Mockito.when( student.getDisciplines( ) ).thenReturn(disciplines);
		Mockito.when( student.getCra( ) ).thenReturn( ( float ) 3.9 );
		
		Mockito.when( discipline.getSituation( ) ).thenReturn(1);
		Mockito.when( discipline.getTimesAttended( ) ).thenReturn( 5 );
		Mockito.when( discipline.getCode( ) ).thenReturn( "TIN0202" );
		
		disciplines.put( discipline.getCode(), discipline );
		
		assertEquals( "Failure - should be true", true, jb.isJubilate( student ) );
		
		Mockito.when( student.getCra( ) ).thenReturn( ( float ) 3.9 );
		Mockito.when( discipline.getTimesAttended( ) ).thenReturn( 4 );
		Mockito.when( discipline.getSituation( ) ).thenReturn( 0 );
		assertEquals( "Failure - should be true", true, jb.isJubilate( student ) );
	}
}
