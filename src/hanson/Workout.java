package hanson;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Workout {

	private DayOfWeek dayOfWeek;
	private List<WorkoutStep> workoutSteps = new ArrayList<WorkoutStep>();
	private Week week;
	private EquivalentPace paces;

	public Workout(Week week, DayOfWeek dayOfWeek, EquivalentPace paces) {
		week.add(this);
		this.week = week;
		this.dayOfWeek = dayOfWeek;
		this.paces = paces;
	}

	public Workout dwu1() {
		workoutSteps.add(new WorkoutStep("DWU1"));
		return this;
	}

	public Workout easyMiles(int miles) {
		int m = mi2m(miles);
		workoutSteps.add(new WorkoutStep(String.format("Lugnt %.1f km @ %s-%s", m * 0.001, paces.paceEasyAerobicB().replaceAll(" min/km", ""),paces.paceEasyAerobicA()), m));
		return this;
	}

	public Workout lsflex() {
		workoutSteps.add(new WorkoutStep("LS/Flex"));
		return this;
	}

	public String toString() {
		double minKM = 0.001 * workoutSteps.stream().mapToInt(WorkoutStep::minDistance).sum();
		double maxKM = 0.001 * workoutSteps.stream().mapToInt(WorkoutStep::maxDistance).sum();
		String howlong = (minKM != maxKM) ? String.format("%.1f-%.1f", minKM, maxKM) : String.format("%.1f", minKM);
		String dow = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault());
		String desc = workoutSteps.stream().map(WorkoutStep::toString).collect(Collectors.joining(", "));
		String optDate = "";
		if (this.week.getStart()!=null) {
			LocalDate date = this.week.getStart().plusDays(dayOfWeek.getValue()-1);
			optDate = " "+date.getDayOfMonth()+"/"+date.getMonthValue();
		}
		return String.format("%s%s: %s (%s km)", dow, optDate, desc, howlong);
	}

	public Workout ls() {
		workoutSteps.add(new WorkoutStep("LS"));
		return this;
	}

	public int minDistance() {
		return workoutSteps.stream().mapToInt(WorkoutStep::minDistance).sum();
	}

	public int maxDistance() {
		return workoutSteps.stream().mapToInt(WorkoutStep::maxDistance).sum();
	}

	public Workout bwm() {
		workoutSteps.add(new WorkoutStep("BWM"));
		return this;
	}

	public Workout wu() {
		workoutSteps.add(new WorkoutStep("Uppvärmning 2-5 km", 2000, 5000));
		return this;
	}

	public Workout dwu2() {
		workoutSteps.add(new WorkoutStep("DWU2"));
		return this;
	}

	public Workout speedMeters(int n, int active, int recovery) {
		int distance = (n * active + (n - 1) * recovery);
		workoutSteps.add(new WorkoutStep(String.format("Fart: %dx%dm @ %s m %dm joggvila", n, active, paces.pace10k(),recovery), distance));
		return this;
	}

	public Workout cd() {
		workoutSteps.add(new WorkoutStep("Nerjogg 2-5 km", 2000, 5000));
		return this;
	}

	public Workout tempoMiles(int miles) {
		int m = mi2m(miles);
		workoutSteps.add(new WorkoutStep(String.format("Tempo %.1f km @ %s", m * 0.001,paces.paceM()), m));
		return this;
	}

	public Workout longMiles(int miles) {
		int m = mi2m(miles);
		workoutSteps.add(new WorkoutStep(String.format("Lång %.1f km @ %s", m * 0.001,paces.paceLongRun()), m));
		return this;
	}

	private int mi2m(int miles) {
		return (int) Math.round(miles * 1609.433);
	}

	public Workout rt() {
		workoutSteps.add(new WorkoutStep("RT"));
		return this;
	}

	public Workout strengthMeters(int n, int active, int recovery) {
		int distance = (n * active + (n - 1) * recovery);
		workoutSteps.add(new WorkoutStep(String.format("Styrka: %dx%dm @ %s m %dm joggvila", n, active, paces.paceHM(),recovery), distance));
		return this;
	}

	public Workout race() {
		int distance = 42195;
		workoutSteps.add(new WorkoutStep("RACE @ "+paces.paceM(), distance));
		return this;
	}
	
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public String toExcelCell() {
		double minKM = 0.001 * workoutSteps.stream().mapToInt(WorkoutStep::minDistance).sum();
		double maxKM = 0.001 * workoutSteps.stream().mapToInt(WorkoutStep::maxDistance).sum();
		String howlong = (minKM != maxKM) ? String.format("%.1f-%.1f km", minKM, maxKM) : String.format("%.1f km", minKM);
		if (maxKM==0) {
			howlong="";
		}
		String desc = workoutSteps.stream().map(WorkoutStep::toString).collect(Collectors.joining("\n"));
		String optDate = "";
		if (this.week.getStart()!=null) {
			LocalDate date = this.week.getStart().plusDays(dayOfWeek.getValue()-1);
			optDate = date.getDayOfMonth()+"/"+date.getMonthValue();
		}
		return String.format("%s %s\n%s", optDate, howlong,desc );
	}
}
