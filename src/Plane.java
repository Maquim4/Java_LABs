public class Plane {

    private String name;// название
    private int capacity;// вместимость
    private double carrying;// грузоподъемность
    private double  distance;// дальность полета
    private double fuelInput;// расход топлива



    public Plane(String name, int capacity, double carrying,double distance,double fuelInput) {
        this.name = name;
        this.capacity = capacity;
        this.carrying = carrying;
        this.distance = distance;
        this.fuelInput = fuelInput;
    }



    public double getCapacity() {
        return capacity;
    }



    public double getCarrying() {
        return carrying;
    }


    public double getDistance() {
        return distance;
    }



    public double getFuelInput() {
        return fuelInput;
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
