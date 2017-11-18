package hanson;

public class WorkoutStep {

	private String what;
	private int minDistance;
	private int maxDistance;
	public WorkoutStep(String what) {
		this(what,0);
	}
	public WorkoutStep(String what, int m) {
		this(what,m,m);
	}
	public WorkoutStep(String what, int minMeter, int maxMeter) {
		this.what = what;
		this.minDistance=minMeter;
		this.maxDistance=maxMeter;
	}

	public String toString() {
		return what;
	}
	
	public int minDistance() { return minDistance; }
	public int maxDistance() { return maxDistance; }
}
