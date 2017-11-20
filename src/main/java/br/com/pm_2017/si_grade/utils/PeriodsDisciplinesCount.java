package br.com.pm_2017.si_grade.utils;

public class PeriodsDisciplinesCount {
	private final static int[] disciplinesCount = {0,6,6,7,6,7,6,6,7};
	
	public static int countDisciplinesAttendedUntilNow(int periodsCount) {
		int count = 0;
		if(periodsCount <= 8 & periodsCount >= 0) {
			for(int i = 0; i <= periodsCount; i++)
				count += disciplinesCount[i];
		}else
			return -1;
		return count;
	}
	public static int countMissingDisciplines(int periodsToGo) {
		int count = 0;
		if(periodsToGo <= 8 & periodsToGo >= 0) {
			for(int i = 8; i > (8 - periodsToGo); i--)
				count += disciplinesCount[i];
		}else
			return -1;
		return count;
	}
	public static void main( String... args ) {
		System.out.println(countDisciplinesAttendedUntilNow(2));
		System.out.println(countMissingDisciplines(2));
		System.out.println(countDisciplinesAttendedUntilNow(3));
		System.out.println(countMissingDisciplines(3));
		System.out.println(countDisciplinesAttendedUntilNow(8));
		System.out.println(countMissingDisciplines(8));
		System.out.println(countDisciplinesAttendedUntilNow(9));
		System.out.println(countMissingDisciplines(9));
		System.out.println(countDisciplinesAttendedUntilNow(0));
		System.out.println(countMissingDisciplines(0));
		System.out.println(countDisciplinesAttendedUntilNow(-1));
		System.out.println(countMissingDisciplines(-1));
	}
}
