package hanson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Program {

	private List<Week> weeks = new ArrayList<Week>();
	private EquivalentPace paces;

	public Week week(int i) {
		Week week = new Week(this, i);
		return week;
	}

	public void add(Week week) {
		weeks.add(week);
	}

	public String toString() {
		return weeks.stream().map(Week::toString).collect(Collectors.joining("\n"));
	}
	
	public void programEnd(LocalDate date) {
		while(date.getDayOfWeek()!=DayOfWeek.MONDAY) {
			date = date.minusDays(1);
		}
		for(Week w:weeks) {
			LocalDate start = date.minusWeeks(weeks.size()).plusWeeks(w.n());
			w.setStart(start);
		}
	}

	public void setPaces(EquivalentPace paces) {
		this.paces = paces;
	}
	
	public EquivalentPace getPaces() {
		return paces;
	}

	public void asExcel(String outFile) {
		Workbook wb = new XSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("Beginner's Program");

		short rowIx = 0;
		Row row;

		// Timestamp
		row = sheet.createRow(rowIx++);
		
		for(DayOfWeek dow:DayOfWeek.values()) {
			row.createCell(dow.getValue()).setCellValue(dow.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("se")));
			  //adjust column width to fit the content
             sheet.autoSizeColumn(dow.getValue());
		}
		for(Week week:weeks) {
			row = sheet.createRow(rowIx++);
			week.generateExcelRow(wb,sheet,row);	
		}
		
		try {
			FileOutputStream fileOut = new FileOutputStream(outFile);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			wb.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Wrote file "+outFile);
	}
}
