public class NestVar {
    
    public static void main(String[] args) {
        
        int count = 1; 
        System.out.println("count = " + count);
        
        { 

            System.out.println("Первый независимый блок: count = " + count);
            
            int n = 3; 
            System.out.println("Первый независимый блок: n = " + n);
            
        }
        
        { 
            
            int n = 5; 
            
            System.out.println("Второй независимый блок: n = " + n);
            
        }
        
    }
    
}