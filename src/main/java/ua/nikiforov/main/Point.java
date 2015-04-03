package ua.nikiforov.main;

/**
 * @author Sergey Nikiforov
 */
public class Point {
    private double x;
    private double y;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Point that = (Point) obj;
        return Double.compare(this.x, that.x) == 0 && Double.compare(this.y, that.y) == 0;
    }

    @Override
    public int hashCode() {
        long bitsX = Double.doubleToLongBits(x);
        long bitsY = Double.doubleToLongBits(y);
        return 31 * (int) (bitsX ^ (bitsX >>> 32)) + (int) (bitsY ^ (bitsY >>> 32));
    }
}
