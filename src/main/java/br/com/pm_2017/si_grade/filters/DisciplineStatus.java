package br.com.pm_2017.si_grade.filters;

public enum DisciplineStatus {
	DISPENSA_SEM_NOTA("DIS - Dispensa sem nota", true),
	DISPENSA_COM_NOTA("DIS - Dispensa com nota", true),
	APROVADO("APV- Aprovado", true),
	REPROVADO("RPV- Reprovado", false);
	
	private String statusName;
	private boolean status;
	
	DisciplineStatus(String statusName, boolean status) {
		this.statusName = statusName;
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public boolean isStatus() {
		return status;
	}
}
