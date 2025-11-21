class QuickSort {
    
    static void sort(char items[]) {
        quickSort(items, 0, items.length - 1);
    } 
    
    private static void quickSort(char items[], int left, int right) {
        int top, bottom;
        char comparer, value;

        top = left;      
        bottom = right;  
        
        comparer = items[(left + right) / 2];
        
        do {
            while ((items[top] < comparer) && (top < right)) top++;
            
            while ((comparer < items[bottom]) && (bottom > left)) bottom--;
            
            if (top <= bottom) {
                value = items[top];
                items[top] = items[bottom];
                items[bottom] = value;
                
                top++;
                bottom--;
            }
        } while (top <= bottom);

        if (((right - left) - items.length) < 0) { 
            for (int i = 0; i < items.length; i++) {
                System.out.print(items[i]);
            }
            System.out.println();
        }

        if (left < bottom) {
            quickSort(items, left, bottom);
        }
        
        if (top < right) {
            quickSort(items, top, right);
        }
    }
    
} 

public class QuickSortDemo {
    
    public static void main(String[] args) {
        
        char seq[] = {'r', 'h', 'a', 'x', 'd', 'p', 'i', 'c', 'e', 'r', 'i', 'f'};

        System.out.print("Исходный порядок символов: ");
        for (int i = 0; i < seq.length; i++) {
            System.out.print(seq[i]);
        }
        
        System.out.println();
        
        QuickSort.sort(seq);

        System.out.print("Отсортированный порядок: ");
        for (int i = 0; i < seq.length; i++) {
            System.out.print(seq[i]);
        }
        
        System.out.println();
    } 
    
}