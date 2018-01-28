package hanson;

import java.time.LocalDate;

public class BeginnersProgram {
	public static void main(String[] args) {
		Program program = new Program();
		program.setPaces(Paces.getPace(3, 30, 12));
		
		{
			Week week = program.week(1);
			week.thu().dwu1().easyMiles(3).lsflex();
			week.sat().easyMiles(3);
			week.sun().dwu1().easyMiles(4).lsflex();
		}
		{
			Week week = program.week(2);
			week.tue().easyMiles(2);
			week.thu().dwu1().easyMiles(3).lsflex();
			week.fri().dwu1().easyMiles(3).ls();
			week.sat().dwu1().easyMiles(3).lsflex();
			week.sun().dwu1().easyMiles(4).lsflex();
		}
		{
			Week week = program.week(3);
			week.tue().easyMiles(4);
			week.thu().dwu1().easyMiles(4).lsflex();
			week.fri().easyMiles(4).ls();
			week.sat().dwu1().easyMiles(4).lsflex();
			week.sun().dwu1().easyMiles(5).lsflex();
		}
		{
			Week week = program.week(4);
			week.tue().dwu1().easyMiles(5).bwm().ls();
			week.thu().dwu1().easyMiles(3).lsflex();
			week.fri().dwu1().easyMiles(3).ls();
			week.sat().dwu1().easyMiles(5).lsflex();
			week.sun().dwu1().easyMiles(5).lsflex();
		}
		{
			Week week = program.week(5);
			week.tue().dwu1().easyMiles(5).bwm().ls();
			week.thu().dwu1().easyMiles(4).lsflex();
			week.fri().dwu1().easyMiles(5).ls();
			week.sat().dwu1().easyMiles(4).lsflex();
			week.sun().dwu1().easyMiles(6).lsflex();
		}
		{
			Week week = program.week(6);
			week.mon().dwu1().easyMiles(4).lsflex();
			week.tue().dwu1().wu().dwu2().speedMeters(12, 400, 400).cd();
			week.wed().dwu1().bwm().lsflex();
			week.thu().dwu1().wu().dwu2().tempoMiles(5).cd();
			week.fri().dwu1().easyMiles(4).bwm().lsflex();
			week.sat().dwu1().easyMiles(8).bwm().lsflex();
			week.sun().dwu1().easyMiles(8).lsflex();
		}
		{
			Week week = program.week(7);
			week.mon().dwu1().easyMiles(4).lsflex();
			week.tue().dwu1().wu().dwu2().speedMeters(8, 600, 400).cd();
			week.wed().dwu1().rt().lsflex();
			week.thu().dwu1().wu().dwu2().tempoMiles(5).cd();
			week.fri().dwu1().easyMiles(4).bwm().lsflex();
			week.sat().dwu1().easyMiles(6).bwm().lsflex();
			week.sun().dwu1().longMiles(10).lsflex();
		}
		{
			Week week = program.week(8);
			week.mon().dwu1().easyMiles(6).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().speedMeters(6, 800, 400).cd();
			week.wed().dwu1().rt().lsflex();
			week.thu().dwu1().wu().dwu2().tempoMiles(5).cd();
			week.fri().dwu1().easyMiles(5).bwm().lsflex();
			week.sat().dwu1().easyMiles(6).bwm().lsflex();
			week.sun().dwu1().longMiles(10).lsflex();
		}
		{
			Week week = program.week(9);
			week.mon().dwu1().easyMiles(5).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().speedMeters(5, 1000, 400).cd();
			week.wed().dwu1().rt().lsflex();
			week.thu().dwu1().wu().dwu2().tempoMiles(8).cd();
			week.fri().dwu1().easyMiles(6).bwm().lsflex();
			week.sat().dwu1().easyMiles(5).bwm().lsflex();
			week.sun().dwu1().longMiles(15).ls();
		}
		{
			Week week = program.week(10);
			week.mon().dwu1().easyMiles(7).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().speedMeters(4, 1200, 400).cd();
			week.wed().dwu1().rt().ls();
			week.thu().dwu1().wu().dwu2().tempoMiles(8).cd();
			week.fri().dwu1().easyMiles(5).bwm().lsflex();
			week.sat().dwu1().easyMiles(8).bwm().lsflex();
			week.sun().dwu1().longMiles(10).ls();
		}
		{
			Week week = program.week(11);
			week.mon().dwu1().easyMiles(5).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().strengthMeters(6, 1600, 400).cd();
			week.wed().dwu1().rt().ls();
			week.thu().dwu1().wu().dwu2().tempoMiles(8).cd();
			week.fri().dwu1().easyMiles(5).bwm().lsflex();
			week.sat().dwu1().easyMiles(8).bwm().lsflex();
			week.sun().dwu1().longMiles(16).ls();
		}
		{
			Week week = program.week(12);
			week.mon().dwu1().easyMiles(5).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().strengthMeters(4, 2400, 800).cd();
			week.wed().dwu1().rt().ls();
			week.thu().dwu1().wu().dwu2().tempoMiles(9).cd();
			week.fri().dwu1().easyMiles(5).bwm().lsflex();
			week.sat().dwu1().easyMiles(8).bwm().rt().lsflex();
			week.sun().dwu1().longMiles(10).ls();
		}
		{
			Week week = program.week(13);
			week.mon().dwu1().easyMiles(7).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().strengthMeters(3, 3200, 800).cd();
			week.wed().dwu1().rt().ls();
			week.thu().dwu1().wu().dwu2().tempoMiles(9).cd();
			week.fri().dwu1().easyMiles(6).bwm().lsflex();
			week.sat().dwu1().easyMiles(6).bwm().lsflex();
			week.sun().dwu1().longMiles(16).ls();
		}
		{
			Week week = program.week(14);
			week.mon().dwu1().easyMiles(5).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().strengthMeters(2, 4800, 1600).cd();
			week.wed().dwu1().rt().ls();
			week.thu().dwu1().wu().dwu2().tempoMiles(9).cd();
			week.fri().dwu1().easyMiles(5).bwm().lsflex();
			week.sat().dwu1().easyMiles(8).bwm().rt().lsflex();
			week.sun().dwu1().longMiles(10).ls();
		}
		{
			Week week = program.week(15);
			week.mon().dwu1().easyMiles(7).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().strengthMeters(3, 3200, 800).cd();
			week.wed().dwu1().rt().ls();
			week.thu().dwu1().wu().dwu2().tempoMiles(10).cd();
			week.fri().dwu1().easyMiles(6).bwm().lsflex();
			week.sat().dwu1().easyMiles(6).bwm().lsflex();
			week.sun().dwu1().longMiles(16).ls();
		}
		{
			Week week = program.week(16);
			week.mon().dwu1().easyMiles(5).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().strengthMeters(4, 2400, 800).cd();
			week.wed().dwu1().rt().ls();
			week.thu().dwu1().wu().dwu2().tempoMiles(10).cd();
			week.fri().dwu1().easyMiles(5).bwm().lsflex();
			week.sat().dwu1().easyMiles(8).bwm().rt().lsflex();
			week.sun().dwu1().longMiles(10).ls();
		}
		{
			Week week = program.week(17);
			week.mon().dwu1().easyMiles(7).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().strengthMeters(6, 1600, 400).cd();
			week.wed().dwu1().rt().ls();
			week.thu().dwu1().wu().dwu2().tempoMiles(10).cd();
			week.fri().dwu1().easyMiles(6).bwm().lsflex();
			week.sat().dwu1().easyMiles(6).bwm().lsflex();
			week.sun().dwu1().longMiles(8).ls();
		}
		{
			Week week = program.week(18);
			week.mon().dwu1().easyMiles(5).ls();
			week.tue().dwu1().easyMiles(5).ls();
			week.thu().dwu1().dwu1().easyMiles(6).ls();
			week.fri().dwu1().easyMiles(5).bwm().lsflex();
			week.sat().dwu1().easyMiles(3).ls();
			week.sun().race();
		}
		
		program.programEnd(LocalDate.of(2018, 5, 13));
		System.out.println(program.toString());
	}
}
