package leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		Iterator<Interval> it = intervals.iterator();
		while (it.hasNext()) {
			Iterator<Interval> it2 = result.iterator();
			Interval temp1 = it.next();
			while (it2.hasNext()) {

				Interval temp2 = it2.next();
				int start1 = temp1.start;
				int end1 = temp1.end;
				int start2 = temp2.start;
				int end2 = temp2.end;
				if ((start1 <= end2 && start1 >= start2) || (start2 <= end1 && start2 >= start1)) {
					it2.remove();
					temp1=new Interval(Math.min(start1, start2), Math.max(end1, end2));
					
				}

			}
			result.add(temp1);
		}
		return result;

	}

	public void testLoop() {
		List<Interval> test = new ArrayList<>();
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(2, 3);
		test.add(i1);
		test.add(i2);
		List<Interval> result = merge(test);
		System.out.println(result.get(0).start);
	}

	public static void main(String[] args) {
		MergeIntervals m = new MergeIntervals();
		m.testLoop();

	}

}
