package br.com.pm_2017.si_grade.model;

public class Disciplina {
	private String codigo;
	private String nomeDisciplina;
	private String Creditos;
	private String cargaHoraria;
	private String media;
	private String frequencia;
	private String situacao;
	
	public Disciplina(String codigo, String nomeDisciplina, String creditos, String cargaHoraria, String media,
			String frequencia, String situacao) {
		super();
		this.codigo = codigo;
		this.nomeDisciplina = nomeDisciplina;
		Creditos = creditos;
		this.cargaHoraria = cargaHoraria;
		this.media = media;
		this.frequencia = frequencia;
		this.situacao = situacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public String getCreditos() {
		return Creditos;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public String getMedia() {
		return media;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public String getSituacao() {
		return situacao;
	}
	
	
}
