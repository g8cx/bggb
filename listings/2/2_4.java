public class ForStatementDemo {
    
    public static void main(String[] args) {
        
        int count;
        
        for (count = 0; count < 5; count = count + 1)
            System.out.println("Переменная цикла равна " + count);
        
        System.out.println("Цикл окончен");
        
    }
    
}