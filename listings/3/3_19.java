class Auto extends Vehicle {
    boolean sunroof; 
} 
class ExtendsVehicleDemo {

    public static void main(String[] args) {

        Auto bmw = new Auto();
        bmw.sunroof = true; 

        System.out.print("Путь, пройденный за 1.5 часа: ");
        System.out.println(bmw.distance(1.5) + " км.");
        System.out.print("Max. скорость: ");
        System.out.println(bmw.getMaxSpeed() + " км/ч.");
        System.out.println("Наличие люка: " + bmw.sunroof);
    } 
} 