package hanson;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
}
