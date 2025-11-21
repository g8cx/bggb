public class IfStatementDemo {
    
    public static void main(String[] args) {
        
        int a, b, c, d;
        
        a = 2;
        b = 3;
        
        System.out.println("а равно 2, b равно 3");
        if (a < b) System.out.println("а меньше b");
        if (a > b) System.out.println("этот текст вы никогда не увидите");
        
        System.out.println("");
        
        c = a - b;
        System.out.println("с равно -1");
        if (c >= 0) System.out.println("с имеет положительное значение ");
        if (c < 0) System.out.println("с имеет отрицательное значение");
        
        System.out.println("");
        
        d = b - a;
        System.out.println("d равно 1");
        if (d >= 0) System.out.println("d имеет положительное значение");
        if (d < 0) System.out.println("d имеет отрицательное значение");
        
        System.out.println("");
        
        if (a + c != b) System.out.println("а плюс с не равняется b");
        if (a + d == b) System.out.println("а плюс d равняется b");
        
    }
    
}