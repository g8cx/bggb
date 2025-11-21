interface A {
    void metodA(); 
} 

interface B extends A {
    void metodB(); 
} 

class IExample implements B {

    public void metodA() { System.out.println("Метод А"); }
    public void metodB() { System.out.println("Метод В"); }

} 

public class IExampleDemo {

    public static void main(String[] args) {
        IExample ie = new IExample();
        ie.metodA(); 
        ie.metodB(); 
    } 
} 