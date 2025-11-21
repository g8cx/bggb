class Queue {
    
    private char q[];       
    private int putloc;    
    private int getloc;    

    public Queue(int size) {
        q = new char[size + 1]; 
        putloc = 0;
        getloc = 0;
    } 

    public Queue(Queue ob) {
        putloc = ob.putloc;
        getloc = ob.getloc;
        q = new char[ob.q.length]; 
        
        System.arraycopy(ob.q, 0, q, 0, ob.q.length);
    }

    public Queue(char a[]) {
        putloc = 0;
        getloc = 0;
        q = new char[a.length + 1]; 
        
        for (int i = 0; i < a.length; i++) {
            put(a[i]);
        }
    } 

    public boolean isFull() {
        return putloc == (q.length - 1);
    } 

    public boolean isEmpty() {
        return (getloc == putloc); 
    }

    void put(char ch) throws IllegalStateException {
        if (isFull()) {
            return;
        }

        putloc++; 
        
        q[putloc] = ch;
    } 

    char get() throws IllegalStateException {
        if (isEmpty()) {
            return (char) 0; 
        }

        getloc++;
        
        return q[getloc];
    } 
    
} 