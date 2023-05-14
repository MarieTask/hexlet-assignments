package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public String toString() {
        return String.format("%s этажный коттедж площадью %s метров", floorCount, getArea());
    }

    @Override
    public double getArea() {
        return area;
    }

    public int compareTo(Home another) {
        int result;
        if (another.getArea() == getArea()) {
            result = 0;
        } else if (another.getArea() < getArea()) {
            result = -1;
        } else {
            result = 1;
        }
        return result;
    }
}

// END
