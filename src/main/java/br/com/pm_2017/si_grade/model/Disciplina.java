package br.com.pm_2017.si_grade.model;

public class Disciplina {
	private String codigo;
	private String situacao;
	
	public Disciplina(String codigo, String situacao) {
		super();
		this.codigo = codigo;
		this.situacao = situacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getSituacao() {
		return situacao;
	}
	
	
}
