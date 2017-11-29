package br.com.pm_2017.si_grade.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Contains the sets of disciplines used for categorize disciplines
 */
public class DisciplineCodHelper {
	public static final String[] MANDATORY_LIST = new String[] { "TIN0107", "TIN0011", "TIN0114", "TIN0168", "TIN0118",
			"TIN0106", "TIN0013", "TIN0120", "TIN0130", "TIN0112", "TIN0110", "TIN0115", "TIN0169", "TIN0117",
			"TIN0131", "TIN0108", "TME0015", "TIN0116", "TIN0123", "TIN0126", "TIN0125", "TIN0133", "HTD0058",
			"TIN0105", "TIN0109", "TIN0119", "TIN0171", "TIN0121", "TIN0122", "TIN0132", "TME0101", "TME0112",
			"TME0113", "TME0115", "TIN0054", "TIN0055", "TIN0056", "TIN0057", "TME0114" };
	public static final Set<String> MANDATORY_DISCIPLINES = new HashSet<>(Arrays.asList(MANDATORY_LIST));
	public static final String[] OPTIONAL_LIST = new String[] { "TIN0135", "TIN0144", "TIN0150", "TIN0146", "TIN0149",
			"TIN0138", "TIN0158", "TIN0143", "TIN0147", "TIN0136", "TIN0160", "TIN0128", "TIN0172", "TIN0142",
			"TIN0159", "TIN0148", "TIN0145", "TIN0137", "TIN0162", "TIN0161", "TIN0166", "TIN0141", "TIN0164",
			"TIN0165" };
	public static final Set<String> OPTIONAL_DISCIPLINES = new HashSet<>(Arrays.asList(OPTIONAL_LIST));

	public static final String TRANCAMENTO_GERAL = "TRT0001";

}
