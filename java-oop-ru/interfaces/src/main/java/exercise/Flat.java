package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public String toString() {
        return String.format("Квартира площадью %s метров на %s этаже", getArea(), floor);
    }

    public double getArea() {
        return (area + balconyArea);
    }

    public int compareTo(Home another) {
        int result;
        if ((another.getArea()) == (getArea())) {
            result = 0;
        } else if ((another.getArea()) < (getArea())) {
            result = -1;
        } else {
            result = 1;
        }
        return result;
    }
}
// END
