package exercise;

// BEGIN
class Circle {
    Point point;
    int radius;

    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        switch (radius) {
            case 0 -> throw NegativeRadiusException.INVALID_RADIUS;
            default -> {
                return Math.PI * radius * radius;
            }
        }
    }
}
// END