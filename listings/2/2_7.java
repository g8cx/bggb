public class HypotDemo {
    
    public static void main(String[] args) {
        
        double cathetus1, cathetus2, hypot;
        
        cathetus1 = 3;
        cathetus2 = 4;
        
        hypot = Math.sqrt(((cathetus1 * cathetus1) +
                           (cathetus2 * cathetus2)));
        
        System.out.println("длина гипотенузы равна " + hypot);
        
    }
    
}