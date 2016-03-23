import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 23/3/2016.
 */
public class MaxPoints {

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;


        int max = 0;
        for (int j = 0; j < points.length; j++) {
            Map<Double, Integer> map = new HashMap<>();
            Point pivot = points[j];

            int special= 0;
            int same = 0;
            for (int i = 0; i < points.length; i++) {
                if (pivot.x == points[i].x && pivot.y == points[i].y) {
                    same++;
                } else if (pivot.x == points[i].x) {
                    special++;
                } else {
                    double slope = slope(pivot, points[i]);
                    map.merge(slope, 1, (a, b) -> a + b);
                }
            }

            for (Integer in : map.values()) {
                if (special < in) {
                    special = in;
                }
            }

            max = special + same > max ? special + same : max;
        }

        return max;
    }

    public double slope(Point point1, Point point2) {
        return (point1.y - point2.y) / (float) (point1.x - point2.x);
    }

    public static void main(String[] args) {
        Point p1 = new Point(-4, -4);
        Point p2 = new Point(-8, -582);
        Point p3 = new Point(-3, 3);
        Point p4 = new Point(-9, -651);
        Point p5 = new Point(9, 591);

        Point[] points = {p1, p2, p3, p4, p5};
        MaxPoints maxPoints = new MaxPoints();
        int result = maxPoints.maxPoints(points);
        System.out.println();

    }
}
