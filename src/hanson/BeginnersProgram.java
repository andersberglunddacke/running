package hanson;

public class BeginnersProgram {
	public static void main(String[] args) {
		Program program = new Program();
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
			week.tue().dwu1().wu().dwu2().speedMeters(12,400,400).cd();
			week.wed().dwu1().bwm().lsflex();
			week.thu().dwu1().wu().dwu2().tempoMiles(5).cd();
			week.fri().dwu1().easyMiles(4).bwm().lsflex();
			week.sat().dwu1().easyMiles(8).bwm().lsflex();
			week.sun().dwu1().easyMiles(8).lsflex();
		}
		{
			Week week = program.week(7);
			week.mon().dwu1().easyMiles(4).lsflex();
			week.tue().dwu1().wu().dwu2().speedMeters(8,600,400).cd();
			week.wed().dwu1().rt().lsflex();
			week.thu().dwu1().wu().dwu2().tempoMiles(5).cd();
			week.fri().dwu1().easyMiles(4).bwm().lsflex();
			week.sat().dwu1().easyMiles(6).bwm().lsflex();
			week.sun().dwu1().longMiles(10).lsflex();
		}
		{
			Week week = program.week(8);
			week.mon().dwu1().easyMiles(6).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().speedMeters(6,800,400).cd();
			week.wed().dwu1().rt().lsflex();
			week.thu().dwu1().wu().dwu2().tempoMiles(5).cd();
			week.fri().dwu1().easyMiles(5).bwm().lsflex();
			week.sat().dwu1().easyMiles(6).bwm().lsflex();
			week.sun().dwu1().longMiles(10).lsflex();
		}
		{
			Week week = program.week(9);
			week.mon().dwu1().easyMiles(5).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().speedMeters(5,1000,400).cd();
			week.wed().dwu1().rt().lsflex();
			week.thu().dwu1().wu().dwu2().tempoMiles(8).cd();
			week.fri().dwu1().easyMiles(6).bwm().lsflex();
			week.sat().dwu1().easyMiles(5).bwm().lsflex();
			week.sun().dwu1().longMiles(15).ls();
		}
		{
			Week week = program.week(10);
			week.mon().dwu1().easyMiles(7).bwm().lsflex();
			week.tue().dwu1().wu().dwu2().speedMeters(4,1200,400).cd();
			week.wed().dwu1().rt().ls();
			week.thu().dwu1().wu().dwu2().tempoMiles(8).cd();
			week.fri().dwu1().easyMiles(5).bwm().lsflex();
			week.sat().dwu1().easyMiles(8).bwm().lsflex();
			week.sun().dwu1().longMiles(10).ls();
		}
		System.out.println(program.toString());
	}
}
