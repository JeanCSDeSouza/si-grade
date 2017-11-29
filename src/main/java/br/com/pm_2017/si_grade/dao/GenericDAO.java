package br.com.pm_2017.si_grade.dao;

import java.util.List;

import br.com.pm_2017.si_grade.io.SiGradeIO;

/**
 * Encapsulates the logic for IO implemented in this project
 *
 */
public class GenericDAO {
	SiGradeIO svgIo;

	public GenericDAO(String svgPath) {
		this.svgIo = new SiGradeIO(svgPath);
	}

	/**
	 * Return the lines list of a document
	 * 
	 * @return List<String>
	 */
	public List<String> getDocumentStringList() {
		return svgIo.getDocument();
	}

}
