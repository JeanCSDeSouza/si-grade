package br.com.pm_2017.si_grade.configuration;

import java.io.File;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.pm_2017.si_grade.exceptions.EmptyCollectionException;
import br.com.pm_2017.si_grade.exceptions.StudentException;
import br.com.pm_2017.si_grade.utils.ExceptionConstants;

public class ConfigurationImpl implements Configuration{
	public String getRuleConfigutarion(int year) {
		ListRuleConfiguration lrc = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ListRuleConfiguration.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			lrc = (ListRuleConfiguration) jaxbUnmarshaller.unmarshal(new File("Configuration-Rules.xml"));
		} catch (JAXBException jaxbe) {
			jaxbe.getMessage();
		}
		if(lrc == null || lrc.getRulesConfiguration().isEmpty() || lrc.getRulesConfiguration().isEmpty())
			throw new EmptyCollectionException(ExceptionConstants.RULES_CONFIGURATION_LIST.getMessage());
		Optional<RuleConfiguration> rl = lrc.getRulesConfiguration().stream()
		.filter( value -> ( ( value.getStart() <= year ) && ( year <=value.getEnd() ))).findFirst();
		if(rl.isPresent())
			return rl.get().getFlag();
		else
			throw new StudentException(ExceptionConstants.STUDENT_REGISTRY_YEAR_LESS_NOT_RECONIZED.getMessage());
	}
}
