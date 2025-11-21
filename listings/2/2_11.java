public class ScopeDemo {
    
    public static void main(String[] args) {
        
        int x; 
        
        x = 1;
        System.out.println("До вложенного блока: x равно " + x);
        
        {

            int y = 3;
            
            System.out.println("Внутренний блок: x равно " + x + ", y равно " + y);
            
            x = y * 3;
            
        }

        System.out.println("После вложенного блока: x равно " + x);
        
    }
    
} 