package hanson;

public class EquivalentPace {
	private int k10;
	private int k5;
	private int m;
	private int hm;
	private int recovery;
	private int easyAerobicB;
	private int easyAerobicA;
	private int longrun;

	public EquivalentPace k10(int m, int s) {
		this.k10 = hms(0, m, s);
		return this;
	}

	public EquivalentPace k5(int m, int s) {
		this.k5 = hms(0, m, s);
		return this;
	}

	public EquivalentPace m(int h, int m, int s) {
		this.m = hms(h, m, s);
		return this;
	}

	public EquivalentPace hm(int h, int m, int s) {
		this.hm = hms(h, m, s);
		return this;
	}

	public static int hms(int h, int m, int s) {
		return 3600 * h + 60 * m + s;
	}

	public String pace5k() {
		return pace(k5 / 5);
	}

	public String pace10k() {
		return pace(k10 / 10);
	}

	public String paceHM() {
		return pace((int) Math.round(hm / 21.095));
	}

	public String paceM() {
		return pace((int) Math.round(m / 42.195));
	}

	public String time5k() {
		return time(k5);
	}

	public String time10k() {
		return time(k10);
	}

	public String timeHM() {
		return time(hm);
	}

	public String timeM() {
		return time(m);
	}

	private String time(int secs) {
		if (secs >= 3600) {
			return String.format("%d:%02d:%02d", secs / 3600, (secs / 60) % 60, secs % 60);
		} else {
			return String.format("%d:%02d", secs / 60, secs % 60);
		}
	}

	private String pace(int i) {
		return String.format("%02d:%02d", i / 60, i % 60);
	}

	public int getMarathonSecs() {
		return m;
	}

	public void dump() {
		System.out.println("Marathon: " + timeM());
		if (longrun!=0) {
			System.out.println("  recovery @ " + paceRecovery());
			System.out.println("  easy aerobic A @ " + paceEasyAerobicA());
			System.out.println("  easy aerobic B @ " + paceEasyAerobicB());
			System.out.println("  long run @ " + paceLongRun());
		}
		System.out.println("  marathon @ "+paceM());
		System.out.println("  hm @ "+paceHM() + " = "+ timeHM());
		System.out.println("  10k @ "+pace10k()+ " = "+ time10k() );
		System.out.println("  5k @ " + pace5k() + " = " + time5k());
	}
	public String paceLongRun() {
		return pace(longrun);
	}
	public String paceRecovery() {
		return pace(recovery);
	}
	public String paceEasyAerobicA() {
		return pace(easyAerobicB);
	}
	public String paceEasyAerobicB() {
		return pace(easyAerobicA);
	}
	
	public EquivalentPace recovery(int paceMPM) {
		recovery=(int) Math.round(secPerKm(paceMPM));
		return this;
	}

	public EquivalentPace easyAerobicA(int paceMPM) {
		easyAerobicB=(int) Math.round(secPerKm(paceMPM));
		return this;
	}
	public EquivalentPace easyAerobicB(int paceMPM) {
		easyAerobicA=(int) Math.round(secPerKm(paceMPM));
		return this;
	}

	public EquivalentPace longrun(int paceMPM) {
		longrun=(int) Math.round(secPerKm(paceMPM));
		return this;
	}

	public EquivalentPace tempo(int paceMPM) {
		m=(int) Math.round(secPerKm(paceMPM)*42.195);
		return this;
	}

	private double secPerKm(int paceMPM) {
		int secsPerMile = paceMPM%100+60*(paceMPM/100);
		return secsPerMile/1.609344;
	}

	public EquivalentPace strength(int paceMPM) {
		hm=(int) Math.round(secPerKm(paceMPM)*21.095);
		return this;
	}

	public EquivalentPace speed10k(int paceMPM) {
		k10=(int) Math.round(secPerKm(paceMPM)*10);
		return this;
	}
	
	public EquivalentPace speed5k(int paceMPM) {
		k5=(int) Math.round(secPerKm(paceMPM)*5);
		return this;
	}
}
