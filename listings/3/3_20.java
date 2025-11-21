class Vehicle {

    public String toString() {
        return "Vehicle(passengers=" + passengers + ", " +
               "wheels=" + wheels + ", " +
               "maxspeed=" + maxspeed + ", " +
               "burnup=" + burnup + ")";
    } 
} 

class Auto extends Vehicle {
    boolean sunroof; 

    Auto(boolean sunroof) {
        this(4, 4, 200, 12, sunroof);
    } 

    Auto(int f, int g, int h, int j, boolean sunroof) {
        super(f, g, h, j);
        this.sunroof = sunroof;
    } 
} 

class VehicleOverrideDemo {

    public static void main(String[] args) {

        Vehicle v = new Vehicle(2, 2, 100, 9);
        Auto a = new Auto(2, 4, 180, 12, true);

        System.out.println("Vehicle.toString(): " + v.toString());
        System.out.println("Auto.toString(): " + a.toString());
    }
} 