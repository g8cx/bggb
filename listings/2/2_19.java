class BreakDemo {
    
    public static void main(String[] args) {
        
        int nmax = 25;
        
        for (int n = 0; n < nmax; n++) {

            if ((n * n) >= nmax) break;
            
            System.out.println("n равно " + n +  ", n в квадрате равно " + n * n);
        }
        
        System.out.println("Конец цикла");
        
    }
    
}