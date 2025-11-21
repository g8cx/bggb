class Vehicle {
    int passengers; 
    private int wheels;
    private int maxspeed; 
    int burnup; 

    Vehicle(int passengers, int wheels, int maxspeed,
            int burnup) {
        this.passengers = passengers;
        this.wheels = wheels;
        this.maxspeed = maxspeed;
        this.burnup = burnup;
    } 

    double distance(double interval) {
        double val = this.maxspeed * interval;
        return val;
    }

    int getMaxSpeed() {
        return this.maxspeed;
    }

    int getWheels() {
        return this.wheels;
    }

    void setWheels(int wheels) {
        if ((wheels < 1) || (wheels > 24)) {
            System.out.println("Некорректно указано число колес.");
            return;
        }
        this.wheels = wheels;
    }
}

class VehicleGetSetMethod {

    public static void main(String[] args) {

        Vehicle ferrari = new Vehicle(2, -2, 360, 12);

        System.out.println("Max скорость: "
                           + ferrari.getMaxSpeed() + " км/ч");

        System.out.println("Число колес: "
                           + ferrari.getWheels());

        ferrari.setWheels(4);
        System.out.println("Число колес (повторно): "
                           + ferrari.getWheels());
    }
} 