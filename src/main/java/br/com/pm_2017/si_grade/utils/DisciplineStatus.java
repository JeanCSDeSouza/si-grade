package br.com.pm_2017.si_grade.utils;

/** 
 * This class represents the status of a disciplines with 
 * Approved(1), Reproved(0), Registered(-1), locked(-2). 
 * Dispensation also counts as approved.
 * <p>
 */
public enum DisciplineStatus {
	DISPENSA_SEM_NOTA("DIS - Dispensa sem nota", 1),
	DISPENSA_COM_NOTA("DIS - Dispensa com nota", 1),
	APROVADO("APV- Aprovado", 1),
	MATRICULA("ASC - Matrícula", -1),
	REPROVADO("RPV- Reprovado", 0),
	REPROVADO_SEM_NOTA("ASC - Reprovado sem nota ", 0),
	TRANCADO("TRA - Trancamento", -2);
	
	private String statusName;
	private int status;
	
	DisciplineStatus( String statusName, int status ) {
		this.statusName = statusName;
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public int getStatus() {
		return status;
	}
}
