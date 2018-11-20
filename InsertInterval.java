import java.util.ArrayList;
import java.util.List;


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

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals==null||intervals.size()==0){
            intervals.add(newInterval);
            return intervals;
        }
        int l = intervals.size();
        int flag = 0;
        int flag2;
        for (Interval itv : intervals) {
            if (newInterval.start < itv.start) break;
            flag++;
        }
        if (flag == l) {
            if (intervals.get(flag - 1).end < newInterval.start)
                intervals.add(newInterval);
            else
                intervals.get(flag - 1).end = Math.max(intervals.get(flag - 1).end, newInterval.end);
        } else {
            for (flag2 = flag; flag2 < l; flag2++) {
                if (newInterval.end < intervals.get(flag2).start) break;
            }
            if(flag==0){
                if(flag2==0)
                    intervals.add(0,newInterval);
                else{
                    newInterval.end=Math.max(intervals.get(flag2-1).end,newInterval.end);
                    for(int s=0;s<flag2;s++)
                        intervals.remove(0);

                    intervals.add(0,newInterval);
                }
            }
            else{
                if(intervals.get(flag-1).end<newInterval.start){
                    newInterval.end=Math.max(newInterval.end,intervals.get(flag2-1).end);
                    for(int s=flag;s<flag2;s++)
                        intervals.remove(flag);
                    intervals.add(flag,newInterval);
                }
                else{
                    newInterval.start=intervals.get(flag-1).start;
                    newInterval.end=Math.max(intervals.get(flag2-1).end,newInterval.end);
                    for(int s=flag-1;s<flag2;s++)
                        intervals.remove(flag-1);
                    intervals.add(flag-1,newInterval);
                }
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> list=new ArrayList<>();

        Interval i1=new Interval(1,2);
        Interval i2=new Interval(3,5);
        Interval i3=new Interval(6,7);
        Interval i4=new Interval(8,10);
        Interval i5=new Interval(12,16);
        Interval i6=new Interval(4,8);
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        list.add(i5);

        InsertInterval s=new InsertInterval();
        list=s.insert(list,i6);
        System.out.println(list);
    }
}
