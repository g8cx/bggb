class ExtendedBreakDemo {
    
    public static void main(String[] args) {
        
        for (int i = 1; i < 4; i++) {
            
            Блок1: { 
                Блок2: { 
                    Блок3: { 
                        
                        System.out.println("\ni равно " + i);
                        
                        if (i == 1) break Блок1; 
                        
                        if (i == 2) break Блок2; 
                        
                        // При i=3, выход из Блока3
                        if (i == 3) break Блок3; 
                        
                        System.out.println("Эта строка никогда не будет напечатана");
                        
                    }

                    System.out.println("завершен Блок3"); 

                }

                System.out.println("завершен Блок2"); 
                
            }
            
            System.out.println("завершен Блок1"); 
            
        }
        
        System.out.println("конец цикла for");
        
    }
    
}