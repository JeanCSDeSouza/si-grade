package br.com.pm_2017.si_grade.configuration;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="rule")
@XmlAccessorType(XmlAccessType.FIELD)
public class RuleConfiguration {
	private int start;
	private int end;
	private String flag;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "RulePeriod [start=" + start + ", end=" + end + ", flag=" + flag + "]";
	}
	
	
}
