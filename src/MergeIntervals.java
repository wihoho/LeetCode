import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 7/12/2015.
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start == o2.start) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            if (end < currentInterval.start) {
                result.add(new Interval(start, end));
                start = currentInterval.start;
                end = currentInterval.end;
            } else {
                end = currentInterval.end < end ? end: currentInterval.end;
            }
        }

        result.add(new Interval(start, end));
        return result;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }
}
