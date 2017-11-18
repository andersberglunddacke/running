package hanson;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Week {

	private int n;
	private List<Workout> workouts=new ArrayList<Workout>();

	public Week(Program program, int i) {
		this.n = i;
		program.add(this);
	}

	public Workout mon() {
		return new Workout(this, DayOfWeek.MONDAY);
	}

	public Workout tue() {
		return new Workout(this, DayOfWeek.TUESDAY);
	}

	public Workout wed() {
		return new Workout(this, DayOfWeek.WEDNESDAY);
	}

	public Workout thu() {
		return new Workout(this, DayOfWeek.THURSDAY);
	}

	public Workout fri() {
		return new Workout(this, DayOfWeek.FRIDAY);
	}

	public Workout sat() {
		return new Workout(this, DayOfWeek.SATURDAY);
	}

	public Workout sun() {
		return new Workout(this, DayOfWeek.SUNDAY);
	}

	public void add(Workout workout) {
		workouts.add(workout);	
	}

	public String toString() {
		double minKM = 0.001*workouts.stream().mapToInt(Workout::minDistance).sum();
		double maxKM = 0.001*workouts.stream().mapToInt(Workout::maxDistance).sum();
		String howlong = (minKM!=maxKM) ? String.format("%.1f-%.1f", minKM,maxKM):String.format("%.1f", minKM);
		String header = "\nV"+n+" ("+howlong+" km):\n";
		String content = workouts.stream().map(Workout::toString).collect(Collectors.joining("\n"));
		return header +content;
	}
}
