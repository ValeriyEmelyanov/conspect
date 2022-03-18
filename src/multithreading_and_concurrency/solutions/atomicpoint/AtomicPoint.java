package multithreading_and_concurrency.solutions.atomicpoint;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicPoint {
    private final AtomicReference<Point> pointReference;

    public AtomicPoint(int x, int y) {
        this.pointReference =  new AtomicReference<>(new Point(x, y));
    }

    public void rotateClockwise() {
        pointReference.updateAndGet(Point::rotateClockwise);
    }

    private static class Point {
        final int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point rotateClockwise() {
            return new Point(y, -x);
        }
    }
}
