public class Plane {
    private String name;// название
    private int capacity;// вместимость
    private double carrying;// грузоподъемность
    private double  distance;// дальность полета
    private double fuelInput;// расход топлива

    public Plane() {
    }

    public Plane(String name, int capacity, double carrying,double distance,double fuelInput) {
        this.name = name;
        this.capacity = capacity;
        this.carrying = carrying;
        this.distance = distance;
        this.fuelInput = fuelInput;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getCarrying() {
        return carrying;
    }

    public void setCarrying(double carrying) {
        this.carrying = carrying;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFuelInput() {
        return fuelInput;
    }

    public void setFuelInput(double fuelInput) {
        this.fuelInput = fuelInput;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name=" + name +
                ", capacity= " + capacity +
                ", carrying=" + carrying +
                ", distance=" + distance +
                ", fuel input=" + fuelInput +
                '}';
    }








}
