
class PolyVehicleDemo {

    public static void main(String[] args) {

        Auto a = new Auto(true); 
        Vehicle v = new Vehicle(); 

        Vehicle[] pvd = {a, v};

        for (int i = 0; i < pvd.length; i++) {
            System.out.println(pvd[i].toString());
        } 
    } 
} 