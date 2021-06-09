import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalScheduler {

    public static List<Interval> run(List<Interval> intervals)
    {
        Collections.sort(intervals);

        int n = intervals.size();
        List<Interval> arrLst = new ArrayList<>();
        arrLst.add(intervals.get(0));
        int j = 0;

        for(int i = 1;i < n;i++)
        {
            if(intervals.get(i).getStart() >= intervals.get(j).getEnd())
            {
                arrLst.add(intervals.get(i));
                j = i;
            }
        }

        return arrLst;

    }

}
