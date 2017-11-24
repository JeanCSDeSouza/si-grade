package br.com.pm_2017.si_grade.parser;

import java.util.List;
import java.util.Map;

import br.com.pm_2017.si_grade.model.Student;
import br.com.pm_2017.si_grade.utils.HtmlConstants;
import br.com.pm_2017.si_grade.utils.RuleMessageDescriptor;
import br.com.pm_2017.si_grade.validation.StudentValidator;

public class HtmlParser {
	public static List<String> generateHtmlPage(List<String> html, Student student, Map<String, Boolean> rulesCache,String svgLinesAsString){
		for(int i =0; i < html.size(); i++ ) {
			String htmlLine = html.get(i);
			if(htmlLine.contains(HtmlConstants.SVG_MARKER.getValue()))
				html.set(i, svgLinesAsString);
			if( new StudentValidator().execute(student)) {
				if(htmlLine.contains(HtmlConstants.STUDENT_NAME_PROPERTY.getValue()))
					html.set(i, (htmlLine.replace( HtmlConstants.STUDENT_NAME_PROPERTY.getValue(), student.getName() ) ));	
				else
					if(htmlLine.contains(HtmlConstants.STUDENT_REGISTRY_PROSPERTY.getValue()))
						html.set(i, (htmlLine.replace( HtmlConstants.STUDENT_REGISTRY_PROSPERTY.getValue(), student.getRegistry() ) ));
					else	
						if(htmlLine.contains(HtmlConstants.STUDENT_YEAR_OF_REGISTRY_PROPERTY.getValue()))
							html.set(i, (htmlLine.replace( HtmlConstants.STUDENT_YEAR_OF_REGISTRY_PROPERTY.getValue(), String.valueOf( student.getYearOfRegistry() ) ) ));
						else
							if(htmlLine.contains(HtmlConstants.STUDENT_CRA_PROPERTY .getValue()))
								html.set( i, ( htmlLine.replace( HtmlConstants.STUDENT_CRA_PROPERTY .getValue(), String.valueOf( student.getCra() ) ) ) );
							else
								if(htmlLine.contains(HtmlConstants.STUDENT_PERIODS_CR_PROPERTY .getValue()))
									html.set(i, (htmlLine.replace( HtmlConstants.STUDENT_PERIODS_CR_PROPERTY .getValue(), student.getPeriodsCr().toString() ) ));
								else
									if(htmlLine.contains(HtmlConstants.GRADUATION_TIME_RULE_PROPERTY.getValue())) {
										if(rulesCache.get(RuleMessageDescriptor.GRADUATION_TIME_MESSAGE.getValue()))
											html.set(i, (htmlLine.replace( HtmlConstants.GRADUATION_TIME_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_TRUE.getValue() ) ));
										else
											html.set(i, (htmlLine.replace( HtmlConstants.GRADUATION_TIME_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_FALSE.getValue() ) ));
									}else
										if(htmlLine.contains(HtmlConstants.INTEGRALIZATION_RULE_PROPERTY.getValue())) {
											if(rulesCache.get(RuleMessageDescriptor.INTEGRALIZATION_MESSAGE.getValue()))
												html.set(i, (htmlLine.replace( HtmlConstants.INTEGRALIZATION_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_TRUE.getValue() ) ));
											else
												html.set(i, (htmlLine.replace( HtmlConstants.INTEGRALIZATION_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_FALSE.getValue() ) ));
										}else	
											if(htmlLine.contains(HtmlConstants.INTEGRALIZATION_PLAN_CR_RESPECTED_RULE_PROPERTY.getValue())) {
												if(!rulesCache.get(RuleMessageDescriptor.INTEGRALIZATION_MESSAGE.getValue()))
													html.set(i, (htmlLine.replace( HtmlConstants.INTEGRALIZATION_PLAN_CR_RESPECTED_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_NOT_APPLICABLE.getValue() ) ));
												else	
													if(!(rulesCache.get(RuleMessageDescriptor.INTEGRALIZATION_PLAN_PERIODS_CR_RESPECTED_MESSAGE.getValue())))
														html.set(i, (htmlLine.replace( HtmlConstants.INTEGRALIZATION_PLAN_CR_RESPECTED_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_FALSE.getValue() ) ));
											}if(htmlLine.contains(HtmlConstants.CRA_RULE_PROPERTY.getValue())) {
												if(rulesCache.get(RuleMessageDescriptor.CRA_MESSAGE.getValue()))
													html.set(i, (htmlLine.replace( HtmlConstants.CRA_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_TRUE.getValue() ) ));
												else
													html.set(i, (htmlLine.replace( HtmlConstants.CRA_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_FALSE.getValue() ) ));
											}else
												if(htmlLine.contains(HtmlConstants.REGISTERED_DISCIPLINES_RULE_PROPERTY.getValue())) {
													if(rulesCache.get(RuleMessageDescriptor.REGISTERED_DISCIPLINES_MESSAGE.getValue()))
														html.set(i, (htmlLine.replace( HtmlConstants.REGISTERED_DISCIPLINES_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_TRUE.getValue() ) ));
													else
														html.set(i, (htmlLine.replace( HtmlConstants.REGISTERED_DISCIPLINES_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_FALSE.getValue() ) ));
												}else
													if(htmlLine.contains(HtmlConstants.JUBILATE_RULE_PROPERTY.getValue())) {
														if(rulesCache.get(RuleMessageDescriptor.JUBILATE_MESSAGE.getValue()))
															html.set(i, (htmlLine.replace( HtmlConstants.JUBILATE_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_TRUE.getValue() ) ));
														else
															html.set(i, (htmlLine.replace( HtmlConstants.JUBILATE_RULE_PROPERTY.getValue(), HtmlConstants.RULE_FLAG_FALSE.getValue() ) ));
													}
			}
		}
		return html;
	}
}
