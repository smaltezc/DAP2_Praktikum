public class Interval implements Comparable<Interval> {
    private int start;
    private int end;

    public Interval(int start,int end)
    {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "[" + start +
                "," + end +
                ']';
    }

    @Override
    public int compareTo(Interval i2) {
        int result = 0;
        if(getEnd() < i2.getEnd())
        {
            result = -1;
        }
        else if(getEnd() > i2.getEnd())
        {
            result = 1;
        }
        return result;
    }

}
