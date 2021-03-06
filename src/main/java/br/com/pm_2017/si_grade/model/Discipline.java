package br.com.pm_2017.si_grade.model;

/**
 * Represents the disciplines of the S.I course, used to count how many times
 * the student has done the disciplines and comparison reasons
 * <p>
 */
public class Discipline {
	private String code;
	private int situation;
	private int type;
	private int timesAttended;
	private int timesFailure;

	public Discipline() {
	}

	public Discipline(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public int getSituation() {
		return situation;
	}

	public void setSituation(int situation) {
		this.situation = situation;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getTimesAttended() {
		return timesAttended;
	}

	public void setTimesAttended(int timesAttended) {
		this.timesAttended = timesAttended;
	}

	/**
	 * increases the number of times a disciplines was coursed in 1
	 */
	public void attempt() {
		this.timesAttended++;
	}

	@Override
	public String toString() {
		return "Discipline [code=" + code + ", situation=" + situation + ", type=" + type + ", timesAttended="
				+ timesAttended + ", timesFailure=" + timesFailure + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	/**
	 * compares disciplines by code
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Discipline other = (Discipline) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	public int getTimesFailure() {
		return timesFailure;
	}

	public void setTimesFailure(int timesFailure) {
		this.timesFailure = timesFailure;
	}

	public void fail() {
		this.timesFailure++;
	}
}
