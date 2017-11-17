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
			week.fri().easyMiles(3).ls();
			week.sat().dwu1().easyMiles(5).lsflex();
			week.sun().dwu1().easyMiles(5).lsflex();
		}
		{
			Week week = program.week(5);
			week.tue().dwu1().easyMiles(5).bwm().ls();
			week.thu().dwu1().easyMiles(4).lsflex();
			week.fri().easyMiles(5).ls();
			week.sat().dwu1().easyMiles(4).lsflex();
			week.sun().dwu1().easyMiles(6).lsflex();
		}
		System.out.println(program.toString());
	}
}
