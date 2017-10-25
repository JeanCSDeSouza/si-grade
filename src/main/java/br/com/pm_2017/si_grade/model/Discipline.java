package br.com.pm_2017.si_grade.model;

public class Discipline {
	private String codigo;
	private boolean situacao;
	
	public Discipline(String codigo, boolean situacao) {
		super();
		this.codigo = codigo;
		this.situacao = situacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public boolean getSituacao() {
		return situacao;
	}
	
	
}
