package br.com.pm_2017.si_grade.dao;

import java.io.IOException;
import java.util.List;

import br.com.pm_2017.si_grade.exceptions.PdfProblemException;
import br.com.pm_2017.si_grade.io.PDFIO;

/**
 * Encapsulates the logic for PDFIO implemented in this project
 *
 */
public class PdfDAO {
	PDFIO pdfio;

	public PdfDAO(String pdfPath) {
		this.pdfio = new PDFIO(pdfPath);

	}

	/**
	 * Return the lines list of a document
	 * 
	 * @return List<String>
	 */
	public List<String> getDocumentStringList() {
		return pdfio.getLinesList();
	}

	/**
	 * The PdfBox still needs to call a close method
	 */
	public void closePdfDocument() {
		try {
			pdfio.closeDocument();
		} catch (IOException e) {
			throw new PdfProblemException("No pdf here to close");
		}
	}

}
