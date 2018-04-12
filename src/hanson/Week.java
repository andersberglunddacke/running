package hanson;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Week {

	private int n;
	private List<Workout> workouts = new ArrayList<Workout>();
	private LocalDate date;
	private EquivalentPace paces;

	public Week(Program program, int i) {
		this.n = i;
		program.add(this);
		this.paces = program.getPaces();
	}

	public Workout mon() {
		return new Workout(this, DayOfWeek.MONDAY, paces);
	}

	public Workout tue() {
		return new Workout(this, DayOfWeek.TUESDAY,paces);
	}

	public Workout wed() {
		return new Workout(this, DayOfWeek.WEDNESDAY,paces);
	}

	public Workout thu() {
		return new Workout(this, DayOfWeek.THURSDAY,paces);
	}

	public Workout fri() {
		return new Workout(this, DayOfWeek.FRIDAY,paces);
	}

	public Workout sat() {
		return new Workout(this, DayOfWeek.SATURDAY,paces);
	}

	public Workout sun() {
		return new Workout(this, DayOfWeek.SUNDAY,paces);
	}

	public void add(Workout workout) {
		workouts.add(workout);
	}

	public String toString() {
		String howlong = getHowLong();
		String header = "\nV" + n + " "+date+" (" + howlong + " km):\n";
		String content = workouts.stream().map(Workout::toString).collect(Collectors.joining("\n"));
		return header + content;
	}

	private String getHowLong() {
		double minKM = 0.001 * workouts.stream().mapToInt(Workout::minDistance).sum();
		double maxKM = 0.001 * workouts.stream().mapToInt(Workout::maxDistance).sum();
		String howlong = (minKM != maxKM) ? String.format("%.1f-%.1f", minKM, maxKM) : String.format("%.1f", minKM);
		return howlong;
	}
	
	public int n() {
		return n;
	}

	public void setStart(LocalDate date) {
		this.date = date;
	}
	
	public LocalDate getStart() {
		return this.date;
	}

	public void generateExcelRow(Workbook wb, Sheet sheet, Row row) {
		CellStyle cs = wb.createCellStyle();
		//cs.setWrapText(true);
		
		WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
		int weekNumber = date.get(weekFields.weekOfWeekBasedYear());
		row.createCell(0).setCellValue("V"+weekNumber+"\n"+getHowLong()+" km");
		
		int height = 1;
		for(DayOfWeek dow:DayOfWeek.values()) {
			Cell dayCell = row.createCell(dow.getValue());
			for(Workout workout:workouts) {
				if (workout.getDayOfWeek()==dow) {
					String text = workout.toExcelCell();

					dayCell.setCellValue(text);
					dayCell.setCellStyle(cs);
					
					height = Math.max(height, text.split("\n").length);

				}
			}
		}
		
		
		//increase row height to accomodate two lines of text
		row.setHeightInPoints((height * sheet.getDefaultRowHeightInPoints()));
	}
}
