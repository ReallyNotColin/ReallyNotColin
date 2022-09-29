public class Test {
    public static void main(String args []){
    
        MaxHeap heap = new MaxHeap();

        System.out.println(heap.isEmpty());
        heap.insert(1);
        heap.insert(3);
        heap.insert(5);
        heap.insert(7);
        heap.insert(9);
        heap.insert(11);
        heap.insert(13);
        // Shouldn't insert 15 because the index would be 7, which is index value more than the array can handle
        heap.insert(15);
        heap.insert(17);
        heap.insert(19);
        heap.insert(21);
        heap.insert(23);
        heap.extractMax();
        System.out.println(heap.findMax());

        MinHeap heap2 = new MinHeap();

        System.out.println(heap2.isEmpty());
        
    }

}

