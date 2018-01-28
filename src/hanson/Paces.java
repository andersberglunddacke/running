package hanson;

import java.util.ArrayList;
import java.util.List;

public class Paces {
	public static List<EquivalentPace> getPaces() {
		List<EquivalentPace> result = new ArrayList<EquivalentPace>();
		result.add(new EquivalentPace().m(3, 29, 36).hm(1, 39, 23).k10(44, 40).k5(21, 30));
		result.add(new EquivalentPace().m(3, 24, 43).hm(1, 37, 04).k10(43, 37).k5(21, 0));
		result.add(new EquivalentPace().m(3, 19, 51).hm(1, 34, 46).k10(42, 35).k5(20, 30));
		result.add(new EquivalentPace().m(3, 14, 58).hm(1, 32, 27).k10(41, 33).k5(20, 0));
		result.add(new EquivalentPace().m(3, 10, 06).hm(1, 30, 8).k10(40, 30).k5(19, 30));
		result.add(new EquivalentPace().m(3, 05, 14).hm(1, 27, 50).k10(39, 28).k5(19, 0));
		
		result.add(new EquivalentPace().m(3, 30, 0).recovery(1019).easyAerobicA(941).easyAerobicB(902).longrun(842).tempo(801).strength(751).speed10k(721).speed5k(703));
		return result;
	}

	public static EquivalentPace getPace(int h, int m, int s) {
		int target = EquivalentPace.hms(h, m, s);
		EquivalentPace best = null;
		int bestDiff = Integer.MAX_VALUE;
		for (EquivalentPace ep : getPaces()) {
			int thisDiff = target - ep.getMarathonSecs();
			if (thisDiff > 0 && thisDiff < bestDiff) {
				bestDiff = thisDiff;
				best = ep;
			}
		}
		return best;
	}

	public static void main(String[] args) {
		for (EquivalentPace ep : getPaces()) {
			ep.dump();
		}
		System.out.println();
		getPace(3, 30, 0).dump();
	}
}
