package hanson;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		double minKM = 0.001 * workouts.stream().mapToInt(Workout::minDistance).sum();
		double maxKM = 0.001 * workouts.stream().mapToInt(Workout::maxDistance).sum();
		String howlong = (minKM != maxKM) ? String.format("%.1f-%.1f", minKM, maxKM) : String.format("%.1f", minKM);
		String header = "\nV" + n + " "+date+" (" + howlong + " km):\n";
		String content = workouts.stream().map(Workout::toString).collect(Collectors.joining("\n"));
		return header + content;
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
}
