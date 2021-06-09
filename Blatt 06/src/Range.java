import java.math.BigDecimal;

public class Range {

    private int l;
    private int r;
    private BigDecimal dr;

    public Range(int l, int r,BigDecimal dr)
    {
        this.l = l;
        this.r = r;
        this.dr = dr;
    }

    public int getLeft() {
        return l;
    }

    public int getRight() {
        return r;
    }

    public BigDecimal getProd() {
        return dr;
    }

    @Override
    public String toString() {
        return "[" + l +
                "," + r +
                "," + dr +
                ']';
    }
}
