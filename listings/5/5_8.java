public class Stack {
    
    private Object theArray[]; 
    
    private int topOfStack; 
    
    private static final int DEFAULT_CAPACITY = 10; 

    public Stack() {
        theArray = new Object[DEFAULT_CAPACITY]; 
        topOfStack = -1; 
    } 

    public boolean isEmpty() {
        return topOfStack == -1;
    } 

    public Object top() {
        if (isEmpty())
            return null;
        return theArray[topOfStack];
    } 

    public void pop() {
        if (isEmpty())
            return;
        topOfStack--;
    } 

    public Object topAndPop() {
        if (isEmpty())
            return null;
        return theArray[topOfStack--];
    } 


    public void push(Object x) {

        if (topOfStack + 1 == theArray.length) {
            doubleArray();
        }
        theArray[++topOfStack] = x;
    }


    public void makeEmpty() {
        topOfStack = -1; 
    } 

    private void doubleArray() {
        Object[] newArray = new Object[theArray.length * 2];

        for (int i = 0; i < theArray.length; i++) {
            newArray[i] = theArray[i];
        }
        
        theArray = newArray;
    } 
}