package br.com.pm_2017.si_grade.configuration;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
/**
 * Represents the root element of the configuration xml.
 * <p>
 * @author Araragi-san
 */
@XmlRootElement(name="years")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListRuleConfiguration {
    @XmlElement(name="rule")
	List<RuleConfiguration> rulesConfiguration;

	public List<RuleConfiguration> getRulesConfiguration() {
		return rulesConfiguration;
	}

	public void setRulesConfiguration(List<RuleConfiguration> rulesConfiguration) {
		this.rulesConfiguration = rulesConfiguration;
	}

	@Override
	public String toString() {
		return "ListRuleConfiguration [rulesConfiguration=" + rulesConfiguration + "]";
	}
	
}
