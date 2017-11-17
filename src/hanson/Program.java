package hanson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	private List<Week> weeks=new ArrayList<Week>();

	public Week week(int i) {
		Week week = new Week(this,i);
		return week;
	}

	public void add(Week week) {
		weeks.add(week);
	}

	public String toString() {
		return weeks.stream().map(Week::toString).collect(Collectors.joining("\n"));
	}
}
