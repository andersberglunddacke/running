package hanson;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Workout {

	private DayOfWeek dayOfWeek;
	private List<WorkoutStep> workoutSteps = new ArrayList<WorkoutStep>();
private int distance = 0;

	public Workout(Week week, DayOfWeek dayOfWeek) {
		week.add(this);
		this.dayOfWeek = dayOfWeek;
	}

	public Workout dwu1() {
		workoutSteps.add(new WorkoutStep("DWU1"));
		return this;
	}

	public Workout easyMiles(int miles) {
		int km = (int)Math.round(miles*1.609433);
		distance += km;
		workoutSteps.add(new WorkoutStep(String.format("Easy %d km",km)));
		return this;
	}

	public Workout lsflex() {
		workoutSteps.add(new WorkoutStep("LS/Flex"));
		return this;
	}
	
	public String toString() {
		return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())+": "+workoutSteps.stream().map(WorkoutStep::toString).collect(Collectors.joining(", "));
	}

	public Workout ls() {
		workoutSteps.add(new WorkoutStep("LS"));	
		return this;
	}
	
	public int distance() {
		return distance;
	}

	public Workout bwm() {
		workoutSteps.add(new WorkoutStep("BWM"));		
		return this;
	}
}
